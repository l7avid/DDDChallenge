package com.sofkaU.ChallengeDDD.cashdesk.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.ChallengeDDD.cashdesk.values.CC;
import com.sofkaU.ChallengeDDD.cashdesk.values.ClientID;

public class ClientCCUpdated extends DomainEvent {

    private final ClientID clientID;
    private final CC cc;

    public ClientCCUpdated(ClientID clientID, CC cc) {
        super("davidreina.cashdesk.clientccupdated");
        this.clientID = clientID;
        this.cc = cc;
    }

    public ClientID clientID() {
        return clientID;
    }

    public CC cc() {
        return cc;
    }
}
