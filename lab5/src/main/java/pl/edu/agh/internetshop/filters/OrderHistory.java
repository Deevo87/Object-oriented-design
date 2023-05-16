package pl.edu.agh.internetshop.filters;

import java.util.ArrayList;
import java.util.List;

public class OrderHistory {
    private List<OrderLog> history;

    public OrderHistory(List<OrderLog> history) {
        this.history = history;
    }

    public OrderHistory() {
        this.history = new ArrayList<>();
    }

    public void addToHistory(OrderLog orderLog) {
        this.history.add(orderLog);
    }

    public List<OrderLog> getHistory() {
        return this.history;
    }

    public ArrayList<OrderLog> applyAllFilters(CompositeSearchStrategy filters) {
        ArrayList<OrderLog> output = new ArrayList<>();

        for (OrderLog log : this.history) {
            System.out.println(log.getOrder().getProducts());
            if (filters.filter(log)) {
                output.add(log);
                System.out.println(log.getOrder());
            }
        }
        return output;
    }
}
