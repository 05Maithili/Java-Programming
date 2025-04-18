import billing.Bill;
import java.util.Scanner;

public class RestaurantApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bill bill = new Bill();
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Restaurant System ---");
            System.out.println("1. View Menu");
            System.out.println("2. Order Food");
            System.out.println("3. Book a Table");
            System.out.println("4. View Table Status");
            System.out.println("5. Generate Bill");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    bill.displayMenu();
                    break;
                case 2:
                    System.out.println("Enter item number to order: ");
                    int item = scanner.nextInt();
                    switch (item) {
                        case 1:
                            bill.addToBill(75);
                            System.out.println("Burger added to the bill.");
                            break;
                        case 2:
                            bill.addToBill(100);
                            System.out.println("Pizza added to the bill.");
                            break;
                        case 3:
                            bill.addToBill(75);
                            System.out.println("Pasta added to the bill.");
                            break;
                        default:
                            System.out.println("Invalid item selection.");
                    }
                    break;
                case 3:
                    System.out.print("Enter table number to book (1-10): ");
                    int tableNumber = scanner.nextInt();
                    bill.bookTable(tableNumber);
                    break;
                case 4:
                    bill.displayTables();
                    break;
                case 5:
                    bill.generateBill();
                    break;
                case 6:
                    exit = true;
                    System.out.println("Exiting... Thank you for visiting!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        scanner.close();
    }
}
