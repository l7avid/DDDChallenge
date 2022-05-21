package com.sofkaU.ChallengeDDD.cashdesk.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.ChallengeDDD.cashdesk.values.PaymentID;
import com.sofkaU.ChallengeDDD.cashdesk.values.PaymentMethod;
import com.sofkaU.ChallengeDDD.cashdesk.values.Total;

public class AddPayment extends Command {

    private final PaymentID paymentID;
    private final PaymentMethod paymentMethod;
    private final Total total;


    public AddPayment(PaymentID paymentID, PaymentMethod paymentMethod, Total total) {
        this.paymentID = paymentID;
        this.paymentMethod = paymentMethod;
        this.total = total;
    }

    public PaymentID paymentID() {
        return paymentID;
    }

    public PaymentMethod paymentMethod() {
        return paymentMethod;
    }

    public Total total() {
        return total;
    }
}
