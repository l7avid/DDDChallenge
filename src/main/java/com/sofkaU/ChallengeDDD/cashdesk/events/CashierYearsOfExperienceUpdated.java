package com.sofkaU.ChallengeDDD.cashdesk.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.ChallengeDDD.cashdesk.values.CashierID;
import com.sofkaU.ChallengeDDD.share.YearsOfExperience;

public class CashierYearsOfExperienceUpdated extends DomainEvent {

    private final CashierID cashierID;
    private final YearsOfExperience yearsOfExperience;


    public CashierYearsOfExperienceUpdated(CashierID cashierID, YearsOfExperience yearsOfExperience) {
        super("davidreina.cashdesk.cashieryearsofexpierenceupdated");
        this.cashierID = cashierID;
        this.yearsOfExperience = yearsOfExperience;
    }

    public CashierID cashierID() {
        return cashierID;
    }

    public YearsOfExperience yearsOfExperience() {
        return yearsOfExperience;
    }
}
