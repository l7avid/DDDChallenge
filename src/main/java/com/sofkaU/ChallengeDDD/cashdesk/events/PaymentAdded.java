package com.sofkaU.ChallengeDDD.cashdesk.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.ChallengeDDD.cashdesk.values.PaymentID;
import com.sofkaU.ChallengeDDD.cashdesk.values.PaymentMethod;
import com.sofkaU.ChallengeDDD.cashdesk.values.Total;

public class PaymentAdded extends DomainEvent {

    private final PaymentID paymentID;
    private final Total total;
    private final PaymentMethod paymentMethod;


    public PaymentAdded(PaymentID paymentID, Total total, PaymentMethod paymentMethod) {
        super("davidreina.cashdesk.paymentadded");
        this.paymentID = paymentID;
        this.total = total;
        this.paymentMethod = paymentMethod;
    }

    public PaymentID paymentID() {
        return paymentID;
    }

    public Total total() {
        return total;
    }

    public PaymentMethod paymentMethod() {
        return paymentMethod;
    }
}
