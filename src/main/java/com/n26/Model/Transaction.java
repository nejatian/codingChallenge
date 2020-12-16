package com.n26.Model;

import javax.validation.constraints.NotNull;
import java.time.Instant;

public class Transaction {
    @NotNull(message = "amount can not be null!")
    private Double amount;
    @NotNull(message = "time can not be null!")
    private Instant timestamp;


    public Transaction(Double amount, Instant timestamp) {
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public Double getAmount() {
        return amount;
    }


    public Instant getTimestamp() {
        return timestamp;
    }


}

