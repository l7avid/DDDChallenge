package com.sofkaU.ChallengeDDD.cashdesk.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.ChallengeDDD.cashdesk.values.CashDeskID;
import com.sofkaU.ChallengeDDD.cashdesk.values.CashierID;
import com.sofkaU.ChallengeDDD.share.Name;

public class UpdateCashierName extends Command {

    private final CashDeskID cashDeskID;
    private final CashierID cashierID;
    private final Name name;


    public UpdateCashierName(CashDeskID cashDeskID, CashierID cashierID, Name name) {
        this.cashDeskID = cashDeskID;
        this.cashierID = cashierID;
        this.name = name;
    }

    public CashDeskID cashDeskID() {
        return cashDeskID;
    }

    public CashierID cashierID() {
        return cashierID;
    }

    public Name name() {
        return name;
    }
}
