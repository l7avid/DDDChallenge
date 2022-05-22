package com.sofkaU.ChallengeDDD.inventory.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class InventoryDate implements ValueObject<String> {

    private final String value;

    public InventoryDate(String value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return value;
    }
}
