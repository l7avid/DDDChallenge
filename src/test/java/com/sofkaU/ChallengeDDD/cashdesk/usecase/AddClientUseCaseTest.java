package com.sofkaU.ChallengeDDD.cashdesk.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofkaU.ChallengeDDD.cashdesk.commands.AddClient;
import com.sofkaU.ChallengeDDD.cashdesk.events.CashDeskCreated;
import com.sofkaU.ChallengeDDD.cashdesk.events.CashierAdded;
import com.sofkaU.ChallengeDDD.cashdesk.events.ClientAdded;
import com.sofkaU.ChallengeDDD.cashdesk.values.CC;
import com.sofkaU.ChallengeDDD.cashdesk.values.CashDeskID;
import com.sofkaU.ChallengeDDD.cashdesk.values.ClientID;
import com.sofkaU.ChallengeDDD.cashdesk.values.CompanyHeadquarter;
import com.sofkaU.ChallengeDDD.share.Name;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class AddClientUseCaseTest {

    private final String ROOT_ID = "456";

    @Mock
    private DomainEventRepository repository;

    @Test
    void addClient(){
        var command = new AddClient(CashDeskID.of(ROOT_ID),
                ClientID.of("1"),
                new Name("Maria"),
                new CC(0000L));

        var useCase = new AddClientUseCase();

        Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(List.of(
                new CashDeskCreated(
                        new CompanyHeadquarter("Bogota")
                )
        ));

        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOT_ID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Something went wrong while creating a client"))
                .getDomainEvents();

        var event = (ClientAdded)events.get(0);
        Assertions.assertEquals(command.clientID().value(),event.clientID().value());
        Assertions.assertEquals(command.name().value(), event.name().value());
        Assertions.assertEquals(command.cc().value(), event.cc().value());
    }
}