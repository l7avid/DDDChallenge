package com.sofkaU.ChallengeDDD.inventory.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofkaU.ChallengeDDD.inventory.events.InventoryCreated;
import com.sofkaU.ChallengeDDD.inventory.events.OderDataAdded;
import com.sofkaU.ChallengeDDD.inventory.events.ProductBrandOrderDataUpdated;
import com.sofkaU.ChallengeDDD.inventory.events.SupplierUpdated;
import com.sofkaU.ChallengeDDD.inventory.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UpdateSupplierUseCaseTest {

    private final String ROOT_ID = "000";

    @Mock
    private DomainEventRepository repository;

    @Test
    void updateSupplier(){

        var eventSupplierUpdated = new SupplierUpdated(InventoryID.of(ROOT_ID),
                OrderDataID.of("2"),
                new Supplier("Yamaha Musical"));

        var useCase = new UpdateSupplierUseCase();

        Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(List.of(
                new InventoryCreated(new InventoryDate("15-01-2021")),
                new OderDataAdded(InventoryID.of("4"),
                        OrderDataID.of("2"),
                        new ProductBrand("Yamaha"),
                        new ProductModel("C40"),
                        new Supplier("Fender musical"))
                )
        );

        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOT_ID)
                .syncExecutor(useCase, new TriggeredEvent<>(eventSupplierUpdated))
                .orElseThrow(() -> new IllegalArgumentException("Something went wrong while updating a supplier"))
                .getDomainEvents();

        var event = (SupplierUpdated)events.get(0);
        Assertions.assertEquals(eventSupplierUpdated.supplier().value(),event.supplier().value());
    }

}