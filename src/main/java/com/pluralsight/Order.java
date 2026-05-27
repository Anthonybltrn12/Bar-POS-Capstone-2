package com.pluralsight;

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
        for (IObject item : orderList) {
            if (item instanceof Drink) {
                drinks.add(((Drink) item).getSummary());
            }
        }

        return drinks;
    }

    public void getSnack() {
        for (IObject item : orderList) {
            if (item instanceof Snack) {
                System.out.println("-" + ((Snack) item).getName() + "\n" + "\t-$" + item.getPrice() + "\n");
            }
        }
    }

    public void getOrderSummary() {
        for (IObject item : orderList) {
            System.out.println(item.getName());
            System.out.println(item.getPrice());
        }
    }

    public double getTotal() {
        double total = 0;
        for (IObject item : orderList) {
            double itemPrice = item.getPrice();
            total += itemPrice;
        }

        return total;

    }

    public double getTaxedTotal() {
        double total = getTotal();
        double tax = .063;
        double taxRate = total * tax;
        return total + taxRate;
    }

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
            System.out.printf("1)20%%- %.2f\n 2)18%%- %.2f\n 3)15%%-%.2f\n", (getTotal() * .2), (getTotal() * .18), (getTotal() * .15));
            int tipInput = theScanner.nextInt();
            switch (tipInput) {
                case 1:
                    System.out.println("Total:$" + getTaxedTotal() + "\n Total w/ Tip: $" + (getTaxedTotal() + (getTotal() * .2)));
                    totalWTip = (getTaxedTotal() + (getTotal() * .2));

                    break;
                case 2:
                    System.out.println("Total:$" + getTaxedTotal() + "\n Total w/ Tip: $" + (getTaxedTotal() + (getTotal() * .18)));
                    totalWTip = (getTaxedTotal() + (getTotal() * .18));

                    break;
                case 3:
                    System.out.println("Total:$" + getTaxedTotal() + "\n Total w/ Tip: $" + (getTaxedTotal() + (getTotal() * .15)));
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
