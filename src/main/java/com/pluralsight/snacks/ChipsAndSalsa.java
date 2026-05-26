package com.pluralsight.snacks;

public class ChipsAndSalsa extends Snack{
    private String salsaType;


    public ChipsAndSalsa(String name, double price, String salsaType, boolean isSalted, String size) {
        super(name, price, isSalted, size);
        this.salsaType = salsaType;

    }

    public String getSalsaType() {
        return salsaType;
    }

    public void setSalsaType(String salsaType) {
        this.salsaType = salsaType;
    }
}
