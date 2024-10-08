package models.bankTransaction;

import models.CommunSchema;
import models.item.ItemSchema;
import models.item.SimpleItemSchema;

public class BankItemTransactionSchema extends CommunSchema {
    private ItemSchema item;
    private SimpleItemSchema[] bank;


    public ItemSchema getItem() {
        return item;
    }

    public void setItem(ItemSchema item) {
        this.item = item;
    }

    public SimpleItemSchema[] getBank() {
        return bank;
    }

    public void setBank(SimpleItemSchema[] bank) {
        this.bank = bank;
    }

}
