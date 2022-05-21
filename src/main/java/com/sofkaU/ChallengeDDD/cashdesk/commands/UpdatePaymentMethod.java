package com.sofkaU.ChallengeDDD.cashdesk.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.ChallengeDDD.cashdesk.values.PaymentID;
import com.sofkaU.ChallengeDDD.cashdesk.values.PaymentMethod;

public class UpdatePaymentMethod extends Command {

    private final PaymentID paymentID;
    private final PaymentMethod paymentMethod;

    public UpdatePaymentMethod(PaymentID paymentID, PaymentMethod paymentMethod) {
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
