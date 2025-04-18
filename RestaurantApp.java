import java.util.Scanner;

class RestaurantCustomer extends Thread {
    private Restaurant restaurant;

    RestaurantCustomer(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public synchronized void waitForTable() {
        try {
            System.out.println("[Customer Thread] Customer is waiting for a table...");
            wait(); // Waits until notify() is called
            System.out.println("[Customer Thread] Customer got a table! Dining started.");
        } catch (InterruptedException e) {
            System.out.println("[Customer Thread] Interrupted while waiting!");
        }
    }

    public void run() {
        System.out.println("[Customer Thread] Customer entered the restaurant.");
        waitForTable();
        dine();
    }

    public void dine() {
        System.out.println("[Customer Thread] Customer is dining...");
        try {
            Thread.sleep(3000); // Simulate dining time
        } catch (InterruptedException e) {
            System.out.println("[Customer Thread] Interrupted while dining!");
        }
        System.out.println("[Customer Thread] Customer finished dining and left the restaurant.");
    }
}

class RestaurantManager implements Runnable {
    private RestaurantCustomer customer;

    RestaurantManager(RestaurantCustomer customer) {
        this.customer = customer;
    }

    public void run() {
        try {
            Thread.sleep(2000); // Simulate delay
        } catch (InterruptedException e) {}

        synchronized (customer) {
            System.out.println("[Manager Thread] Manager assigned a table to the customer!");
            customer.notify(); // Notifies waiting customer
        }
    }
}

public class RestaurantApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RestaurantCustomer customer = null;
        RestaurantManager manager = null;
        int choice;

        do {
            System.out.println("\n1. Start Customer Thread (Enter + Wait)");
            System.out.println("2. Start Manager Thread (Assign Table)");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    if (customer == null || !customer.isAlive()) {
                        customer = new RestaurantCustomer(null); // Restaurant object can be passed if needed
                        customer.setName("CustomerThread");
                        customer.setPriority(Thread.NORM_PRIORITY); // Optional: set priority
                        customer.start(); // Start customer thread
                        System.out.println("Customer Thread Name: " + customer.getName());
                    } else {
                        System.out.println("[Main] Customer thread already running.");
                    }
                    break;

                case 2:
                    if (customer != null) {
                        manager = new RestaurantManager(customer);
                        Thread managerThread = new Thread(manager);
                        managerThread.setName("ManagerThread");
                        managerThread.setPriority(Thread.MAX_PRIORITY); // Set high priority for manager
                        managerThread.start(); // Start manager thread using Runnable
                        System.out.println("Manager Thread priority set to: " + managerThread.getPriority());
                    } else {
                        System.out.println("[Main] Start customer thread first!");
                    }
                    break;

                case 3:
                    System.out.println("Exiting application...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 3);

        sc.close();
    }
}