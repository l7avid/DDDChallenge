package com.sofkaU.ChallengeDDD.inventory.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.ChallengeDDD.inventory.values.InventoryID;
import com.sofkaU.ChallengeDDD.inventory.values.OrderDataID;
import com.sofkaU.ChallengeDDD.inventory.values.ProductModel;

public class ProductModelOrderDataUpdated extends DomainEvent {

    private final InventoryID inventoryID;
    private final OrderDataID orderDataID;
    private final ProductModel productModel;


    public ProductModelOrderDataUpdated(InventoryID inventoryID, OrderDataID orderDataID, ProductModel productModel) {
        super("davidreina.inventory.productmodelorderdataupdated");
        this.inventoryID = inventoryID;
        this.orderDataID = orderDataID;
        this.productModel = productModel;
    }

    public InventoryID inventoryID() {
        return inventoryID;
    }

    public OrderDataID orderDataID() {
        return orderDataID;
    }

    public ProductModel productModel() {
        return productModel;
    }
}
