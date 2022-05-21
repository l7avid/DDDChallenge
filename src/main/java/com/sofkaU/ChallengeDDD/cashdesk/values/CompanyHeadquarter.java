package com.sofkaU.ChallengeDDD.cashdesk.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class CompanyHeadquarter implements ValueObject<String> {

    private final String value;


    public CompanyHeadquarter(String value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return value;
    }
}
