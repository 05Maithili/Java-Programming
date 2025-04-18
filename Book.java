import java.util.*;

public class Book {

    private String title;
    private String author;
    private String publisher;
    private int pages;
    private int copies;
    private double price;

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of books:");
        int n = sc.nextInt();
        Book[] books = new Book[n];
        for (int i = 0; i < n; i++) {
            books[i] = new Book();
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