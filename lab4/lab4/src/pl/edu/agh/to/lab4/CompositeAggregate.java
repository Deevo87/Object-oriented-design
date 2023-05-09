package pl.edu.agh.to.lab4;

import java.util.*;

public class CompositeAggregate implements ISuspectAggregate {

    private List<ISuspectAggregate> suspectAggregates = new ArrayList<>();

    public CompositeAggregate(List<ISuspectAggregate> peopleCollection) {
        this.suspectAggregates = peopleCollection;
    }

    @Override
    public Iterator<Suspect> iterator(ISearchStrategy filter) {
        Collection<Suspect> suspects = new ArrayList<>();
        suspectAggregates.forEach(aggregate -> {
            Iterator<Suspect> suspectIterator = aggregate.iterator(filter);
            while (suspectIterator.hasNext()) {
                suspects.add(suspectIterator.next());
            }
        });
        return suspects.iterator();
    }
}
