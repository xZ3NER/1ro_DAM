package actividadInterfaces.Objects;

import actividadInterfaces.Utilities.DateFormat;

public class Tutors extends Teachers{

    private String group;

    /**
     * Constructor for initialize our attributes.
     *
     * @param name       Name of the Tutor.
     * @param dni        DNI of the Tutor.
     * @param birthday   Birthday of the Tutor.
     * @param nrp        NRP of the Tutor.
     * @param speciality Speciality of the Tutor.
     * @param center     Center of the Tutor.
     * @param salary     Salary of the Tutor.
     */
    public Tutors(
            String name, String dni, DateFormat birthday, String nrp, int speciality, String center, double salary, String group
    ) {
        super(name, dni, birthday, nrp, speciality, center, salary);

        this.group = group;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public double getSalary() {
        return super.getSalary()*TUTORING_COMPLEMENT+super.getSalary();
    }
}
