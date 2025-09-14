import java.time.LocalDateTime;
import java.util.*;

// ------------------ Immutable Product ------------------
final class Product {
    private final String productId;
    private final String name;
    private final String category;
    private final String manufacturer;
    private final double basePrice;
    private final double weight;
    private final String[] features;
    private final Map<String, String> specifications;

    private Product(String productId, String name, String category, String manufacturer,
                    double basePrice, double weight, String[] features, Map<String, String> specifications) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.manufacturer = manufacturer;
        this.basePrice = basePrice;
        this.weight = weight;
        this.features = Arrays.copyOf(features, features.length);
        this.specifications = Map.copyOf(specifications);
    }

    public static Product createElectronics(String productId, String name, String manufacturer,
                                            double basePrice, double weight,
                                            String[] features, Map<String, String> specifications) {
        return new Product(productId, name, "Electronics", manufacturer, basePrice, weight, features, specifications);
    }

    public static Product createClothing(String productId, String name, String manufacturer,
                                         double basePrice, double weight,
                                         String[] features, Map<String, String> specifications) {
        return new Product(productId, name, "Clothing", manufacturer, basePrice, weight, features, specifications);
    }

    public static Product createBooks(String productId, String name, String manufacturer,
                                      double basePrice, double weight,
                                      String[] features, Map<String, String> specifications) {
        return new Product(productId, name, "Books", manufacturer, basePrice, weight, features, specifications);
    }

    public String getProductId() { return productId; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public String getManufacturer() { return manufacturer; }
    public double getBasePrice() { return basePrice; }
    public double getWeight() { return weight; }
    public String[] getFeatures() { return Arrays.copyOf(features, features.length); }
    public Map<String, String> getSpecifications() { return Map.copyOf(specifications); }

    public final double calculateTax(String region) {
        return switch (region.toLowerCase()) {
            case "us" -> basePrice * 0.07;
            case "eu" -> basePrice * 0.2;
            case "asia" -> basePrice * 0.1;
            default -> basePrice * 0.05;
        };
    }

    @Override
    public String toString() {
        return "Product{" + name + " - " + category + "}";
    }
}

// ------------------ Customer ------------------
class Customer {
    private final String customerId;
    private final String email;
    private String name;
    private String phoneNumber;
    private String preferredLanguage;
    private final String accountCreationDate;

    public Customer(String customerId, String email, String name, String phoneNumber, String preferredLanguage) {
        this.customerId = customerId;
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.preferredLanguage = preferredLanguage;
        this.accountCreationDate = LocalDateTime.now().toString();
    }

    public Customer(String email) {
        this("GUEST" + System.currentTimeMillis(), email, "Guest", "", "EN");
    }

    public String getCustomerId() { return customerId; }
    public String getEmail() { return email; }
    public String getName() { return name; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getPreferredLanguage() { return preferredLanguage; }
    public String getAccountCreationDate() { return accountCreationDate; }

    void setName(String name) { this.name = name; }
    void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    void setPreferredLanguage(String lang) { this.preferredLanguage = lang; }

    String getCreditRating() {
        return "GOOD";
    }

    public String getPublicProfile() {
        return "Customer: " + name + ", Language: " + preferredLanguage;
    }

    @Override
    public String toString() {
        return "Customer{id='" + customerId + "', email='" + email + "'}";
    }
}

// ------------------ ShoppingCart ------------------
class ShoppingCart {
    private final String cartId;
    private final String customerId;
    private final List<Object> items = new ArrayList<>();
    private double totalAmount = 0.0;
    private int itemCount = 0;

    public ShoppingCart(String customerId) {
        this.cartId = "CART" + System.currentTimeMillis();
        this.customerId = customerId;
    }

    public boolean addItem(Object product, int quantity) {
        if (!(product instanceof Product) || quantity <= 0) return false;
        Product p = (Product) product;
        for (int i = 0; i < quantity; i++) {
            items.add(p);
        }
        totalAmount += p.getBasePrice() * quantity;
        itemCount += quantity;
        return true;
    }

