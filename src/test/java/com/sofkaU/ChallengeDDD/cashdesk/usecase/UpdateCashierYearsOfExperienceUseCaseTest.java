package com.sofkaU.ChallengeDDD.cashdesk.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofkaU.ChallengeDDD.cashdesk.events.CashDeskCreated;
import com.sofkaU.ChallengeDDD.cashdesk.events.CashierAdded;
import com.sofkaU.ChallengeDDD.cashdesk.events.CashierNameUpdated;
import com.sofkaU.ChallengeDDD.cashdesk.events.CashierYearsOfExperienceUpdated;
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

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UpdateCashierYearsOfExperienceUseCaseTest {

    private final String ROOT_ID = "001";

    @Mock
    private DomainEventRepository repository;

    @Test
    void updateCashierYearsOfExperience(){
        var eventCashierYearsOfExperienceUpdated = new CashierYearsOfExperienceUpdated(CashDeskID.of(ROOT_ID),
                CashierID.of("1"),
                new YearsOfExperience(2));

        var useCase = new UpdateCashierYearsOfExperienceUseCase();

        Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(List.of(
                new CashDeskCreated(new CompanyHeadquarter("Medellin")),
                new CashierAdded(CashDeskID.of("2"),
                        CashierID.of("1"),
                        new Name("David"),
                        new YearsOfExperience(1))
                )
        );

        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOT_ID)
                .syncExecutor(useCase, new TriggeredEvent<>(eventCashierYearsOfExperienceUpdated))
                .orElseThrow(() -> new IllegalArgumentException("Something went wrong while updating cashier years of " +
                        "experience"))
                .getDomainEvents();

        var event = (CashierYearsOfExperienceUpdated)events.get(0);
        Assertions.assertEquals(eventCashierYearsOfExperienceUpdated.cashDeskID().value(),event.cashDeskID().value());
        Assertions.assertEquals(eventCashierYearsOfExperienceUpdated.yearsOfExperience().value(),
                event.yearsOfExperience().value());

    }
}