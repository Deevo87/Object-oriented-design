package pl.edu.agh.internetshop.filters;

import java.math.BigDecimal;

public class OrderPriceSearchStrategy implements ISearchStrategy {
    private BigDecimal price;

    public OrderPriceSearchStrategy(Double price) {
        this.price = BigDecimal.valueOf(price);
    }
    @Override
    public boolean filter(OrderLog log) {
        return log.getOrder().getPrice().equals(price);
    }
}
