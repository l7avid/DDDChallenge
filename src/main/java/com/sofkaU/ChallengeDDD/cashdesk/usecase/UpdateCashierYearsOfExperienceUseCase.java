package com.sofkaU.ChallengeDDD.cashdesk.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofkaU.ChallengeDDD.cashdesk.CashDesk;
import com.sofkaU.ChallengeDDD.cashdesk.events.CashierYearsOfExperienceUpdated;

public class UpdateCashierYearsOfExperienceUseCase extends UseCase<TriggeredEvent<CashierYearsOfExperienceUpdated>,
        ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<CashierYearsOfExperienceUpdated>
                                           cashierYearsOfExperienceUpdatedTriggeredEvent) {

        var event = cashierYearsOfExperienceUpdatedTriggeredEvent.getDomainEvent();
        var cashdesk = CashDesk.from(event.cashDeskID(), retrieveEvents(event.cashDeskID().value()));
        cashdesk.updateCashierYearsOfExperience(event.cashDeskID(),event.cashierID(), event.yearsOfExperience());

        emit().onResponse(new ResponseEvents(cashdesk.getUncommittedChanges()));

    }
}
