package models;

public class CharacterMovementDataSchema extends CommunSchema {
    private MapSchema destination;

    public MapSchema getDestination() {
        return destination;
    }

    public void setDestination(MapSchema destination) {
        this.destination = destination;
    }


}
