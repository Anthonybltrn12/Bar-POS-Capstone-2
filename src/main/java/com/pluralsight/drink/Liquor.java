package com.pluralsight.drink;

public enum Liquor {
    VODKA("Vodka"),
    WHISKEY("Whiskey"),
    TEQUILA("Tequila"),
    RUM("Rum");

    private final String name;

    Liquor(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
