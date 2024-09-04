package models;

public class BankExtensionTransactionSchema extends CommunSchema {
    private BankExtensionSchema transaction;

    public BankExtensionSchema getTransaction() {
        return transaction;
    }

    public void setTransaction(BankExtensionSchema transaction) {
        this.transaction = transaction;
    }
}
