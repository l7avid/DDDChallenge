package com.sofkaU.ChallengeDDD.cashdesk.values;

import co.com.sofka.domain.generic.Identity;

public class CashDeskID extends Identity {

    private CashDeskID(String uuid) {
        super(uuid);
    }

    public CashDeskID() {
    }

    public static CashDeskID of(String id){
        return new CashDeskID(id);
    }
}
