package com.pluralsight;

public class Chips {
    private ChipsFlavor type; // Different flavors enum
    private double price;

    public Chips (ChipsFlavor type) {
        this.type = type;
        this.price = 1.50; // Fixed price
    }

    public ChipsFlavor getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public String getDetails() {
        return type.toString() + " Chips - $" + price;
    }
}
