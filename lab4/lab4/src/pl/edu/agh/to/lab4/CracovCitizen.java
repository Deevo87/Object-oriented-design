package pl.edu.agh.to.lab4;

import java.time.LocalDate;

public class CracovCitizen extends Suspect {

    public CracovCitizen(String firstname, String lastname, int age) {
        super(firstname, lastname, age);
    }

    @Override
    public boolean canBeAccused() {
        return getAge() >= 18;
    }

    @Override
    public LocalDate getBirthDate() {
        return null; //there is no PESEL so i can't extract birthDate
    }

}
