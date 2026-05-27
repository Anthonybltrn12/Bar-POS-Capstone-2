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
    public void getDrink(){

        for(IObject item : orderList){
            if(item instanceof Drink){
                System.out.println(((Drink) item).getSummary());
            }
        }


    }

    public ArrayList<Snack> getSnack(){
        ArrayList<Snack> snacks = new ArrayList<>();
        for(IObject item : orderList){
            if(item instanceof Snack){
                snacks.add((Snack) item);
            }
        }
        return snacks;
    }

    public void getOrderSummary(){
        for(IObject item : orderList){
            System.out.println(item.getName());
            System.out.println(item.getPrice());
        }
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
