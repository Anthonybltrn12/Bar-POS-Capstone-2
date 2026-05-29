package com.pluralsight;

import com.pluralsight.userInterface.IMenu;

import java.io.IOException;

public class POS {
    public static void main(String[] args) throws IOException {
        //instantiating a new menu
        IMenu menu = new IMenu();
        //kicking off the "app"
        menu.menu();


    }
}
