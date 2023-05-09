package pl.edu.agh.to.lab4;


import java.util.List;

public class Application {

    public static void main(String[] args) {
        PersonDataProvider personDataProvider = new PersonDataProvider();
        PrisonersDatabase prisonersDataProvider = new PrisonersDatabase();
        Finder suspects = new Finder(new CompositeAggregate(List.of(personDataProvider, prisonersDataProvider)));
        suspects.displayAllLookedForSuspects(new CompositeSearchStrategy(List.of(new NameSearchStrategy("Janusz"))));
    }
}
