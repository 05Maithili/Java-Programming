import java.util.*;

class Book {
    protected String title;
    protected String author;
    protected String publisher;
    protected int pages;
    protected int copies;
    protected double price;

    public void getInfo(Scanner sc) {
        System.out.println("Enter Book Title:");
        title = sc.next();
        System.out.println("Enter Author Name:");
        author = sc.next();
        System.out.println("Enter Publisher:");
        publisher = sc.next();
        System.out.println("Enter Number of Pages:");
        pages = sc.nextInt();
        while (pages <= 0) {
            System.out.println("*Error!! Pages cannot be negative or zero");
            System.out.println("Enter Number of Pages:");
            pages = sc.nextInt();
        }
        System.out.println("Enter Number of Copies:");
        copies = sc.nextInt();
        while (copies <= 0) {
            System.out.println("*Error!! Copies cannot be negative or zero");
            System.out.println("Enter Number of Copies:");
            copies = sc.nextInt();
        }
        System.out.println("Enter Book Price:");
        price = sc.nextDouble();
        while (price <= 0) {
            System.out.println("*Error!! Price cannot be negative or zero");
            System.out.println("Enter Book Price:");
            price = sc.nextDouble();
        }
    }

    public void display() {
        System.out.println("Book Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Publisher: " + publisher);
        System.out.println("Number of Pages: " + pages);
        System.out.println("Number of Copies: " + copies);
        System.out.println("Price: $" + price);
    }
}

final class EBook extends Book {
    private double fileSize;

    @Override
    public void getInfo(Scanner sc) {
        super.getInfo(sc);
        System.out.println("Enter File Size (MB):");
        fileSize = sc.nextDouble();
    }

    @Override
    public void display() {
        super.display();
        System.out.println("File Size: " + fileSize + "MB");
    }
}

final class AudioBook extends Book {
    private double duration;

    @Override
    public void getInfo(Scanner sc) {
        super.getInfo(sc);
        System.out.println("Enter Duration (hours):");
        duration = sc.nextDouble();
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Duration: " + duration + " hours");
    }
}

final class PrintedBook extends Book {
    private double weight;

    @Override
    public void getInfo(Scanner sc) {
        super.getInfo(sc);
        System.out.println("Enter Weight (kg):");
        weight = sc.nextDouble();
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Weight: " + weight + " kg");
    }
}

public class Library {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of books:");
        int n = sc.nextInt();
        Book[] books = new Book[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the type of book (1. EBook, 2. AudioBook, 3. PrintedBook):");
            int type = sc.nextInt();
            switch (type) {
                case 1:
                    books[i] = new EBook();
                    break;
                case 2:
                    books[i] = new AudioBook();
                    break;
                case 3:
                    books[i] = new PrintedBook();
                    break;
                default:
                    System.out.println("Invalid type! Defaulting to PrintedBook.");
                    books[i] = new PrintedBook();
                    break;
            }
        }
        int ch;
        while (true) {
            System.out.println("Enter your choice:");
            System.out.println("1. Accept Book Info");
            System.out.println("2. Display Books");
            System.out.println("3. Exit");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter book details:");
                    for (int i = 0; i < n; i++) {
                        books[i].getInfo(sc);
                    }
                    break;
                case 2:
                    for (int i = 0; i < n; i++) {
                        System.out.println("Book Information: " + (i + 1));
                        books[i].display();
                    }
                    break;
                case 3:
                    System.out.println("Exiting Program....");
                    return;
                default:
                    System.out.println("Invalid choice... Enter valid choice.");
            }
        }
    }
}
