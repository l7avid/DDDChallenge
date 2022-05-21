package com.sofkaU.ChallengeDDD.cashdesk;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.ChallengeDDD.cashdesk.events.*;
import com.sofkaU.ChallengeDDD.cashdesk.values.*;
import com.sofkaU.ChallengeDDD.share.Name;
import com.sofkaU.ChallengeDDD.share.YearsOfExperience;

import java.util.List;
import java.util.Objects;

public class CashDesk extends AggregateEvent<CashDeskID> {

    protected CompanyHeadquarter companyHeadquarter;
    protected Client client;
    protected Payment payment;
    protected Cashier cashier;

    public CashDesk(CashDeskID cashDeskID, CompanyHeadquarter companyHeadquarter){
        super(cashDeskID);
        appendChange(new CashDeskCreated(companyHeadquarter)).apply();
    }

    private CashDesk(CashDeskID cashDeskID){
        super(cashDeskID);
        subscribe(new CashDeskChange(this));
    }

    public static CashDesk from(CashDeskID cashDeskID, List<DomainEvent> events){
        CashDesk cashDesk = new CashDesk(cashDeskID);
        events.forEach((event) -> cashDesk.applyEvent(event));
        return cashDesk;
    }

    public void addCashier(CashDeskID cashDeskID, CashierID cashierID, Name name, YearsOfExperience yearsOfExperience){
        Objects.requireNonNull(cashDeskID);
        Objects.requireNonNull(cashierID);
        Objects.requireNonNull(name);
        Objects.requireNonNull(yearsOfExperience);
        appendChange(new CashierAdded(cashDeskID, cashierID, name, yearsOfExperience)).apply();
    }

    public void addClient(CashDeskID cashDeskID, ClientID clientID, Name name, CC cc){
        Objects.requireNonNull(cashDeskID);
        Objects.requireNonNull(clientID);
        Objects.requireNonNull(name);
        Objects.requireNonNull(cc);
        appendChange(new ClientAdded(cashDeskID, clientID, name, cc)).apply();
    }

    public void addPayment(CashDeskID cashDeskID, PaymentID paymentID, PaymentMethod paymentMethod, Total total){
        Objects.requireNonNull(cashDeskID);
        Objects.requireNonNull(paymentID);
        Objects.requireNonNull(paymentMethod);
        Objects.requireNonNull(total);
        appendChange(new PaymentAdded(cashDeskID, paymentID, total, paymentMethod)).apply();
    }

    public void updateCashierName(CashDeskID cashDeskID, CashierID cashierID, Name name){
        Objects.requireNonNull(cashDeskID);
        Objects.requireNonNull(cashierID);
        Objects.requireNonNull(name);
        appendChange(new CashierNameUpdated(cashDeskID, cashierID, name)).apply();
    }

    public void updateCashierYearsOfExperience(CashDeskID cashDeskID, CashierID cashierID, YearsOfExperience yearsOfExperience){
        Objects.requireNonNull(cashDeskID);
        Objects.requireNonNull(cashierID);
        Objects.requireNonNull(yearsOfExperience);
        appendChange(new CashierYearsOfExperienceUpdated(cashDeskID, cashierID, yearsOfExperience)).apply();
    }

    public void updateClientName(CashDeskID cashDeskID, ClientID clientID, Name name){
        Objects.requireNonNull(cashDeskID);
        Objects.requireNonNull(clientID);
        Objects.requireNonNull(name);
        appendChange(new ClientNameUpdated(cashDeskID, clientID, name)).apply();
    }

    public void updateClientCC(CashDeskID cashDeskID, ClientID clientID, CC cc){
        Objects.requireNonNull(cashDeskID);
        Objects.requireNonNull(clientID);
        Objects.requireNonNull(cc);
        appendChange(new ClientCCUpdated(cashDeskID, clientID, cc)).apply();
    }

    public void updateTotalPayment(CashDeskID cashDeskID, PaymentID paymentID, Total total){
        Objects.requireNonNull(cashDeskID);
        Objects.requireNonNull(paymentID);
        Objects.requireNonNull(total);
        appendChange(new TotalToPayUpdated(cashDeskID, paymentID, total)).apply();
    }

    public void updatePaymentMethod(CashDeskID cashDeskID, PaymentID paymentID, PaymentMethod paymentMethod){
        Objects.requireNonNull(cashDeskID);
        Objects.requireNonNull(paymentID);
        Objects.requireNonNull(paymentMethod);
        appendChange(new PaymentMethodUpdated(cashDeskID, paymentID, paymentMethod)).apply();
    }

    public CompanyHeadquarter companyHeadquarter() {
        return companyHeadquarter;
    }

    public Client client() {
        return client;
    }

    public Payment payment() {
        return payment;
    }

    public Cashier cashier() {
        return cashier;
    }
}
