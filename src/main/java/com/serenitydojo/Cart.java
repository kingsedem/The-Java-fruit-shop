package com.serenitydojo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cart {

    List<CartItem> items = new ArrayList();
    private Catalog catalog;

    public Cart(Catalog catalog) {
        this.catalog = catalog;
    }

    public int getNumberOfItems() {
        return items.size();
    }

    public void addToCart(String product, double quantity) {
        items.add(new CartItem(product, quantity));
    }

    public double getRunningTotal() {
          return items.stream()
                  .mapToDouble(item-> priceOf(item))
                  .sum();
    }

    private double priceOf(CartItem item) {
        if(item.quantity() >=5.0){
           return  catalog.getPriceOf(item.product()) * item.quantity() * 0.9;
        }else
        return  catalog.getPriceOf(item.product()) * item.quantity();
    }
}
