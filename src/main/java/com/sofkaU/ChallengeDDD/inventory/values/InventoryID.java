package com.sofkaU.ChallengeDDD.inventory.values;

import co.com.sofka.domain.generic.Identity;

public class InventoryID extends Identity {

    public InventoryID(String uuid) {
        super(uuid);
    }

    public InventoryID() {
    }

    public static InventoryID of(String id){
        return new InventoryID(id);
    }
}
