package com.pluralsight;

public class Drink {
    private String size;
    private DrinkFlavor flavor; // Different flavors enum
    private double price;

    public Drink (String size, DrinkFlavor flavor) {
        this.size = size;
        this.flavor = flavor;
        this.price = calculatePrice(size);
    }

    private double calculatePrice (String size) {
        return switch (size.toLowerCase()) {
            case "small" -> 2.00;
            case "medium" -> 2.50;
            case "large" -> 3.00;
            default -> 0.00;
        };
    }

    public double getPrice() {
        return price;
    }

    public DrinkFlavor getFlavor() {
        return flavor;
    }

    public String getDetails() {
        return size + " " + flavor.toString() + " Drink - $" + price;
    }
}
