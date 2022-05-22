package com.sofkaU.ChallengeDDD.inventory.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofkaU.ChallengeDDD.cashdesk.events.CashierNameUpdated;
import com.sofkaU.ChallengeDDD.cashdesk.usecase.UpdateCashierNameUseCase;
import com.sofkaU.ChallengeDDD.inventory.Inventory;
import com.sofkaU.ChallengeDDD.inventory.OrderData;
import com.sofkaU.ChallengeDDD.inventory.Product;
import com.sofkaU.ChallengeDDD.inventory.commands.UpdateProductBrandOrderData;
import com.sofkaU.ChallengeDDD.inventory.events.InventoryCreated;
import com.sofkaU.ChallengeDDD.inventory.events.OderDataAdded;
import com.sofkaU.ChallengeDDD.inventory.events.ProductAdded;
import com.sofkaU.ChallengeDDD.inventory.events.ProductBrandOrderDataUpdated;
import com.sofkaU.ChallengeDDD.inventory.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;


@ExtendWith(MockitoExtension.class)
class UpdateProductBrandOrderDataUseCaseTest {

    private final String ROOT_ID = "000";

    @Mock
    private DomainEventRepository repository;

    @Test
    void updateProductBrandOrderData(){
        var command = new UpdateProductBrandOrderData(InventoryID.of(ROOT_ID),
                OrderDataID.of("2"),
                new ProductBrand("Fender"));

        var useCase = new UpdateProductBrandOrderDataUseCase();

        Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(List.of(
                new InventoryCreated(new InventoryDate("15-01-2021")),
                new OderDataAdded(InventoryID.of("4"),
                        OrderDataID.of("2"),
                        new ProductBrand("Yamaha"),
                        new ProductModel("C40"),
                        new Supplier("Yamaha musical"))
                )
        );

        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOT_ID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Something went wrong while updating product brand"))
                .getDomainEvents();

        var event = (ProductBrandOrderDataUpdated)events.get(0);
        Assertions.assertEquals(command.productBrand().value(),event.productBrand().value());
    }

}