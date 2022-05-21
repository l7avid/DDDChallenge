package com.sofkaU.ChallengeDDD.cashdesk.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.ChallengeDDD.cashdesk.values.CashDeskID;
import com.sofkaU.ChallengeDDD.cashdesk.values.PaymentID;
import com.sofkaU.ChallengeDDD.cashdesk.values.Total;

public class UpdateTotalToPay extends Command {

    private final CashDeskID cashDeskID;
    private final PaymentID paymentID;
    private final Total total;


    public UpdateTotalToPay(CashDeskID cashDeskID, PaymentID paymentID, Total total) {
        this.cashDeskID = cashDeskID;
        this.paymentID = paymentID;
        this.total = total;
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
}
