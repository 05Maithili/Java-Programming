package menu;

public class RestaurantMenu {
    protected boolean[] tables = new boolean[10]; 

    public void displayMenu() {
        System.out.println("---- Restaurant Menu ----");
        System.out.println("1. Burger - 75");
        System.out.println("2. Pizza - 100");
        System.out.println("3. Pasta - 75");
    }

    public boolean bookTable(int tableNumber) {  // Changed to public
        if (tableNumber < 1 || tableNumber > tables.length) {
            System.out.println("Invalid table number! Choose between 1 and " + tables.length);
            return false;
        }
        if (tables[tableNumber - 1]) {
            System.out.println("Table " + tableNumber + " is already booked.");
            return false;
        } else {
            tables[tableNumber - 1] = true;
            System.out.println("Table " + tableNumber + " has been successfully booked.");
            return true;
        }
    }

    public void displayTables() { // Changed to public
        System.out.println("\n---- Table Booking Status ----");
        for (int i = 0; i < tables.length; i++) {
            System.out.println("Table " + (i + 1) + ": " + (tables[i] ? "Booked" : "Available"));
        }
    }
}
