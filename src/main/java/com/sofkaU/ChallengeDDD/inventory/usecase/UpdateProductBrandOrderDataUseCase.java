package com.sofkaU.ChallengeDDD.inventory.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkaU.ChallengeDDD.inventory.Inventory;
import com.sofkaU.ChallengeDDD.inventory.InventoryAssistant;
import com.sofkaU.ChallengeDDD.inventory.commands.UpdateProductBrandOrderData;

public class UpdateProductBrandOrderDataUseCase extends UseCase<RequestCommand<UpdateProductBrandOrderData>,
        ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<UpdateProductBrandOrderData> updateProductBrandOrderDataRequestCommand) {

        var command = updateProductBrandOrderDataRequestCommand.getCommand();

        var inventory = Inventory.from(command.inventoryID(), retrieveEvents(command.inventoryID().value()));

        inventory.updateProductBrandOrderData(command.inventoryID(), command.orderDataID(), command.productBrand());

        emit().onResponse(new ResponseEvents(inventory.getUncommittedChanges()));
    }
}
