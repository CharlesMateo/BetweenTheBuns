package com.pluralsight;

import java.util.Arrays;
import java.util.List;

public enum SignatureType {
    BLT("BLT", SandwichSize.EightInch, BreadType.White,
            Arrays.asList(new PremiumTopping("Bacon", ToppingType.Bacon),
                    new RegularTopping("Lettuce"),
                    new RegularTopping("Tomato"),
                    new RegularTopping("Mayo")),
            true),

    ThePhilly("The Philly", SandwichSize.EightInch, BreadType.White,
            Arrays.asList(new PremiumTopping("Steak", ToppingType.Meat),
                    new PremiumTopping("Cheese", ToppingType.Cheese),
                    new RegularTopping("Peppers"),
                    new RegularTopping("Lettuce"),
                    new RegularTopping("Tomato"),
                    new RegularTopping("Mayo")),
            true),

    WelcomeToTheClub("Welcome to the Club", SandwichSize.EightInch, BreadType.White,
            Arrays.asList(new PremiumTopping("Honey Glazed Turkey", ToppingType.Meat),
                    new PremiumTopping("Swiss Cheese", ToppingType.Cheese),
                    new RegularTopping("Lettuce"),
                    new RegularTopping("Tomato"),
                    new RegularTopping("Mayo")),
            true),

    TheCheesiest("The Cheesiest", SandwichSize.TwelveInch, BreadType.Rye,
            Arrays.asList(new PremiumTopping("Swiss Cheese", ToppingType.Cheese),
                    new PremiumTopping("Monterey Jack Cheese", ToppingType.Cheese),
                    new PremiumTopping("Mozzarella Cheese", ToppingType.Cheese),
                    new RegularTopping("Butter")),
            true),

    VegetariansArePeopleToo("Vegetarians Are People Too", SandwichSize.TwelveInch, BreadType.Wheat,
            Arrays.asList(new PremiumTopping("Lettuce", ToppingType.Vegetable),
                    new PremiumTopping("Tomato", ToppingType.Vegetable),
                    new PremiumTopping("Cucumber", ToppingType.Vegetable),
                    new RegularTopping("Peppers"),
                    new RegularTopping("Onions"),
                    new PremiumTopping("Salt, Pepper, and Vinaigrette", ToppingType.OliveOilAndVinegar)),
            false);

    private final String friendlyName;
    private final SandwichSize defaultSize;
    private final BreadType defaultBread;
    private final List<Topping> toppings;
    private final boolean toasted;

    SignatureType(String friendlyName, SandwichSize defaultSize, BreadType defaultBread, List<Topping> toppings, boolean toasted) {
        this.friendlyName = friendlyName;
        this.defaultSize = defaultSize;
        this.defaultBread = defaultBread;
        this.toppings = toppings;
        this.toasted = toasted;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public SandwichSize getDefaultSize() {
        return defaultSize;
    }

    public BreadType getDefaultBread() {
        return defaultBread;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public boolean isToasted() {
        return toasted;
    }
}
