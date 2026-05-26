package com.pluralsight.snacks;

public class Popcorn extends Snack{
    private boolean isButtered;

    public Popcorn(String name, double price, boolean isSalted, boolean isButtered, String size) {
        super(name, price, isSalted, size);
        this.isButtered = isButtered;
    }

    public boolean isButtered() {
        return isButtered;
    }

    public void setButtered(boolean buttered) {
        isButtered = buttered;
    }

}
