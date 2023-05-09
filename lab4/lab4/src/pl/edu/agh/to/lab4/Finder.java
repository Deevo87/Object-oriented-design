package pl.edu.agh.to.lab4;

import java.util.ArrayList;
import java.util.Iterator;

public class Finder {
    private final CompositeAggregate compositeAggregates;

    public Finder(CompositeAggregate allPeople) {
        this.compositeAggregates = allPeople;
    }

    public void displayAllLookedForSuspects(CompositeSearchStrategy filter) {
        Iterator<Suspect> compositeIterator = compositeAggregates.iterator(filter);
        ArrayList<Suspect> suspects = new ArrayList<>();

        while (compositeIterator.hasNext() && suspects.size() < 10) {
            Suspect suspect = compositeIterator.next();
            suspects.add(suspect);
        }
        int t = suspects.size();
        System.out.println("Znalazlem " + t + " pasujacych podejrzanych!");

        for (Suspect suspect : suspects) {
            System.out.println(suspect.display() + " " + suspect.getBirthDate());
        }
    }
}
