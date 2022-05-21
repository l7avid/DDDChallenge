package com.sofkaU.ChallengeDDD.cashdesk.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkaU.ChallengeDDD.cashdesk.CashDesk;
import com.sofkaU.ChallengeDDD.cashdesk.commands.AddPayment;

public class AddPaymentUseCase extends UseCase<RequestCommand<AddPayment>, ResponseEvents>{

    @Override
    public void executeUseCase(RequestCommand<AddPayment> addPaymentRequestCommand) {
        var command = addPaymentRequestCommand.getCommand();
        var cashdesk = CashDesk.from(command.cashDeskID(), retrieveEvents(command.cashDeskID().value()));
        cashdesk.addPayment(command.paymentID(), command.paymentMethod(), command.total());

        emit().onResponse(new ResponseEvents(cashdesk.getUncommittedChanges()));
    }
}
