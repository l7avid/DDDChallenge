package com.sofkaU.ChallengeDDD.cashdesk.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.ChallengeDDD.cashdesk.values.PaymentID;
import com.sofkaU.ChallengeDDD.cashdesk.values.Total;

public class TotalToPayUpdated extends DomainEvent {

    private final PaymentID paymentID;
    private final Total total;


    public TotalToPayUpdated(PaymentID paymentID, Total total) {
        super("davidreina.cashdesk.totaltopayupdated");
        this.paymentID = paymentID;
        this.total = total;
    }

    public PaymentID paymentID() {
        return paymentID;
    }

    public Total total() {
        return total;
    }
}
