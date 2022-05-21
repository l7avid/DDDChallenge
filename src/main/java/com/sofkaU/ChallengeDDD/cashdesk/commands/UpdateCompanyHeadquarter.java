package com.sofkaU.ChallengeDDD.cashdesk.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.ChallengeDDD.cashdesk.values.CashDeskID;
import com.sofkaU.ChallengeDDD.cashdesk.values.CompanyHeadquarter;

public class UpdateCompanyHeadquarter extends Command {

    private final CashDeskID cashDeskID;
    private final CompanyHeadquarter companyHeadquarter;


    public UpdateCompanyHeadquarter(CashDeskID cashDeskID, CompanyHeadquarter companyHeadquarter) {
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
