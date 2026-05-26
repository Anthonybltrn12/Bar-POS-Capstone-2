package com.pluralsight.userInterface;

import com.pluralsight.drink.*;

import java.util.Scanner;

public class IMenu {
    public static Scanner theScanner = new Scanner(System.in);

    public void menu(){
        System.out.println("Welcome to the Bar!");
        boolean isRunning = true;
        while(isRunning){
            System.out.println("""
                    Please select from the following options
                    1) New Order
                    2) Exit
                    """);
            int userInput = theScanner.nextInt();
            switch (userInput){
                case 1:
                    Drink drink = new Drink();
                    liquorMenu(drink);
                    pourSizeMenu(drink);
                    mixerMenu(drink);
                    garnishMenu(drink);
                    finalPrice(drink);
                    break;
                case 2:
                    System.out.println("Thank you, have a good night!");
                    isRunning = false;
                    break;
            }
        }
    }

    public void liquorMenu(Drink drink){

        Liquor[] liquors = Liquor.values();
        for(Liquor liquorType : Liquor.values()){
            System.out.println((liquorType.ordinal() + 1) + "." + liquorType.getName());
        }
        System.out.println("Please select an option:");
        int userInput = theScanner.nextInt();
        drink.setLiquor(liquors[userInput - 1]);

    }
    public void pourSizeMenu(Drink drink){
        PourSize[] pourSizes = PourSize.values();
        for(PourSize poursize : PourSize.values()){
            System.out.println((poursize.ordinal() + 1) + "."+ poursize.getName());
        }
        System.out.println("Please select an option:");
        int userInput = theScanner.nextInt();
        drink.setPourSize(pourSizes[userInput - 1]);
    }
    public void mixerMenu(Drink drink){
        Mixer[] mixers = Mixer.values();
        for(Mixer mixer : Mixer.values()){
            System.out.println((mixer.ordinal() + 1) + "." + mixer.getName());
        }
        System.out.println("Please select an option:");
        int userInput = theScanner.nextInt();
        drink.setMixer(mixers[userInput - 1]);
    }
    public void garnishMenu(Drink drink){
        Garnish[] garnishes = Garnish.values();
        for(Garnish garnish : Garnish.values()){
            System.out.println((garnish.ordinal() + 1) + "." + garnish.getName());
        }
        System.out.println("Please select an option:");
        int userInput = theScanner.nextInt();
        drink.setGarnish(garnishes[userInput - 1]);
    }

    public void finalPrice(Drink drink){
        System.out.println(drink.getTotal());
    }
}
