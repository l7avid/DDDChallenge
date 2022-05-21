package com.sofkaU.ChallengeDDD.cashdesk.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.ChallengeDDD.cashdesk.values.CompanyHeadquarter;

public class CompanyHeadquarterUpdated extends DomainEvent {

    private final CompanyHeadquarter companyHeadquarter;


    public CompanyHeadquarterUpdated(CompanyHeadquarter companyHeadquarter) {
        super("davidreina.cashdesk.companyheadquarterupdated");
        this.companyHeadquarter = companyHeadquarter;
    }

    public CompanyHeadquarter companyHeadquarter() {
        return companyHeadquarter;
    }
}
