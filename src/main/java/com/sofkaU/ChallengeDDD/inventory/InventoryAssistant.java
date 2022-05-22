package com.sofkaU.ChallengeDDD.inventory;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.generic.Identity;
import com.sofkaU.ChallengeDDD.inventory.values.ProductBrand;
import com.sofkaU.ChallengeDDD.inventory.values.ProductModel;
import com.sofkaU.ChallengeDDD.share.Name;
import com.sofkaU.ChallengeDDD.share.YearsOfExperience;

import java.util.Objects;

public class InventoryAssistant extends Entity {

    private Name name;
    private YearsOfExperience yearsOfExperience;


    public InventoryAssistant(Identity entityId, Name name, YearsOfExperience yearsOfExperience) {
        super(entityId);
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
    }

    public void updateInventoryAssistantName(Name name){
        this.name = Objects.requireNonNull(name);
    }

    public void updateInventoryAssistantYearsOfExperience(YearsOfExperience yearsOfExperience){
        this.yearsOfExperience = Objects.requireNonNull(yearsOfExperience);
    }
}
