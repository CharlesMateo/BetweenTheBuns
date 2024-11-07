package com.pluralsight;

public enum SandwichSize {
    FourInch(5.50),
    EightInch(7.00),
    TwelveInch(8.50);

    private final double priceBase;

    SandwichSize(double priceBase) {
        this.priceBase = priceBase;
    }

    public double getPriceBase() {
        return priceBase;
    }

    @Override
    public String toString() {
        return switch (this){
            case FourInch -> "4\"";
            case EightInch -> "8\"";
            case TwelveInch -> "12\"";
        };
    }
}
