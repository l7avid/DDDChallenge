package com.sofkaU.ChallengeDDD.cashdesk.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkaU.ChallengeDDD.cashdesk.CashDesk;
import com.sofkaU.ChallengeDDD.cashdesk.commands.AddCashier;

public class AddCashierUseCase extends UseCase<RequestCommand<AddCashier>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddCashier> addCashierRequestCommand) {
        var command = addCashierRequestCommand.getCommand();
        var cashdesk = CashDesk.from(command.cashDeskID(), retrieveEvents(command.cashDeskID().value()));
        cashdesk.addCashier(command.cashDeskID(), command.cashierID(), command.name(), command.yearsOfExperience());

        emit().onResponse(new ResponseEvents(cashdesk.getUncommittedChanges()));
    }
}
