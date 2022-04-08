package actividadHerencia.Objects;

import actividadHerencia.Utilities.DateFormat;

import java.time.LocalDate;
import java.time.Period;

public abstract class People {

    private String name;
    private String dni;
    protected DateFormat birthday;

    /**
     * Constructor for initialize our attributes.
     * @param name Name of the person.
     * @param dni DNI of the person.
     * @param birthday Birthday of the person.
     */
    public People(String name, String dni, DateFormat birthday) {
        this.name = name;
        this.dni = dni;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    private DateFormat getPeopleBirthday() {
        return birthday;
    }

    public void setPeopleBirthday(DateFormat birthday) {
        this.birthday = birthday;
    }

    /**
     * Calculates the years between the user birthday and now.
     * @return Age of the user.
     */
    public int Age() {
        LocalDate now = LocalDate.now();

        Period period = Period.between(birthday.getBirthday(),now);
        return period.getYears();
    }
}
