package com.pluralsight.drink;

public enum Liquor {
    //creating an enum to hold the different types of bases for a drink
    VODKA("Vodka"),
    WHISKEY("Whiskey"),
    TEQUILA("Tequila"),
    RUM("Rum");

    private final String name;

    Liquor(String name) {
        this.name = name;
    }
    //getter
    public String getName() {
        return name;
    }

}
