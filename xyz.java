// import java.util.*;

// public class xyz{
//     public int a;
//     public int b;
//     xyz(int a, int b)
//     {
//         this.a=a;
//         this.b=b;
//     }
//     int add(Scanner sc)
//     {
//         System.out.println("Enter first number: ");
//         a=sc.nextInt();
//         System.out.println("Enter Second number: ");
//         b=sc.nextInt();
//         return a+b;
//     }

//     public static void main(String agr[])
//     {
//         Scanner sc = new Scanner(System.in);
//         xyz obj = new xyz(0,0);
//         int sum = obj.add(sc);
//         System.out.println("Addition of Two numer "+obj.a+" and "+obj.b+" is: "+sum);
//     }
// }
// import java.util.* ;

// class Shape{
//     Shape()
//     {}

//     public void getinfo(Scanner sc)
//     {

//     }

//     protected double Area()
//     { 
//         return 0;
//       }

//     protected double Perimeter()
//     {
//         return 0;
//     }
// }

// final class Circle extends Shape
// {
//     private float radius;

//     Circle()
//     {
//         super();
//     }

//     @Override
//     public void getinfo(Scanner sc)
//     {
//         System.out.println("Enter Radius: ");
//         radius=sc.nextFloat(); 
//         while(radius<=0)
//         {
//             System.out.println("Please Enter valide value: ");
//             radius = sc.nextFloat();
//         }
//     }
    
//     @Override
//     public double Area()
//     { 
//         return Math.PI*radius*radius;
//     }

//     @Override
//     public double Perimeter()
//     {
//         return 2* Math.PI *radius;
//     }

// }

// final class Rectangle extends Shape
// {
//     private float l,b;

//     Rectangle()
//     {
//         super();
//     }

//     @Override
//     public void getinfo(Scanner sc)
//     {
//         System.out.println("Enter length: ");
//         l=sc.nextFloat(); 
//         while(l<=0)
//         {
//             System.out.println("Please Enter valide value: ");
//             l = sc.nextFloat();
//         }
//         System.out.println("Enter breadth: ");
//         b=sc.nextFloat(); 
//         while(b<=0)
//         {
//             System.out.println("Please Enter valide value: ");
//             b = sc.nextFloat();
//         }
//     }
    
//     @Override
//     public double Area()
//     { 
//         return l*b;
//     }

//     @Override
//     public double Perimeter()
//     {
//         return  2*(l+b);
//     }

// }

// public class xyz{
//     public static void main(String arg[])
//     {
//         Circle c = new  Circle();
//         Rectangle r = new Rectangle();
//         Scanner sc = new Scanner(System.in);
//         int ch;

//         do{
//             System.out.println("Enter your choice:");
//             System.out.println("\n1. Circle \n2.Rectangle \n3.Exit:");
//             ch = sc.nextInt();

//             switch(ch)
//             {
//                 case 1:
//                     c.getinfo(sc);
//                     System.out.println("Area of circle is : "+c.Area());
//                     System.out.println("Perimeter of circle is : "+c.Perimeter());
//                     break;

//                 case 2:
//                     r.getinfo(sc);
//                     System.out.println("Area of rectangle is : "+r.Area());
//                     System.out.println("Perimeter of circle is : "+r.Perimeter()); 
//                     break;

//                 case 3:
//                     System.out.println("Exiting Program........");  
//                     break; 

//                 default :
//                     System.out.println("Invalide Choice....");     
//                     break;   
//             }
//         }while(ch!=3);
//         sc.close();
//     }
// }
import java.util.*;

interface Shape1D{
    final float PI =3.14f;
    double Area();
    double perimetre();
}

interface Shape2D{
    final float PI =3.14f;
    double Area2D();
    double Volume();
}

interface operation extends Shape1D , Shape2D{}

class Shape implements operation{
    private float radius;
    private float length;
    private float breadth;
    private float height;

    Shape(){
        radius=0;
        breadth =0;
        length = 0;
        height = 0;
    }

    public void getdatal(Scanner sc){
        length = sc.nextFloat();
    }
    public void getdatar(Scanner sc){
        radius = sc.nextFloat();
    }
    public void getdatab(Scanner sc){
        breadth = sc.nextFloat();
    }
    public void getdatah(Scanner sc){
        height = sc.nextFloat();
    }

    @Override
    public double Area(){
        return Shape1D.PI * radius * radius;
    }

    @Override
    public double perimetre(){
        return 2 *Shape1D.PI* radius;
    }

    @Override
    public double Area2D(){
        return Shape2D.PI* radius * radius;
    }

    @Override
    public double Volume(){
        return Shape2D.PI* radius * radius;
    }
}

public class xyz{
    public static void main(String arg[])
    {
        Shape s = new Shape();
        Scanner sc = new Scanner(System.in);
        int ch;
        do { 
            System.out.println("\nEnter your choice:\n1.Circle\n2.Rectangle\n3.Exits");
            ch = sc.nextInt();

            switch(ch)
            {
                case 1: 
                    System.out.println("Enter radius :");
                    s.getdatar(sc);
                    System.out.println("Area of circle is : "+s.Area());
                    System.out.println("Perimeter of circle is : "+s.perimetre());
                    break;

                case 2:
                    System.out.println("Enter breadth:");
                    s.getdatab(sc);
                    System.out.println("Enter length:");
                    s.getdatal(sc); 
                    System.out.println("Area of circle is : "+s.Area());
                    System.out.println("Perimeter of circle is : "+s.perimetre());
                    break;

                case 3:
                    System.out.println("Exiting program.....");
                    break;

                default:
                    System.out.println("Invalide choice....");
                    break;    

            }
        } while (ch!=3);
        sc.close();
    }
}