package models.GETransaction;

import models.CommunSchema;

public class GETransactionListSchema extends CommunSchema {
    private GETransactionSchema transaction;

    public GETransactionSchema getTransaction() {
        return transaction;
    }

    public void setTransaction(GETransactionSchema transaction) {
        this.transaction = transaction;
    }
}
