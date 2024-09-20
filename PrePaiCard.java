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
 The PrePaiCard class is designed to represent prepaid cards and encapsulates essential details such as
 card type, ID, and expiry date. It provides flexibility through a default constructor for creating an empty prepaid card,
 a parameterized constructor to set card details with validation for the expiry day and month, and a copy constructor to
 replicate the details of another card. The class offers getter methods to retrieve card details and setter methods to
 update the expiry day and month. The toString method is overridden to present a formatted string representation of the
 card, including type, ID, and expiry date. Additionally, the equals method facilitates the comparison of two Prepaid
 Cards for equality based on their card type, ID, expiry day, and expiry month.
 ------------------------
 Algorithm of the program
 ------------------------
1) PrePaiCard Class:
Define a class named "PrePaiCard" to represent prepaid cards with type, ID, and expiry date.
2)Private Fields:
=>Include private fields to store card details:
=>cardType: String, representing the type of the prepaid card.
=>cardId: String, representing the ID of the prepaid card.
=>expiryDay: Integer, representing the day of expiry.
=>expiryMonth: Integer, representing the month of expiry.
3)Constructors:
=>Default Constructor:
Create a default constructor to initialize an empty prepaid card.
=>Parameterized Constructor:
Create a parameterized constructor to set card details with validation for expiry day and month.
=>Copy Constructor:
Implement a copy constructor to create a new prepaid card with the same details as another card.
4)Getter Methods:
Create getter methods to retrieve card details:
=>getCardType(): Retrieve the card type.
=>getCardId(): Retrieve the card ID.
=>getExpiryDay(): Retrieve the expiry day.
=>getExpiryMonth(): Retrieve the expiry month.
5)setter Methods:
Implement setter methods to update the expiry day and month:
=>setExpiryDay(int day): Update the expiry day with validation.
=>setExpiryMonth(int month): Update the expiry month with validation.
6)ToString Method:
Override the toString() method to provide a formatted string representation of the card, including type, ID, and expiry
date.
7)Equals Method:
Override the equals(PrePaiCard other) method to compare two prepaid cards for equality based on card type, ID, expiry
day, and expiry month.
 */


// PrePaiCard class represents prepaid cards with type, ID, and expiry date
class PrePaiCard {

    // Private fields to store card details
    private String cardType;
    private String cardId;
    private int expiryDay;
    private int expiryMonth;

    // Default constructor for creating an empty Prepaid Card
    public PrePaiCard() {
        // Default constructor
    }

    // Parameterized constructor sets card details based on input
    public PrePaiCard(String cardType, String cardId, int expiryDay, int expiryMonth) {
        // Set card details with validation for expiry day and month
        this.cardType = cardType;
        this.cardId = cardId;
        this.expiryDay = (expiryDay >= 1 && expiryDay <= 31) ? expiryDay : 0;
        this.expiryMonth = (expiryMonth >= 1 && expiryMonth <= 12) ? expiryMonth : 0;
    }

    // Copy constructor to create a new Prepaid Card with the same details as another card
    public PrePaiCard(PrePaiCard other) {
        // Copy details from another Prepaid Card
        this.cardType = other.cardType;
        this.cardId = other.cardId;
        this.expiryDay = other.expiryDay;
        this.expiryMonth = other.expiryMonth;
    }

    // Getter methods to retrieve card details
    public String getCardType() {
        return cardType;
    }

    public String getCardId() {
        return cardId;
    }

    public int getExpiryDay() {
        return expiryDay;
    }

    public int getExpiryMonth() {
        return expiryMonth;
    }

    // Setter methods to update the expiry day and month
    public void setExpiryDay(int day) {
        this.expiryDay = (day >= 1 && day <= 31) ? day : 0;
    }

    public void setExpiryMonth(int month) {
        this.expiryMonth = (month >= 1 && month <= 12) ? month : 0;
    }

    // Override the toString method to provide a formatted string representation of the card
    @Override
    public String toString() {
        return String.format("%s - %s - %02d/%02d.", this.cardType, this.cardId, this.expiryDay, this.expiryMonth);
    }

    // Override the equals method to compare two Prepaid Cards for equality
    public boolean equals(PrePaiCard other) {
        return this.cardType.equals(other.cardType) &&
                this.cardId.equals(other.cardId) &&
                this.expiryDay == other.expiryDay &&
                this.expiryMonth == other.expiryMonth;
    }
}
