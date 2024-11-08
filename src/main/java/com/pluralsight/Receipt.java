package com.pluralsight;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Receipt {
    public static void saveToFile(Order order) {
        String fileName = "receipt_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".txt";
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(order.getOrderDetails());
        } catch (IOException e) {
            System.err.println("Failed to save receipt: " + e.getMessage());
        }
    }
}

