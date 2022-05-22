package com.sofkaU.ChallengeDDD.inventory.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkaU.ChallengeDDD.inventory.Inventory;
import com.sofkaU.ChallengeDDD.inventory.commands.AddOrderData;

public class AddOrderDataUseCase extends UseCase<RequestCommand<AddOrderData>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<AddOrderData> addOrderDataRequestCommand) {
        var command = addOrderDataRequestCommand.getCommand();

        var inventory = Inventory.from(command.inventoryID(), retrieveEvents(command.inventoryID().value()));

        /*inventory.toOrder().add(new OrderData(command.orderDataID(), command.productBrand(), command.productModel()));*/

        inventory.addOrderData(command.inventoryID(), command.orderDataID(), command.productBrand(), command.productModel(),
                command.supplier());

        emit().onResponse(new ResponseEvents(inventory.getUncommittedChanges()));
    }
}
