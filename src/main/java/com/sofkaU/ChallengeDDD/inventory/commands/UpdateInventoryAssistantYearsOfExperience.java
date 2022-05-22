package com.sofkaU.ChallengeDDD.inventory.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.ChallengeDDD.inventory.values.InventoryAssistantID;
import com.sofkaU.ChallengeDDD.inventory.values.InventoryID;
import com.sofkaU.ChallengeDDD.share.YearsOfExperience;

public class UpdateInventoryAssistantYearsOfExperience extends Command {

    private final InventoryID inventoryID;
    private final InventoryAssistantID inventoryAssistantID;
    private final YearsOfExperience yearsOfExperience;

    public UpdateInventoryAssistantYearsOfExperience(InventoryID inventoryID, InventoryAssistantID inventoryAssistantID, YearsOfExperience yearsOfExperience) {
        this.inventoryID = inventoryID;
        this.inventoryAssistantID = inventoryAssistantID;
        this.yearsOfExperience = yearsOfExperience;
    }

    public InventoryID inventoryID() {
        return inventoryID;
    }

    public InventoryAssistantID inventoryAssistantID() {
        return inventoryAssistantID;
    }

    public YearsOfExperience yearsOfExperience() {
        return yearsOfExperience;
    }
}
