package com.sofkaU.ChallengeDDD.cashdesk;

import co.com.sofka.domain.generic.AggregateEvent;
import com.sofkaU.ChallengeDDD.cashdesk.events.CashDeskCreated;
import com.sofkaU.ChallengeDDD.cashdesk.values.CashDeskID;
import com.sofkaU.ChallengeDDD.cashdesk.values.CompanyHeadquarter;

public class CashDesk extends AggregateEvent<CashDeskID> {

    protected CompanyHeadquarter companyHeadquarter;
    protected Client client;
    protected Payment payment;
    protected Cashier cashier;

    public CashDesk(CashDeskID cashDeskID, CompanyHeadquarter companyHeadquarter){
        super(cashDeskID);
        appendChange(new CashDeskCreated(companyHeadquarter)).apply();
    }

    private CashDesk(CashDeskID cashDeskID){
        super(cashDeskID);
        subscribe(new CashDeskChange(this));
    }
}
