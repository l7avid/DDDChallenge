package com.sofkaU.ChallengeDDD.cashdesk.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.ChallengeDDD.cashdesk.values.CashDeskID;
import com.sofkaU.ChallengeDDD.cashdesk.values.ClientID;
import com.sofkaU.ChallengeDDD.share.Name;

public class ClientNameUpdated extends DomainEvent {

    private final CashDeskID cashDeskID;
    private final ClientID clientID;
    private final Name name;


    public ClientNameUpdated(CashDeskID cashDeskID, ClientID clientID, Name name) {
        super("davidreina.cashdesk.clientnameupdated");
        this.cashDeskID = cashDeskID;
        this.clientID = clientID;
        this.name = name;
    }

    public CashDeskID cashDeskID() {
        return cashDeskID;
    }

    public ClientID clientID() {
        return clientID;
    }

    public Name name() {
        return name;
    }
}
