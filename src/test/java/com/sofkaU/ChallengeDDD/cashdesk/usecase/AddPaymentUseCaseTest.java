package com.sofkaU.ChallengeDDD.cashdesk.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofkaU.ChallengeDDD.cashdesk.commands.AddPayment;
import com.sofkaU.ChallengeDDD.cashdesk.events.CashDeskCreated;
import com.sofkaU.ChallengeDDD.cashdesk.events.ClientAdded;
import com.sofkaU.ChallengeDDD.cashdesk.events.PaymentAdded;
import com.sofkaU.ChallengeDDD.cashdesk.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AddPaymentUseCaseTest {

    private final String ROOT_ID = "789";

    @Mock
    private DomainEventRepository repository;

    @Test
    void addPayment(){
        var command = new AddPayment(CashDeskID.of(ROOT_ID),
                PaymentID.of("2"),
                new PaymentMethod("Cash"),
                new Total(200L));

        var useCase = new AddPaymentUseCase();

        Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(List.of(
                new CashDeskCreated(
                        new CompanyHeadquarter("Medellin")
                )
        ));

        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOT_ID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Something went wrong while creating a payment"))
                .getDomainEvents();

        var event = (PaymentAdded)events.get(0);
        Assertions.assertEquals(command.paymentID().value(),event.paymentID().value());
        Assertions.assertEquals(command.paymentMethod().value(), event.paymentMethod().value());
        Assertions.assertEquals(command.total().value(), event.total().value());
    }

}