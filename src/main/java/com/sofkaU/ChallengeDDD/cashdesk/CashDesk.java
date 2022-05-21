package com.sofkaU.ChallengeDDD.cashdesk;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.ChallengeDDD.cashdesk.commands.UpdateCashierName;
import com.sofkaU.ChallengeDDD.cashdesk.events.CashDeskCreated;
import com.sofkaU.ChallengeDDD.cashdesk.events.CashierAdded;
import com.sofkaU.ChallengeDDD.cashdesk.events.ClientAdded;
import com.sofkaU.ChallengeDDD.cashdesk.events.PaymentAdded;
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

    public void addCashier(CashierID cashierID, Name name, YearsOfExperience yearsOfExperience){
        Objects.requireNonNull(name);
        Objects.requireNonNull(yearsOfExperience);
        appendChange(new CashierAdded(cashierID, name, yearsOfExperience)).apply();
    }

    public void addClient(ClientID clientID, Name name, CC cc){
        Objects.requireNonNull(name);
        Objects.requireNonNull(cc);
        appendChange(new ClientAdded(clientID, name, cc)).apply();
    }

    public void addPayment(PaymentID paymentID, PaymentMethod paymentMethod, Total total){
        Objects.requireNonNull(paymentMethod);
        Objects.requireNonNull(total);
        appendChange(new PaymentAdded(paymentID, total, paymentMethod)).apply();
    }

    public void updateCashierName(CashierID cashierID, Name name){
        Objects.requireNonNull(name);
        appendChange(new UpdateCashierName())
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
