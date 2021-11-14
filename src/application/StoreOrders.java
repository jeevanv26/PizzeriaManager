package application;

public class StoreOrders {

    private ArrayList<Order> orders;

    public StoreOrders() {
        orders = new ArrayList<>;
    }

    public void cancelOrder(Order order) {
        orders.remove(order);
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public String toString() {

    }

    public void export() {

    }
}
