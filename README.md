# BetweenTheBuns
# Sandwich Shop POS System

**Between The Buns** is a point-of-sale (POS) system for managing orders at a sandwich shop. This Java-based application allows users to create new orders with custom or signature sandwiches, add drinks and chips, and check out with an order summary. The app is designed with flexibility and ease-of-use in mind for quick and effective order processing.

---

## Features

- **Custom Sandwich Creation**: Choose bread type, size, toast preference, and add toppings to create a custom sandwich.
- **Signature Sandwiches**: Quickly select from pre-configured sandwiches with popular flavors and combinations.
- **Drink and Chips Selection**: Add drinks and chips to your order with a variety of flavors and sizes.
- **Order Management**: View order summary, cancel an order, or confirm checkout with a saved receipt.

---

## Class Overview

### Main Classes

- **UserInterface**: Manages user interactions, displays menus, and handles order processing.
- **Order**: Represents a single order, containing sandwiches, drinks, and chips.
- **Sandwich**: Defines a customizable sandwich with bread type, size, toast preference, and toppings.
- **SignatureSandwich**: Extends `Sandwich` with predefined configurations for popular choices.
- **Drink**: Represents a drink with size and flavor.
- **Chips**: Represents a chips selection with a chosen flavor.

### Additional Classes

- **Topping**: Abstract class representing a sandwich topping.
  - **PremiumTopping**: Extends `Topping` for premium toppings (e.g., bacon).
  - **RegularTopping**: Extends `Topping` for standard toppings (e.g., lettuce).
  
### Enumerations

- **BreadType**: Enum for different types of bread (e.g., White, Wheat, Rye).
- **SandwichSize**: Enum for sandwich sizes (e.g., EightInch, TwelveInch).
- **SignatureType**: Enum for signature sandwich types (e.g., BLT, The Philly).
- **DrinkFlavor**: Enum for drink flavors (e.g., Cola, Lemonade).
- **ChipsFlavor**: Enum for chips flavors (e.g., SaltAndVinegar, BBQ).
- **ToppingType**: Enum for topping types (e.g., Meat, Vegetable).

---

## Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/yourusername/between-the-buns.git
   cd between-the-buns
