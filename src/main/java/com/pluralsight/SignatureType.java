package com.pluralsight;

public enum SignatureType {
    BLT,
    ThePhilly,
    WelcomeToTheClub,
    TheCheesiest,
    VegetariansArePeopleToo;

    public String getName() {
        switch (this) {
            case BLT: return "BLT";
            case ThePhilly: return "The Philly";
            case WelcomeToTheClub: return "Welcome to the Club";
            case TheCheesiest: return "The Cheesiest";
            case VegetariansArePeopleToo: return "Vegetarians Are People Too";
            default: throw new IllegalArgumentException("Unknown signature sandwich type: " + this);
        }
    }
}
