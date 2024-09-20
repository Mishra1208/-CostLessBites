//---------------------------------------------------------------------------------------------------------------------
// Assignment 4
// Written by:[NARENDRA MISHRA] [Student ID:40224303]
// For COMP 248 Section: H_2232 – Fall 2023
// Date of Submission : 05th December 2023
// --------------------------------------------------------------------------------------------------------------------
/*
 --------------------
 program description:
 --------------------
  program defines a Sales class for managing sales quantities in various meal categories. It includes constants for
  category prices, constructors for initialization, getters and setters for each category, and methods for adding sales
  and calculating total sales. The toString method provides a formatted string representation, and the equals method
  compares Sales objects for equality.
 ------------------------
 Algorithm of the program
 ------------------------
1)Sales Class:
Define a class named "Sales" to represent sales quantities for different meal categories.
2)Constants:
Include constants representing prices for each meal category:
=>JUNIOR_PRICE, TEEN_PRICE, MEDIUM_PRICE, BIG_PRICE, FAMILY_PRICE.
3)Instance Variables:
Declare instance variables to store sales quantities for each meal category:
=>junior, teen, medium, big, family.
4)Default Constructor:
Create a default constructor initializing sales quantities to default values.
5)Parameterized Constructor:
Implement a parameterized constructor allowing the initialization of sales quantities.
6)Copy Constructor:
Implement a copy constructor creating a new Sales object based on an existing one.
7)Getter and Setter Methods:
Create getter and setter methods for each meal category to retrieve and update sales quantities.
8)Add Sales Method:
Implement a method (addSales) to add sales quantities for each meal category.
9)Sales Total Method:
Implement a method (salesTotal) to calculate the total sales amount based on the quantities and prices.
10)ToString Method Override:
Override the toString() method to provide a formatted string representation of sales quantities.
11)Equals Method:
Implement a method (equals) to check equality between two Sales objects based on sales quantities.
 */

// Sales class represents the sales quantities for different meal categories
class Sales {

    // Constants representing prices for each meal category
    public static final int JUNIOR_PRICE = 5;
    public static final int TEEN_PRICE = 10;
    public static final int MEDIUM_PRICE = 12;
    public static final int BIG_PRICE = 15;
    public static final int FAMILY_PRICE = 20;

    // Instance variables to store sales quantities for each meal category
    private int junior;
    private int teen;
    private int medium;
    private int big;
    private int family;

    // Default constructor initializing sales quantities to default values
    public Sales() {
        junior = 5;
        teen = 10;
        medium = 12;
        big = 15;
        family = 20;
    }

    // Parameterized constructor allowing the initialization of sales quantities
    public Sales(int junior, int teen, int medium, int big, int family) {
        this.junior = junior;
        this.teen = teen;
        this.medium = medium;
        this.big = big;
        this.family = family;
    }

    // Copy constructor creating a new Sales object based on an existing one
    public Sales(Sales other) {
        this.junior = other.junior;
        this.teen = other.teen;
        this.medium = other.medium;
        this.big = other.big;
        this.family = other.family;
    }

    // Getter and setter methods for each meal category
    public int getJunior() {
        return junior;
    }

    public void setJunior(int junior) {
        this.junior = junior;
    }

    public int getTeen() {
        return teen;
    }

    public void setTeen(int teen) {
        this.teen = teen;
    }

    public int getMedium() {
        return medium;
    }

    public void setMedium(int medium) {
        this.medium = medium;
    }

    public int getBig() {
        return big;
    }

    public void setBig(int big) {
        this.big = big;
    }

    public int getFamily() {
        return family;
    }

    public void setFamily(int family) {
        this.family = family;
    }

    // Method to add sales quantities for each meal category
    public void addSales(int junior, int teen, int medium, int big, int family) {
        this.junior += junior;
        this.teen += teen;
        this.medium += medium;
        this.big += big;
        this.family += family;
    }

    // Method to calculate the total sales amount
    public int salesTotal() {
        return (junior * JUNIOR_PRICE +
                teen * TEEN_PRICE +
                medium * MEDIUM_PRICE +
                big * BIG_PRICE +
                family * FAMILY_PRICE);
    }

    // Override of the toString method to provide a formatted string representation
    @Override
    public String toString() {
        return String.format("%d x $%d + %d x $%d + %d x $%d + %d x $%d + %d x $%d ",
                junior, JUNIOR_PRICE, teen, TEEN_PRICE, medium, MEDIUM_PRICE, big, BIG_PRICE, family, FAMILY_PRICE);
    }

    // Method to check equality between two Sales objects
    public boolean equals(Sales other) {
        return this.junior == other.junior &&
                this.teen == other.teen &&
                this.medium == other.medium &&
                this.big == other.big &&
                this.family == other.family;
    }
}
