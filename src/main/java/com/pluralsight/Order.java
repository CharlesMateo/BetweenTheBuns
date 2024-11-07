package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Sandwich> sandwiches = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();
    private List<Chips> chips = new ArrayList<>();

    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void addChips(Chips chip) {
        chips.add(chip);
    }

    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public List<Chips> getChips() {
        return chips;
    }

    public String getOrderDetails() {
        StringBuilder details = new StringBuilder("Order Details: \n");
        for (Sandwich sandwich: sandwiches) {
            details.append(sandwich.getDetails()).append("\n");
        }
        for (Drink drink: drinks) {
            details.append(drink.getDetails()).append("\n");
        }
        for (Chips chip : chips) {
            details.append(chip.getDetails()).append("\n");
        }
        details.append("Total Price: $").append(PriceCalculator.calculateTotal(this)).append("\n");
        return details.toString();
    }
}
