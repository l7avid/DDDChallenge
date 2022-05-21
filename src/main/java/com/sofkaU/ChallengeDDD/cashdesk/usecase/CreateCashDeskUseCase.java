package com.sofkaU.ChallengeDDD.cashdesk.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkaU.ChallengeDDD.cashdesk.CashDesk;
import com.sofkaU.ChallengeDDD.cashdesk.commands.CreateCashDesk;

public class CreateCashDeskUseCase extends UseCase<RequestCommand<CreateCashDesk>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<CreateCashDesk> createCashDeskRequestCommand) {

        var command = createCashDeskRequestCommand.getCommand();
        var cashdesk = new CashDesk(command.getCashDeskID(), command.companyHeadquarter());

        emit().onResponse(new ResponseEvents(cashdesk.getUncommittedChanges()));

    }
}
