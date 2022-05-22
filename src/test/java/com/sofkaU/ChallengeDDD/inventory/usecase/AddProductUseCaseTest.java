package com.sofkaU.ChallengeDDD.inventory.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofkaU.ChallengeDDD.inventory.commands.AddInventoryAssistant;
import com.sofkaU.ChallengeDDD.inventory.commands.AddProduct;
import com.sofkaU.ChallengeDDD.inventory.events.InventoryAssistantAdded;
import com.sofkaU.ChallengeDDD.inventory.events.InventoryCreated;
import com.sofkaU.ChallengeDDD.inventory.events.ProductAdded;
import com.sofkaU.ChallengeDDD.inventory.values.*;
import com.sofkaU.ChallengeDDD.share.Name;
import com.sofkaU.ChallengeDDD.share.YearsOfExperience;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AddProductUseCaseTest {

    private final String ROOT_ID = "123";

    @Mock
    private DomainEventRepository repository;

    @Test
    void addProduct(){
        var command = new AddProduct(InventoryID.of(ROOT_ID),
                ProductID.of("5"),
                new ProductBrand("Yamaha"),
                new ProductModel("CF")
                );

        var useCase = new AddProductUseCase();

        Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(List.of(
                new InventoryCreated(new InventoryDate("15-01-2021"))));


        useCase.addRepository(repository);
        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOT_ID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Something went wrong while creating an inventory assistant"))
                .getDomainEvents();

        var event = (ProductAdded)events.get(0);
        Assertions.assertEquals(command.inventoryID().value(),event.inventoryID().value());
        Assertions.assertEquals(command.productID().value(), event.productID().value());
        Assertions.assertEquals(command.productBrand().value(), event.productBrand().value());
        Assertions.assertEquals(command.productModel().value(), event.productModel().value());
    }

}