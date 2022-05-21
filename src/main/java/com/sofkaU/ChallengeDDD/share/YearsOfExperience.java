package com.sofkaU.ChallengeDDD.share;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class YearsOfExperience implements ValueObject<Integer> {

    private final Integer value;

    public YearsOfExperience(Integer value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Integer value() {
        return null;
    }
}
