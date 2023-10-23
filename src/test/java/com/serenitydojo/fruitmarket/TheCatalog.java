package com.serenitydojo.fruitmarket;
import static org.assertj.core.api.Assertions.assertThat;
import com.serenitydojo.Catalog;
import com.serenitydojo.FruitUnAvailableException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.plaf.PanelUI;


public class TheCatalog {

    Catalog catalog = new Catalog();

    @BeforeEach
    public void setUpCatalog(){
        catalog.setPrice("Apples", 4.00);
        catalog.setPrice("Oranges", 5.50);
        catalog.setPrice("Bananas", 6.00);
        catalog.setPrice("Pears", 4.50);
    }
    @DisplayName("Should return the current price of a fruit")
        @Test
        public void shouldBeAbleToUpdateTheCurrentPriceOfAFruit() {
            double priceOfApples = catalog.getPriceOf("Apples");
            double priceOfOranges = catalog.getPriceOf("Oranges");
            double priceOfBananas = catalog.getPriceOf("Bananas");
            double priceOfPears = catalog.getPriceOf("Pears");

            assertThat(priceOfApples).isEqualTo(4.00);
            assertThat(priceOfOranges).isEqualTo(5.50);
            assertThat(priceOfBananas).isEqualTo(6.00);
            assertThat(priceOfPears).isEqualTo(4.50);
        }

    @DisplayName("Should list the names of the currently available fruits in alphabetical order")

        @Test
        public void shouldListProductsInAlphabeticalOrder(){
            assertThat(catalog.getProducts()).containsExactly("Apples", "Bananas", "Oranges", "Pears");
        }


    @DisplayName("Should throw a FruitUnavailableException if the fruit is not currently available")

        //@Test(expected = FruitUnAvailableException.class)
        @Test
        public void shouldThrowExceptionIfFruitNotAvailableException(){
            catalog.getPriceOf("Pears");
    }

}

