package com.sofkaU.ChallengeDDD.cashdesk.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Total implements ValueObject<Long> {

    private final Long value;


    public Total(Long value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Long value() {
        return value;
    }
}
