package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    private SandwichSize size; // 4, 8, or 12in
    private BreadType bread; // White, wheat, rye, or a wrap
    protected boolean toasted;
    private List<Topping> toppings = new ArrayList<>();

    public Sandwich(SandwichSize size, BreadType bread) {
       this.size = size;
       this.bread = bread;
    }

    public SandwichSize getSize() {
        return size;
    }

    public BreadType getBread() {
        return bread;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setSize(SandwichSize size) {
        this.size = size;
    }

    public void setBread(BreadType bread) {
        this.bread = bread;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }

    public void addTopping (Topping topping) {
        toppings.add(topping);
    }

    public boolean isToasted() {
        return toasted;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
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
