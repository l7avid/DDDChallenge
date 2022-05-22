package com.sofkaU.ChallengeDDD.inventory.values;

import co.com.sofka.domain.generic.Identity;

public class OrderDataID extends Identity {

    public OrderDataID(String uuid) {
        super(uuid);
    }

    public OrderDataID() {
    }

    public static OrderDataID of(String id){
        return new OrderDataID(id);
    }
}
