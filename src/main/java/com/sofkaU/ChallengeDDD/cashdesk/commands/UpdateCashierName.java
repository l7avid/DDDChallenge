package com.sofkaU.ChallengeDDD.cashdesk.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.ChallengeDDD.cashdesk.values.CashierID;
import com.sofkaU.ChallengeDDD.share.Name;

public class UpdateCashierName extends Command {

    private final CashierID cashierID;
    private final Name name;


    public UpdateCashierName(CashierID cashierID, Name name) {
        this.cashierID = cashierID;
        this.name = name;
    }

    public CashierID cashierID() {
        return cashierID;
    }

    public Name name() {
        return name;
    }
}
