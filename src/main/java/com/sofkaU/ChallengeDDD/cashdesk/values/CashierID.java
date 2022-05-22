package com.sofkaU.ChallengeDDD.cashdesk.values;

import co.com.sofka.domain.generic.Identity;

public class CashierID extends Identity {

    private CashierID(String uuid) {
        super(uuid);
    }

    private CashierID() {
    }

    public static CashierID of(String id){
        return new CashierID(id);
    }
}
