package com.sofkaU.ChallengeDDD.cashdesk.values;

import co.com.sofka.domain.generic.Identity;

public class PaymentID extends Identity {

    private PaymentID(String uuid) {
        super(uuid);
    }

    public PaymentID() {
    }

    public static PaymentID of(String id){
        return new PaymentID(id);
    }
}
