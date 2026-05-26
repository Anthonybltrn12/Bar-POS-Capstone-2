package com.pluralsight.drink;

public class Drink {

    protected double price;
    protected PourSize pourSize;
    protected Mixer mixer;
    protected Liquor liquor;

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

    public double getTotal(){
        double total = this.price;
        total += pourSize.getPrice();
        total += mixer.getPrice();

        return total;
    }

}
