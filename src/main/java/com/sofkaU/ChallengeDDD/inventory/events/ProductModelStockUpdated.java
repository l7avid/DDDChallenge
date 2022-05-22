package com.sofkaU.ChallengeDDD.inventory.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.ChallengeDDD.inventory.values.InventoryID;
import com.sofkaU.ChallengeDDD.inventory.values.ProductID;
import com.sofkaU.ChallengeDDD.inventory.values.ProductModel;

public class ProductModelStockUpdated extends DomainEvent {

    private final InventoryID inventoryID;
    private final ProductID productID;
    private final ProductModel productModel;


    public ProductModelStockUpdated(InventoryID inventoryID, ProductID productID, ProductModel productModel) {
        super("davidreina.inventory.productmodelstockupdated");
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
