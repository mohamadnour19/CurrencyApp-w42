package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;



public class CurrencyConverter {
    private Scanner scanner;
    public CurrencyConverter() {
        scanner = new Scanner(System.in);
    }

    public void performConversion(Currency from, Currency to) {
        System.out.printf("\n==== Converting %s to %s ====\n", from.getCode(), to.getCode());

        double amount = getValidAmount();
        if (amount < 0) {
            return;
        }
        double convertedAmount = from.convertTo(to, amount);
        displayResult(amount, from, convertedAmount, to);

    }

    private double getValidAmount() {
        while (true) {
            System.out.print("Enter amount to convert (or '0' to go back): ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("0")) {
                return -1;
            }
            try {
                double amount = Double.parseDouble(input);
                if (amount < 0) {
                    System.out.println("Error: Amount cannot be negative. Please try again.");
                    continue;
                }
                return amount;
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number.");
            }
        }


    }

    private void displayResult(double originalAmount, Currency from, double convertedAmount, Currency to) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        System.out.println("\n" + "=".repeat(50));
        System.out.println("CONVERSION RESULT");
        System.out.println("=".repeat(50));
        System.out.printf("%s = %s\n", from.format(originalAmount), to.format(convertedAmount));
        System.out.println("Conversion date: " + now.format(formatter));
        System.out.println("=".repeat(50));

        System.out.println("\nPress ENTER to continue...");
        scanner.nextLine();


    }


}
