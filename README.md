# -CostLessBites

#Author: Narendra Mishra
#University: Concordia University, Montreal, Canada
#Date of submission of project : 05th December 2023

# CostLessBites Point of Sale (PoS) Simulation

## Overview
This Java program simulates a Point of Sale (PoS) system for CostLessBites catering, which serves the Concordia community with healthy and budget-friendly meals. The system handles orders through on-demand sales or prepaid cards. This project was developed as part of COMP 248 - Fall 2023, Assignment 4 at Concordia University.

## Features
The program is designed to manage meal sales and prepaid cards with the following features:
- Five meal categories: junior, teen, medium, big, and family size with predefined prices.
- Six diet types: Carnivore, Halal, Kosher, Pescatarian, Vegetarian, and Vegan.
- Yearly prepaid cards for different diets.
- A robust PoS system to handle sales and manage prepaid cards.

## Classes and Methods

### 1. `Sales` Class
Handles the sales of different meal categories.
- **Attributes**: Counts of junior, teen, medium, big, and family meals.
- **Methods**:
  - Constructors: Default, parameterized, and copy constructors.
  - `addSales(int, int, int, int, int)`: Adds to the count of each meal category.
  - `SalesTotal()`: Calculates the total sales value.
  - `toString()`: Provides a formatted string of sales counts.
  - `equals(Sales)`: Compares two sales objects for equality.

### 2. `PrePaiCard` Class
Manages prepaid card information.
- **Attributes**: Diet type, cardholder ID, expiry day, and month.
- **Methods**:
  - Constructors: Default, parameterized, and copy constructors.
  - `toString()`: Returns a formatted string of prepaid card details.
  - `equals(PrePaiCard)`: Compares two prepaid cards for equality.

### 3. `PoS` Class
Combines sales and prepaid cards to form the complete PoS system.
- **Attributes**: Sales object and an array of prepaid cards.
- **Methods**:
  - Constructors: Default and parameterized.
  - `addPrePaiCard(PrePaiCard)`: Adds a new prepaid card to the PoS.
  - `removePrePaiCard(int)`: Removes a specified prepaid card.
  - `addSales(int, int, int, int, int)`: Adds meal sales to the PoS.
  - `toString()`: Provides a detailed breakdown of sales and prepaid cards.

### 4. `PoSDemo` Class (Driver)
The driver class for testing and demonstrating the functionality of the system.
- **Features**:
  - Creates multiple PoS objects with various configurations.
  - Displays menus to interact with the user for testing purposes.

## Usage
1. Clone the repository to your local machine.
2. Compile and run the `PoSDemo` class to interact with the PoS system.
3. Follow the on-screen prompts to manage sales and prepaid cards.

## Installation
Ensure you have Java installed. You can compile the code using the following command:
```bash
javac PoSDemo.java

# -CostLessBites
