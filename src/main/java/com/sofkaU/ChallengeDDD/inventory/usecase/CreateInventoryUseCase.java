package com.sofkaU.ChallengeDDD.inventory.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkaU.ChallengeDDD.inventory.Inventory;
import com.sofkaU.ChallengeDDD.inventory.commands.CreateInventory;

public class CreateInventoryUseCase extends UseCase<RequestCommand<CreateInventory>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CreateInventory> createInventoryRequestCommand) {

        var command = createInventoryRequestCommand.getCommand();

        var inventory = new Inventory(command.inventoryID(), command.inventoryDate());

        emit().onResponse(new ResponseEvents(inventory.getUncommittedChanges()));
    }
}
