package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public abstract class Sandwhich {
    private SandwhichSize size; // 4, 8, or 12in
    private BreadType bread; // White, wheatt, rye, or a wrap
    protected boolean toasted;
    private List<Topping> toppings = new ArrayList<>();

    public Sandwhich(SandwhichSize size, BreadType bread) {
       this.size = size;
       this.bread = bread;
    }

    public void addTopping (Topping topping) {
        toppings.add(topping);
    }

    public double calculatePrice() {
        double price = size.getPriceBase();
        for (Topping topping : toppings) {
            price += topping.calculatePrice(size);
        }
        return price;
    }

    public String getDetails() {
        StringBuilder details = new StringBuilder(size + " " + bread + " Sandwich ");
        if (toasted) {
            details.append("(Toasted) ");
        }
        details.append("with: ");
        for (Topping topping: toppings) {
            details.append(topping.getName()).append(", ");
        }
        details.setLength(details.length()-2);
        details.append(" - $").append(calculatePrice());
        return details.toString();
    }
}
