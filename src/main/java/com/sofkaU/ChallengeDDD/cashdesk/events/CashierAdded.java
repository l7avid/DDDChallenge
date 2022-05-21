package com.sofkaU.ChallengeDDD.cashdesk.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.ChallengeDDD.cashdesk.values.CashDeskID;
import com.sofkaU.ChallengeDDD.cashdesk.values.CashierID;
import com.sofkaU.ChallengeDDD.share.Name;
import com.sofkaU.ChallengeDDD.share.YearsOfExperience;

public class CashierAdded extends DomainEvent {

    private final CashDeskID cashDeskID;
    private final CashierID cashierID;
    private final Name name;
    private final YearsOfExperience yearsOfExperience;

    public CashierAdded(CashDeskID cashDeskID, CashierID cashierID, Name name, YearsOfExperience yearsOfExperience) {
        super("davidreina.cashdesk.cashieradded");
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
