package com.sofkaU.ChallengeDDD.inventory.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkaU.ChallengeDDD.inventory.Inventory;
import com.sofkaU.ChallengeDDD.inventory.OrderData;
import com.sofkaU.ChallengeDDD.inventory.Product;
import com.sofkaU.ChallengeDDD.inventory.commands.AddProduct;

public class AddProductUseCase extends UseCase<RequestCommand<AddProduct>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<AddProduct> addProductRequestCommand) {
        var command = addProductRequestCommand.getCommand();

        var inventory = Inventory.from(command.inventoryID(), retrieveEvents(command.inventoryID().value()));

        inventory.addProduct(command.inventoryID(),command.productID(),command.productBrand(),command.productModel());
        /*inventory.stock().add(new Product(command.productID(), command.productBrand(), command.productModel()));*/

        emit().onResponse(new ResponseEvents(inventory.getUncommittedChanges()));
    }
}
