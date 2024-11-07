package com.pluralsight;

public class PremiumTopping extends Topping {
    public PremiumTopping(String name,ToppingType type) {
        super(name, type);
    }

    @Override
    public double calculatePrice(SandwhichSize size) {
        return switch (size) {
            case FourInch -> 1.00;
            case EightInch -> 2.00;
            case TweleveInch -> 3.00;
        };
    }
}
