package com.pluralsight;

import java.util.Scanner;

public class UserInterface {
    private Scanner scan = new Scanner(System.in);
    private Order currentOrder = new Order();

    public void showHomeScreen() {
        while (true) {
            System.out.println("Welcome to DELI-cious!");
            System.out.println("1. New Order");
            System.out.println("2. Exit");

            int choice = getUserInput();
            switch (choice) {
                case 1:
                    startNewOrder();
                    break;
                case 2:
                    System.out.println("Thank you for using DELI-cious POS!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void startNewOrder() {
        while (true) {
            System.out.println("\nOrder Menu:");
            System.out.println("1. Add Sandwich");
            System.out.println("2. Add Drink");
            System.out.println("3. Add Chips");
            System.out.println("4. Checkout");
            System.out.println("5. Cancel Order");

            int choice = getUserInput();
            switch (choice) {
                case 1:
                    addSandwich();
                    break;
                case 2:
                    addDrink();
                    break;
                case 3:
                    addChips();
                    break;
                case 4:
                    checkout();
                    return;
                case 5:
                    cancelOrder();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addSandwich() {
        System.out.println("\nSelect your bread:");
        for (BreadType bread : BreadType.values()) {
            System.out.println(bread.ordinal() + 1 + ". " + bread);
        }
        int breadChoice = getUserInput();
        BreadType selectedBread = BreadType.values()[breadChoice - 1];

        System.out.println("\nSelect sandwich size:");
        for (SandwichSize size : SandwichSize.values()) {
            System.out.println(size.ordinal() + 1 + ". " + size);
        }
        int sizeChoice = getUserInput();
        SandwichSize selectedSize = SandwichSize.values()[sizeChoice - 1];

        Sandwich sandwich = new Sandwich(selectedSize, selectedBread);

        System.out.println("\nWould you like your sandwich toasted? (Y/N)");
        String toastedChoice = scan.nextLine();
        sandwich.setToasted(toastedChoice.equalsIgnoreCase("Y"));

        addToppingsToSandwich(sandwich);
        currentOrder.addSandwich(sandwich);
    }

    private void addToppingsToSandwich(Sandwich sandwich) {
        System.out.println("\nSelect toppings (enter number to add, 0 to stop):");
        System.out.println("1. Bacon (Premium)");
        System.out.println("2. Lettuce (Regular)");
        System.out.println("3. Tomato (Regular)");
        System.out.println("4. Roast Beef (Premium)");
        System.out.println("5. Guacamole (Regular)");

        while (true) {
            int toppingChoice = getUserInput();
            if (toppingChoice == 0) {
                break;
            }

            switch (toppingChoice) {
                case 1:
                    sandwich.addTopping(new PremiumTopping("Bacon", ToppingType.Meat));
                    break;
                case 2:
                    sandwich.addTopping(new RegularTopping("Lettuce"));
                    break;
                case 3:
                    sandwich.addTopping(new RegularTopping("Tomato"));
                    break;
                case 4:
                    sandwich.addTopping(new PremiumTopping("Roast Beef", ToppingType.Meat));
                    break;
                case 5:
                    sandwich.addTopping(new RegularTopping("Guacamole"));
                    break;
                default:
                    System.out.println("Invalid topping choice. Try again.");
                    continue;
            }
            System.out.println("Topping added!");
        }
    }

    private void addDrink() {
        System.out.println("\nSelect drink size:");
        System.out.println("1. Small");
        System.out.println("2. Medium");
        System.out.println("3. Large");
        int sizeChoice = getUserInput();

        System.out.println("\nSelect drink flavor:");
        for (DrinkFlavor flavor : DrinkFlavor.values()) {
            System.out.println(flavor.ordinal() + 1 + ". " + flavor);
        }
        int flavorChoice = getUserInput();
        DrinkFlavor selectedFlavor = DrinkFlavor.values()[flavorChoice - 1];

        String size = switch (sizeChoice) {
            case 1 -> "Small";
            case 2 -> "Medium";
            case 3 -> "Large";
            default -> "Medium";
        };

        Drink drink = new Drink(size, selectedFlavor);
        currentOrder.addDrink(drink);
        System.out.println("Drink added!");
    }

    private void addChips() {
        System.out.println("\nSelect chips flavor:");
        for (ChipsFlavor flavor : ChipsFlavor.values()) {
            System.out.println(flavor.ordinal() + 1 + ". " + flavor);
        }
        int flavorChoice = getUserInput();
        ChipsFlavor selectedFlavor = ChipsFlavor.values()[flavorChoice - 1];

        Chips chips = new Chips(selectedFlavor);
        currentOrder.addChips(chips);
        System.out.println("Chips added!");
    }

    private void checkout() {
        System.out.println("\nOrder Summary:");
        System.out.println(currentOrder.getOrderDetails());

        System.out.println("\nDo you want to confirm the order? (Y/N)");
        String confirmChoice = scan.nextLine();

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

    private int getUserInput() {
        try {
            return Integer.parseInt(scan.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input, please enter a valid number.");
            return getUserInput();
        }
    }
}

