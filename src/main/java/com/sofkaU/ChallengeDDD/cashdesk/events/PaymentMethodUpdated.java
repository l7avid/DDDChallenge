package com.sofkaU.ChallengeDDD.cashdesk.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.ChallengeDDD.cashdesk.values.CashDeskID;
import com.sofkaU.ChallengeDDD.cashdesk.values.PaymentID;
import com.sofkaU.ChallengeDDD.cashdesk.values.PaymentMethod;

public class PaymentMethodUpdated extends DomainEvent {

    private final CashDeskID cashDeskID;
    private final PaymentID paymentID;
    private final PaymentMethod paymentMethod;

    public PaymentMethodUpdated(CashDeskID cashDeskID, PaymentID paymentID, PaymentMethod paymentMethod) {
        super("davidreina.cashdesk.paymentmethodupdated");
        this.cashDeskID = cashDeskID;
        this.paymentID = paymentID;
        this.paymentMethod = paymentMethod;
    }

    public CashDeskID cashDeskID() {
        return cashDeskID;
    }

    public PaymentID paymentID() {
        return paymentID;
    }

    public PaymentMethod paymentMethod() {
        return paymentMethod;
    }
}
