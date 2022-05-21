package com.sofkaU.ChallengeDDD.cashdesk.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.ChallengeDDD.cashdesk.values.CompanyHeadquarter;

public class UpdateCompanyHeadquarter extends Command {

    private final CompanyHeadquarter companyHeadquarter;


    public UpdateCompanyHeadquarter(CompanyHeadquarter companyHeadquarter) {
        this.companyHeadquarter = companyHeadquarter;
    }

    public CompanyHeadquarter companyHeadquarter() {
        return companyHeadquarter;
    }
}
