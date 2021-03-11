package caffienate_me;



import java.util.Objects;

public class Customer {
    public Customer(String name, int distanceInMetres) {
        this.name = name;
        this.distanceInMetres = distanceInMetres;
    }

    public Customer(String name) {
        this.name = name;
    }

    public static Customer named(String name) {
        return new Customer(name);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", distanceInMetres=" + distanceInMetres +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return distanceInMetres == customer.distanceInMetres &&
                Objects.equals(name, customer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, distanceInMetres);
    }

    private String name;
    private int distanceInMetres;

    public void setDistanceFromShop(int distanceInMetres) {
        this.distanceInMetres = distanceInMetres;
    }

    public CustomerBuilder placesAnOrderOf(Order order) {
        return new CustomerBuilder(order,distanceInMetres);
    }

    public static class CustomerBuilder {
        private final Order order;
        private final int distanceInMetres;

        public CustomerBuilder(Order order, int distanceInMetres) {

            this.order = order;
            this.distanceInMetres = distanceInMetres;
        }

        public void at(CoffeeShop coffeeShop) {
            coffeeShop.placeOrder(order,distanceInMetres);
        }
    }
}
