package com.pluralsight.drink;

public enum Mixer {
    WATER("water", 0.00),
    CRANBERRY("cranberry",0.50),
    PINEAPPLE("pineapple", 0.50),
    ORANGE("orange",0.50),
    COKE("coke", 1.00),
    DR_PEPPER("Dr.Pepper",1.00),
    SPRITE("Sprite",1.00),
    GINGER_BEER("Ginger beer",1.50);

    private final String name;
    private final double price;

    Mixer(String name, double price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
