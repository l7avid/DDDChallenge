package com.sofkaU.ChallengeDDD.cashdesk.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class CC implements ValueObject<Long> {

    private final Long value;


    public CC(Long value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Long value() {
        return value;
    }
}
