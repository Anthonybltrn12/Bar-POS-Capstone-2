package com.pluralsight.drink;

public enum Mixer {
    WATER("water", 0.00),
    CRANBERRY("cranberry",1.00);

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
