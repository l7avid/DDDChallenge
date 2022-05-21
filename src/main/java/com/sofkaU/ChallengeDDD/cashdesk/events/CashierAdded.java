package com.sofkaU.ChallengeDDD.cashdesk.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.ChallengeDDD.cashdesk.values.CashierID;
import com.sofkaU.ChallengeDDD.share.Name;
import com.sofkaU.ChallengeDDD.share.YearsOfExperience;

public class CashierAdded extends DomainEvent {

    private final CashierID cashierID;
    private final Name name;
    private final YearsOfExperience yearsOfExperience;

    public CashierAdded(CashierID cashierID, Name name, YearsOfExperience yearsOfExperience) {
        super("davidreina.cashdesk.cashieradded");
        this.cashierID = cashierID;
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
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
