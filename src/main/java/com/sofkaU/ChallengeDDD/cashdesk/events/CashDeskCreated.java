package com.sofkaU.ChallengeDDD.cashdesk.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.ChallengeDDD.cashdesk.values.CashDeskID;
import com.sofkaU.ChallengeDDD.cashdesk.values.CompanyHeadquarter;

public class CashDeskCreated extends DomainEvent {

    //private final CashDeskID cashDeskID;
    private final CompanyHeadquarter companyHeadquarter;

    public CashDeskCreated(CompanyHeadquarter companyHeadquarter) {
        super("davidreina.cashdesk.cashdeskcreated");
        this.companyHeadquarter = companyHeadquarter;
    }

    public CompanyHeadquarter companyHeadquarter() {
        return companyHeadquarter;
    }
}
