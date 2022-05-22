package com.sofkaU.ChallengeDDD.inventory.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkaU.ChallengeDDD.inventory.Inventory;
import com.sofkaU.ChallengeDDD.inventory.InventoryAssistant;
import com.sofkaU.ChallengeDDD.inventory.commands.AddInventoryAssistant;

public class AddInventoryAssistantUseCase extends UseCase<RequestCommand<AddInventoryAssistant>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddInventoryAssistant> addInventoryAssistantRequestCommand) {
        var command = addInventoryAssistantRequestCommand.getCommand();

        var inventory = Inventory.from(command.inventoryID(), retrieveEvents(command.inventoryID().value()));

        inventory.addInventoryAssistant(command.inventoryID(),command.inventoryAssistantID(),command.name(), command.yearsOfExperience());

        /*inventory.assistants().add(new InventoryAssistant(command.inventoryAssistantID(),
                command.name(),
                command.yearsOfExperience()));*/

        emit().onResponse(new ResponseEvents(inventory.getUncommittedChanges()));

    }
}
