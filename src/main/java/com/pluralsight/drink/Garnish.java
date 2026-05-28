package com.pluralsight.drink;

public enum Garnish {
    //creating an enum to hold the different kinds of garnishes
    LIME("Lime", 0.00),
    LEMON("Lemon", 0.00),
    STRAWBERRIES("Strawberries", 0.50),
    CHERRIES("Cherries", 0.25),
    SALT_RIM("Salt Rim", 0.25),
    TAJIN_RIM("Tajin Rim", 0.25),
    ORANGE("Oranges", 0.50),
    CINNAMON_STICK("Cinnamon Stick", 1.00);

    private final String name;
    private final double price;

    Garnish(String name, double price) {
        this.name = name;
        this.price = price;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
