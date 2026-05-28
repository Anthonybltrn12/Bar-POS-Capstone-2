package com.pluralsight.drink;

public enum Mixer {
    //creating an enum to hold all of the mixer options available to the user
    WATER("Water", 0.00),
    SODA_WATER("Soda Water", 0.00),
    CRANBERRY("Cranberry", 0.50),
    PINEAPPLE("Pineapple", 0.50),
    ORANGE("Orange", 0.50),
    COKE("Coke", 1.00),
    DR_PEPPER("Dr.Pepper", 1.00),
    SPRITE("Sprite", 1.00),
    GINGER_BEER("Ginger beer", 1.50),
    NONE("None", 0.00);

    private final String name;
    private final double price;

    Mixer(String name, double price) {
        this.name = name;
        this.price = price;
    }

    //getters
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
