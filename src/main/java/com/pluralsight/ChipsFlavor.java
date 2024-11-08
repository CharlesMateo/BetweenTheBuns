package com.pluralsight;

public enum ChipsFlavor {
    SaltAndVinegar,
    BBQ,
    SourCreamAndOnion,
    Baked,
    SweetAndSpicy,
    Classic;

    @Override
    public String toString() {
        return switch (this) {
            case SaltAndVinegar -> "Salt and Vinegar";
            case BBQ -> "BBQ";
            case SourCreamAndOnion -> "Sour Cream and Onion";
            case Baked -> "Baked";
            case SweetAndSpicy -> "Sweet and Spicy";
            case Classic -> "Classic";
        };
    }
}

