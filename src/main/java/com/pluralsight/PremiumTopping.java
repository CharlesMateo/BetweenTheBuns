package com.pluralsight;

public class PremiumTopping extends Topping {
    public PremiumTopping(String name) {
        super(name);
    }

    public double getPrice(int size) {
        return switch (size) {
            case 4 -> 1.00;
            case 8 -> 2.00;
            case 12 -> 3.00;
            default -> 0;
        };
    }
}
