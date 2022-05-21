package com.sofkaU.ChallengeDDD.cashdesk.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.ChallengeDDD.cashdesk.values.CashDeskID;
import com.sofkaU.ChallengeDDD.cashdesk.values.CashierID;
import com.sofkaU.ChallengeDDD.share.YearsOfExperience;

public class CashierYearsOfExperienceUpdated extends DomainEvent {

    private final CashDeskID cashDeskID;
    private final CashierID cashierID;
    private final YearsOfExperience yearsOfExperience;


    public CashierYearsOfExperienceUpdated(CashDeskID cashDeskID, CashierID cashierID, YearsOfExperience yearsOfExperience) {
        super("davidreina.cashdesk.cashieryearsofexpierenceupdated");
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
