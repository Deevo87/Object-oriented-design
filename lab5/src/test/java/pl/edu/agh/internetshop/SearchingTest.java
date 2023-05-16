package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;
import pl.edu.agh.internetshop.filters.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchingTest {
    private CompositeSearchStrategy searchStrategies;
    private Discount DISCOUNT = new Discount(BigDecimal.valueOf(30));
    private Product product1 = new Product("Pizza", BigDecimal.valueOf(50), DISCOUNT);
    private Product product2 = new Product("Burger", BigDecimal.valueOf(50), DISCOUNT);
    private Product product3 = new Product("Piwo", BigDecimal.valueOf(50), DISCOUNT);
    private Product product4 = new Product("Curry", BigDecimal.valueOf(50), DISCOUNT);
    private HashMap<String, Product> products1 = new HashMap<>();
    private HashMap<String, Product> products2 = new HashMap<>();
    private Discount zero = new Discount(BigDecimal.valueOf(0));
    private Order order1;
    private Order order2;
    private OrderLog log1;
    private OrderLog log2;



    private OrderLog createOrderLog(Order order) {
        return new OrderLog(order);
    }

    private OrderHistory createSampleHistory() {
        this.products1.put(product1.getName(), product1);
        this.products1.put(product2.getName(), product2);
        this.products2.put(product3.getName(), product3);
        this.products2.put(product4.getName(), product4);

        this.order1 = new Order(products1, zero);
        this.order2 = new Order(products2, zero);

        List<OrderLog> logs = new ArrayList<>();
        this.log1 = new OrderLog(order1);
        this.log2 = new OrderLog(order2);
        logs.add(this.log1);
        logs.add(this.log2);

        return new OrderHistory(logs);
    }

    private CompositeSearchStrategy createPriceFilter(Double price) {
        return new CompositeSearchStrategy(List.of(new OrderPriceSearchStrategy(price)));
    }

    private CompositeSearchStrategy createNameFilter(String productName) {
        return new CompositeSearchStrategy(List.of(new ProductNameSearchStrategy(productName)));
    }

    private CompositeSearchStrategy createCustomerNameFilter(String customerName) {
        return new CompositeSearchStrategy(List.of(new CustomeNameSearchStrategy(customerName)));
    }

    @Test
    public void checkIfPriceStrategyWorks() {
        // given
        CompositeSearchStrategy strategy = createPriceFilter(70.00);
        OrderHistory history = createSampleHistory();
        ArrayList<OrderLog> expectedResult = new ArrayList<>();

        // when
        expectedResult.add(this.log1);
        expectedResult.add(this.log2);

        // then
        assertEquals(expectedResult, history.applyAllFilters(strategy));
    }

    @Test
    public void checkIfProductNameStrategyWorks() {
        // given
        CompositeSearchStrategy strategy = createNameFilter("Pizza");
        OrderHistory history = createSampleHistory();
        ArrayList<OrderLog> expectedResult = new ArrayList<>();

        // when
        expectedResult.add(log1);

        // then
        assertEquals(expectedResult, history.applyAllFilters(strategy));
    }


}
