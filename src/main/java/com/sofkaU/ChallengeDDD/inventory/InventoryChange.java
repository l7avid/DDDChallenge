package com.sofkaU.ChallengeDDD.inventory;

import co.com.sofka.domain.generic.EventChange;
import com.sofkaU.ChallengeDDD.inventory.events.*;

public class InventoryChange extends EventChange {

    public InventoryChange(Inventory inventory){
        apply((InventoryCreated event) -> {
            inventory.inventoryDate = event.inventoryDate();
        });

        apply((ProductAdded event) -> {
            inventory.stock().add(new Product(event.productID(), event.productBrand(), event.productModel()));
        });

        apply((OderDataAdded event) -> {
            inventory.toOrder().add(new OrderData(event.orderDataID(), event.productBrand(),event.productModel()));
        });

        apply((InventoryAssistantAdded event) -> {
            inventory.assistants().add(new InventoryAssistant(event.inventoryAssistantID(),event.name(),
                    event.yearsOfExperience()));
        });

        apply((ProductBrandStockUpdated event) -> {
            var product = inventory.getProductByID(event.productID()).orElseThrow(() ->
                    new IllegalArgumentException("Not able to find a product with the id provided"));
            product.updateProductBrand(event.productBrand());
        });

        apply((ProductModelStockUpdated event) -> {
            var product = inventory.getProductByID(event.productID()).orElseThrow(() ->
                    new IllegalArgumentException("Not able to find a product with the id provided"));
            product.updateProductModel(event.productModel());
        });

        apply((ProductBrandOrderDataUpdated event) -> {
            var order = inventory.getOrderDataByID(event.orderDataID()).orElseThrow(() ->
                    new IllegalArgumentException("Not able to find a order data with the id provided"));
            order.updateProductBrand(event.productBrand());
        });

        apply((ProductModelOrderDataUpdated event) -> {
            var order = inventory.getOrderDataByID(event.orderDataID()).orElseThrow(() ->
                    new IllegalArgumentException("Not able to find a order data with the id provided"));
            order.updateProductModel(event.productModel());
        });

        apply((SupplierUpdated event) -> {
            var order = inventory.getOrderDataByID(event.orderDataID()).orElseThrow(() ->
                    new IllegalArgumentException("Not able to find a order data with the id provided"));
            order.updateSupplier(event.supplier());
        });

        apply((InventoryAssistantNameUpdated event) -> {
            var assistant = inventory.getInventoryAssistantByID(event.inventoryAssistantID())
                    .orElseThrow(() -> new IllegalArgumentException("Not able to find an assistant with the id provided"));
            assistant.updateInventoryAssistantName(event.name());
        });

        apply((InventoryAssistantYearsOfExperienceUpdated event) -> {
            var assistant = inventory.getInventoryAssistantByID(event.inventoryAssistantID())
                    .orElseThrow(() -> new IllegalArgumentException("Not able to find an assistant with the id provided"));
            assistant.updateInventoryAssistantYearsOfExperience(event.yearsOfExperience());
        });

        apply((InventoryDateUpdated event) -> {
            inventory.inventoryDate = event.inventoryDate();
        });

    }

}
