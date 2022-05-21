package com.sofkaU.ChallengeDDD.cashdesk.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.ChallengeDDD.cashdesk.values.CashDeskID;
import com.sofkaU.ChallengeDDD.cashdesk.values.CashierID;
import com.sofkaU.ChallengeDDD.share.Name;

public class CashierNameUpdated extends DomainEvent {

    private final CashDeskID cashDeskID;
    private final CashierID cashierID;
    private final Name name;


    public CashierNameUpdated(CashDeskID cashDeskID, CashierID cashierID, Name name) {
        super("davidreina.cashdesk.cashiernameupdated");
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
