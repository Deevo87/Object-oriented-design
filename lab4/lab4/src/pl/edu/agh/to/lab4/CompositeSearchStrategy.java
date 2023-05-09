package pl.edu.agh.to.lab4;

import java.util.List;

public class CompositeSearchStrategy implements ISearchStrategy{

    private final List<ISearchStrategy> filters;

    public CompositeSearchStrategy(List<ISearchStrategy> filters) {
        this.filters = filters;
    }

    @Override
    public boolean filter(Suspect suspect) {
        return filters.stream().allMatch(
                toFilter -> toFilter.filter(suspect)
        );
    }
}
