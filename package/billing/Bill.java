package billing;

import menu.RestaurantMenu;

public class Bill extends RestaurantMenu { 
    private int totalAmount = 0;

    public void addToBill(int price) {
        totalAmount += price;
    }

    public void generateBill() {
        System.out.println("\nGenerating bill...");
        System.out.println("Total Amount: " + totalAmount);
    }
}
