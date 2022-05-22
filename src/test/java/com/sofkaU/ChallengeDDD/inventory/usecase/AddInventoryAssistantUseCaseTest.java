package com.sofkaU.ChallengeDDD.inventory.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofkaU.ChallengeDDD.cashdesk.commands.AddCashier;
import com.sofkaU.ChallengeDDD.cashdesk.events.CashDeskCreated;
import com.sofkaU.ChallengeDDD.cashdesk.events.CashierAdded;
import com.sofkaU.ChallengeDDD.cashdesk.usecase.AddCashierUseCase;
import com.sofkaU.ChallengeDDD.cashdesk.values.CashDeskID;
import com.sofkaU.ChallengeDDD.cashdesk.values.CashierID;
import com.sofkaU.ChallengeDDD.cashdesk.values.CompanyHeadquarter;
import com.sofkaU.ChallengeDDD.inventory.commands.AddInventoryAssistant;
import com.sofkaU.ChallengeDDD.inventory.events.InventoryAssistantAdded;
import com.sofkaU.ChallengeDDD.inventory.events.InventoryCreated;
import com.sofkaU.ChallengeDDD.inventory.events.OderDataAdded;
import com.sofkaU.ChallengeDDD.inventory.values.*;
import com.sofkaU.ChallengeDDD.share.Name;
import com.sofkaU.ChallengeDDD.share.YearsOfExperience;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AddInventoryAssistantUseCaseTest {

    private final String ROOT_ID = "123";

    @Mock
    private DomainEventRepository repository;

    @Test
    void addInventoryAssistant(){
        var command = new AddInventoryAssistant(InventoryID.of(ROOT_ID),
                InventoryAssistantID.of("5"),
                new Name("Santiago"),
                new YearsOfExperience(3));

        var useCase = new AddInventoryAssistantUseCase();

        Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(List.of(
                new InventoryCreated(new InventoryDate("15-01-2021"))));


        useCase.addRepository(repository);
        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOT_ID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Something went wrong while creating an inventory assistant"))
                .getDomainEvents();

        var event = (InventoryAssistantAdded)events.get(0);
        Assertions.assertEquals(command.inventoryID().value(),event.inventoryID().value());
        Assertions.assertEquals(command.inventoryAssistantID().value(), event.inventoryAssistantID().value());
        Assertions.assertEquals(command.name().value(), event.name().value());
        Assertions.assertEquals(command.yearsOfExperience().value(), event.yearsOfExperience().value());
    }
}