package com.sofkaU.ChallengeDDD.inventory.commands;

import com.sofkaU.ChallengeDDD.inventory.values.InventoryAssistantID;
import com.sofkaU.ChallengeDDD.inventory.values.InventoryID;
import com.sofkaU.ChallengeDDD.share.Name;

public class UpdateInventoryAssistantName {

    private final InventoryID inventoryID;
    private final InventoryAssistantID inventoryAssistantID;
    private final Name name;

    public UpdateInventoryAssistantName(InventoryID inventoryID, InventoryAssistantID inventoryAssistantID, Name name) {
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
