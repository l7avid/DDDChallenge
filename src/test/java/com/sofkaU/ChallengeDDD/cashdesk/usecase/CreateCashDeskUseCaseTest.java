package com.sofkaU.ChallengeDDD.cashdesk.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.sofkaU.ChallengeDDD.cashdesk.commands.CreateCashDesk;
import com.sofkaU.ChallengeDDD.cashdesk.events.CashDeskCreated;
import com.sofkaU.ChallengeDDD.cashdesk.events.PaymentAdded;
import com.sofkaU.ChallengeDDD.cashdesk.values.CashDeskID;
import com.sofkaU.ChallengeDDD.cashdesk.values.CompanyHeadquarter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CreateCashDeskUseCaseTest {

    private final String ROOT_ID = "111";
    private CreateCashDeskUseCase createCashDeskUseCase;

    @Test
    void createCashDesk(){

        var command = new CreateCashDesk(CashDeskID.of(ROOT_ID), new CompanyHeadquarter("Manizales"));

        var useCase = new CreateCashDeskUseCase();

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOT_ID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Something went wrong while creating a cash desk"))
                .getDomainEvents();

        var event = (CashDeskCreated)events.get(0);
        Assertions.assertEquals(command.companyHeadquarter().value(),event.companyHeadquarter().value());
    }

}