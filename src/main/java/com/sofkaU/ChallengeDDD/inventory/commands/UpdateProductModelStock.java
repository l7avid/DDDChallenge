package com.sofkaU.ChallengeDDD.inventory.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.ChallengeDDD.inventory.values.InventoryID;
import com.sofkaU.ChallengeDDD.inventory.values.ProductID;
import com.sofkaU.ChallengeDDD.inventory.values.ProductModel;

public class UpdateProductModelStock extends Command {

    private final InventoryID inventoryID;
    private final ProductID productID;
    private final ProductModel productModel;

    public UpdateProductModelStock(InventoryID inventoryID, ProductID productID, ProductModel productModel) {
        this.inventoryID = inventoryID;
        this.productID = productID;
        this.productModel = productModel;
    }

    public InventoryID inventoryID() {
        return inventoryID;
    }

    public ProductID productID() {
        return productID;
    }

    public ProductModel productModel() {
        return productModel;
    }
}
