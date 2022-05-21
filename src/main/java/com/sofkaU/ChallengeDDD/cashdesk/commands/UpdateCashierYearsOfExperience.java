package com.sofkaU.ChallengeDDD.cashdesk.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.ChallengeDDD.cashdesk.values.CashDeskID;
import com.sofkaU.ChallengeDDD.cashdesk.values.CashierID;
import com.sofkaU.ChallengeDDD.share.YearsOfExperience;

public class UpdateCashierYearsOfExperience extends Command {

    private final CashDeskID cashDeskID;
    private final CashierID cashierID;
    private final YearsOfExperience yearsOfExperience;


    public UpdateCashierYearsOfExperience(CashDeskID cashDeskID, CashierID cashierID, YearsOfExperience yearsOfExperience) {
        this.cashDeskID = cashDeskID;
        this.cashierID = cashierID;
        this.yearsOfExperience = yearsOfExperience;
    }

    public CashDeskID cashDeskID() {
        return cashDeskID;
    }

    public CashierID cashierID() {
        return cashierID;
    }

    public YearsOfExperience yearsOfExperience() {
        return yearsOfExperience;
    }
}
