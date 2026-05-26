package com.pluralsight.snacks;

public abstract class Snack {
    private String name;
    private double price;
    private String size;
    private boolean isSalted;

    public Snack(String name, double price, boolean isSalted, String size) {
        this.name = name;
        this.price = price;
        this.isSalted = isSalted;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isSalted() {
        return isSalted;
    }

    public void setSalted(boolean salted) {
        isSalted = salted;
    }
}
