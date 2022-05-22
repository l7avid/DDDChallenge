package com.sofkaU.ChallengeDDD.inventory.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.ChallengeDDD.inventory.values.InventoryID;
import com.sofkaU.ChallengeDDD.inventory.values.ProductBrand;
import com.sofkaU.ChallengeDDD.inventory.values.ProductID;

public class ProductBrandStockUpdated extends DomainEvent {

    private final InventoryID inventoryID;
    private final ProductID productID;
    private final ProductBrand productBrand;

    public ProductBrandStockUpdated(InventoryID inventoryID, ProductID productID, ProductBrand productBrand) {
        super("davidreina.inventory.prouctbrandstockupdated");
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
