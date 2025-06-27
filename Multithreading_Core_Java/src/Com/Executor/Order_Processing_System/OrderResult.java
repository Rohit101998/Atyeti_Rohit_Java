package Com.Executor.Order_Processing_System;

public class OrderResult {
    int orderId;
    String status;

    public OrderResult(int orderId, String status) {
        this.orderId = orderId;
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderResult{" +
                "orderId=" + orderId +
                ", status='" + status + '\'' +
                '}';
    }
}
