package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class StoreInventory {
    private static final String InventoryFile = "inventory.csv";

    private static final HashMap<Integer, Product> inventory = new HashMap<>();

    public static void main(String[] args){
        loadInventory();

        Scanner scanner = new Scanner(System.in);
        boolean searchAgain = true;

        while (searchAgain) {
            searchForProduct(scanner);

            System.out.print("Do you want to search again? (yes/no): ");
            String answer = scanner.nextLine().trim();
            searchAgain = answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y");
        }

        System.out.println("Goodbye!");
    }

    private static void loadInventory(){
        try (BufferedReader reader = new BufferedReader(new FileReader(InventoryFile))){
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) {
                    continue;
                }

                try {
                    String[] parts = line.split("\\|");

                    int id = Integer.parseInt(parts[0].trim());

                    String name = parts[1].trim();
                    double price = Double.parseDouble(parts[2].trim());

                    inventory.put(id, new Product(id, name, price));
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.out.println("Skipping a line that isn't in id|name|price format: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("ERROR: Could not read " + InventoryFile + ": " + e.getMessage());
        }
    }

    private static void searchForProduct(Scanner scanner){
        System.out.println("What item # are you interested in? ");

        try {
            int id = Integer.parseInt(scanner.nextLine().trim());
            Product matchedProduct = inventory.get(id);

            if (matchedProduct == null) {
                System.out.println("We don't carry that product");
                return;
            }

            System.out.printf("We carry %s and the price is $%.2f%n",
                    matchedProduct.getName(), matchedProduct.getPrice());
        } catch (NumberFormatException e) {
            System.out.println("That wasn't a valid item number. Please enter a whole number.");
        }
    }
}
