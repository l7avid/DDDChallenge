package com.sofkaU.ChallengeDDD.cashdesk;

import co.com.sofka.domain.generic.Entity;
import com.sofkaU.ChallengeDDD.cashdesk.values.CC;
import com.sofkaU.ChallengeDDD.cashdesk.values.ClientID;
import com.sofkaU.ChallengeDDD.share.Name;

import java.util.Objects;

public class Client extends Entity<ClientID> {

    private Name name;
    private CC cc;


    public Client(ClientID clientID, Name name, CC cc) {
        super(clientID);
        this.name = name;
        this.cc = cc;
    }

    public void updateClientName(Name name){
        this.name = Objects.requireNonNull(name);
    }

    public void updateClientCC(CC cc){
        this.cc = Objects.requireNonNull(cc);
    }
}
