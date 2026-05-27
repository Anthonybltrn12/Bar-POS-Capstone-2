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
        System.out.println("Welcome to AB Bar & Lounge!");
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("""
                    Please select from the following options
                    1) New Order
                    2) Exit
                    """);
            int userInput = theScanner.nextInt();
            switch (userInput) {
                case 1:
                    orderMenu();
                    break;
                case 2:
                    System.out.println("Thank you, have a good night!");
                    isRunning = false;
                    break;
            }
        }
    }

    public void orderMenu() throws IOException {
        boolean isRunning = true;
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
                    Drink drink = new Drink();
                    liquorMenu(drink);
                    pourSizeMenu(drink);
                    mixerMenu(drink);
                    garnishMenu(drink);
                    finalPrice(drink);
                    order.addDrink(drink);
                    break;
                case 2:

                    snackMenu(order);
                    break;
                case 3:
                    displayOrder(order);
                    isRunning = false;
                    break;
                case 0:
                    isRunning = false;
                    break;
            }
        }
    }

    public void liquorMenu(Drink drink) {

        Liquor[] liquors = Liquor.values();
        for (Liquor liquorType : Liquor.values()) {
            System.out.println((liquorType.ordinal() + 1) + "." + liquorType.getName());
        }
        System.out.println("Please select an option:");
        int userInput = theScanner.nextInt();
        drink.setLiquor(liquors[userInput - 1]);

    }

    public void pourSizeMenu(Drink drink) {
        PourSize[] pourSizes = PourSize.values();
        for (PourSize poursize : PourSize.values()) {
            System.out.println((poursize.ordinal() + 1) + "." + poursize.getName());
        }
        System.out.println("Please select an option:");
        int userInput = theScanner.nextInt();
        drink.setPourSize(pourSizes[userInput - 1]);
    }

    public void mixerMenu(Drink drink) {
        Mixer[] mixers = Mixer.values();
        for (Mixer mixer : Mixer.values()) {
            System.out.println((mixer.ordinal() + 1) + "." + mixer.getName());
        }
        System.out.println("Please select an option:");
        int userInput = theScanner.nextInt();
        drink.setMixer(mixers[userInput - 1]);
    }

    public void garnishMenu(Drink drink) {
        Garnish[] garnishes = Garnish.values();
        for (Garnish garnish : Garnish.values()) {
            System.out.println((garnish.ordinal() + 1) + "." + garnish.getName());
        }
        System.out.println("Please select an option:");
        int userInput = theScanner.nextInt();
        drink.setGarnish(garnishes[userInput - 1]);
    }

    public void finalPrice(Drink drink) {
        System.out.println(drink.getPrice());
    }

    public void snackMenu(Order order) {
        Snack[] snacks = Snack.values();
        for (Snack snack : Snack.values()) {
            System.out.println((snack.ordinal() + 1) + "." + snack.getName());
        }
        System.out.println("Please select an option:");
        int userInput = theScanner.nextInt();
        order.addSnack(snacks[userInput - 1]);
    }

    public void displayOrder(Order order) throws IOException {
        theScanner.nextLine();
        boolean isRunning = true;
        while (isRunning) {
            System.out.println(ReceiptWriter.timeStamp());

            for (String drink : order.getDrink()) {
                System.out.println(drink);
            }
            order.getSnack();
            System.out.printf("SubTotal: $ %.2f\n", order.getTotal());
            System.out.printf("Tax(6.25%%): $ %.2f\n", order.getTax());
            System.out.printf("Total: $ %.2f\n", order.getTaxedTotal());
            order.addTip();

            System.out.println("Confirm Order(Y/N)?");
            String usrInput = theScanner.nextLine();
            if (usrInput.equalsIgnoreCase("y")) {

                System.out.println("Thank you for your order!");
                ReceiptWriter.saveReceipt(order);
                isRunning = false;

            } else {
                orderMenu();
            }


        }

    }

}
