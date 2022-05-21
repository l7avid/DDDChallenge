package com.sofkaU.ChallengeDDD.cashdesk;

import co.com.sofka.domain.generic.Entity;
import com.sofkaU.ChallengeDDD.cashdesk.values.CashierID;
import com.sofkaU.ChallengeDDD.share.Name;
import com.sofkaU.ChallengeDDD.share.YearsOfExperience;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Cashier extends Entity<CashierID> {

    private Name name;
    private YearsOfExperience yearsOfExperience;

    public Cashier(CashierID entityId, Name name, YearsOfExperience yearsOfExperience) {
        super(entityId);
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
    }

    public void updateCashierName(Name name){
        this.name = Objects.requireNonNull(name);

    }

    public void updateCashierYearsOfExperience(YearsOfExperience yearsOfExperience){
        if(StringUtils.isNumeric(yearsOfExperience.toString())){
            this.yearsOfExperience = yearsOfExperience;
        }
    }

    public Name name() {
        return name;
    }

    public YearsOfExperience yearsOfExperience() {
        return yearsOfExperience;
    }
}
