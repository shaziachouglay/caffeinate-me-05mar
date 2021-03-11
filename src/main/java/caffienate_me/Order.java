package caffienate_me;

import java.util.Objects;

public class Order {
    private final int quantity;

    public int getQuantity() {
        return quantity;
    }

    public String getOrderedProduct() {
        return orderedProduct;
    }

    public Customer getCustomer() {
        return customer;
    }

    public OrderStatus getStatus() {
        return status;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return quantity == order.quantity &&
                Objects.equals(orderedProduct, order.orderedProduct) &&
                Objects.equals(customer, order.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity, orderedProduct, customer);
    }

    private final String orderedProduct;
    private final Customer customer;
    private final OrderStatus status;

    public Order(int quantity, String orderedProduct, Customer customer, OrderStatus status) {
        this.quantity = quantity;
        this.orderedProduct = orderedProduct;
        this.customer = customer;
        this.status = status;
    }

    public Order(int quantity, String orderedProduct, Customer customer) {
        this(quantity,orderedProduct,customer,OrderStatus.Normal);
    }

    public static OrderBuilder of(int quantity, String orderedProduct) {
        return new OrderBuilder(quantity,orderedProduct);
    }

    public Order withStatus(OrderStatus status) {
        return new Order(quantity,orderedProduct,customer,status);
    }

    public static class OrderBuilder {
        private final int quantity;
        private final String orderedProduct;

        public OrderBuilder(int quantity, String orderedProduct) {
            this.quantity = quantity;
            this.orderedProduct = orderedProduct;
        }

        public Order forCustomer(Customer customer) {
            return new Order(quantity,orderedProduct,customer);
        }
    }
}
