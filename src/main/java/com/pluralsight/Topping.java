package com.pluralsight;

public abstract class Topping {
    private String name;
    private ToppingType type;

    public Topping(String name, ToppingType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public ToppingType getType() {
        return type;
    }

    public abstract double calculatePrice(SandwichSize size);
}

