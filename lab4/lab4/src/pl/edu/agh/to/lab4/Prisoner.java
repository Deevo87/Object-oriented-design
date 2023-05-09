package pl.edu.agh.to.lab4;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

// zrób getBirthDate (z peselu wyciągnij)
public class Prisoner extends Suspect{
    private final int judgementYear;

    private final int senteceDuration;

    private final String pesel;

    public Prisoner(String firstName, String lastName, int age, String pesel, int judgementYear, int sentenceDuration) {
       super(firstName, lastName, age);

        this.pesel = pesel;
        this.judgementYear = judgementYear;
        this.senteceDuration = sentenceDuration;
    }

    public String getPesel() {
        return pesel;
    }

    public boolean ifPossibleSuspect() {
        return judgementYear + senteceDuration >= getCurrentYear();
    }

    public int getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    public boolean isJailedNow() {
        Date currentDate = new Date();
        int currentYear = currentDate.getYear();
        return (this.judgementYear + this.senteceDuration) > currentYear;
    }

    @Override
    public LocalDate getBirthDate() {
        int month = Integer.parseInt(this.pesel.substring(2, 4));
        int year = 0;
        if (month > 12) {
            year = 2000;
            month -= 20;
        } else {
            year = 1900;
        }
        year += Integer.parseInt(pesel.substring(0, 2));
        int day = Integer.parseInt(pesel.substring(4, 6));
        LocalDate birthDate = LocalDate.of(year, month, day);
        return birthDate;
    }

    @Override
    public boolean canBeAccused() {
        return !ifPossibleSuspect();
    }

}
