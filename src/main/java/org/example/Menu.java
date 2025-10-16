package org.example;

import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private CurrencyConverter converter;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.converter = new CurrencyConverter();
    }

    public void displayMenu() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("      CURRENCY CONVERTER APP");
        System.out.println("=".repeat(40));
        System.out.println("1. Convert SEK to USD");
        System.out.println("2. Convert USD to SEK");
        System.out.println("3. Convert SEK to EUR");
        System.out.println("4. Convert EUR to SEK");
        System.out.println("5. Convert USD to EUR");
        System.out.println("6. Convert EUR to USD");
        System.out.println("0. Exit");
        System.out.println("=".repeat(40));
    }

    public int getMenuChoice() {
        while (true) {
            System.out.print("Enter your choice (0-6): ");
            String input = scanner.nextLine().trim();

            try {
                int choice = Integer.parseInt(input);
                if (choice >= 0 && choice <= 6) {
                    return choice;
                } else {
                    System.out.println("Error: Please enter a number between 0 and 6.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number.");
            }
        }
    }

    public void handleMenuChoice(int choice) {
        switch (choice) {
            case 1:
                converter.performConversion(Currency.SEK, Currency.USD);
                break;
            case 2:
                converter.performConversion(Currency.USD, Currency.SEK);
                break;
            case 3:
                converter.performConversion(Currency.SEK, Currency.EUR);
                break;
            case 4:
                converter.performConversion(Currency.EUR, Currency.SEK);
                break;
            case 5:
                converter.performConversion(Currency.USD, Currency.EUR);
                break;
            case 6:
                converter.performConversion(Currency.EUR, Currency.USD);
                break;
            case 0:
                System.out.println("Thank you for using Currency Converter App. Goodbye!");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    public void run() {
        int choice;
        do {
            displayMenu();
            choice = getMenuChoice();
            handleMenuChoice(choice);
        } while (choice != 0);

        scanner.close();
    }
}