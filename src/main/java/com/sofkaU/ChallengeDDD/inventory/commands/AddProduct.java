package com.sofkaU.ChallengeDDD.inventory.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.ChallengeDDD.inventory.values.InventoryID;
import com.sofkaU.ChallengeDDD.inventory.values.ProductBrand;
import com.sofkaU.ChallengeDDD.inventory.values.ProductID;
import com.sofkaU.ChallengeDDD.inventory.values.ProductModel;

public class AddProduct extends Command {

    private final InventoryID inventoryID;
    private final ProductID productID;
    private final ProductBrand productBrand;
    private final ProductModel productModel;


    public AddProduct(InventoryID inventoryID, ProductID productID, ProductBrand productBrand, ProductModel productModel) {
        this.inventoryID = inventoryID;
        this.productID = productID;
        this.productBrand = productBrand;
        this.productModel = productModel;
    }

    public InventoryID inventoryID() {
        return inventoryID;
    }

    public ProductID productID() {
        return productID;
    }

    public ProductBrand productBrand() {
        return productBrand;
    }

    public ProductModel productModel() {
        return productModel;
    }
}
