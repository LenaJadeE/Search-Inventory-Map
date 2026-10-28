package com.pluralsight;

public class Product {
    private final int id;
    private final String name;
    private final double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}


//  EXERCISE 2
//      Create a new Java application search-inventory-map.
//      Write the code for the application that was demonstrated in the previous pages.
//      Add a loadInventory() method to load all of the products from the inventory.csv file.
//      Create a product from each line and add it to a Map.
//      Use the product id as the map key so that users can search for products by name.
//          Test the application.
//      BONUS: Write code to let the user look up more than one product.
//          After the program displays the results of the search, ask the user "Do you want to search again?".
//          Keep repeating the search as long as they answer yes to the question.