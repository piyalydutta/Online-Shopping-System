import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<Product> products;
    private final List<Integer> quantities;

    public Order() {
        this.products = new ArrayList<>();
        this.quantities = new ArrayList<>();
    }

    public void addProduct(Product product, int quantity) {
        products.add(product);
        quantities.add(quantity);
        product.reduceStock(quantity);
    }

    public double calculateTotal() {
        double total = 0;
        for (int i = 0; i < products.size(); i++) {
            total += products.get(i).getPrice() * quantities.get(i);
        }
        return total;
    }

    public void displayOrderSummary() {
        System.out.println("\nOrder Summary:");
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i).getName() + " x" + quantities.get(i) + " = $" +
                               (products.get(i).getPrice() * quantities.get(i)));
        }
        System.out.println("Total: $" + calculateTotal());
    }

      
    }

