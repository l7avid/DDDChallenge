package com.sofkaU.ChallengeDDD.inventory.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.ChallengeDDD.inventory.values.InventoryID;
import com.sofkaU.ChallengeDDD.inventory.values.OrderDataID;
import com.sofkaU.ChallengeDDD.inventory.values.ProductBrand;

public class UpdateProductBrandOrderData extends Command {


    private final InventoryID inventoryID;
    private final OrderDataID orderDataID;
    private final ProductBrand productBrand;


    public UpdateProductBrandOrderData(InventoryID inventoryID, OrderDataID orderDataID, ProductBrand productBrand) {
        this.inventoryID = inventoryID;
        this.orderDataID = orderDataID;
        this.productBrand = productBrand;
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
}
