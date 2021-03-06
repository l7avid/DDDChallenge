package com.sofkaU.ChallengeDDD.cashdesk.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkaU.ChallengeDDD.cashdesk.CashDesk;
import com.sofkaU.ChallengeDDD.cashdesk.commands.AddClient;

public class AddClientUseCase extends UseCase<RequestCommand<AddClient>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<AddClient> addClientRequestCommand) {

        var command = addClientRequestCommand.getCommand();
        var cashdesk = CashDesk.from(command.cashDeskID(), retrieveEvents(command.cashDeskID().value()));
        cashdesk.addClient(command.cashDeskID(), command.clientID(), command.name(), command.cc());

        emit().onResponse(new ResponseEvents(cashdesk.getUncommittedChanges()));
    }
}
