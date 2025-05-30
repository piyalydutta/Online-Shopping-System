import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create products
        try (Scanner scanner = new Scanner(System.in)) {
            // Create products
            List<Product> productList = new ArrayList<>();
            productList.add(new Product("Laptop", 999.99, 10));
            productList.add(new Product("Smartphone", 499.99, 20));
            productList.add(new Product("Headphones", 59.99, 15));
            
            System.out.println("Welcome to Online Shopping!");
            
            // Register user
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();
            System.out.print("Enter email: ");
            String email = scanner.nextLine();
            System.out.print("Create password: ");
            String password = scanner.nextLine();
            
            Account account = new Account(email, password);
            User user = new User(name, account);
            
            System.out.println("Registration successful. Hello, " + user.getUsername() + "!");
            
            // Start ordering
            Order order = new Order();
            
            while (true) {
                System.out.println("\nAvailable Products:");
                for (int i = 0; i < productList.size(); i++) {
                    Product p = productList.get(i);
                    System.out.println((i + 1) + ". " + p.getName() + " - $" + p.getPrice() + " [" + p.getStock() + " in stock]");
                }
                
                System.out.print("Enter product number to buy (0 to checkout): ");
                int choice = scanner.nextInt();
                if (choice == 0) {
                    break;
                }
                
                if (choice < 1 || choice > productList.size()) {
                    System.out.println("Invalid product number.");
                    continue;
                }
                
                Product selected = productList.get(choice - 1);
                System.out.print("Enter quantity: ");
                int quantity = scanner.nextInt();
                
                if (selected.isInStock(quantity)) {
                    order.addProduct(selected, quantity);
                    System.out.println("Added " + quantity + " x " + selected.getName() + " to your order.");
                } else {
                    System.out.println("Sorry, not enough stock.");
                }
            }
            
            // Checkout
            order.displayOrderSummary();
            System.out.println("Thank you for shopping with us!");
        }
    }
}
