package com.sofkaU.ChallengeDDD.inventory.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.ChallengeDDD.inventory.values.InventoryDate;

public class InventoryCreated extends DomainEvent {

    private final InventoryDate inventoryDate;


    public InventoryCreated(InventoryDate inventoryDate) {
        super("davidreina.inventory.inventorycreated");
        this.inventoryDate = inventoryDate;
    }

    public InventoryDate inventoryDate() {
        return inventoryDate;
    }
}
