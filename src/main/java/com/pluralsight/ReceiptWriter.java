package com.pluralsight;

import com.pluralsight.drink.Liquor;
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
            bufferedWriter.write(timeStamp());

            for(String drink : order.getDrink()){
                bufferedWriter.write(drink);
            }

            for (IObject item : order.orderList) {
                bufferedWriter.write("-" +item.getName() + " " + item.getPrice() + "\n");


            }
            bufferedWriter.close();
        }catch(Exception e){
            System.out.println("File not created");
        }
    }

    public static String timeStamp(){
        LocalDateTime now = LocalDateTime.now();
        return now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
