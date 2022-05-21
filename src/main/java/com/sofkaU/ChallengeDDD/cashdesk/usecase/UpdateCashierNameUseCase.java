package com.sofkaU.ChallengeDDD.cashdesk.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkaU.ChallengeDDD.cashdesk.CashDesk;
import com.sofkaU.ChallengeDDD.cashdesk.commands.UpdateCashierName;

public class UpdateCashierNameUseCase extends UseCase<RequestCommand<UpdateCashierName>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<UpdateCashierName> updateCashierNameRequestCommand) {
        var command = updateCashierNameRequestCommand.getCommand();
        var cashdesk = CashDesk.from(command.cashDeskID(), retrieveEvents(command.cashDeskID().value()));
        cashdesk.updateCashierName(command.cashDeskID(), command.cashierID(),command.name());

        emit().onResponse(new ResponseEvents(cashdesk.getUncommittedChanges()));
    }
}
