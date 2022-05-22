package com.sofkaU.ChallengeDDD.inventory.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.ChallengeDDD.inventory.values.InventoryDate;
import com.sofkaU.ChallengeDDD.inventory.values.InventoryID;

public class UpdateInventoryDate extends Command {


    private final InventoryID inventoryID;
    private final InventoryDate inventoryDate;

    public UpdateInventoryDate(InventoryID inventoryID, InventoryDate inventoryDate) {
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
