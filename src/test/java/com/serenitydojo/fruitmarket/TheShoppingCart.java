package com.serenitydojo.fruitmarket;

import com.serenitydojo.Cart;
import com.serenitydojo.Catalog;
import io.cucumber.java.Before;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class TheShoppingCart {
    Catalog catalog = new Catalog();
    @Before
    public void setUpCatalog(){
        catalog.setPrice("Apples", 5.0);
        catalog.setPrice("Bananas", 3.0);
        catalog.setPrice("Oranges", 4.0);
    }

    //A shopping cart should initially be empty
    @Test
    public void shouldBeEmptyWhenCreated(){
        Cart cart = new Cart(catalog);
        int numberOfItems = cart.getNumberOfItems();
        assertThat(numberOfItems).isEqualTo(0);
    }

    //You can add a single item to the shopping cart
    @Test
    public void shouldBeAbleToAddAnItem(){
        Cart cart = new Cart(catalog);
        cart.addToCart("Apples", 2.0);
        double numberOfItems = cart.getNumberOfItems();
        assertThat(numberOfItems).isEqualTo(1);
    }

    //The shopping cart should keep a running total of the items in the cart.

    @Test
    public void shouldKeepARunningTotal(){
        Cart cart = new Cart(catalog);
        cart.addToCart("Apples", 2.0);
        cart.addToCart("Bananas", 1.0);
        cart.addToCart("Oranges", 3.0);

        double runningTotal = cart.getRunningTotal();
        assertThat(runningTotal).isEqualTo(25.0);
    }

    //You can remove items from your shopping cart, which should keep a running total.
    //You can reset your shopping cart, which should reset the running total to zero.
}
