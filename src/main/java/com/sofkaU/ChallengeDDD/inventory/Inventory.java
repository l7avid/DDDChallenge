package com.sofkaU.ChallengeDDD.inventory;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.ChallengeDDD.inventory.events.*;
import com.sofkaU.ChallengeDDD.inventory.values.*;
import com.sofkaU.ChallengeDDD.share.Name;
import com.sofkaU.ChallengeDDD.share.YearsOfExperience;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


public class Inventory extends AggregateEvent<InventoryID>{

    protected InventoryDate inventoryDate;
    protected ArrayList<Product> stock = new ArrayList<>();
    protected ArrayList<OrderData> toOrder = new ArrayList<>() ;
    protected ArrayList<InventoryAssistant> assistants = new ArrayList<>();

    public Inventory(InventoryID inventoryID, InventoryDate inventoryDate) {
        super(inventoryID);
        appendChange(new InventoryCreated(inventoryDate)).apply();
    }

    private Inventory(InventoryID inventoryID){
        super(inventoryID);
        subscribe(new InventoryChange(this));
    }

    public static Inventory from(InventoryID inventoryID, List<DomainEvent> events){
        Inventory inventory = new Inventory(inventoryID);
        events.forEach((event) -> inventory.applyEvent(event));
        return inventory;
    }

    public void addProduct(InventoryID inventoryID, ProductID productID, ProductBrand productBrand,
                           ProductModel productModel){
        Objects.requireNonNull(inventoryID);
        Objects.requireNonNull(productID);
        Objects.requireNonNull(productBrand);
        Objects.requireNonNull(productModel);
        appendChange(new ProductAdded(inventoryID,productID,productBrand,productModel)).apply();
    }

    public void addOrderData(InventoryID inventoryID, OrderDataID orderDataID, ProductBrand productBrand,
                           ProductModel productModel, Supplier supplier){
        Objects.requireNonNull(inventoryID);
        Objects.requireNonNull(orderDataID);
        Objects.requireNonNull(productBrand);
        Objects.requireNonNull(productModel);
        Objects.requireNonNull(supplier);
        appendChange(new OderDataAdded(inventoryID,orderDataID,productBrand,productModel,supplier)).apply();
    }

    public void addInventoryAssistant(InventoryID inventoryID, InventoryAssistantID inventoryAssistantID,
                                      Name name,
                                      YearsOfExperience yearsOfExperience){
        Objects.requireNonNull(inventoryID);
        Objects.requireNonNull(inventoryAssistantID);
        Objects.requireNonNull(name);
        Objects.requireNonNull(yearsOfExperience);
        appendChange(new InventoryAssistantAdded(inventoryID, inventoryAssistantID, name, yearsOfExperience)).apply();
    }

    public void updateProductBrandStock(InventoryID inventoryID, ProductID productID, ProductBrand productBrand){
        Objects.requireNonNull(inventoryID);
        Objects.requireNonNull(productID);
        Objects.requireNonNull(productBrand);
        appendChange(new ProductBrandStockUpdated(inventoryID, productID, productBrand)).apply();
    }

    public void updateProductModelStock(InventoryID inventoryID, ProductID productID, ProductModel productModel){
        Objects.requireNonNull(inventoryID);
        Objects.requireNonNull(productID);
        Objects.requireNonNull(productModel);
        appendChange(new ProductModelStockUpdated(inventoryID, productID, productModel)).apply();
    }

    public void updateProductBrandOrderData(InventoryID inventoryID, OrderDataID orderDataID, ProductBrand productBrand){
        Objects.requireNonNull(inventoryID);
        Objects.requireNonNull(orderDataID);
        Objects.requireNonNull(productBrand);
        appendChange(new ProductBrandOrderDataUpdated(inventoryID, orderDataID, productBrand)).apply();
    }

    public void updateProductModelOrderData(InventoryID inventoryID, OrderDataID orderDataID, ProductModel productModel){
        Objects.requireNonNull(inventoryID);
        Objects.requireNonNull(orderDataID);
        Objects.requireNonNull(productModel);
        appendChange(new ProductModelOrderDataUpdated(inventoryID, orderDataID, productModel)).apply();
    }

    public void updateSupplier(InventoryID inventoryID, OrderDataID orderDataID, Supplier supplier){
        Objects.requireNonNull(inventoryID);
        Objects.requireNonNull(orderDataID);
        Objects.requireNonNull(supplier);
        appendChange(new SupplierUpdated(inventoryID, orderDataID, supplier)).apply();
    }

    public void updateInventoryAssistantName(InventoryID inventoryID, InventoryAssistantID inventoryAssistantID,
                                             Name name){
        Objects.requireNonNull(inventoryID);
        Objects.requireNonNull(inventoryAssistantID);
        Objects.requireNonNull(name);
        appendChange(new InventoryAssistantNameUpdated(inventoryID, inventoryAssistantID, name)).apply();
    }

    public void updateInventoryAssistantYearsOfExperience(InventoryID inventoryID,
                                                          InventoryAssistantID inventoryAssistantID,
                                                          YearsOfExperience yearsOfExperience)
    {
        Objects.requireNonNull(inventoryID);
        Objects.requireNonNull(inventoryAssistantID);
        Objects.requireNonNull(yearsOfExperience);
        appendChange(new InventoryAssistantYearsOfExperienceUpdated(inventoryID,
                inventoryAssistantID,
                yearsOfExperience)).apply();
    }

    public void updateInventoryDate(InventoryID inventoryID, InventoryDate inventoryDate){
        Objects.requireNonNull(inventoryID);
        Objects.requireNonNull(inventoryDate);
        appendChange(new InventoryDateUpdated(inventoryID,inventoryDate)).apply();
    }

    protected Optional<Product> getProductByID(ProductID productID){
        return stock()
                .stream()
                .filter(product -> product.identity().equals(productID))
                .findFirst();
    }

    protected Optional<OrderData> getOrderDataByID(OrderDataID orderDataID){
        return toOrder
                .stream()
                .filter(item -> item.identity().equals(orderDataID))
                .findFirst();
    }

    protected Optional<InventoryAssistant> getInventoryAssistantByID(InventoryAssistantID inventoryAssistantID){
        return assistants()
                .stream()
                .filter(product -> product.identity().equals(inventoryAssistantID))
                .findFirst();
    }

    public InventoryDate inventoryDate() {
        return inventoryDate;
    }

    public ArrayList<Product> stock() {
        return stock;
    }

    public ArrayList<OrderData> toOrder() {
        return toOrder;
    }

    public ArrayList<InventoryAssistant> assistants() {
        return assistants;
    }
}
