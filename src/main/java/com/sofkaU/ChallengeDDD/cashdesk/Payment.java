package com.sofkaU.ChallengeDDD.cashdesk;

import co.com.sofka.domain.generic.Entity;
import com.sofkaU.ChallengeDDD.cashdesk.values.PaymentID;
import com.sofkaU.ChallengeDDD.cashdesk.values.PaymentMethod;
import com.sofkaU.ChallengeDDD.cashdesk.values.Total;

import java.util.Objects;

public class Payment extends Entity<PaymentID> {

    private Total total;
    private PaymentMethod paymentMethod;


    public Payment(PaymentID entityId, Total total, PaymentMethod paymentMethod) {
        super(entityId);
        this.total = total;
        this.paymentMethod = paymentMethod;
    }

    public void updatePaymentMethod(PaymentMethod paymentMethod){
        this.paymentMethod = Objects.requireNonNull(paymentMethod);
    }

    public void updateTotal(Total total){
        this.total = Objects.requireNonNull(total);
    }
}
