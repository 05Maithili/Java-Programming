import java.util.Scanner;

class Library {
    private int availableBooks = 5;

    synchronized void borrowBook(int quantity, String studentName) {
        System.out.println("Thread: " + Thread.currentThread().getName());
        System.out.println("Priority: " + Thread.currentThread().getPriority());
        System.out.println(studentName + " is trying to borrow " + quantity + " book(s)");

        if (availableBooks >= quantity) {
            System.out.println("Processing borrow request for " + studentName + "...");
            try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
            availableBooks -= quantity;
            System.out.println("Borrow successful for " + studentName);
        } else {
            System.out.println("Not enough books available for " + studentName);
        }

        System.out.println("Books remaining: " + availableBooks);
    }

    synchronized void returnBook(int quantity, String studentName) {
        System.out.println("Thread: " + Thread.currentThread().getName());
        System.out.println("Priority: " + Thread.currentThread().getPriority());
        System.out.println(studentName + " is returning " + quantity + " book(s)");

        try { Thread.sleep(1500); } catch (InterruptedException e) { e.printStackTrace(); }

        availableBooks += quantity;
        System.out.println("Return successful for " + studentName);
        System.out.println("Books now available: " + availableBooks);
    }

    void checkAvailability(String studentName) {
        System.out.println("Thread: " + Thread.currentThread().getName());
        System.out.println("Priority: " + Thread.currentThread().getPriority());
        System.out.println(studentName + " is checking book availability...");
        System.out.println("Books available: " + availableBooks);

        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
    }
}

// Thread for borrowing books
class BorrowThread extends Thread {
    Library library;
    int quantity;
    String student;

    BorrowThread(Library library, int quantity, String student, String name) {
        super(name);
        this.library = library;
        this.quantity = quantity;
        this.student = student;
    }

    public void run() {
        library.borrowBook(quantity, student);
    }
}

// Thread for returning books
class ReturnThread extends Thread {
    Library library;
    int quantity;
    String student;

    ReturnThread(Library library, int quantity, String student, String name) {
        super(name);
        this.library = library;
        this.quantity = quantity;
        this.student = student;
    }

    public void run() {
        library.returnBook(quantity, student);
    }
}

// Runnable for checking availability
class AvailabilityCheck implements Runnable {
    Library library;
    String student;

    AvailabilityCheck(Library library, String student) {
        this.library = library;
        this.student = student;
    }

    public void run() {
        library.checkAvailability(student);
    }
}

// Main class
public class LibraryThread {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        int choice;
        do {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Borrow Book(s)");
            System.out.println("2. Return Book(s)");
            System.out.println("3. Check Book Availability");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            String name;
            int quantity;
            Thread thread = null;

            switch (choice) {
                case 1:
                    System.out.print("Enter your name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter number of books to borrow: ");
                    quantity = scanner.nextInt();
                    scanner.nextLine();
                    thread = new BorrowThread(library, quantity, name, "Borrow-Thread");
                    thread.setPriority(9);
                    break;

                case 2:
                    System.out.print("Enter your name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter number of books to return: ");
                    quantity = scanner.nextInt();
                    scanner.nextLine();
                    thread = new ReturnThread(library, quantity, name, "Return-Thread");
                    thread.setPriority(7);
                    break;

                case 3:
                    System.out.print("Enter your name: ");
                    name = scanner.nextLine();
                    thread = new Thread(new AvailabilityCheck(library, name), "CheckAvailability-Thread");
                    thread.setPriority(5);
                    break;

                case 4:
                    System.out.println("Thank you for using the library system!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            if (thread != null) {
                thread.start();
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        } while (choice != 4);

        scanner.close();
    }
}