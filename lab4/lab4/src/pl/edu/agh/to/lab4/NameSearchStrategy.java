package pl.edu.agh.to.lab4;

public class NameSearchStrategy implements ISearchStrategy{

    private String name;

    public NameSearchStrategy(String name) {
        this.name = name;
    }

    @Override
    public boolean filter(Suspect suspect) {
        return suspect.getFirstName().equals(this.name);
    }
}
