package com.pluralsight;

public enum BreadType {
    White,
    Wheat,
    Rye,
    Wrap;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}

