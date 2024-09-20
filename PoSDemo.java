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
The "PoSDemo" program serves as a practical implementation of a Point of Sale (PoS) system for a catering service,
developed as part of a college assignment. The program employs the "PoS" class to encapsulate sales and prepaid card
details, facilitating the management of catering sales data. Within the application, users can interact with various PoS
instances through a menu-driven interface. The functionalities include viewing the content of all PoS, displaying the
content of a specific PoS, listing PoS with similar sales amounts or sales categories, adding and removing prepaid cards,
updating prepaid card expiry dates, and adding sales to specific PoS. The program incorporates user input validation
 and ensures a seamless and interactive experience.
 ------------------------
 Algorithm of the program
 ------------------------
1)Initialize Program:
Display a welcome message for the CostLessBites Catering Sales Counter Application.
2)Create PoS Instances:
=>Create an array posList of size 5 to store instances of the PoS class.
=>Create five PoS instances (posList[0] to posList[4]) with predefined sales and prepaid card details.
3)User Interaction Loop:
=>Enter a while loop for user interaction.
=>Display a menu with various options for interacting with PoS instances.
=>Get user choice using the getUserChoice() method.
4)Menu Options Implementation:
=>Implement menu options using a switch-case structure.
Option 1: Display content of all PoS instances.
Option 2: Display content of a specific PoS chosen by the user.
Option 3: List PoS instances with the same total sales amount.
Option 4: List PoS instances with the same sales categories.
Option 5: List PoS instances with the same total sales amount and the same number of prepaid cards.
Option 6: Add a prepaid card to a specific PoS chosen by the user.
Option 7: Remove a prepaid card from a specific PoS chosen by the user.
Option 8: Update the expiry date of a prepaid card in a specific PoS chosen by the user.
Option 9: Add sales to a specific PoS chosen by the user.
Option 0: Quit the program.
5)Menu Option Implementations (Detailed):
=>Display all PoS instances' content (displayAllPos).
=>Display content of a specific PoS chosen by the user (displayOnePos).
=>List PoS instances with the same total sales amount (listPossWithSameSalesAmount).
=>List PoS instances with the same sales categories (listPossWithSameSalesCategories).
=>List PoS instances with the same total sales amount and the same number of prepaid cards (listPossWithSameSalesAndPrepaidCards).
=>Add a prepaid card to a specific PoS chosen by the user (addPrepaidCard).
=>Remove a prepaid card from a specific PoS chosen by the user (removePrepaidCard).
=>Update the expiry date of a prepaid card in a specific PoS chosen by the user (updatePrepaidCardExpiry).
=>Add sales to a specific PoS chosen by the user (addSalesToPos).
6)Utility Methods:
=>welcomeMessage(): Display a welcome message.
=>displayMenu(): Display the menu options for the user to choose from.
=>getUserChoice(): Get the user's choice from the menu.
=>isValidCardType(String cardType): Check if the entered card type is valid.
7)Exit Program:
If the user chooses option 0, display a closing message and exit the program.
 */

import java.util.Scanner;

public class PoSDemo {

