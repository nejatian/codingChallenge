package com.n26.adepter.Service;

import com.n26.Model.Statics;
import com.n26.Model.Transaction;

public interface StaticService {
     void newTransaction(Transaction transaction);
     Statics getStatics();
     void deleteAll();

}
