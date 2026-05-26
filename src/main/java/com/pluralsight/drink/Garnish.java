package com.pluralsight.drink;

public enum Garnish {
    LIME("Lime",0.00),
    LEMON("Lemon", 0.00),
    STRAWBERRIES("Strawberries", 0.50),
    CHERRIES("Cherries", 0.50),
    ORANGE("Oranges", 0.50),
    CINNAMON_STICK("Cinnamon Stick", 0.50);

    private final String name;
    private final double price;

    Garnish(String name,double price){
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
