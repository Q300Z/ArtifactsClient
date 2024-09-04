package models.recycling;

import models.commun.DropSchema;

public class RecyclingItemsSchema {
    private DropSchema[] items;

    public DropSchema[] getItems() {
        return items;
    }

    public void setItems(DropSchema[] items) {
        this.items = items;
    }
}
