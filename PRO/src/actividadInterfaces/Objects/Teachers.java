package actividadInterfaces.Objects;

import actividadInterfaces.Interfaces.Salary;
import actividadInterfaces.Utilities.DateFormat;

public class Teachers extends People implements Salary {

    private String nrp;
    private int speciality;
    private String destinationCenter;
    private double salary;

    /**
     * Constructor for initialize our attributes.
     * @param name Name of the Teacher.
     * @param dni DNI of the Teacher.
     * @param birthday Birthday of the Teacher.
     * @param nrp NRP of the Teacher.
     * @param speciality Speciality of the Teacher.
     * @param center Center of the Teacher.
     * @param salary Salary of the Teacher.
     */
    public Teachers(
            String name, String dni, DateFormat birthday, String nrp, int speciality, String center, double salary
    ) {
        super(name,dni,birthday);

        this.nrp = nrp;
        this.speciality = speciality;
        this.destinationCenter = center;
        this.salary = salary;
    }

    public String getNrp() {
        return nrp;
    }

    public void setNrp(String nrp) {
        this.nrp = nrp;
    }

    public int getSpeciality() {
        return speciality;
    }

    public void setSpeciality(int speciality) {
        this.speciality = speciality;
    }

    public String getDestinationCenter() {
        return destinationCenter;
    }

    public void setDestinationCenter(String destinationCenter) {
        this.destinationCenter = destinationCenter;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return salary+TARGET_COMPLEMENT;
    }

    @Override
    public String IdentityAccess() {
        return this.nrp;
    }

}
