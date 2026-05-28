package com.pluralsight.drink;

public enum GlassSize {
    SHORT("Short"),
    TALL("Tall");

    private final String name;

    GlassSize(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
