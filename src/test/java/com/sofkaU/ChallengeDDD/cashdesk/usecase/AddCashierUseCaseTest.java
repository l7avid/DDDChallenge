package com.sofkaU.ChallengeDDD.cashdesk.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofkaU.ChallengeDDD.cashdesk.commands.AddCashier;
import com.sofkaU.ChallengeDDD.cashdesk.events.CashDeskCreated;
import com.sofkaU.ChallengeDDD.cashdesk.events.CashierAdded;
import com.sofkaU.ChallengeDDD.cashdesk.values.CashDeskID;
import com.sofkaU.ChallengeDDD.cashdesk.values.CashierID;
import com.sofkaU.ChallengeDDD.cashdesk.values.CompanyHeadquarter;
import com.sofkaU.ChallengeDDD.share.Name;
import com.sofkaU.ChallengeDDD.share.YearsOfExperience;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class AddCashierUseCaseTest {

    private final String ROOT_ID = "123";

    @Mock
    private DomainEventRepository repository;

    @Test
    void addCashier(){
        var command = new AddCashier(CashDeskID.of(ROOT_ID),
                CashierID.of("1"),
                new Name("David"),
                new YearsOfExperience(0));

        var useCase = new AddCashierUseCase();

        Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(List.of(
                new CashDeskCreated(
                        new CompanyHeadquarter("Neiva")
                )
        ));

        useCase.addRepository(repository);
        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOT_ID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Something went wrong while creating a cashier"))
                .getDomainEvents();

        var event = (CashierAdded)events.get(0);
        Assertions.assertEquals(command.cashierID().value(),event.cashierID().value());
        Assertions.assertEquals(command.name().value(), event.name().value());
        Assertions.assertEquals(command.yearsOfExperience().value(), event.yearsOfExperience().value());
    }

}