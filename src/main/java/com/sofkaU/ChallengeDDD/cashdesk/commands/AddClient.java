package com.sofkaU.ChallengeDDD.cashdesk.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.ChallengeDDD.cashdesk.values.CC;
import com.sofkaU.ChallengeDDD.cashdesk.values.ClientID;
import com.sofkaU.ChallengeDDD.share.Name;

public class AddClient extends Command {

    private final ClientID clientID;
    private final Name name;
    private final CC cc;


    public AddClient(ClientID clientID, Name name, CC cc) {
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
