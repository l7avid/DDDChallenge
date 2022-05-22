package com.sofkaU.ChallengeDDD.inventory.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.ChallengeDDD.inventory.values.*;

public class AddOrderData extends Command {

    private final InventoryID inventoryID;
    private final OrderDataID orderDataID;
    private final ProductBrand productBrand;
    private final ProductModel productModel;
    private final Supplier supplier;

    public AddOrderData(InventoryID inventoryID, OrderDataID orderDataID, ProductBrand productBrand, ProductModel productModel, Supplier supplier) {
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
