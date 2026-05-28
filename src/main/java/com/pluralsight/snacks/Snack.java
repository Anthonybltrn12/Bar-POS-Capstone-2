package com.pluralsight.snacks;

import com.pluralsight.userInterface.IObject;

public enum Snack implements IObject {
    //creating an enum to give user an option of a snack while they drink
    POPCORN("Popcorn", 1.00),
    CHIPS_AND_SALSA("Chips and Salsa", 2.00);

    private String name;
    private double price;


    Snack(String name, double price) {
        this.name = name;
        this.price = price;

    }

    //getter and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
