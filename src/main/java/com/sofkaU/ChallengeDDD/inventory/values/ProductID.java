package com.sofkaU.ChallengeDDD.inventory.values;

import co.com.sofka.domain.generic.Identity;
import com.sofkaU.ChallengeDDD.cashdesk.values.PaymentID;

public class ProductID extends Identity {

    private ProductID(String uuid) {
        super(uuid);
    }

    public ProductID() {
    }

    public static ProductID of(String id){
        return new ProductID(id);
    }
}
