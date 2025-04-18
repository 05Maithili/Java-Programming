import java.util.*;

class Shape {
    public Shape() {
        // Default constructor
    }

    protected void getInfo(Scanner sc) {
        // This method will be overridden in subclasses
    }

    protected double calculateArea() {
        // This method will be overridden in subclasses
        return 0;
    }

    protected double calculatePerimeter() {
        // This method will be overridden in subclasses
        return 0;
    }

    protected double calculateVolume() {
        // This method will be overridden in subclasses
        return 0;
    }
}

final class Circle extends Shape {
    private double radius;

    public Circle() {
        super(); // Call the constructor of the Shape class
    }

    @Override
    public void getInfo(Scanner sc) {
        System.out.println("Enter radius of the circle:");
        this.radius = sc.nextDouble();
        while(this.radius<=0)
        {
             System.out.println("***Error!!!! Radius can not be negative!!!");
             System.out.println("Re-Enter radius of the circle:");
             this.radius = sc.nextDouble();

         }
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

final class Rectangle extends Shape {
    private double length;
    private double breadth;

    public Rectangle() {
        super(); // Call the constructor of the Shape class
    }

    @Override
    public void getInfo(Scanner sc) {
        System.out.println("Enter length and breadth of the rectangle:");
        this.length = sc.nextDouble();
        this.breadth = sc.nextDouble();
        while(this.length<=0 || this.breadth<=0 )
        {
             System.out.println("***Error!!!! Radius can not be negative!!!");
             System.out.println("Re-Enter length and breadth of the rectangle:");
             this.length = sc.nextDouble();
             this.breadth = sc.nextDouble();   

         }

    }

    @Override
    public double calculateArea() {
        return length * breadth;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (length + breadth);
    }
}

final class Sphere extends Shape {
    private double radius;

    public Sphere(double radius) {
        super(); // Call the constructor of the Shape class
        this.radius=radius;
    }

    @Override
    public void getInfo(Scanner sc) {
        System.out.println("Enter radius of the sphere:");
        this.radius = sc.nextDouble();
        while(this.radius<=0)
        {
             System.out.println("***Error!!!! Radius can not be negative!!!");
             System.out.println("Re-Enter radius of the sphere:");
             this.radius = sc.nextDouble();

         }

        
    }

    @Override
    public double calculateArea() {
        return 4 * Math.PI * radius * radius;
    }

    @Override
    public double calculateVolume() {
        return (4.0 / 3.0) * Math.PI * radius * radius * radius;
    }
}

final class Cuboid extends Shape {
    private double length;
    private double width;
    private double height;

    public Cuboid(double length,double width,double height) {
        super(); // Call the constructor of the Shape class
        this.length=length;
        this.width=width;
        this.height=height;

    }

    @Override
    public void getInfo(Scanner sc) {
        System.out.println("Enter length, width, and height of the cuboid:");
        this.length = sc.nextDouble();
        this.width = sc.nextDouble();
        this.height = sc.nextDouble();
        while(this.length<=0 || this.height<=0 || this.width<=0)
        {
             System.out.println("***Error!!!! Radius can not be negative!!!");
             System.out.println("Re-Enter length, width, and height of the cuboid:");
             this.length = sc.nextDouble();
             this.width = sc.nextDouble();
             this.height = sc.nextDouble();   

         }

    }

    @Override
    public double calculateArea() {
        return 2 * (length * width + width * height + height * length);
    }

    @Override
    public double calculateVolume() {
        return length * width * height;
    }
}

public class ShapeDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Select the type of shape:");
            System.out.println("1. Circle");
            System.out.println("2. Rectangle");
            System.out.println("3. Sphere");
            System.out.println("4. Cuboid");
            System.out.println("5. Exit");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Circle circle = new Circle();
                    circle.getInfo(sc);
                    System.out.println("Area: " + circle.calculateArea());
                    System.out.println("Perimeter: " + circle.calculatePerimeter());
                    break;
                case 2:
                    Rectangle rectangle = new Rectangle();
                    rectangle.getInfo(sc);
                    System.out.println("Area: " + rectangle.calculateArea());
                    System.out.println("Perimeter: " + rectangle.calculatePerimeter());
                    break;
                case 3:
                    Sphere sphere = new Sphere(0);
                    sphere.getInfo(sc);
                    System.out.println("Area: " + sphere.calculateArea());
                    System.out.println("Volume: " + sphere.calculateVolume());
                    break;
                case 4:
                    Cuboid cuboid = new Cuboid(0,0,0);
                    cuboid.getInfo(sc);
                    System.out.println("Area: " + cuboid.calculateArea());
                    System.out.println("Volume: " + cuboid.calculateVolume());
                    break;
                case 5:
                    System.out.println("Exiting program!!");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    continue;
            }
        } while (choice != 5);

        sc.close();
    
    }
}
