package pl.edu.agh.internetshop.filters;

public class ProductNameSearchStrategy implements ISearchStrategy {
    private String productName;

    public ProductNameSearchStrategy(String productName) {
        this.productName = productName;
    }
    @Override
    public boolean filter(OrderLog log) {
        return log.getOrder().getProducts().entrySet().stream().anyMatch(
                toFilter -> {
                    System.out.println(toFilter.getKey());
                    return toFilter.getKey().equals(productName);
                }
        );
    }
}
