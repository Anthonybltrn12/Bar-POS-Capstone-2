# AB Bar & Lounge Ordering System

## Overview

AB Bar & Lounge is a Java-based ordering system designed to simulate the experience of placing an order at a bar and lounge. The application allows users to create drink and snack orders, calculate pricing based on selections, apply tips, and generate a finalized receipt stored as a file using Java's `BufferedWriter`.

This project was developed as a capstone project to demonstrate object-oriented programming concepts, user interaction, file handling, and Java application structure.

---

## Features

* Start a new customer order
* Select a base liquor:

    * Vodka
    * Whiskey
    * Tequila
    * Rum
* Choose drink pour size:

    * Single
    * Double
    * On the Rocks
* Select drink garnishes
* Automatic drink pricing calculation
* Add optional snacks:

    * Popcorn
    * Chips and Salsa
* View detailed checkout receipt
* Add a tip:

    * 20%
    * 18%
    * 15%
* Automatic tip and total calculation
* Confirm and finalize order
* Generate and save receipt files using `BufferedWriter`
* Receipt files are named using the order date and time

---

## Technologies Used

* **Java**
* Object-Oriented Programming (OOP)
* Enums
* Classes and Objects
* User Interfaces
* File Handling
* BufferedWriter

---

## Project Structure

```text id="g4h2qk"
Bar-POS-Capstone-2
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.pluralsight
│   │   │       ├── drink
│   │   │       ├── snacks
│   │   │       ├── userInterface
│   │   │       ├── Order.java
│   │   │       ├── POS.java
│   │   │       └── ReceiptWriter.java
│   │   │
│   │   └── resources
│   │       └── receipt files
│   │
│   └── test
│
├── pom.xml
└── .gitignore
```
### Project Diagram
                         AB's Bar & Lounge POS System
┌───────────────────────────────────────────────────────────────┐
│                           POS.java                           │
│                    (Main Application Entry)                  │
└───────────────────────────────────────────────────────────────┘
│
▼
┌───────────────────────────────────────────────────────────────┐
│                        userInterface                         │
│              Handles menus and customer prompts              │
└───────────────────────────────────────────────────────────────┘
│
┌──────────────┴──────────────┐
▼                             ▼
┌─────────────────────────┐     ┌─────────────────────────┐
│         drink           │     │         snacks          │
│-------------------------│     │-------------------------│
│ • Liquor Selection      │     │ • Popcorn              │
│ • Pour Options          │     │ • Chips & Salsa        │
│ • Garnish Selection     │     │ • Snack Pricing        │
│ • Drink Pricing         │     └─────────────────────────┘
└─────────────────────────┘
│
└──────────────┬──────────────┐
▼
┌───────────────────────────────────────────────────────────────┐
│                         Order.java                           │
│---------------------------------------------------------------│
│ • Stores customer selections                                 │
│ • Calculates subtotal                                        │
│ • Calculates tax                                             │
│ • Calculates tip                                             │
│ • Generates final totals                                     │
└───────────────────────────────────────────────────────────────┘
│
▼
┌───────────────────────────────────────────────────────────────┐
│                    ReceiptWriter.java                        │
│---------------------------------------------------------------│
│ • Creates receipt output                                     │
│ • Uses BufferedWriter                                        │
│ • Writes receipt to text file                                │
│ • Saves file in /resources folder                            │
│ • Uses date & time as filename                               │
└───────────────────────────────────────────────────────────────┘
│
▼
┌───────────────────────────────────────────────────────────────┐
│                       resources/                             │
│---------------------------------------------------------------│
│ Example Receipt File:                                        │
│ 2026-05-28_11-32-27.txt                                      │
└───────────────────────────────────────────────────────────────┘

### Package Descriptions

#### `drink`

Contains drink-related classes and logic including:

* liquor selections
* pour sizes
* garnish options
* drink pricing

#### `snacks`

Handles snack menu items and pricing.

#### `userInterface`

Manages user interaction and menu navigation throughout the ordering process.

#### `Order.java`

Stores customer order information including drinks, snacks, totals, tax, and tips.

#### `POS.java`

Acts as the main point-of-sale application controller and program entry point.

#### `ReceiptWriter.java`

Uses Java `BufferedWriter` to generate and save receipt files in the `resources` folder.

#### `resources`

Stores generated receipt text files named using the order date and time.

---

## How It Works

1. The user starts a new order.
2. The user selects a liquor type.
3. The user chooses a pour size.
4. The user selects a garnish.
5. The drink price is displayed.
6. The user can optionally add snacks.
7. A receipt is generated showing:

    * Drink selections
    * Snack selections
    * Individual prices
    * Order subtotal
8. The user selects a tip percentage.
9. The total is calculated automatically.
10. The user confirms the order.
11. A receipt file is created and saved using `BufferedWriter`.

---

## Example Receipt

```text id="9v7qtw"
- AB's Bar & Lounge -
---------------------

Date Ordered:     Time Ordered:
2026-05-28        11:32:27

Drinks -------------
- Whiskey
- Double
    - $14.00

- Sprite
    - $1.00

- Lime
    - $0.00

SubTotal: $15.00
Tax (6.25%): $0.95
Total: $15.95

Total with Tip: $18.20
```

---

## File Handling

Once the customer confirms the order, the program generates a receipt file using Java's `BufferedWriter`.

Each receipt is automatically saved using the current date and time, allowing orders to be uniquely stored and referenced later.

### Example File Name

```text id="m2x0z7"
2026-05-28_11-32-27.txt
```

This feature demonstrates:

* File creation
* File writing
* Date and time formatting
* Persistent order storage
  in Java.

---

## Learning Outcomes

This project helped strengthen understanding of:

* Java programming fundamentals
* Object-oriented design
* Enums and data organization
* User input validation
* File creation and writing
* Application flow control
* Building modular and maintainable code

---

## Future Improvements

Possible future enhancements include:

* GUI implementation using JavaFX or Swing
* Database integration for order history
* Expanded food and drink menu
* Employee/admin dashboard
* Payment processing simulation
* Customer account system

---

## Installation & Running the Project

1. Clone the repository:

```bash
git clone https://github.com/anthonybltrn12/bar-POS-Capstone-2.git
```

2. Open the project in your preferred Java IDE:

    * IntelliJ IDEA
    * Eclipse
    * VS Code

3. Compile and run the `POS.java` file.

---

## Author

Developed by [Anthony Beltran]

Capstone Project – 2026
