package com.sofkaU.ChallengeDDD.cashdesk;

import co.com.sofka.domain.generic.EventChange;
import com.sofkaU.ChallengeDDD.cashdesk.events.CashDeskCreated;
import com.sofkaU.ChallengeDDD.cashdesk.events.CashierAdded;
import com.sofkaU.ChallengeDDD.cashdesk.events.ClientAdded;
import com.sofkaU.ChallengeDDD.cashdesk.events.PaymentAdded;


public class CashDeskChange extends EventChange {

    public CashDeskChange(CashDesk cashDesk){
        apply((CashDeskCreated event) -> {
            cashDesk.companyHeadquarter = event.companyHeadquarter();
        });

        apply((CashierAdded event) -> {
            Cashier cashier = new Cashier(event.cashierID(), event.name(), event.yearsOfExperience());
        });

        apply((ClientAdded event) -> {
            Client client = new Client(event.clientID(), event.name(), event.cc());
        });

        apply((PaymentAdded event) -> {
            Payment payment = new Payment(event.paymentID(), event.total(), event.paymentMethod());
        });


    }
}
