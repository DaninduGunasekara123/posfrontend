package entity;

import java.util.Objects;

public class OrderDetail_PK {
    private int customerName;
    private int orderId;

    public OrderDetail_PK() {
    }

    public OrderDetail_PK(int customerName, int orderId) {
        this.customerName = customerName;
        this.orderId = orderId;
    }

    public void setCustomerName(int customerName) {
        this.customerName = customerName;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerName() {
        return customerName;
    }

    public int getOrderId() {
        return orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetail_PK that = (OrderDetail_PK) o;
        return customerName == that.customerName &&
                orderId == that.orderId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerName, orderId);
    }
}
