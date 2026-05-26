package com.pluralsight;

import com.pluralsight.drink.Drink;
import com.pluralsight.snacks.Snack;
import com.pluralsight.userInterface.IObject;

import java.util.ArrayList;
import java.util.List;

public class Order {
    List<IObject> orderList = new ArrayList<>();
    private double totalPrice;

    public Order() {
        this.totalPrice = 0;
    }

    public List<IObject> getOrderList() {
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
    public String getDrink(Drink drink){
        return drink.getSummary();

    }

    public void getOrderSummary(Drink drink, Snack snack){
        System.out.println(drink.getSummary().toString());
    }

    public double getTotal(){
        double total = 0;
        for(IObject item : orderList){
            double itemPrice = item.getPrice();
            total += itemPrice;
        }

        return total;

    }
}
