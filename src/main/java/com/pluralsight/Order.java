package com.pluralsight;

import com.pluralsight.drink.Drink;
import com.pluralsight.snacks.Snack;

import java.util.ArrayList;
import java.util.List;

public class Order {
    List<Object> orderList = new ArrayList<>();
    private double totalPrice;

    public Order() {
        this.totalPrice = 0;
    }

    public List<Object> getOrderList() {
        return orderList;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void addDrink(Drink drink){
        orderList.add(drink);
    }

    public void addSnack(Snack snack){
        orderList.add(snack);
    }


}
