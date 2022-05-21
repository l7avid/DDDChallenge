package com.sofkaU.ChallengeDDD.cashdesk.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.ChallengeDDD.cashdesk.values.CashDeskID;
import com.sofkaU.ChallengeDDD.cashdesk.values.CompanyHeadquarter;

public class CompanyHeadquarterUpdated extends DomainEvent {

    private final CashDeskID cashDeskID;
    private final CompanyHeadquarter companyHeadquarter;


    public CompanyHeadquarterUpdated(CashDeskID cashDeskID, CompanyHeadquarter companyHeadquarter) {
        super("davidreina.cashdesk.companyheadquarterupdated");
        this.cashDeskID = cashDeskID;
        this.companyHeadquarter = companyHeadquarter;
    }

    public CashDeskID cashDeskID() {
        return cashDeskID;
    }

    public CompanyHeadquarter companyHeadquarter() {
        return companyHeadquarter;
    }
}
