package com.n26.adepter.Service;

import com.n26.Exceptions.TransactionNotValidException;
import com.n26.Exceptions.TransactionTimeNotValidException;
import com.n26.Model.Statics;
import com.n26.Model.Transaction;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;


@Service
public class StaticServiceImpl implements StaticService {

    private static final List<Transaction> TRANSACTION_LIST = new ArrayList<>(); //to store transactions
    public static final Integer seconds = 60000; //for further time comparison
    private Object lock = new Object(); //lock adding process for being threadSafe
    private Statics statistics;

    @Override
    public void newTransaction(Transaction transaction) {
        if (!validateTimeDiff(transaction)) {
            throw new TransactionNotValidException();
        }
        synchronized (lock) {
            TRANSACTION_LIST.add(transaction);
            statisticAnalysis();
        }


    }

    @Override
    public Statics getStatics() {
        if (statistics != null) {
            removeOldData();
        }
        if (statistics == null) {
            statistics = new Statics();
        }
        return statistics;
    }

    @Override
    public void deleteAll() {

        TRANSACTION_LIST.clear();
        statistics = new Statics();


    }


    public boolean validateTimeDiff(Transaction transaction) {
        if (Instant.now().toEpochMilli() < transaction.getTimestamp().toEpochMilli()) {
            throw new TransactionTimeNotValidException();
        }

        if ((Instant.now().toEpochMilli() - transaction.getTimestamp().toEpochMilli()) < seconds
                && Instant.now().toEpochMilli() >= transaction.getTimestamp().toEpochMilli()) {

            return true;
        }

        return false;
    }

    public void statisticAnalysis() {
        if (TRANSACTION_LIST.isEmpty()) {
            statistics = new Statics();
        } else {
            DoubleSummaryStatistics stat = TRANSACTION_LIST.stream().mapToDouble(Transaction::getAmount)
                    .summaryStatistics();
            statistics = new Statics(BigDecimal.valueOf(stat.getSum()).setScale(2, RoundingMode.HALF_UP),
                    BigDecimal.valueOf(stat.getAverage()).setScale(2, RoundingMode.HALF_UP),
                    BigDecimal.valueOf(stat.getMax()).setScale(2, RoundingMode.HALF_UP),
                    BigDecimal.valueOf(stat.getMin()).setScale(2, RoundingMode.HALF_UP),
                    stat.getCount());
        }
    }

    public void removeOldData() {

        TRANSACTION_LIST.removeIf(
                transcation -> (!validateTimeDiff(transcation)));

        statisticAnalysis();


    }
}
