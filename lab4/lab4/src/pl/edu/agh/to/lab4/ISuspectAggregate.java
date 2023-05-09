package pl.edu.agh.to.lab4;

import java.util.Iterator;

public interface ISuspectAggregate {
    Iterator<Suspect> iterator(ISearchStrategy filter);
}
