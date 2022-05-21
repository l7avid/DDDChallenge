package com.sofkaU.ChallengeDDD.cashdesk.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.ChallengeDDD.cashdesk.values.CashDeskID;
import com.sofkaU.ChallengeDDD.cashdesk.values.PaymentID;
import com.sofkaU.ChallengeDDD.cashdesk.values.PaymentMethod;
import com.sofkaU.ChallengeDDD.cashdesk.values.Total;

public class AddPayment extends Command {

    private final CashDeskID cashDeskID;
    private final PaymentID paymentID;
    private final PaymentMethod paymentMethod;
    private final Total total;


    public AddPayment(CashDeskID cashDeskID, PaymentID paymentID, PaymentMethod paymentMethod, Total total) {
        this.cashDeskID = cashDeskID;
        this.paymentID = paymentID;
        this.paymentMethod = paymentMethod;
        this.total = total;
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

    public Total total() {
        return total;
    }
}
