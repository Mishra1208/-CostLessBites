//---------------------------------------------------------------------------------------------------------------------
// Assignment 4
// Written by:[NARENDRA MISHRA] [Student ID:40224303]
// For COMP 248 Section: H_2232 – Fall 2023
// Date of Submission : 05th December 2023
// --------------------------------------------------------------------------------------------------------------------
/*
    --------------------
    Program Description:
    --------------------
     program defines a Point of Sale (PoS) class for a sales system with methods to handle sales and prepaid card
     operations. It supports tasks like comparing total sales, managing prepaid cards, updating card expiry,
     adding sales categories, and providing a string representation of the sales breakdown.
-----------------------
Algorithm of the program:
------------------------
1) Class (PoS):
=>Represents a Point of Sale with sales and prepaid cards.
=>Contains private members for storing sales and an array of
prepaid cards.
2)Constructors:
=>Default constructor is present but not provided in the code.
=>Parameterized constructor initializes sales and prepaid cards.
3)Comparison Methods:
=>totalSalesEqual(PoS other): Compares total sales with another PoS object.
=>salesCategoriesEqual(PoS other): Compares sales categories with another PoS object.
4)Sales Information Retrieval:
=>totalSales(): Retrieves the total sales.
=>numPrepaidCards(): Returns the number of prepaid cards.
5)Prepaid Card Operations:
=>addPrepaidCard(PrePaiCard card): Adds a prepaid card to the array.
=>removePrepaidCard(int index): Removes a prepaid card from the array.
=>updatePrepaidCardExpiry(int index, int newDay, int newMonth): Updates the expiry date of a prepaid card.
6)Sales Categories:
=>addSales(int junior, int teen, int medium, int big, int family): Adds sales for different categories.
7)Object Equality:
=>equals(PoS other): Checks if two PoS objects are equal based on total sales and the number of prepaid cards.
8)String Representation:
=>toString(): Generates a string representation of the PoS object, including sales and prepaid card details.
9)Sales Breakdown:
=>salesBreakdown(): Returns the sales breakdown as a string.
 */

// PoS class represents a Point of Sale with sales and prepaid cards
class PoS {

    // Private members to store sales and prepaid cards
    private Sales sales;
    private PrePaiCard[] prepaidCards;

    // Default constructor
    public PoS() {

    }

    // Parameterized constructor to initialize sales and prepaid cards
    public PoS(Sales sales, PrePaiCard[] prepaidCards) {
        this.sales = new Sales(sales);
        this.prepaidCards = prepaidCards.clone();
    }

    // Check if total sales are equal to another PoS object
    public boolean totalSalesEqual(PoS other) {
        return this.sales.salesTotal() == other.sales.salesTotal();
    }

    // Check if sales categories are equal to another PoS object
    public boolean salesCategoriesEqual(PoS other) {
        return this.sales.equals(other.sales);
    }

    // Get the total sales
    public int totalSales() {
        return this.sales.salesTotal();
    }

    // Get the number of prepaid cards
    public int numPrepaidCards() {
        return prepaidCards.length;
    }

    // Add a prepaid card to the array
    public int addPrepaidCard(PrePaiCard card) {
        PrePaiCard[] newCards = new PrePaiCard[prepaidCards.length + 1];
        for(int i = 0; i < prepaidCards.length; i++)
            newCards[i] = prepaidCards[i];
        newCards[prepaidCards.length] = card;
        prepaidCards = newCards;
        return prepaidCards.length;
    }

    // Remove a prepaid card from the array
    public boolean removePrepaidCard(int index) {
        if (index >= 0 && index < prepaidCards.length) {
            PrePaiCard[] newCards = new PrePaiCard[prepaidCards.length - 1];
            System.arraycopy(prepaidCards, 0, newCards, 0, index);
            System.arraycopy(prepaidCards, index + 1, newCards, index, prepaidCards.length - index - 1);
            prepaidCards = newCards;
            return true;
        }
        return false;
    }

    // Update the expiry date of a prepaid card
    public boolean updatePrepaidCardExpiry(int index, int newDay, int newMonth) {
        if (index >= 0 && index < prepaidCards.length) {
            prepaidCards[index].setExpiryDay(newDay);
            prepaidCards[index].setExpiryMonth(newMonth);
            return true;
        }
        return false;
    }

    // Add sales for different categories
    public int addSales(int junior, int teen, int medium, int big, int family) {
        this.sales.addSales(junior, teen, medium, big, family);
        return this.totalSales();
    }

    // Check if two PoS objects are equal
    public boolean equals(PoS other) {
        return this.totalSales() == other.totalSales() && this.numPrepaidCards() == other.numPrepaidCards();
    }

    // String representation of the PoS object
    @Override
    public String toString() {
        String result = sales.toString();

        if (prepaidCards.length == 0) {
            result += "\nNo prepaiCards";
        } else {
            for (PrePaiCard card : prepaidCards) {
                result += "\n";
                result += card.toString();
            }
        }
        return result;
    }

    // Get the sales breakdown as a string
    public String salesBreakdown() {
        return sales.toString();
    }
}