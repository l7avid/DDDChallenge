package com.sofkaU.ChallengeDDD.inventory;

import co.com.sofka.domain.generic.Entity;
import com.sofkaU.ChallengeDDD.cashdesk.values.PaymentMethod;
import com.sofkaU.ChallengeDDD.cashdesk.values.Total;
import com.sofkaU.ChallengeDDD.inventory.values.ProductBrand;
import com.sofkaU.ChallengeDDD.inventory.values.ProductID;
import com.sofkaU.ChallengeDDD.inventory.values.ProductModel;

import java.util.Objects;

public class Product extends Entity<ProductID> {

    private ProductBrand productBrand;
    private ProductModel productModel;

    public Product(ProductID entityId, ProductBrand productBrand, ProductModel productModel) {
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
}
