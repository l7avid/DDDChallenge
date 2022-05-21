package com.sofkaU.ChallengeDDD.cashdesk.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.ChallengeDDD.cashdesk.values.CC;
import com.sofkaU.ChallengeDDD.cashdesk.values.ClientID;
import com.sofkaU.ChallengeDDD.share.Name;

public class ClientAdded extends DomainEvent {

    private final ClientID clientID;
    private final Name name;
    private final CC cc;


    public ClientAdded(ClientID clientID, Name name, CC cc) {
        super("davidreina.cashdesk.clientadded");
        this.clientID = clientID;
        this.name = name;
        this.cc = cc;
    }

    public ClientID clientID() {
        return clientID;
    }

    public Name name() {
        return name;
    }

    public CC cc() {
        return cc;
    }
}
