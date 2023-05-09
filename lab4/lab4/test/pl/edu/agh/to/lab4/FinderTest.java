package pl.edu.agh.to.lab4;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FinderTest {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private PrintStream originalOut;

    private PersonDataProvider personDataProvider;

    private PrisonersDatabase prisonersDataProvider;

    private CompositeAggregate compositeAggregates;

    private Finder suspectFinder;

    public FinderTest() {
        prisonersDataProvider = new PrisonersDatabase();
        personDataProvider = new PersonDataProvider();
        compositeAggregates = new CompositeAggregate(List.of(personDataProvider, prisonersDataProvider));
        suspectFinder = new Finder(compositeAggregates);
    }

    @Test
    public void testDisplayingNotJailedPrisoner() {
        prisonersDataProvider.addPrisoner("Wiezeienie stanowe", new Prisoner("Jan", "Kowalski", 31,"802104543357", 2000, 1));
        suspectFinder.displayAllLookedForSuspects(new CompositeSearchStrategy(List.of(new NameSearchStrategy("Janusz"))));
        assertContentIsDisplayed("Jan Kowalski");
    }

    @Test
    public void testDisplayingSuspectedPerson() {
        personDataProvider.getAllCracovCitizens().add(new CracovCitizen("Jan", "Kowalski", 20));
        suspectFinder.displayAllLookedForSuspects(new CompositeSearchStrategy(List.of(new NameSearchStrategy("Janusz"))));
        assertContentIsDisplayed("Jan Kowalski");
    }

    @Test
    public void testNotDisplayingTooYoungPerson() {
        personDataProvider.getAllCracovCitizens().add(new CracovCitizen("Jan", "Kowalski", 15));
        suspectFinder.displayAllLookedForSuspects(new CompositeSearchStrategy(List.of(new NameSearchStrategy("Janusz"))));
        assertContentIsNotDisplayed("Jan Kowalski");
    }

    @Test
    public void testNotDisplayingJailedPrisoner() {
        personDataProvider.getAllCracovCitizens().add(new CracovCitizen("Jan", "Kowalski", 20));
        prisonersDataProvider.addPrisoner("Wiezeienie stanowe",
                new Prisoner("Jan", "Kowalski2", 29,"802104543357", 2000, 20));
        suspectFinder.displayAllLookedForSuspects(new CompositeSearchStrategy(List.of(new NameSearchStrategy("Janusz"))));
        assertContentIsNotDisplayed("Jan Kowalski2");
    }

    private void assertContentIsDisplayed(String expectedContent) {
        assertTrue("Application did not contain expected content: " + outContent.toString(), outContent.toString()
                .contains(expectedContent));
    }

    private void assertContentIsNotDisplayed(String expectedContent) {
        assertFalse("Application did contain expected content although it should not: " + outContent.toString(), outContent.toString()
                .contains(expectedContent));
    }

    @Before
    public void redirectSystemOut() {
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void resetSystemOut() {
        System.setOut(originalOut);
    }


}
