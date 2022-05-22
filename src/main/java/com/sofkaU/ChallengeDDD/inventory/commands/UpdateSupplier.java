package com.sofkaU.ChallengeDDD.inventory.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.ChallengeDDD.inventory.values.InventoryID;
import com.sofkaU.ChallengeDDD.inventory.values.OrderDataID;
import com.sofkaU.ChallengeDDD.inventory.values.Supplier;

public class UpdateSupplier extends Command {

    private final InventoryID inventoryID;
    private final OrderDataID orderDataID;
    private final Supplier supplier;


    public UpdateSupplier(InventoryID inventoryID, OrderDataID orderDataID, Supplier supplier) {
        this.inventoryID = inventoryID;
        this.orderDataID = orderDataID;
        this.supplier = supplier;
    }

    public InventoryID inventoryID() {
        return inventoryID;
    }

    public OrderDataID orderDataID() {
        return orderDataID;
    }

    public Supplier supplier() {
        return supplier;
    }
}
