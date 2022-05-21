package com.sofkaU.ChallengeDDD.cashdesk.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.ChallengeDDD.cashdesk.values.CashDeskID;
import com.sofkaU.ChallengeDDD.cashdesk.values.CashierID;
import com.sofkaU.ChallengeDDD.share.Name;
import com.sofkaU.ChallengeDDD.share.YearsOfExperience;

public class AddCashier extends Command {

    private final CashDeskID cashDeskID;
    private final CashierID cashierID;
    private final Name name;
    private final YearsOfExperience yearsOfExperience;

    public AddCashier(CashDeskID cashDeskID, CashierID cashierID, Name name, YearsOfExperience yearsOfExperience) {
        this.cashDeskID = cashDeskID;
        this.cashierID = cashierID;
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
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

    public YearsOfExperience yearsOfExperience() {
        return yearsOfExperience;
    }
}
