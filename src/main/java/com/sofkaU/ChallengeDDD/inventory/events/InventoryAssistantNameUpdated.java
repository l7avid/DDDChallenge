package com.sofkaU.ChallengeDDD.inventory.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.ChallengeDDD.inventory.values.InventoryAssistantID;
import com.sofkaU.ChallengeDDD.inventory.values.InventoryID;
import com.sofkaU.ChallengeDDD.share.Name;

public class InventoryAssistantNameUpdated extends DomainEvent {

    private final InventoryID inventoryID;
    private final InventoryAssistantID inventoryAssistantID;
    private final Name name;


    public InventoryAssistantNameUpdated(InventoryID inventoryID, InventoryAssistantID inventoryAssistantID, Name name) {
        super("davidreina.inventory.inventoryassistantnameupdated");
        this.inventoryID = inventoryID;
        this.inventoryAssistantID = inventoryAssistantID;
        this.name = name;
    }

    public InventoryID inventoryID() {
        return inventoryID;
    }

    public InventoryAssistantID inventoryAssistantID() {
        return inventoryAssistantID;
    }

    public Name name() {
        return name;
    }
}
