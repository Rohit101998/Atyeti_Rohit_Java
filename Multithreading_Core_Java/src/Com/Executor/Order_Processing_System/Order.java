package Com.Executor.Order_Processing_System;

public class Order {
    int orderId;
    String customerName;
    String product;
    int quantity;

    public Order(int orderId, String customerName, String product, int quantity) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.product = product;
        this.quantity = quantity;
    }


}
