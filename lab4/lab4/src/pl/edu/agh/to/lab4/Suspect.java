package pl.edu.agh.to.lab4;

//możemy tu zastosować zasadę polimorfizmu dla klas prisoner i CracovCitizen

import java.time.LocalDate;

public abstract class Suspect {

    private String firstName;

    private String lastName;

    private int age;

    public Suspect(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

    public String display() {
        return firstName + " " + lastName;
    }

    public int getAge() {
        return age;
    }

    public abstract boolean canBeAccused();

    public abstract LocalDate getBirthDate();

}
