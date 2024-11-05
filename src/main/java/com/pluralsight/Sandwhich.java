package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public abstract class Sandwhich {
    protected int size; // 4, 8, or 12in
    protected String breadType; // White, wheatt, rye, or a wrap
    protected boolean toasted;
    protected List<Topping> regularToppings;
    protected List<Topping> premiumToppings;

    public Sandwhich(int size, String breadType, boolean toasted) {
       this.size = size;
       this.breadType = breadType;
       this.toasted = toasted;
       this.regularToppings = new ArrayList<>();
        this.premiumToppings = new ArrayList<>();
    }

    public void addRegularTopping (Topping topping) {
        regularToppings.add(topping);
    }

    public void addPremiumTopping (Topping topping) {
        premiumToppings.add(topping);
    }

    public abstract double calculatePrice();

    public String getDetails() {
        StringBuilder details = new StringBuilder(size + "\" " + breadType + " Sandwich\n");
        if (toasted) details.append("Toasted\n");
        details.append("Regular Toppings: ");
        for (Topping topping : regularToppings) details.append(topping.getName()).append(", ");
        details.append("\nPremium Toppings: ");
        for (Topping topping : premiumToppings) details.append(topping.getName()).append(", ");
        return details.toString();
    }
}
