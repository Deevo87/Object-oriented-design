package pl.edu.agh.to.lab4;

public class AgeSearchStrategy implements ISearchStrategy{

    private int age;

    public AgeSearchStrategy(int age) {
        this.age = age;
    }

    @Override
    public boolean filter(Suspect suspect) {
        return suspect.getAge() >= this.age;
    }
}
