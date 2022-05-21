package com.sofkaU.ChallengeDDD.cashdesk.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.ChallengeDDD.cashdesk.values.ClientID;
import com.sofkaU.ChallengeDDD.share.Name;

public class UpdateClientName extends Command {

    private final ClientID clientID;
    private final Name name;


    public UpdateClientName(ClientID clientID, Name name) {
        this.clientID = clientID;
        this.name = name;
    }

    public ClientID clientID() {
        return clientID;
    }

    public Name name() {
        return name;
    }
}
