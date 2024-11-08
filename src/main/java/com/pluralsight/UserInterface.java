package com.pluralsight;

import java.util.Scanner;

public class UserInterface {
    private final Scanner scan = new Scanner(System.in);
    private Order currentOrder;

    public UserInterface() {
        this.currentOrder = new Order();
    }

    public void showHomeScreen() {
        while (true) {
            System.out.println("Welcome to Between The Buns!");
            System.out.println("1. New Order");
            System.out.println("2. Exit");

            int choice = getUserInput(1, 2);
            switch (choice) {
                case 1 -> startNewOrder();
                case 2 -> exitApplication();
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void startNewOrder() {
        currentOrder = new Order();
        boolean ordering = true;

        while (ordering) {
            System.out.println("\nOrder Menu:");
            System.out.println("1. Add Sandwich");
            System.out.println("2. Add Drink");
            System.out.println("3. Add Chips");
            System.out.println("4. Checkout");
            System.out.println("5. Cancel Order");

            int choice = getUserInput(1, 5);
            switch (choice) {
                case 1 -> addSandwich();
                case 2 -> addDrink();
                case 3 -> addChips();
                case 4 -> {
                    checkout();
                    ordering = false;
                }
                case 5 -> {
                    cancelOrder();
                    ordering = false;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addSandwich() {
        BreadType selectedBread = promptBreadSelection();
        SandwichSize selectedSize = promptSizeSelection();

        Sandwich sandwich = new Sandwich(selectedSize, selectedBread);
        sandwich.setToasted(promptToastedChoice());

        addToppingsToSandwich(sandwich);
        currentOrder.addSandwich(sandwich);
        System.out.println("Sandwich added to your order!");
    }

    private BreadType promptBreadSelection() {
        System.out.println("\nSelect your bread:");
        for (BreadType bread : BreadType.values()) {
            System.out.println(bread.ordinal() + 1 + ". " + bread);
        }
        int choice = getUserInput(1, BreadType.values().length);
        return BreadType.values()[choice - 1];
    }

    private SandwichSize promptSizeSelection() {
        System.out.println("\nSelect sandwich size:");
        for (SandwichSize size : SandwichSize.values()) {
            System.out.println(size.ordinal() + 1 + ". " + size);
        }
        int choice = getUserInput(1, SandwichSize.values().length);
        return SandwichSize.values()[choice - 1];
    }

    private boolean promptToastedChoice() {
        System.out.println("\nWould you like your sandwich toasted? (Y/N)");
        String toastedChoice = scan.nextLine().trim();
        return toastedChoice.equalsIgnoreCase("Y");
    }

    private void addToppingsToSandwich(Sandwich sandwich) {
        System.out.println("\nSelect toppings (enter number to add, 0 to finish):");
        System.out.println("1. Bacon (Premium)");
        System.out.println("2. Lettuce (Regular)");
        System.out.println("3. Tomato (Regular)");
        System.out.println("4. Meat of your choice (Premium)");
        System.out.println("5. Guacamole (Regular)");

        while (true) {
            int toppingChoice = getUserInput(0, 5);
            if (toppingChoice == 0) break;

            switch (toppingChoice) {
                case 1 -> sandwich.addTopping(new PremiumTopping("Bacon", ToppingType.Meat));
                case 2 -> sandwich.addTopping(new RegularTopping("Lettuce"));
                case 3 -> sandwich.addTopping(new RegularTopping("Tomato"));
                case 4 -> sandwich.addTopping(new PremiumTopping("Meat of your choice", ToppingType.Meat));
                case 5 -> sandwich.addTopping(new RegularTopping("Guacamole"));
                default -> System.out.println("Invalid topping choice. Try again.");
            }
            System.out.println("Topping added!");
        }
    }

    private void addDrink() {
        String size = promptDrinkSize();
        DrinkFlavor flavor = promptDrinkFlavor();

        Drink drink = new Drink(size, flavor);
        currentOrder.addDrink(drink);
        System.out.println("Drink added to your order!");
    }

    private String promptDrinkSize() {
        System.out.println("\nSelect drink size:");
        System.out.println("1. Small");
        System.out.println("2. Medium");
        System.out.println("3. Large");

        int choice = getUserInput(1, 3);
        return switch (choice) {
            case 1 -> "Small";
            case 2 -> "Medium";
            case 3 -> "Large";
            default -> "Medium";
        };
    }

    private DrinkFlavor promptDrinkFlavor() {
        System.out.println("\nSelect drink flavor:");
        for (DrinkFlavor flavor : DrinkFlavor.values()) {
            System.out.println(flavor.ordinal() + 1 + ". " + flavor);
        }
        int choice = getUserInput(1, DrinkFlavor.values().length);
        return DrinkFlavor.values()[choice - 1];
    }

    private void addChips() {
        ChipsFlavor flavor = promptChipsFlavor();
        Chips chips = new Chips(flavor);
        currentOrder.addChips(chips);
        System.out.println("Chips added to your order!");
    }

    private ChipsFlavor promptChipsFlavor() {
        System.out.println("\nSelect chips flavor:");
        for (ChipsFlavor flavor : ChipsFlavor.values()) {
            System.out.println(flavor.ordinal() + 1 + ". " + flavor);
        }
        int choice = getUserInput(1, ChipsFlavor.values().length);
        return ChipsFlavor.values()[choice - 1];
    }

    private void checkout() {
        System.out.println("\nOrder Summary:");
        System.out.println(currentOrder.getOrderDetails());

        System.out.println("\nDo you want to confirm the order? (Y/N)");
        String confirmChoice = scan.nextLine().trim();

        if (confirmChoice.equalsIgnoreCase("Y")) {
            Receipt.saveToFile(currentOrder);
            System.out.println("Receipt saved. Thank you for your order!");
        } else {
            System.out.println("Order cancelled.");
        }
    }

    private void cancelOrder() {
        System.out.println("Order cancelled. Returning to home screen.");
        currentOrder = new Order(); // Reset the current order
    }

    private void exitApplication() {
        System.out.println("Thank you for using BTB POS!");
        System.exit(0);
    }

    // Enhanced input validation with range checks
    private int getUserInput(int min, int max) {
        while (true) {
            try {
                int input = Integer.parseInt(scan.nextLine());
                if (input >= min && input <= max) {
                    return input;
                } else {
                    System.out.println("Please enter a number between " + min + " and " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a valid number.");
            }
        }
    }
}


