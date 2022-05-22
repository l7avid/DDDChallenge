package com.sofkaU.ChallengeDDD.inventory.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.sofkaU.ChallengeDDD.cashdesk.commands.CreateCashDesk;
import com.sofkaU.ChallengeDDD.cashdesk.events.CashDeskCreated;
import com.sofkaU.ChallengeDDD.cashdesk.usecase.CreateCashDeskUseCase;
import com.sofkaU.ChallengeDDD.cashdesk.values.CashDeskID;
import com.sofkaU.ChallengeDDD.cashdesk.values.CompanyHeadquarter;
import com.sofkaU.ChallengeDDD.inventory.commands.CreateInventory;
import com.sofkaU.ChallengeDDD.inventory.events.InventoryCreated;
import com.sofkaU.ChallengeDDD.inventory.values.InventoryDate;
import com.sofkaU.ChallengeDDD.inventory.values.InventoryID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CreateInventoryUseCaseTest {

    private final String ROOT_ID = "111";

    @Test
    void createInventory(){

        var command = new CreateInventory(InventoryID.of(ROOT_ID),new InventoryDate("14-02-2022"));

        var useCase = new CreateInventoryUseCase();

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOT_ID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Something went wrong while creating an inventory"))
                .getDomainEvents();

        var event = (InventoryCreated)events.get(0);
        Assertions.assertEquals(command.inventoryDate().value(),event.inventoryDate().value());
    }
}