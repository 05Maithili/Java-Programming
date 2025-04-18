import java.util.*;

class Restaurant {
    private int availableTables;

    Restaurant(int tables) {
        this.availableTables = tables;
    }

    synchronized void reserveTable(String customer) {
        System.out.println(customer + " trying to reserve a table...");
        while (availableTables == 0) {
            System.out.println("No tables available for " + customer + ". Waiting...");
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(customer + " interrupted.");
            }
        }
        availableTables--;
        System.out.println(customer + " reserved a table. Tables left: " + availableTables);
    }

    synchronized void releaseTable(String customer) {
        System.out.println(customer + " is leaving the restaurant...");
        availableTables++;
        System.out.println(customer + " released a table. Tables left: " + availableTables);
        notifyAll();
    }
}

class Customer implements Runnable {
    private Restaurant restaurant;
    private String name;

    Customer(Restaurant restaurant, String name) {
        this.restaurant = restaurant;
        this.name = name;
    }

    public void run() {
        System.out.println("Thread " + Thread.currentThread().getName() + " has priority " + Thread.currentThread().getPriority());
        restaurant.reserveTable(name);
        try {
            Thread.sleep(3000); // Simulate dining time
        } catch (InterruptedException e) {
            System.out.println(name + " interrupted while dining.");
        }
        restaurant.releaseTable(name);
    }
}

class Waiter implements Runnable {
    private String name;

    Waiter(String name) {
        this.name = name;
    }

    public void run() {
        while (true) {
            System.out.println("[Waiter " + name + "] Assisting customers and preparing tables...");
            try {
                Thread.sleep(3000); // Simulate assisting time
            } catch (InterruptedException e) {
                System.out.println("[Waiter " + name + "] Interrupted while working.");
            }
        }
    }
}

class Monitor extends Thread {
    private Restaurant restaurant;

    Monitor(Restaurant restaurant) {
        this.restaurant = restaurant;
        setDaemon(true);
    }

    public void run() {
        while (true) {
            System.out.println("[Monitor] Restaurant system is running...");
            try {
                sleep(5000); // Periodic check
            } catch (InterruptedException e) {
                System.out.println("[Monitor] Interrupted.");
            }
        }
    }
}

public class SmartRestaurantSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter total tables: ");
        int tables = sc.nextInt();
        Restaurant restaurant = new Restaurant(tables);

        System.out.print("Enter number of customers: ");
        int customerCount = sc.nextInt();
        sc.nextLine(); // Consume newline

        Thread[] customers = new Thread[customerCount];

        for (int i = 0; i < customerCount; i++) {
            System.out.print("Enter name of customer " + (i + 1) + ": ");
            String name = sc.nextLine();

            customers[i] = new Thread(new Customer(restaurant, name));
            customers[i].setPriority(3); // Set default priority
        }

        System.out.print("Enter number of waiters: ");
        int waiterCount = sc.nextInt();
        sc.nextLine(); // consume newline
        Thread[] waiters = new Thread[waiterCount];

        for (int i = 0; i < waiterCount; i++) {
            System.out.print("Enter name of waiter " + (i + 1) + ": ");
            String waiterName = sc.nextLine();

            waiters[i] = new Thread(new Waiter(waiterName));
            waiters[i].setPriority(1);
            waiters[i].setDaemon(true); // Optional: Background thread
            waiters[i].start();
        }

        // Start monitor thread
        new Monitor(restaurant).start();

        // Start all customer threads
        for (Thread c : customers) {
            c.start();
        }

        // Join all customer threads
        for (Thread c : customers) {
            try {
                c.join();
            } catch (InterruptedException e) {
                System.out.println("Main interrupted.");
            }
        }

        System.out.println("All customers processed. Restaurant is closing.");
        sc.close();
    }
}
