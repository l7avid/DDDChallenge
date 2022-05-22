package com.sofkaU.ChallengeDDD.inventory.values;

import co.com.sofka.domain.generic.ValueObject;

public class Supplier implements ValueObject<String> {

    private final String value;


    public Supplier(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