    public static void main(String[] args) {
        welcomeMessage();
        PoS[] posList = new PoS[5];

        //pos 0
        Sales sale0 = new Sales(2, 1, 0, 4, 1);
        PrePaiCard[] prepaicard0 = new PrePaiCard[2];
        prepaicard0[0] = new PrePaiCard("Vegetarian", "40825164", 25, 12);
        prepaicard0[1] = new PrePaiCard("Carnivore", "21703195", 3, 12);

        posList[0] = new PoS(sale0, prepaicard0);

        // Pos 1
        Sales sale1 = new Sales(2, 1, 0, 4, 1);
        PrePaiCard[] prepaicard1 = new PrePaiCard[2];
        prepaicard1[0] = new PrePaiCard("Vigan", "40825164", 7, 12);
        prepaicard1[1] = new PrePaiCard("Vegetarian ", "21596387", 24, 8);

        posList[1] = new PoS(sale1, prepaicard1);

        // PoS 2
        Sales sale2 = new Sales(0, 1, 5, 2, 0);
        PrePaiCard[] prepaicard2 = new PrePaiCard[3];
        prepaicard2[0] = new PrePaiCard("Pescatarian", "95432806 ", 1, 6);
        prepaicard2[1] = new PrePaiCard("Halal", "42087913", 18, 12);
        prepaicard2[2] = new PrePaiCard("Kosher", "40735421", 5, 4);

        posList[2] = new PoS(sale2, prepaicard2);

        // PoS 3
        Sales sale3 = new Sales(3, 2, 4, 1, 2);
        PrePaiCard[] prepaicard3 = new PrePaiCard[0];

        posList[3] = new PoS(sale3, prepaicard3);

        // PoS 4
        Sales sale4 = new Sales(3, 2, 4, 1, 2);
        PrePaiCard[] prepaicard4 = new PrePaiCard[0];

        posList[4] = new PoS(sale4, prepaicard4);

        // User interaction loop
        while (true) {
            displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    displayAllPos(posList);
                    break;
                case 2:
                    displayOnePos(posList);
                    break;
                case 3:
                    listPossWithSameSalesAmount(posList);
                    break;
                case 4:
                    listPossWithSameSalesCategories(posList);
                    break;
                case 5:
                    listPossWithSameSalesAndPrepaidCards(posList);
                    break;
                case 6:
                    addPrepaidCard(posList);
                    break;
                case 7:
                    removePrepaidCard(posList);
                    break;
                case 8:
                    updatePrepaidCardExpiry(posList);
                    break;
                case 9:
                    addSalesToPos(posList);
                    break;
                case 0:
                    System.out.println("Thank you for using the Concordia CostLessBites Catering Sales Counter Application!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Display a welcome message for the CostLessBites Catering Sales Counter Application
    private static void welcomeMessage() {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Welcome to Concordia CostLessBites Catering Sales Counter Application");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

    // Display the menu options for the user to choose from
    private static void displayMenu() {
        System.out.println("\nWhat would you like to do?");
        System.out.println("1 >> See the content of all PoSs");
        System.out.println("2 >> See the content of one PoS");
        System.out.println("3 >> List PoSs with the same $ amount of sales");
        System.out.println("4 >> List PoS with the same number of sales categories");
        System.out.println("5 >> List PoSs with the same $ amount of sales and the same number of Prepaid cards");
        System.out.println("6 >> Add a Prepaid card to an existing PoS");
        System.out.println("7 >> Remove an existing Prepaid card from a PoS");
        System.out.println("8 >> Update the expiry date of an existing Prepaid card");
        System.out.println("9 >> Add Sales to a PoS");
        System.out.println("0 >> To quit");
    }

    // Get the user's choice from the menu
    private static int getUserChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your choice and press <Enter>: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            System.out.print("Please enter your choice and press <Enter>: ");
            scanner.next(); // Consume the invalid input
        }
        int choice = scanner.nextInt();
        return choice;
    }

    // Display the content of all PoS (Point of Sale)
    private static void displayAllPos(PoS[] posList) {
        System.out.println("Content of each PoS");
        System.out.println("--------------------");
        for (int i = 0; i < posList.length; i++) {
            System.out.println("PoS #" + (i) + ":\n" + posList[i].toString() + "\n");
        }
    }

    // Display the content of a specific PoS chosen by the user
    private static void displayOnePos(PoS[] posList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Which PoS you want to see the content of? (Enter number 0 to 4): ");

        while (true) {

            int posIndex = scanner.nextInt();
            if (posIndex >= 0 && posIndex < posList.length) {
                System.out.println("PoS " + posIndex + ":\n" + posList[posIndex]);
                break;
            } else {
                System.out.print("Sorry but there is no PoS number " + posIndex + "\n--> Try agian: (Enter number 0 to 4):");
            }
        }
    }

    // List PoSs with the same total sales amount
    private static void listPossWithSameSalesAmount(PoS[] posList) {
        System.out.println("List of PoSs with same total $ Sales: ");
        System.out.println(" ");
        for (int i = 0; i < posList.length - 1; i++) {
            for (int j = i + 1; j < posList.length; j++) {
                if (posList[i].totalSalesEqual(posList[j])) {
                    System.out.println("PoS " + (i) + " and " + (j) + " both have $" + posList[i].totalSales());
                }
            }
        }
    }

    // List PoSs with the same sales categories
    private static void listPossWithSameSalesCategories(PoS[] posList) {
        System.out.println("List of Poss with same Sales categories: ");
        System.out.println(" ");
        for (int i = 0; i < posList.length - 1; i++) {
            for (int j = i + 1; j < posList.length; j++) {
                if (posList[i].salesCategoriesEqual(posList[j])) {
                    System.out.println("PoS " + i + " and " + j + " both have " + posList[j].salesBreakdown());
                }
            }
        }
    }

    // List PoSs with the same total sales amount and the same number of Prepaid Cards
    private static void listPossWithSameSalesAndPrepaidCards(PoS[] posList) {
        System.out.println("List of PoS With same $ amount of sales and same number of PrePaiCards : ");
        System.out.println(" ");
        for (int i = 0; i < posList.length - 1; i++) {
            for (int j = i + 1; j < posList.length; j++) {
                // Check if two PoS have the same total sales and the same number of Prepaid Cards
                if (posList[i].equals(posList[j])) {
                    System.out.println("PoS " + i + " and " + j);
                }
            }
        }
    }

    // Add a Prepaid Card to a specific PoS chosen by the user
    private static void addPrepaidCard(PoS[] posList) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Which PoS would you like to add a PrePaiCard to? (Enter number from 0 to 4): ");
        int posIndex = scanner.nextInt();

        if (posIndex >= 0 && posIndex < posList.length) {
            System.out.print("Enter the type of prepaid card (Carnivore, Halal, Kosher, Pescatarian, Vegetarian, Vigan): ");
            String cardType = scanner.next();

            if (isValidCardType(cardType)) {
                System.out.print("Enter ID of the prepaid card owner: ");
                String cardId = scanner.next();
                System.out.print("Enter the expiry day and expiry month (separated by a space): ");
                int expiryDay = scanner.nextInt();
                int expiryMonth = scanner.nextInt();

                // Create a new Prepaid Card and add it to the selected PoS
                PrePaiCard newCard = new PrePaiCard(cardType, cardId, expiryDay, expiryMonth);
                posList[posIndex].addPrepaidCard(newCard);
                System.out.println("You now have " + posList[posIndex].numPrepaidCards() + " PrePaicard");
            } else {
                System.out.println("Invalid card type. Please enter a valid card type.");
            }
        } else {
            System.out.println("Invalid PoS index.");
        }
    }

    // Check if the entered card type is valid
    private static boolean isValidCardType(String cardType) {
        // Array of valid card types
        String[] validCardTypes = {"Carnivore", "Halal", "Kosher", "Pescatarian", "Vegetarian", "Vigan"};

        // Check if the entered card type is in the array of valid card types
        for (String validType : validCardTypes) {
            if (validType.equals(cardType)) {
                return true;
            }
        }
        return false;
    }

    // Remove a Prepaid Card from a specific PoS chosen by the user
    private static void removePrepaidCard(PoS[] posList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Which PoS you want to remove a PrePaiCard from? (Enter number 0 to 4): ");
        int posIndex = scanner.nextInt();

        if (posIndex >= 0 && posIndex < posList.length) {
            if (posList[posIndex].numPrepaidCards() == 0) {
                System.out.println("This PoS does not have any PrePaiCards.");
            } else {
                System.out.print("Which PrePaiCard you want to remove? (Enter number 0 to " + (posList[posIndex].numPrepaidCards() - 1) + "): ");
                int cardIndex = scanner.nextInt();

                // Remove the selected Prepaid Card from the chosen PoS
                if (posList[posIndex].removePrepaidCard(cardIndex)) {
                    System.out.println("PrePaicard was removed successfully.");
                } else {
                    System.out.println("Invalid prepaid card index.");
                }
            }
        } else {
            System.out.println("Invalid PoS index.");
        }
    }

    // Update the expiry date of a Prepaid Card in a specific PoS chosen by the user
    private static void updatePrepaidCardExpiry(PoS[] posList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Which PoS do you want to update a PrePaiCard from? (Enter number 0 to 4): ");
        int posIndex = scanner.nextInt();

        // Check if the selected PoS has any Prepaid Cards
        if (posList[posIndex].numPrepaidCards() == 0) {
            System.out.println("There is no Prepaid Card.");
        } else if (posIndex >= 0 && posIndex < posList.length) {
            System.out.print("Which PrePaiCard do you want to update? (Enter number 0 to " + (posList[posIndex].numPrepaidCards() - 1) + "): ");
            int cardIndex = scanner.nextInt();

            // Get the new expiry date from the user
            System.out.print("Enter the new expiry date day and the new expiry month (separated by a space): ");
            int newDay = scanner.nextInt();
            int newMonth = scanner.nextInt();

            // Update the expiry date of the selected Prepaid Card
            if (posList[posIndex].updatePrepaidCardExpiry(cardIndex, newDay, newMonth)) {
                System.out.println("Expiry date updated.");
            } else {
                System.out.println("Invalid prepaid card index.");
            }
        } else {
            System.out.println("Invalid PoS index.");
        }
    }

    // Add sales to a specific PoS chosen by the user
    private static void addSalesToPos(PoS[] posList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Which Pos do you want to add Sales to? (Enter number 0 to 4): ");
        int posIndex = scanner.nextInt();

        // Check if the selected PoS index is valid
        if (posIndex >= 0 && posIndex < posList.length) {
            System.out.println("How many junior, teen, medium, big, family meal menu do you want to add? ");
            System.out.print("Enter 5 numbers separated by a space: ");
            int junior = scanner.nextInt();
            int teen = scanner.nextInt();
            int medium = scanner.nextInt();
            int big = scanner.nextInt();
            int family = scanner.nextInt();

            // Add sales to the selected PoS and display the total sales
            double totalSales = posList[posIndex].addSales(junior, teen, medium, big, family);
            System.out.println("Sales added to PoS " + posIndex + "\nTotal Sales: $" + totalSales);
        } else {
            System.out.println("Invalid PoS index.");
        }
    }
}