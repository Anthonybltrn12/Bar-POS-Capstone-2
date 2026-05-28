package com.pluralsight.drink;

public enum PourSize {
    //crating enum in order to have different "sizes' for my drinks
    SINGLE("Single", 8.00),
    DOUBLE("Double", 14.00),
    ON_THE_ROCKS("On the Rocks", 12.00);

    private final String name;
    private final double price;

    PourSize(String name, double price) {
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
