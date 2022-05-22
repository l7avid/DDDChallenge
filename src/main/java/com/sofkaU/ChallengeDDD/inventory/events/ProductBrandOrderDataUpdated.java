package com.sofkaU.ChallengeDDD.inventory.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.ChallengeDDD.inventory.values.InventoryID;
import com.sofkaU.ChallengeDDD.inventory.values.OrderDataID;
import com.sofkaU.ChallengeDDD.inventory.values.ProductBrand;

public class ProductBrandOrderDataUpdated extends DomainEvent {

    private final InventoryID inventoryID;
    private final OrderDataID orderDataID;
    private final ProductBrand productBrand;


    public ProductBrandOrderDataUpdated(InventoryID inventoryID, OrderDataID orderDataID, ProductBrand productBrand) {
        super("davidreina.inventory.productbrandorderdataupdated");
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
