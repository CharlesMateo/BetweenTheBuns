package com.pluralsight;

import java.util.List;

public class SignatureSandwich extends Sandwich {
    private final SignatureType type;

    public SignatureSandwich(SignatureType type) {
        super(type.getDefaultSize(), type.getDefaultBread());
        this.type = type;
        constructSignatureSandwich(type);
    }

    public SignatureType getSignatureType() {
        return this.type;
    }

    // Build the sandwich based on type details stored in the SignatureType enum
    private void constructSignatureSandwich(SignatureType type) {
        setSize(type.getDefaultSize());
        setBread(type.getDefaultBread());
        type.getToppings().forEach(this::addTopping);  // Add predefined toppings
        setToasted(type.isToasted());
    }

    @Override
    public String getDetails() {
        StringBuilder details = new StringBuilder();
        details.append(getSignatureName(type))
                .append(" (")
                .append(getSize())
                .append(" ")
                .append(getBread())
                .append(" Sandwich");

        if (isToasted()) {
            details.append(" - Toasted");
        }
        details.append(") with:\n");

        for (Topping topping : getToppings()) {
            details.append("  - ").append(topping.getName()).append("\n");
        }

        details.append("Total Price: $").append(String.format("%.2f", calculatePrice()));
        return details.toString();
    }

    public static String getSignatureName(SignatureType type) {
        return type.getFriendlyName();
    }
}

