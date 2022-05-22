package com.sofkaU.ChallengeDDD.inventory.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofkaU.ChallengeDDD.inventory.Inventory;
import com.sofkaU.ChallengeDDD.inventory.events.SupplierUpdated;

public class UpdateSupplierUseCase extends UseCase<TriggeredEvent<SupplierUpdated>, ResponseEvents> {


    @Override
    public void executeUseCase(TriggeredEvent<SupplierUpdated> supplierUpdatedTriggeredEvent) {

        var event = supplierUpdatedTriggeredEvent.getDomainEvent();

        var inventory = Inventory.from(event.inventoryID(),retrieveEvents(event.inventoryID().value()));

        inventory.updateSupplier(event.inventoryID(),event.orderDataID(),event.supplier());

        emit().onResponse(new ResponseEvents(inventory.getUncommittedChanges()));
    }
}
