package com.pluralsight.drink;

import com.pluralsight.userInterface.IObject;

public class Drink implements IObject {
    //creating the variables needed for the drink class
    protected double price;
    protected PourSize pourSize;
    protected Mixer mixer;
    protected Liquor liquor;
    protected Garnish garnish;

    //instantiating the price
    public Drink() {

        this.price = 0.00;
    }

    //getters and setters
    public void setPourSize(PourSize pourSize) {
        this.pourSize = pourSize;
    }

    public void setMixer(Mixer mixer) {
        this.mixer = mixer;
    }

    public void setLiquor(Liquor liquor) {
        this.liquor = liquor;
    }

    public Liquor getLiquor() {
        return liquor;
    }

    public Garnish getGarnish() {
        return garnish;
    }

    public void setGarnish(Garnish garnish) {
        this.garnish = garnish;
    }

    public double getPrice() {
        double total = this.price;
        total += pourSize.getPrice();
        total += mixer.getPrice();
        total += garnish.getPrice();

        return total;
    }
    // returns the name of the liquor the user chose as the base name for the drink
    public String getName() {
        return liquor.toString();
    }

    //Creating the string that will print out when the user wants to checkout
    public String getSummary() {
        return ("-" + liquor.getName() + "\n"
                + "-" + pourSize.getName() + "\n"
                + "\t -$" + pourSize.getPrice() + "\n"
                + "-" + mixer.getName() + "\n"
                + "\t -$" + mixer.getPrice() + "\n"
                + "-" + garnish.getName()) + "\n"
                + "\t -$" + garnish.getPrice() + "\n";

    }

}
