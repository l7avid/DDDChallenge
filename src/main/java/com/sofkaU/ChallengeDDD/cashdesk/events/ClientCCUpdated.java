package com.sofkaU.ChallengeDDD.cashdesk.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.ChallengeDDD.cashdesk.values.CC;
import com.sofkaU.ChallengeDDD.cashdesk.values.CashDeskID;
import com.sofkaU.ChallengeDDD.cashdesk.values.ClientID;

public class ClientCCUpdated extends DomainEvent {

    private final CashDeskID cashDeskID;
    private final ClientID clientID;
    private final CC cc;

    public ClientCCUpdated(CashDeskID cashDeskID, ClientID clientID, CC cc) {
        super("davidreina.cashdesk.clientccupdated");
        this.cashDeskID = cashDeskID;
        this.clientID = clientID;
        this.cc = cc;
    }

    public CashDeskID cashDeskID() {
        return cashDeskID;
    }

    public ClientID clientID() {
        return clientID;
    }

    public CC cc() {
        return cc;
    }
}
