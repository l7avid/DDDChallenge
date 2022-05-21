package com.sofkaU.ChallengeDDD.cashdesk.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.ChallengeDDD.cashdesk.values.PaymentID;
import com.sofkaU.ChallengeDDD.cashdesk.values.PaymentMethod;

public class PaymentMethodUpdated extends DomainEvent {

    private final PaymentID paymentID;
    private final PaymentMethod paymentMethod;

    public PaymentMethodUpdated(PaymentID paymentID, PaymentMethod paymentMethod) {
        super("davidreina.cashdesk.paymentmethodupdated");
        this.paymentID = paymentID;
        this.paymentMethod = paymentMethod;
    }

    public PaymentID paymentID() {
        return paymentID;
    }

    public PaymentMethod paymentMethod() {
        return paymentMethod;
    }
}
