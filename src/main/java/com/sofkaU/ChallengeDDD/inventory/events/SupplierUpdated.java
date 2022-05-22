package com.sofkaU.ChallengeDDD.inventory.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.ChallengeDDD.inventory.values.InventoryID;
import com.sofkaU.ChallengeDDD.inventory.values.OrderDataID;
import com.sofkaU.ChallengeDDD.inventory.values.Supplier;

public class SupplierUpdated extends DomainEvent {

    private final InventoryID inventoryID;
    private final OrderDataID orderDataID;
    private final Supplier supplier;


    public SupplierUpdated(InventoryID inventoryID, OrderDataID orderDataID, Supplier supplier) {
        super("davidreina.inventory.supplierupdated");
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
