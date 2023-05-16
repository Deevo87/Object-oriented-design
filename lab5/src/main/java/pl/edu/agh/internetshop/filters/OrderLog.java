package pl.edu.agh.internetshop.filters;

import pl.edu.agh.internetshop.Order;

import java.util.Date;

public class OrderLog {
    private Date date;
    private Order order;

    public OrderLog(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }
}
