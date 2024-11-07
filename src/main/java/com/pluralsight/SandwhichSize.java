package com.pluralsight;

public enum SandwhichSize {
    FourInch(5.50),
    EightInch(7.00),
    TweleveInch(8.50);

    private final double priceBase;

    SandwhichSize(double priceBase) {
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
            case TweleveInch -> "12\"";
        };
    }
}
