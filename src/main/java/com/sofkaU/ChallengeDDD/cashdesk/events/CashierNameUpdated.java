package com.sofkaU.ChallengeDDD.cashdesk.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.ChallengeDDD.cashdesk.values.CashierID;
import com.sofkaU.ChallengeDDD.share.Name;

public class CashierNameUpdated extends DomainEvent {

    private final CashierID cashierID;
    private final Name name;


    public CashierNameUpdated(CashierID cashierID, Name name) {
        super("davidreina.cashdesk.cashiernameupdated");
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
