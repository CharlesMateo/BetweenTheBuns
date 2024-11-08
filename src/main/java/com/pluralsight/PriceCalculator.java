package com.pluralsight;

public class PriceCalculator {
    public static double calculateTotal(Order order) {
        double total = 0.0;
        total += order.getSandwiches().stream().mapToDouble(Sandwich::calculatePrice).sum();
        total += order.getDrinks().stream().mapToDouble(Drink::getPrice).sum();
        total += order.getChips().stream().mapToDouble(Chips::getPrice).sum();
        return total;
    }
}

