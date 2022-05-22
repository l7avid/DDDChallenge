package com.sofkaU.ChallengeDDD.inventory.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.ChallengeDDD.inventory.values.*;

public class OderDataAdded extends DomainEvent {


    private final InventoryID inventoryID;
    private final OrderDataID orderDataID;
    private final ProductBrand productBrand;
    private final ProductModel productModel;
    private final Supplier supplier;

    public OderDataAdded(InventoryID inventoryID, OrderDataID orderDataID, ProductBrand productBrand, ProductModel productModel, Supplier supplier) {
        super("davidreina.inventory.orderdataadded");
        this.inventoryID = inventoryID;
        this.orderDataID = orderDataID;
        this.productBrand = productBrand;
        this.productModel = productModel;
        this.supplier = supplier;
    }

    public InventoryID inventoryID() {
        return inventoryID;
    }

    public OrderDataID orderDataID() {
        return orderDataID;
    }

    public ProductBrand productBrand() {
        return productBrand;
    }

    public ProductModel productModel() {
        return productModel;
    }

    public Supplier supplier() {
        return supplier;
    }
}
