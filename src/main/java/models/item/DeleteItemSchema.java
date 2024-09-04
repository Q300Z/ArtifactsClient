package models.item;

import models.CommunSchema;

public class DeleteItemSchema extends CommunSchema {
    private SimpleItemSchema item;

    public SimpleItemSchema getItem() {
        return item;
    }

    public void setItem(SimpleItemSchema item) {
        this.item = item;
    }
}
