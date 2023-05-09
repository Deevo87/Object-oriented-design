package pl.edu.agh.to.lab4;

import java.util.*;

public class FlatIterator implements Iterator<Suspect> {
    private final Iterator<? extends Suspect> prisonerIterator;
    Suspect suspect;
    private ISearchStrategy filter;

    public FlatIterator(Collection<? extends Suspect> prisonersCollection, ISearchStrategy filter) {
        prisonerIterator = prisonersCollection.iterator();
        this.filter = filter;
    }

    @Override
    public boolean hasNext() {
        while (prisonerIterator.hasNext()) {
            Suspect susCandidate = prisonerIterator.next();
            if (susCandidate.canBeAccused() && filter.filter(susCandidate)) {
                suspect = susCandidate;
                return true;
            }
        }
        return false;
    }

    @Override
    public Suspect next() {
        if (suspect != null) {
            return suspect;
        }
        throw new NoSuchElementException("There is no next suspect!\n");
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

}
