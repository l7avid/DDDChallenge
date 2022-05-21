package com.sofkaU.ChallengeDDD.cashdesk.values;

import co.com.sofka.domain.generic.Identity;

public class ClientID extends Identity {

    private ClientID(String uuid) {
        super(uuid);
    }

    public ClientID() {
    }

    public static ClientID of(String id){
        return new ClientID(id);
    }
}
