package com.sofkaU.ChallengeDDD.inventory;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.generic.Identity;
import com.sofkaU.ChallengeDDD.inventory.values.ProductBrand;
import com.sofkaU.ChallengeDDD.inventory.values.ProductModel;
import com.sofkaU.ChallengeDDD.inventory.values.Supplier;

import java.util.Objects;

public class OrderData extends Entity {

    private ProductBrand productBrand;
    private ProductModel productModel;
    private Supplier supplier;


    public OrderData(Identity entityId, ProductBrand productBrand, ProductModel productModel) {
        super(entityId);
        this.productBrand = productBrand;
        this.productModel = productModel;
    }

    public void updateProductBrand(ProductBrand productBrand){
        this.productBrand = Objects.requireNonNull(productBrand);
    }

    public void updateProductModel(ProductModel productModel){
        this.productModel = Objects.requireNonNull(productModel);
    }

    public void updateSupplier(Supplier supplier){
        this.supplier = Objects.requireNonNull(supplier);
    }
}
