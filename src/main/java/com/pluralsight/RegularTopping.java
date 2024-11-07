package com.pluralsight;

public class RegularTopping extends Topping {
    public RegularTopping(String name) {
        super(name, ToppingType.Vegetable);
    }

    @Override
    public double calculatePrice(SandwhichSize size) {
        return 0;
    }
}
