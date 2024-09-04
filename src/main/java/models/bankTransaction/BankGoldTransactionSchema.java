package models.bankTransaction;

import models.CommunSchema;

public class BankGoldTransactionSchema extends CommunSchema {
    private GoldSchema bank;

    public GoldSchema getBank() {
        return bank;
    }

    public void setBank(GoldSchema bank) {
        this.bank = bank;
    }


}
