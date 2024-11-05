package com.pluralsight;

public class RegularTopping extends Topping {
    public RegularTopping(String name) {
        super(name);
    }

    public double getPrice(int size) {
        return 0;
    }
}
