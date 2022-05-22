package com.sofkaU.ChallengeDDD.inventory.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.ChallengeDDD.inventory.values.InventoryAssistantID;
import com.sofkaU.ChallengeDDD.inventory.values.InventoryID;
import com.sofkaU.ChallengeDDD.share.Name;
import com.sofkaU.ChallengeDDD.share.YearsOfExperience;

public class InventoryAssistantAdded extends DomainEvent {

    private final InventoryID inventoryID;
    private final InventoryAssistantID inventoryAssistantID;
    private final Name name;
    private final YearsOfExperience yearsOfExperience;


    public InventoryAssistantAdded(InventoryID inventoryID, InventoryAssistantID inventoryAssistantID, Name name, YearsOfExperience yearsOfExperience) {
        super("davidreina.inventory.invetoryassistantadded");
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
