package com.serenitydojo.fruitmarket;

import com.serenitydojo.Cart;
import com.serenitydojo.Catalog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@DisplayName("The Shopping Cart")

public class ShoppingCartTest {


    Catalog catalog = new Catalog();

    @BeforeEach
    public void setUpCatalog() {
        catalog.setPrice("Apples", 4.00);
        catalog.setPrice("Oranges", 5.50);
        catalog.setPrice("Bananas", 6.00);
        catalog.setPrice("Pears", 4.50);
    }

    @DisplayName("Should initially be empty")
    @Test
    public void shouldBeEmptyWhenCreated() {
        Cart cart = new Cart(catalog);
        int numberOfItems = cart.getNumberOfItems();
        assertThat(numberOfItems).isEqualTo(0);
    }

    @DisplayName("Should be added with a single item in the cart")
    @Test
    public void shouldBeAbleToAddAnItem() {
        Cart cart = new Cart(catalog);
        cart.addToCart("Apples", 2.0);
        double numberOfItems = cart.getNumberOfItems();
        assertThat(numberOfItems).isEqualTo(1);
    }


    @DisplayName("Should keep a running total of the items in the cart.")
    @Test
    public void shouldKeepARunningTotal() {
        Cart cart = new Cart(catalog);
        cart.addToCart("Apples", 2.0);
        cart.addToCart("Bananas", 1.0);
        cart.addToCart("Oranges", 3.0);

        double runningTotal = cart.getRunningTotal();
        assertThat(runningTotal).isEqualTo(30.5);
    }

    @DisplayName("Should give a 10% discount when you buy 5 kilos of a fruit")
    @Test
    public void shouldApplyDiscountWhenBuying5KilosOrMore() {
        Cart cart = new Cart(catalog);
        cart.addToCart("Apples", 5.0);

        double runningTotal = cart.getRunningTotal();
        assertThat(runningTotal).isEqualTo(18.0);

    }

    @DisplayName("Should give a 10% discount when you buy 5 kilos or more with different fruits")

    @Test
    public void shouldApplyDiscountWhenBuying5KilosOrMoreWithDifferentFruits() {
        Cart cart = new Cart(catalog);
        cart.addToCart("Apples", 5.0);
        cart.addToCart("Bananas", 1.0);
        cart.addToCart("Oranges", 10.0);

        double runningTotal = cart.getRunningTotal();
        assertThat(runningTotal).isEqualTo(73.5);
    }

}
