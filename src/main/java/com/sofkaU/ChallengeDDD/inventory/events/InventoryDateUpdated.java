package com.sofkaU.ChallengeDDD.inventory.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.ChallengeDDD.inventory.values.InventoryDate;
import com.sofkaU.ChallengeDDD.inventory.values.InventoryID;

public class InventoryDateUpdated extends DomainEvent {

    private final InventoryID inventoryID;
    private final InventoryDate inventoryDate;


    public InventoryDateUpdated(InventoryID inventoryID, InventoryDate inventoryDate) {
        super("davidreina.inventory.inventorydateupdated");
        this.inventoryID = inventoryID;
        this.inventoryDate = inventoryDate;
    }

    public InventoryID inventoryID() {
        return inventoryID;
    }

    public InventoryDate inventoryDate() {
        return inventoryDate;
    }
}
