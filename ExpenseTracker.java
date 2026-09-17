import java.util.ArrayList;
import java.util.Scanner;

class Expense {

    String name;
    double amount;
    String category;

    Expense(String name, double amount, String category) {
        this.name = name;
        this.amount = amount;
        this.category = category;
    }
}

public class ExpenseTracker {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Expense> expenses = new ArrayList<>();

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n=================================");
            System.out.println("         EXPENSE TRACKER");
            System.out.println("=================================");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. View Total Expense");
            System.out.println("4. Delete Expense");
            System.out.println("5. Exit");
            System.out.println("=================================");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addExpense();
                    break;

                case 2:
                    viewExpenses();
                    break;

                case 3:
                    viewTotal();
                    break;

                case 4:
                    deleteExpense();
                    break;

                case 5:
                    System.out.println("Thank you for using Expense Tracker!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

        sc.close();
    }

    static void addExpense() {

        System.out.println("\n--- Add Expense ---");

        System.out.print("Enter expense name: ");
        String name = sc.nextLine();

        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter category: ");
        String category = sc.nextLine();

        Expense expense = new Expense(name, amount, category);

        expenses.add(expense);

        System.out.println("Expense added successfully!");
    }

       static void viewExpenses() {

    System.out.println("\n--- All Expenses ---");

    if (expenses.isEmpty()) {
        System.out.println("No expenses found.");
        return;
    }

    for (int i = 0; i < expenses.size(); i++) {

        Expense expense = expenses.get(i);

        System.out.println(
            (i + 1) + ". " +
            expense.name +
            " - Rs." +
            expense.amount +
            " - " +
            expense.category
        );
    }
}

    static void viewTotal() {

        double total = 0;

        for (Expense expense : expenses) {
            total = total + expense.amount;
        }

        System.out.println("\n--- Total Expense ---");
        System.out.println("Total: Rs." + total);
    }

    static void deleteExpense() {

        System.out.println("\n--- Delete Expense ---");

        if (expenses.isEmpty()) {
            System.out.println("No expenses to delete.");
            return;
        }

        viewExpenses();

        System.out.print("Enter expense number to delete: ");
        int number = sc.nextInt();

        if (number >= 1 && number <= expenses.size()) {

            Expense removedExpense = expenses.remove(number - 1);

            System.out.println(
                removedExpense.name +
                " deleted successfully!"
            );

        } else {
            System.out.println("Invalid expense number.");
        }
    }
}

