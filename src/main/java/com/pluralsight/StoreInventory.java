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

}
