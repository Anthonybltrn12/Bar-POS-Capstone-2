package com.pluralsight;

import com.pluralsight.drink.Liquor;
import com.pluralsight.snacks.Snack;
import com.pluralsight.userInterface.IObject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {

    public static void saveReceipt(Order order) throws IOException {
        try {
            //creating the file name to contain the date of the order
            String filename = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")) + ".txt";
            FileWriter fileWriter = new FileWriter("src/main/resources/receipts" + filename);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            //making the receipt header
            bufferedWriter.write("""
                    - AB's Bar & Lounge -
                    --------------------- 
                    """);
            bufferedWriter.write(timeStamp() + "\n");
            //making sure this header is only added if there are drinks within the order
            if(order.getDrink() != null){
                bufferedWriter.write("Drinks ------------- \n");
            }

            for (String drink : order.getDrink()) {
                bufferedWriter.write(drink + "\n ---------------- \n");
            }


            for (IObject item : order.orderList) {
                if (item instanceof Snack) {
                    //grabbing the snacks to be under the drinks on receipt
                    bufferedWriter.write(((Snack) item).getName() + "\n " + "\t -" + item.getPrice() + "\n");
                }


            }
            bufferedWriter.write(String.format("SubTotal: $%.2f \n", order.getTotal()));
            bufferedWriter.write(String.format("Tax(6.25%%): $%.2f \n", order.getTax()));
            bufferedWriter.write(String.format("Total: $%.2f \n", order.getTaxedTotal()));
            bufferedWriter.write(String.format("Total with Tip: %.2f", order.getTip()));
            bufferedWriter.write(String.format("\n---------------"));

            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println("File not created");
        }
    }

    public static String timeStamp() {
        //creating timestamp method to use it in the command line
        LocalDateTime now = LocalDateTime.now();
        String formattedTime = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd           HH:mm:ss"));
        return "Date Ordered:     Time Ordered: \n" + formattedTime;
    }
}
