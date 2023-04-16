/* Program management inventory product which can use the following commands:
 *  "search" command to search list of product in inventory
 *  "add/delete" command to add/delete quantity of product
 *  "save" command to save the data to a file
 *  "exit" command to exit the program
 * 
 * Created by Pornthep Sangthongkhamsuk ID: 63070503431
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class exercise2 {

    private static final String FILENAME = "product.txt";   /* file name */
    private static ArrayList<String[]> inventory = new ArrayList<>();   /* array to get input from the file line by line */
    
    public static void main(String[] args) {
        loadInventory();
        Scanner scanner = new Scanner(System.in);
        String command = "";
        /* command  option */
        while (!command.equals("exit")) {
            System.out.println("\nCommands: search, add, delete, save, exit");
            System.out.print("Enter command: ");
            command = scanner.nextLine();
            switch (command) {
                case "search":
                    searchInventory(scanner);
                    break;
                case "add":
                    adjustInventory(scanner, true);
                    break;
                case "delete":
                    adjustInventory(scanner, false);
                    break;
                case "save":
                    saveInventory();
                    break;
                case "exit":
                    System.out.println("Exiting application...");
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
                    break;
            }
        }
    }

    /* Function for reading file and getting input to array from file at read */
    private static void loadInventory() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(", ");
                inventory.add(data);
            }
        } catch (IOException e) {
            System.out.println("Error loading inventory from file: " + e.getMessage());
        }
    }

    /* Function for search details of the product by search from product id */
    private static void searchInventory(Scanner scanner) {
        System.out.print("Enter product id: ");
        String id = scanner.nextLine();
        for (String[] item : inventory) {
            if (item[0].equals(id)) {
                System.out.println("Product name: " + item[1] + ", Quantity: " + item[2]);
                return;
            }
        }
        System.out.println("Product not found.");
    }

    /* Function for add/delete quantity to the product at need to add/delete */
    private static void adjustInventory(Scanner scanner, boolean add) {
        System.out.print("Enter product id: ");
        String id = scanner.nextLine();
        for (String[] item : inventory) {
            if (item[0].equals(id)) {
                System.out.print("Enter quantity to " + (add ? "add" : "delete") + ": ");
                int quantity = scanner.nextInt();
                int currentQuantity = Integer.parseInt(item[2]);
                if (add) {
                    currentQuantity += quantity;
                } else {
                    currentQuantity -= quantity;
                }
                item[2] = String.valueOf(currentQuantity);
                System.out.println("Quantity adjusted. New quantity: " + currentQuantity);
                return;
            }
        }
        System.out.println("Product not found.");
    }

    /* Function for saving to file */
    private static void saveInventory() {
        try (FileWriter writer = new FileWriter(FILENAME)) {
            for (String[] item : inventory) {
                writer.write(String.join(", ", item) + "\n");
            }
            System.out.println("Inventory saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving inventory to file: " + e.getMessage());
        }
    }
}
