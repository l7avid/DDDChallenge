package com.sofkaU.ChallengeDDD.cashdesk;

import co.com.sofka.domain.generic.EventChange;
import com.sofkaU.ChallengeDDD.cashdesk.events.CashDeskCreated;


public class CashDeskChange extends EventChange {

    public CashDeskChange(CashDesk cashDesk){
        apply((CashDeskCreated event) -> {
            cashDesk.companyHeadquarter = event
        })
    }
}
