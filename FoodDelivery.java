// File: FoodDelivery.java
public class FoodDelivery {

    // 1. Basic Delivery (only distance)
    public void calculateDelivery(double distance) {
        double cost = distance * 10; // ₹10 per km
        System.out.println("Basic Delivery: Distance = " + distance + " km");
        System.out.println("Total Delivery Cost = ₹" + cost);
        System.out.println("---------------------------------");
    }

    // 2. Premium Delivery (distance + priority fee)
    public void calculateDelivery(double distance, double priorityFee) {
        double cost = distance * 10 + priorityFee;
        System.out.println("Premium Delivery: Distance = " + distance + " km, Priority Fee = ₹" + priorityFee);
        System.out.println("Total Delivery Cost = ₹" + cost);
        System.out.println("---------------------------------");
    }

    // 3. Group Delivery (distance + number of orders discount)
    public void calculateDelivery(double distance, int numberOfOrders) {
        double baseCost = distance * 10;
        double discount = numberOfOrders * 5; // ₹5 discount per extra order
        double cost = baseCost - discount;
        if (cost < 0) cost = 0; // no negative cost
        System.out.println("Group Delivery: Distance = " + distance + " km, Orders = " + numberOfOrders);
        System.out.println("Discount Applied = ₹" + discount);
        System.out.println("Total Delivery Cost = ₹" + cost);
        System.out.println("---------------------------------");
    }

    // 4. Festival Special (distance + discount% + free delivery if above threshold)
    public void calculateDelivery(double distance, double discountPercent, double freeLimit) {
        double baseCost = distance * 10;
        if (baseCost >= freeLimit) {
            System.out.println("Festival Special: Distance = " + distance + " km");
            System.out.println("Delivery is FREE (above ₹" + freeLimit + ")");
            System.out.println("---------------------------------");
            return;
        }
        double discount = (baseCost * discountPercent) / 100;
        double cost = baseCost - discount;
        System.out.println("Festival Special: Distance = " + distance + " km, Discount = " + discountPercent + "%");
        System.out.println("Discount Applied = ₹" + discount);
        System.out.println("Total Delivery Cost = ₹" + cost);
        System.out.println("---------------------------------");
    }

    // Main Method to test all overloads
    public static void main(String[] args) {
        FoodDelivery fd = new FoodDelivery();

        fd.calculateDelivery(5);                      // Basic
        fd.calculateDelivery(5, 50);                  // Premium
        fd.calculateDelivery(10, 3);                  // Group
        fd.calculateDelivery(15, 20.0, 200);          // Festival
    }
}
