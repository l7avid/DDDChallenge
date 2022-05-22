package com.sofkaU.ChallengeDDD.inventory.values;

import co.com.sofka.domain.generic.ValueObject;

public class ProductModel implements ValueObject<String> {

    private final String value;


    public ProductModel(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
