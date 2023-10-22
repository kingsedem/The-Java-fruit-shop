package com.serenitydojo.fruitmarket;
import static org.assertj.core.api.Assertions.assertThat;
import com.serenitydojo.Catalog;
import com.serenitydojo.FruitUnAvailableException;
import org.junit.jupiter.api.Test;

import javax.swing.plaf.PanelUI;


public class TheCatalog {

        @Test
        public void shouldBeAbleToUpdateTheCurrentPriceOfAFruit() {
            Catalog catalog = new Catalog();
            catalog.setPrice("Apples", 4.00);
            double priceOfApples = catalog.getPriceOf("Apples");
            assertThat(priceOfApples).isEqualTo(4.00);

        }

        @Test
        public void shouldListProductsInAlphabeticalOrder(){
            Catalog catalog = new Catalog();
            catalog.setPrice("Cherries", 3.00);
            catalog.setPrice("Apples", 4.00);
            catalog.setPrice("Bananas", 2.00);

            assertThat(catalog.getProducts()).containsExactly("Apples", "Bananas", "Cherries");
        }



        //@Test(expected = FruitUnAvailableException.class)
        @Test
        public void shouldThrowExceptionIfFruitNotAvailableException(){
            Catalog catalog = new Catalog();
            catalog.setPrice("Cherries", 3.00);
            catalog.setPrice("Apples", 4.00);
            catalog.setPrice("Bananas", 2.00);

            catalog.getPriceOf("Bananas");
    }

}

