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
        return switch (this) {
            case DrPepper -> "Dr.Pepper";
            case IcedTea -> "Iced Tea";
            case Lemonade -> "Lemonade";
            case Coke -> "Coke";
            case Pepsi -> "Pepsi";
            case Purple -> "PURPLE";
        };
    }
}
