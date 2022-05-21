package com.sofkaU.ChallengeDDD.cashdesk.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.ChallengeDDD.cashdesk.values.CC;
import com.sofkaU.ChallengeDDD.cashdesk.values.CashDeskID;
import com.sofkaU.ChallengeDDD.cashdesk.values.ClientID;

public class UpdateClientCC extends Command {

    private final CashDeskID cashDeskID;
    private final ClientID clientID;
    private final CC cc;

    public UpdateClientCC(CashDeskID cashDeskID, ClientID clientID, CC cc) {
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
