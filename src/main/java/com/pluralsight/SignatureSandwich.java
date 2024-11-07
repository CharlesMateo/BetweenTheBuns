package com.pluralsight;

public class SignatureSandwich extends Sandwich {
    private final SignatureType type;  // New field to store the type of signature sandwich

    public SignatureSandwich(SignatureType type) {
        super(getDefaultSize(type), getDefaultBread(type));
        this.type = type;
        constructSignatureSandwich(type);
    }

    // Getter method for the signature type
    public SignatureType getSignatureType() {
        return this.type;
    }

    private void constructSignatureSandwich(SignatureType type) {
        switch (type) {
            case BLT:
                setSize(SandwichSize.EightInch);
                setBread(BreadType.White);
                addTopping(new PremiumTopping("Bacon", ToppingType.Bacon));
                addTopping(new RegularTopping("Lettuce"));
                addTopping(new RegularTopping("Tomato"));
                addTopping(new RegularTopping("Mayo"));
                setToasted(true);
                break;

            case ThePhilly:
                setSize(SandwichSize.EightInch);
                setBread(BreadType.White);
                addTopping(new PremiumTopping("Steak", ToppingType.Meat));
                addTopping(new PremiumTopping("Cheese", ToppingType.Cheese));
                addTopping(new RegularTopping("Peppers"));
                addTopping(new RegularTopping("Lettuce"));
                addTopping(new RegularTopping("Tomato"));
                addTopping(new RegularTopping("Mayo"));
                setToasted(true);
                break;

            case WelcomeToTheClub:
                setSize(SandwichSize.EightInch);
                setBread(BreadType.White);
                addTopping(new PremiumTopping("Honry Glazed Turkey", ToppingType.Meat));
                addTopping(new PremiumTopping("Swiss Cheese", ToppingType.Cheese));
                addTopping(new RegularTopping("Lettuce"));
                addTopping(new RegularTopping("Tomato"));
                addTopping(new RegularTopping("Mayo"));
                setToasted(true);
                break;

            case TheCheesiest:
                setSize(SandwichSize.TwelveInch);
                setBread(BreadType.Rye);
                addTopping(new PremiumTopping("Swiss Cheese", ToppingType.Cheese));
                addTopping(new PremiumTopping("Monterey Jack Cheese", ToppingType.Cheese));
                addTopping(new PremiumTopping("Mozzerella Cheese", ToppingType.Cheese));
                addTopping(new RegularTopping("Butter"));
                setToasted(true);
                break;

            case VegetariansArePeopleToo:
                setSize(SandwichSize.TwelveInch);
                setBread(BreadType.Wheat);
                addTopping(new PremiumTopping("Lettuce", ToppingType.Vegetable));
                addTopping(new PremiumTopping("Tomato", ToppingType.Vegetable));
                addTopping(new PremiumTopping("Cucumber", ToppingType.Vegetable));
                addTopping(new RegularTopping("Peppers"));
                addTopping(new RegularTopping("Onions"));
                addTopping(new PremiumTopping("Salt, Pepper, and Vinaigrette", ToppingType.OliveOilAndVinegar));
                setToasted(false);
                break;

            default:
                throw new IllegalArgumentException("Unknown signature sandwich" + type);
        }
    }

    @Override
    public String getDetails() {
        StringBuilder details = new StringBuilder();

        details.append(SignatureSandwich.getSignatureName(this.getSignatureType()))
                .append(" (")
                .append(getSize())
                .append(" ")
                .append(getBread())
                .append(" Sandwich");

        // Check if the sandwich is toasted
        if (isToasted()) {
            details.append(" - Toasted");
        }

        details.append(") with:\n");

        // List all toppings
        for (Topping topping : getToppings()) {
            details.append("  - ").append(topping.getName()).append("\n");
        }

        // Append the total calculated price
        details.append("Total Price: $").append(String.format("%.2f", calculatePrice()));

        return details.toString();
    }

    // Private helper method to provide default size for each signature sandwich
    private static SandwichSize getDefaultSize(SignatureType type) {
        switch (type) {
            case BLT:
            case ThePhilly:
            case WelcomeToTheClub:
                return SandwichSize.EightInch;
            case TheCheesiest:
            case VegetariansArePeopleToo:
                return SandwichSize.TwelveInch;
            default:
                throw new IllegalArgumentException("Unknown signature sandwich type: " + type);
        }
    }

    // Private helper method to provide default bread type for each signature sandwich
    private static BreadType getDefaultBread(SignatureType type) {
        switch (type) {
            case BLT:
            case ThePhilly:
            case WelcomeToTheClub:
                return BreadType.White;
            case TheCheesiest:
                return BreadType.Rye;
            case VegetariansArePeopleToo:
                return BreadType.Wheat;
            default:
                throw new IllegalArgumentException("Unknown signature sandwich type: " + type);
        }
    }

    // Helper method to return a user-friendly name for each signature sandwich
    public static String getSignatureName(SignatureType type) {
        switch (type) {
            case BLT:
                return "BLT";
            case ThePhilly:
                return "The Philly";
            case WelcomeToTheClub:
                return "Welcome to the Club";
            case TheCheesiest:
                return "The Cheesiest";
            case VegetariansArePeopleToo:
                return "Vegetarians Are People Too";
            default:
                throw new IllegalArgumentException("Unknown signature sandwich type: " + type);
        }
    }
}
