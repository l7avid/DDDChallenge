package com.sofkaU.ChallengeDDD.inventory.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.ChallengeDDD.inventory.values.InventoryID;
import com.sofkaU.ChallengeDDD.inventory.values.ProductBrand;
import com.sofkaU.ChallengeDDD.inventory.values.ProductID;

public class UpdateProductModelOrderData extends Command {


    private final InventoryID inventoryID;
    private final ProductID productID;
    private final ProductBrand productBrand;


    public UpdateProductModelOrderData(InventoryID inventoryID, ProductID productID, ProductBrand productBrand) {
        this.inventoryID = inventoryID;
        this.productID = productID;
        this.productBrand = productBrand;
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
}
