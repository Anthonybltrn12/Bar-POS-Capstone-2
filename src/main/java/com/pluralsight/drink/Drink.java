package com.pluralsight.drink;

public class Drink {

    protected double price;
    protected PourSize pourSize;
    protected Mixer mixer;
    protected Liquor liquor;
    protected Garnish garnish;

    public Drink(){

        this.price = 0.00;
    }

    public double getPrice(){
        return this.price;
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

    public double getTotal(){
        double total = this.price;
        total += pourSize.getPrice();
        total += mixer.getPrice();
        total += garnish.getPrice();

        return total;
    }

}
