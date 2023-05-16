package pl.edu.agh.internetshop.filters;

import java.util.List;

public class CompositeSearchStrategy implements ISearchStrategy {
    private final List<ISearchStrategy> filters;

    public CompositeSearchStrategy(List<ISearchStrategy> filters) {
        this.filters = filters;
    }

    @Override
    public boolean filter(OrderLog log) {
        return filters.stream().allMatch(
                toFilter -> toFilter.filter(log)
        );
    }

    public void addStrategy(ISearchStrategy strategy) {
        this.filters.add(strategy);
    }
}
