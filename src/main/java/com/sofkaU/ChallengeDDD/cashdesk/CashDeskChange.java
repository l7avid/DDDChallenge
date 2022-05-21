package com.sofkaU.ChallengeDDD.cashdesk;

import co.com.sofka.domain.generic.EventChange;
import com.sofkaU.ChallengeDDD.cashdesk.events.*;


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

        apply((CashierNameUpdated event) -> {
            cashDesk.cashier().updateCashierName(event.name());
        });

        apply((CashierYearsOfExperienceUpdated event) -> {
            cashDesk.cashier().updateCashierYearsOfExperience(event.yearsOfExperience());
        });

        apply((ClientNameUpdated event) -> {
            cashDesk.client().updateClientName(event.name());
        });

        apply((ClientCCUpdated event) -> {
            cashDesk.client().updateClientCC(event.cc());
        });

        apply((TotalToPayUpdated event) -> {
            cashDesk.payment().updateTotal(event.total());
        });

        apply((PaymentMethodUpdated event) -> {
            cashDesk.payment().updatePaymentMethod(event.paymentMethod());
        });

        apply((CompanyHeadquarterUpdated event) -> {
            cashDesk.companyHeadquarter = event.companyHeadquarter();
        });
    }
}
