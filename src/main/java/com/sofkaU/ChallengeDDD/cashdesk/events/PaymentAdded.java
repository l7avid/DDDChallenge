package com.sofkaU.ChallengeDDD.cashdesk.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.ChallengeDDD.cashdesk.values.CashDeskID;
import com.sofkaU.ChallengeDDD.cashdesk.values.PaymentID;
import com.sofkaU.ChallengeDDD.cashdesk.values.PaymentMethod;
import com.sofkaU.ChallengeDDD.cashdesk.values.Total;

public class PaymentAdded extends DomainEvent {

    private final CashDeskID cashDeskID;
    private final PaymentID paymentID;
    private final Total total;
    private final PaymentMethod paymentMethod;


    public PaymentAdded(CashDeskID cashDeskID, PaymentID paymentID, Total total, PaymentMethod paymentMethod) {
        super("davidreina.cashdesk.paymentadded");
        this.cashDeskID = cashDeskID;
        this.paymentID = paymentID;
        this.total = total;
        this.paymentMethod = paymentMethod;
    }

    public CashDeskID cashDeskID() {
        return cashDeskID;
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
