package com.pluralsight;

public enum DrinkFlavor {
    DrPepper,
    IcedTea,
    Lemonade,
    Coke,
    Pepsi,
    Purple;


    @Override
    public String toString() {
        return name().replace(" ", " ").toLowerCase();
    }
}
