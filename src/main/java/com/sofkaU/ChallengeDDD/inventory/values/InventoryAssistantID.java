package com.sofkaU.ChallengeDDD.inventory.values;

import co.com.sofka.domain.generic.Identity;

public class InventoryAssistantID extends Identity {

    public InventoryAssistantID(String uuid) {
        super(uuid);
    }

    public InventoryAssistantID() {
    }

    public static InventoryAssistantID of(String id){
        return new InventoryAssistantID(id);
    }
}
