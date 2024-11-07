package com.pluralsight;

public class PremiumTopping extends Topping {
    public PremiumTopping(String name,ToppingType type) {
        super(name, type);
    }

    @Override
    public double calculatePrice(SandwichSize size) {
        return switch (size) {
            case FourInch -> 1.00;
            case EightInch -> 2.00;
            case TwelveInch -> 3.00;
        };
    }
}
