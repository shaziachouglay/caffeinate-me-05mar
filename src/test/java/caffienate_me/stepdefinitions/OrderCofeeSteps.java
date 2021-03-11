package caffienate_me.stepdefinitions;

import caffienate_me.CoffeeShop;
import caffienate_me.Customer;
import caffienate_me.Order;
import caffienate_me.OrderStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;


public class OrderCofeeSteps {
    Customer cathy = Customer.named("Cathy");
    CoffeeShop coffeeShop = new CoffeeShop();
    Order order;
    @Given("Cathy is {int} meters from the coffee shop")
    public void cathyIsMetersFromTheCoffeeShop(int distanceInMetres) {
        cathy.setDistanceFromShop(distanceInMetres);
    }

    @When("^Cathy orders a (.*)")
    public void cathyOrdersA(String orderedProduct) {
        this.order = Order.of(1,orderedProduct).forCustomer(cathy);
        cathy.placesAnOrderOf(order).at(coffeeShop);
    }

    @Then("Barry should recieve the order")
    public void barryShouldRecieveTheOrder() {
        assertThat(coffeeShop.getPendingOrders()).contains(order);
    }

    @And("^Barry should know that the order is (.*)")
    public void barryShouldKnowThatTheOrderIsUrgent(OrderStatus expectedStatus) {
        Order cathysOrder = coffeeShop.getOrderFor(cathy)
                .orElseThrow(() -> new AssertionError("No Order found!"));
        assertThat(cathysOrder.getStatus()).isEqualTo(expectedStatus);
    }
}