    private double calculateDiscount() {
        return totalAmount > 100 ? totalAmount * 0.1 : 0.0;
    }

    String getCartSummary() {
        return "Cart Total: $" + totalAmount + ", Items: " + itemCount + ", Discount: $" + calculateDiscount();
    }

    @Override
    public String toString() {
        return "ShoppingCart{" + cartId + ", totalAmount=" + totalAmount + "}";
    }
}

// ------------------ Order ------------------
class Order {
    private final String orderId;
    private final LocalDateTime orderTime;

    public Order() {
        this.orderId = "ORD" + UUID.randomUUID();
        this.orderTime = LocalDateTime.now();
    }

    public String getOrderId() { return orderId; }
    public LocalDateTime getOrderTime() { return orderTime; }

    @Override
    public String toString() {
        return "Order{id='" + orderId + "', time=" + orderTime + "}";
    }
}

// ------------------ PaymentProcessor ------------------
class PaymentProcessor {
    private final String processorId;
    private final String securityKey;

    public PaymentProcessor(String processorId, String securityKey) {
        this.processorId = processorId;
        this.securityKey = securityKey;
    }

    public boolean processPayment(Order order, double amount) {
        // Dummy logic
        return amount > 0;
    }

    @Override
    public String toString() {
        return "PaymentProcessor{id='" + processorId + "'}";
    }
}

// ------------------ ShippingCalculator ------------------
class ShippingCalculator {
    private final Map<String, Double> shippingRates;

    public ShippingCalculator(Map<String, Double> shippingRates) {
        this.shippingRates = Map.copyOf(shippingRates);
    }

    public double calculateShipping(String region, double weight) {
        return shippingRates.getOrDefault(region.toLowerCase(), 5.0) * weight;
    }

    @Override
    public String toString() {
        return "ShippingCalculator{regions=" + shippingRates.keySet() + "}";
    }
}

// ------------------ ECommerceSystem ------------------
final class ECommerceSystem {
    private static final Map<String, Object> productCatalog = new HashMap<>();

    public static boolean processOrder(Object order, Object customer) {
        if (!(order instanceof Order) || !(customer instanceof Customer)) return false;
        System.out.println("Processing order " + ((Order) order).getOrderId() + " for customer " + ((Customer) customer).getCustomerId());
        return true;
    }

    public static void addProductToCatalog(String productId, Object product) {
        productCatalog.put(productId, product);
    }

    public static Object getProduct(String productId) {
        return productCatalog.get(productId);
    }

    public static void showCatalog() {
        System.out.println("Catalog: " + productCatalog.keySet());
    }
}

// ------------------ Demo Main ------------------
public class ECommerceSystemApp {
    public static void main(String[] args) {
        // Create Products
        Map<String, String> specs = Map.of("Processor", "Intel i7", "RAM", "16GB");
        Product laptop = Product.createElectronics("P001", "Laptop", "TechCorp", 1200, 2.5,
                new String[]{"Touchscreen", "Backlit Keyboard"}, specs);

        Product tshirt = Product.createClothing("P002", "T-Shirt", "CottonBrand", 25, 0.3,
                new String[]{"100% Cotton", "Slim Fit"}, Map.of("Size", "L"));

        ECommerceSystem.addProductToCatalog(laptop.getProductId(), laptop);
        ECommerceSystem.addProductToCatalog(tshirt.getProductId(), tshirt);
        ECommerceSystem.showCatalog();

        // Create Customer and Cart
        Customer customer = new Customer("C001", "john@example.com", "John Doe", "1234567890", "EN");
        ShoppingCart cart = new ShoppingCart(customer.getCustomerId());
        cart.addItem(laptop, 1);
        cart.addItem(tshirt, 2);
        System.out.println(cart.getCartSummary());

        // Place Order
        Order order = new Order();
        PaymentProcessor processor = new PaymentProcessor("PAY123", "SECURE_KEY");
        boolean
