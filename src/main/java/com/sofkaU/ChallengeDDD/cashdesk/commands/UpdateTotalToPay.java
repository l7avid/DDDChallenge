package com.sofkaU.ChallengeDDD.cashdesk.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.ChallengeDDD.cashdesk.values.PaymentID;
import com.sofkaU.ChallengeDDD.cashdesk.values.Total;

public class UpdateTotalToPay extends Command {

    private final PaymentID paymentID;
    private final Total total;


    public UpdateTotalToPay(PaymentID paymentID, Total total) {
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
