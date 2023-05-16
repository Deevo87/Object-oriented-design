package pl.edu.agh.internetshop.filters;

public class CustomeNameSearchStrategy implements ISearchStrategy {
    private String customerName;

    public CustomeNameSearchStrategy(String name) {
        this.customerName = name;
    }

    @Override
    public boolean filter(OrderLog log) {
        return log.getOrder().getShipment().getSenderAddress().getName().equals(customerName);
    }
}
