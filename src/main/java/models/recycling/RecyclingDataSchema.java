package models.recycling;

import models.CommunSchema;

public class RecyclingDataSchema extends CommunSchema {
    private RecyclingItemsSchema details;

    public RecyclingItemsSchema getDetails() {
        return details;
    }

    public void setDetails(RecyclingItemsSchema details) {
        this.details = details;
    }
}
