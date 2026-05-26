package com.pluralsight.snacks;

public class ChipsAndSalsa extends Snack{
    private String salsaType;
    private boolean isSalted;

    public ChipsAndSalsa(String name, double price, String salsaType, boolean isSalted) {
        super(name, price);
        this.salsaType = salsaType;
        this.isSalted = isSalted;
    }
}
