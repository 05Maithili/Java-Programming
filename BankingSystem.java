import java.util.Scanner;

// Custom Exception for empty name
class NonameException extends Exception {
    public NonameException(String message) {
        super(message);
    }
}

// Custom Exception for insufficient balance
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

public class BankingSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balance = 0.0;

        try {
            // Step 1: Initial Balance
            System.out.print("Enter initial amount (balance): ");
            balance = scanner.nextDouble();

            if (balance < 0) {
                throw new ArithmeticException("Initial balance cannot be negative.");
            }

            scanner.nextLine(); // Consume newline

            // Step 2: Get Customer Name
            System.out.print("Enter Customer Name: ");
            String name = scanner.nextLine();

            if (name.isEmpty()) {
                throw new NonameException("Customer name cannot be empty!");
            }

            // Step 3: Transaction Options
            boolean exit = false;
            while (!exit) {
                System.out.println("\nSelect an option:");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Check Balance");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1: // Deposit
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        if (depositAmount <= 0) {
                            throw new ArithmeticException("Deposit amount must be greater than zero.");
                        }
                        balance += depositAmount;
                        System.out.println("Deposit successful! New balance: " + balance);
                        break;

                    case 2: // Withdraw
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = scanner.nextDouble();
                        if (withdrawAmount <= 0) {
                            throw new ArithmeticException("Withdrawal amount must be greater than zero.");
                        }
                        if (withdrawAmount > balance) {
                            throw new InsufficientBalanceException("Insufficient balance to complete withdrawal.");
                        }
                        balance -= withdrawAmount;
                        System.out.println("Withdrawal successful! New balance: " + balance);
                        break;

                    case 3: // Check Balance
                        System.out.println("Current balance: " + balance);
                        break;

                    case 4: // Exit
                        System.out.println("Thank you for using our banking system.");
                        exit = true;
                        break;

                    default:
                        throw new IllegalArgumentException("Invalid option. Please select between 1-4.");
                }
            }

        //} catch (InputMismatchException e) {
        //     System.out.println("Input Mismatch Exception: Please enter valid numeric input.");
        } catch (NonameException e) {
            System.out.println("Custom Exception: " + e.getMessage());
        } catch (InsufficientBalanceException e) {
            System.out.println("Custom Exception: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal Argument Exception: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("\nBanking session ended.");
        }
    }
}
