package com.pluralsight;

import com.pluralsight.drink.CocktailMenu;
import com.pluralsight.drink.Drink;
import com.pluralsight.snacks.Snack;
import com.pluralsight.userInterface.IObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order {
    List<IObject> orderList = new ArrayList<>();
    private double totalPrice;
    protected double totalWTip;

    public Order() {
        this.totalPrice = 0;
    }
    //getters and setters
    public List<IObject> getOrderList() {
        return orderList;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void addDrink(Drink drink) {
        orderList.add(drink);
    }

    public void addSnack(Snack snack) {
        orderList.add(snack);
    }

    public ArrayList<String> getDrink() {
        ArrayList<String> drinks = new ArrayList<>();
        //looping through the array to only pull out the drink order part
        for (IObject item : orderList) {
            if (item instanceof Drink) {
                drinks.add(((Drink) item).getSummary());
            }
        }

        return drinks;
    }

    public void getSnack() {
        for (IObject item : orderList) {
            //looping through to get the snacks from the entire order
            if (item instanceof Snack) {
                System.out.println("-" + ((Snack) item).getName() + "\n" + "\t-$" + item.getPrice() + "\n");
            }
        }
    }

    public void getOrderSummary() {
        for (IObject item : orderList) {
            if(item.getName().equalsIgnoreCase("Ranch Water") || item.getName().equalsIgnoreCase("Marky Mark")){
                System.out.println(item.getName());
                System.out.println(item.getPrice());
            }else {
                System.out.println(item.getName());
                System.out.println(item.getPrice());
            }
        }
    }

    public double getTotal() {
        double total = 0;
        for (IObject item : orderList) {
            //does price of each item in the order and adds it together
            double itemPrice = item.getPrice();
            total += itemPrice;
        }

        return total;

    }
    //getting the total with the tax added to it
    public double getTaxedTotal() {
        double total = getTotal();
        double tax = .063;
        double taxRate = total * tax;
        return total + taxRate;
    }
    //doing the math for the tax on an order before adding it to the total
    public double getTax() {
        double total = getTotal();
        double tax = .063;
        return tax * total;
    }

    public double addTip() {
        Scanner theScanner = new Scanner(System.in);

        double tip = 0;
        System.out.println("Would you like to add a tip?(Y/N)");
        String userInput = theScanner.nextLine();
        if (userInput.equalsIgnoreCase("Y")) {
            System.out.println("Please select an option:");
            //doing the math for the orders tips options based on the total amoount from the order
            System.out.printf("1)20%%- %.2f\n 2)18%%- %.2f\n 3)15%%-%.2f\n", (getTotal() * .2), (getTotal() * .18), (getTotal() * .15));
            int tipInput = theScanner.nextInt();
            switch (tipInput) {
                case 1:
                    System.out.printf("Total: $%.2f \n Total w/ Tip: $%.2f\n", getTaxedTotal(), (getTaxedTotal() + (getTotal() * .2)));
                    totalWTip = (getTaxedTotal() + (getTotal() * .2));

                    break;
                case 2:
                    System.out.printf("Total: $%.2f \n Total w/ Tip: $%.2f\n", getTaxedTotal(), (getTaxedTotal() + (getTotal() * .18)));
                    totalWTip = (getTaxedTotal() + (getTotal() * .18));

                    break;
                case 3:
                    System.out.printf("Total: $%.2f \n Total w/ Tip: $%.2f\n", getTaxedTotal(), (getTaxedTotal() + (getTotal() * .15)));
                    totalWTip = (getTaxedTotal() + (getTotal() * .15));

                    break;
            }
        } else {
            totalWTip = getTaxedTotal();
        }
        return totalWTip;
    }
    public double getTip(){
        return totalWTip;
    }
}
