package com.sofkaU.ChallengeDDD.inventory.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.ChallengeDDD.inventory.values.InventoryAssistantID;
import com.sofkaU.ChallengeDDD.inventory.values.InventoryID;
import com.sofkaU.ChallengeDDD.share.YearsOfExperience;

public class InventoryAssistantYearsOfExperienceUpdated extends DomainEvent {

    private final InventoryID inventoryID;
    private final InventoryAssistantID inventoryAssistantID;
    private final YearsOfExperience yearsOfExperience;


    public InventoryAssistantYearsOfExperienceUpdated(InventoryID inventoryID,
                                                      InventoryAssistantID inventoryAssistantID,
                                                      YearsOfExperience yearsOfExperience)
    {
        super("davidreina.inventory.inventoryassistantyearsofexperienceupdated");
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
