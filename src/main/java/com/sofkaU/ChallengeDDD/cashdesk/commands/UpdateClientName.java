package com.sofkaU.ChallengeDDD.cashdesk.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.ChallengeDDD.cashdesk.values.CashDeskID;
import com.sofkaU.ChallengeDDD.cashdesk.values.ClientID;
import com.sofkaU.ChallengeDDD.share.Name;

public class UpdateClientName extends Command {

    private final CashDeskID cashDeskID;
    private final ClientID clientID;
    private final Name name;


    public UpdateClientName(CashDeskID cashDeskID, ClientID clientID, Name name) {
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
