import java.util.Scanner;

// Custom Exception for unavailable items
class ItemNotAvailableException extends Exception {
    public ItemNotAvailableException(String message) {
        super(message);
    }
}

// Custom Exception for unavailable table
class TableNotAvailableException extends Exception {
    public TableNotAvailableException(String message) {
        super(message);
    }
}

public class RestaurantManagement {
    private static String[] menuItems = {"Pizza", "Burger", "Pasta", "Fries"};
    private static int[] prices = {300, 150, 200, 100};
    private static boolean[] tableAvailable = {true, true, true, true, true}; // 5 tables

    public static int getPrice(String item) throws ItemNotAvailableException {
        for (int i = 0; i < menuItems.length; i++) {
            if (menuItems[i].equalsIgnoreCase(item)) {
                return prices[i];
            }
        }
        throw new ItemNotAvailableException("Sorry, " + item + " is not available.");
    }

    public static void bookTable(Scanner scanner) throws TableNotAvailableException {
        System.out.print("Do you want to book a table? (yes/no): ");
        String choice = scanner.next();

        if (choice.equalsIgnoreCase("yes")) {
            System.out.print("Enter number of people: ");
            int people = scanner.nextInt();

            if (people <= 0) {
                throw new ArithmeticException("Number of people must be greater than zero.");
            }

            System.out.print("Enter table number (1-5): ");
            int tableNum = scanner.nextInt();

            
            if (!tableAvailable[tableNum - 1]) {
                throw new TableNotAvailableException("Table " + tableNum + " is already booked.");
            }

            tableAvailable[tableNum - 1] = false;
            System.out.println("Table " + tableNum + " booked successfully for " + people + " people.");
        } else {
            System.out.println("Skipping table booking.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         
        try {
            // Table Booking First
            bookTable(scanner);

            // Ordering Food
            System.out.println("\nMenu: Pizza, Burger, Pasta, Fries");
            System.out.print("Enter item name: ");
            String item = scanner.next();

            int price = getPrice(item); 
            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();

            if (quantity <= 0) {
                throw new ArithmeticException("Quantity must be greater than zero.");
            }

            int totalPrice = price * quantity;
            System.out.println("Total Price: " + totalPrice);

            // // Forcefully creating IllegalThreadStateException (for demonstration)
            // Thread thread = new Thread();
            // thread.start();
            // thread.start(); // IllegalThreadStateException here

        } catch (ItemNotAvailableException e) {
            System.out.println("Custom Exception: " + e.getMessage());
        } catch (TableNotAvailableException e) {
            System.out.println("Table Booking Exception: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception: " + e.getMessage());
        }  finally {
            scanner.close();
            System.out.println("\nOrder process completed.");
        }
    }
}
