import java.util.*;

public class Flower {

    private String name;
    private String color;
    private String leafColor;
    private int noPetal;
    private int noOfFlower;
    private int flowerSize;
    private String shape;

    public void getInfo(Scanner sc) {
        System.out.println("Enter Flower name:");
        name = sc.next();
        System.out.println("Enter Flower color:");
        color = sc.next();
        System.out.println("Enter Flower leaf color:");
        leafColor = sc.next();
        System.out.println("Enter Flower number of petals:");
        noPetal = sc.nextInt();
        while (noPetal <= 0) {
            System.out.println("***Error!! Petal cannot be negative");
            System.out.println("Enter Flower number of petals:");
            noPetal = sc.nextInt();
        }
        System.out.println("Enter number of Flowers:");
        noOfFlower = sc.nextInt();
        while (noOfFlower <= 0) {
            System.out.println("***Error!! Number of Flowers cannot be negative");
            System.out.println("Enter number of Flowers:");
            noOfFlower = sc.nextInt();
        }
        System.out.println("Enter Flower Size:");
        flowerSize = sc.nextInt();
        while (flowerSize <= 0) {
            System.out.println("***Error!! Flower size cannot be negative");
            System.out.println("Enter Flower Size:");
            flowerSize = sc.nextInt();
        }
        System.out.println("Enter Flower shape:");
        shape = sc.next();
    }

   public void display() {
    System.out.println("Flower name: " + name);
    System.out.println("Flower color: " + color);
    System.out.println("Flower leaf color: " + leafColor);
    if (noPetal > 0) {
        System.out.println("Flower number of petals: " + noPetal);
    } else {
        System.out.println("Flower number of petals: incorrect input");
    }
    if (noOfFlower > 0) {
        System.out.println("Number of Flowers: " + noOfFlower);
    } else {
        System.out.println("Number of Flowers: incorrect input");
    }
    if (flowerSize > 0) {
        System.out.println("Flower Size: " + flowerSize);
    } else {
        System.out.println("Flower Size: incorrect input");
    }
    System.out.println("Flower shape: " + shape);
    if (name.equalsIgnoreCase("rose")) {
        System.out.println("Flower genera: Rosa");
    } else if (name.equalsIgnoreCase("mogara")) {
        System.out.println("Flower genera: Mogra");
    } else if (name.equalsIgnoreCase("marigold")) {
        System.out.println("Flower genera: Tagetes");
    }
}


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size:");
        int n = sc.nextInt();
        Flower[] obj1 = new Flower[n];
        for (int i = 0; i < n; i++) {
            obj1[i] = new Flower();
        }
        int ch;
        while (true) {
            System.out.println("Enter your choice:");
            System.out.println("1. Accept Info");
            System.out.println("2. Display");
            System.out.println("3. Exit");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter data:");
                    for (int i = 0; i < n; i++) {
                        obj1[i].getInfo(sc);
                    }
                    break;
                case 2:
                     
                    for (int i = 0; i < n; i++) {
                    System.out.println("Information:"+i);
                        obj1[i].display();
                    }
                    break;
                case 3:
                    System.out.println("Exiting Program....");
                    return;
                default:
                    System.out.println("Invalid choice...Enter valid choice.");
            }
        }
    }
}
