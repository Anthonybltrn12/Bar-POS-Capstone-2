package com.pluralsight.userInterface;

import com.pluralsight.Order;
import com.pluralsight.ReceiptWriter;
import com.pluralsight.drink.*;
import com.pluralsight.snacks.Snack;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class IMenu {
    public static Scanner theScanner = new Scanner(System.in);

    public void menu() throws IOException {
        //crating a startup menu to kickoff the app
        System.out.println("Welcome to AB Bar & Lounge!");
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("""
                    Please select from the following options
                    1) New Order
                    2) Exit
                    """);
            int userInput = theScanner.nextInt();
            //next path id chosen by user
            switch (userInput) {
                case 1:
                    orderMenu();
                    break;
                case 2:
                    System.out.println("Thank you, have a good night!");
                    isRunning = false;
                    break;
                default:
                    isRunning = false;
                    break;
            }
        }
    }

    public void orderMenu() throws IOException {
        boolean isRunning = true;
        //instantiating a new order everytime a user starts one
        Order order = new Order();
        while (isRunning) {
            System.out.println("""
                    Bartender - What can I do for you?
                    \t1) Add Drink
                    \t2) Add Snack
                    \t3) Checkout
                    \t0) Cancel Order
                    """);
            int userInput = theScanner.nextInt();
            switch (userInput) {
                case 1:
                   drinkMenu(order);
                   break;
                case 2:
                    snackMenu(order);
                    break;
                case 3:
                    displayOrder(order);
                    isRunning = false;
                    break;
                case 0:
                    //exit to the main menu again
                    //menu();
                    isRunning = false;
                    break;
            }
        }
    }

    public void drinkMenu(Order order){
        boolean isRunning = true;
        while(isRunning){
            Drink drink = new Drink();
            System.out.println("""
                    Please select an option:
                    1. Custom Drink
                    2. Specialty Drink
                    0. Return to Menu
                    """);
            int userInput = theScanner.nextInt();
            switch (userInput){
                case 1:
                    liquorMenu(drink);
                    pourSizeMenu(drink);
                    mixerMenu(drink);
                    glassSizeMenu(drink);
                    garnishMenu(drink);
                    finalPrice(drink);
                    //adding drink to the order once the user has chosen all options
                    order.addDrink(drink);
                    break;
                case 2:
                    specialtyCocktailMenu(drink);
                    order.addDrink(drink);
                    break;
                case 0:
                    isRunning = false;
                    break;

            }
        }
    }

    public void specialtyCocktailMenu(Drink drink){
        CocktailMenu[] cocktails = CocktailMenu.values();
        for(CocktailMenu cocktail : CocktailMenu.values()){
            System.out.println((cocktail.ordinal() + 1) + "." + cocktail.getName());
        }
        System.out.println("Please select an option:");
        int userInput = theScanner.nextInt();
        switch (userInput) {
            case 1:
                drink.setName(CocktailMenu.RANCH_WATER.getName());
                drink.setLiquor(CocktailMenu.RANCH_WATER.getLiquor());
                drink.setPourSize(CocktailMenu.RANCH_WATER.getPourSize());
                drink.setGlassSize(CocktailMenu.RANCH_WATER.getGlassSize());
                drink.setMixer(CocktailMenu.RANCH_WATER.getMixer());
                drink.setGarnish(CocktailMenu.RANCH_WATER.getGarnish());
                break;
            case 2:
                drink.setLiquor(CocktailMenu.MARKY_MARK.getLiquor());
                drink.setPourSize(CocktailMenu.MARKY_MARK.getPourSize());
                drink.setGlassSize(CocktailMenu.MARKY_MARK.getGlassSize());
                drink.setMixer(CocktailMenu.MARKY_MARK.getMixer());
                drink.setGarnish(CocktailMenu.MARKY_MARK.getGarnish());
                break;


        }
    }
    public void liquorMenu(Drink drink) {
        //displaying the liquor options by using the enum ordinals to list them
        Liquor[] liquors = Liquor.values();
        for (Liquor liquorType : Liquor.values()) {
            System.out.println((liquorType.ordinal() + 1) + "." + liquorType.getName());
        }
        System.out.println("Please select an option:");
        int userInput = theScanner.nextInt();
        //taking the user input and using it set their choice into the drink order
        drink.setLiquor(liquors[userInput - 1]);

    }

    public void pourSizeMenu(Drink drink) {
        //using the poursize enum to display all option
        PourSize[] pourSizes = PourSize.values();
        for (PourSize poursize : PourSize.values()) {
            System.out.println((poursize.ordinal() + 1) + "." + poursize.getName());
        }
        System.out.println("Please select an option:");
        int userInput = theScanner.nextInt();
        //taking the user choice and setting it in the drink order
        drink.setPourSize(pourSizes[userInput - 1]);
    }

    public void mixerMenu(Drink drink) {
        Mixer[] mixers = Mixer.values();
        for (Mixer mixer : Mixer.values()) {
            System.out.println((mixer.ordinal() + 1) + "." + mixer.getName());
        }
        System.out.println("Please select an option:");
        int userInput = theScanner.nextInt();
        //taking the user choice and setting it in the drink order
        drink.setMixer(mixers[userInput - 1]);
    }

    public void glassSizeMenu(Drink drink){
        GlassSize[] glassSizes = GlassSize.values();
        for(GlassSize glassSize : GlassSize.values()){
            System.out.println((glassSize.ordinal() + 1) + "." + glassSize.getName());
        }
        System.out.println("Please select an option:");
        int userInput = theScanner.nextInt();
        drink.setGlassSize(glassSizes[userInput - 1]);
    }

    public void garnishMenu(Drink drink) {
        Garnish[] garnishes = Garnish.values();
        for (Garnish garnish : Garnish.values()) {
            System.out.println((garnish.ordinal() + 1) + "." + garnish.getName());
        }
            System.out.println("Please select an option:");
            int userInput = theScanner.nextInt();
        //taking the user choice and setting it in the drink order
            drink.setGarnish(garnishes[userInput - 1]);


    }

    public void finalPrice(Drink drink) {
        System.out.println("Current order: $" + drink.getPrice());
    }

    public void snackMenu(Order order) {
        Snack[] snacks = Snack.values();
        for (Snack snack : Snack.values()) {
            System.out.println((snack.ordinal() + 1) + "." + snack.getName());
        }
        System.out.println("Please select an option:");
        int userInput = theScanner.nextInt();
        //taking the user choice and setting it in the snack order
        order.addSnack(snacks[userInput - 1]);
    }
    // creating the command line receipt once the user is done ordering
    public void displayOrder(Order order) throws IOException {
        //eating line because the last input was an integer
        theScanner.nextLine();
        boolean isRunning = true;
        while (isRunning) {
            //using the time stamp for the cl receipt
            System.out.println(ReceiptWriter.timeStamp());

            for (String drink : order.getDrink()) {
                System.out.println(drink);
            }
            order.getSnack();
            System.out.printf("SubTotal: $ %.2f\n", order.getTotal());
            System.out.printf("Tax(6.25%%): $ %.2f\n", order.getTax());
            System.out.printf("Total: $ %.2f\n", order.getTaxedTotal());
            //asking the user if they want to add a tip
            order.addTip();

            System.out.println("Confirm Order(Y/N)?");
            String usrInput = theScanner.nextLine();
            if (usrInput.equalsIgnoreCase("y")) {

                System.out.println("Thank you for your order!");
                ReceiptWriter.saveReceipt(order);
                isRunning = false;

            } else {
                //taking them back to the main menu if they dont confirm the order

                isRunning = false;
                orderMenu();
            }


        }

    }

}
