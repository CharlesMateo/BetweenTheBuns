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
        return name().replace(" ", " ").toLowerCase();
    }
}
