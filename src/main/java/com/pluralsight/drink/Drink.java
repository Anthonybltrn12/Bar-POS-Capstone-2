package com.pluralsight.drink;

import com.pluralsight.userInterface.IObject;

public class Drink implements IObject {

    protected double price;
    protected PourSize pourSize;
    protected Mixer mixer;
    protected Liquor liquor;
    protected Garnish garnish;

    public Drink(){

        this.price = 0.00;
    }


    public void setPourSize(PourSize pourSize){
        this.pourSize = pourSize;
    }
    public void setMixer(Mixer mixer){
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

    public double getPrice(){
        double total = this.price;
        total += pourSize.getPrice();
        total += mixer.getPrice();
        total += garnish.getPrice();

        return total;
    }
    public String getName(){
        return liquor.toString();
    }

    public String getSummary(){
        return ("-" + liquor.getName() + "\n"
                + "-" +  pourSize.getName() + "\n"
                + "\t -$" + pourSize.getPrice() + "\n"
                + "-" +  mixer.getName() + "\n"
                + "\t -$" + mixer.getPrice() + "\n"
                + "-" +  garnish.getName()) + "\n"
                + "\t -$" + garnish.getPrice() + "\n";

    }

}
