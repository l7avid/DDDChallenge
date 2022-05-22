package com.sofkaU.ChallengeDDD.inventory.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.ChallengeDDD.inventory.values.InventoryAssistantID;
import com.sofkaU.ChallengeDDD.inventory.values.InventoryID;
import com.sofkaU.ChallengeDDD.share.Name;
import com.sofkaU.ChallengeDDD.share.YearsOfExperience;

public class AddInventoryAssistant extends Command {

    private final InventoryID inventoryID;
    private final InventoryAssistantID inventoryAssistantID;
    private final Name name;
    private final YearsOfExperience yearsOfExperience;

    public AddInventoryAssistant(InventoryID inventoryID, InventoryAssistantID inventoryAssistantID, Name name, YearsOfExperience yearsOfExperience) {
        this.inventoryID = inventoryID;
        this.inventoryAssistantID = inventoryAssistantID;
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
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

    public YearsOfExperience yearsOfExperience() {
        return yearsOfExperience;
    }
}
