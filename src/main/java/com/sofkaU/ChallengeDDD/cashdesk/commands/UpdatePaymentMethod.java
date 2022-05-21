package com.sofkaU.ChallengeDDD.cashdesk.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.ChallengeDDD.cashdesk.values.CashDeskID;
import com.sofkaU.ChallengeDDD.cashdesk.values.PaymentID;
import com.sofkaU.ChallengeDDD.cashdesk.values.PaymentMethod;

public class UpdatePaymentMethod extends Command {

    private final CashDeskID cashDeskID;
    private final PaymentID paymentID;
    private final PaymentMethod paymentMethod;

    public UpdatePaymentMethod(CashDeskID cashDeskID, PaymentID paymentID, PaymentMethod paymentMethod) {
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
