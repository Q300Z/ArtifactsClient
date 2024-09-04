package models.characterMovement;

import models.CommunSchema;

public class CharacterMovementDataSchema extends CommunSchema {
    private MapSchema destination;

    public MapSchema getDestination() {
        return destination;
    }

    public void setDestination(MapSchema destination) {
        this.destination = destination;
    }


}
