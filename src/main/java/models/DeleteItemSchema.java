package models;

public class DeleteItemSchema extends CommunSchema {
    private SimpleItemSchema item;

    public SimpleItemSchema getItem() {
        return item;
    }

    public void setItem(SimpleItemSchema item) {
        this.item = item;
    }
}
