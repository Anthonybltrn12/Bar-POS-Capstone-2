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
            String filename = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")) + ".txt";
            FileWriter fileWriter = new FileWriter("src/main/resources/receipts" + filename);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("""
                    - AB's Bar & Lounge -
                    --------------------- 
                    """);
            bufferedWriter.write(timeStamp() + "\n");

            for (String drink : order.getDrink()) {
                bufferedWriter.write(drink);
            }

            for (IObject item : order.orderList) {
                // bufferedWriter.write("-" +item.getName() + " " + item.getPrice() + "\n");
                if (item instanceof Snack) {
                    bufferedWriter.write(((Snack) item).getName() + "\n " + "\t -" + item.getPrice());
                }


            }
            bufferedWriter.write(String.format("SubTotal: $%.2f \n", order.getTotal()));
            bufferedWriter.write(String.format("Tax(6.25%%): $%.2f \n", order.getTax()));
            bufferedWriter.write(String.format("Total: $%.2f \n", order.getTaxedTotal()));
            bufferedWriter.write(String.format("Total with Tip: %.2f", order.getTip()));

            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println("File not created");
        }
    }

    public static String timeStamp() {
        LocalDateTime now = LocalDateTime.now();
        String formattedTime = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd \n HH:mm:ss"));
        return "Date Ordered : \n" + formattedTime;
    }
}
