package actividadInterfaces.Objects;

import actividadInterfaces.Utilities.DateFormat;

public class Students extends People {

    private String cial;
    private String course;

    /**
     * Constructor for initialize our attributes.
     * @param name Name of the Student.
     * @param dni DNI of the Student.
     * @param birthday Birthday of the Student.
     * @param cial CIAL of the Student.
     * @param course Course of the Student.
     */
    public Students(String name, String dni, DateFormat birthday, String cial, String course) {
        super(name, dni, birthday);

        this.cial = cial;
        this.course = course;
    }

    public String getCial() {
        return cial;
    }

    public void setCial(String cial) {
        this.cial = cial;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String IdentityAccess() {
        return this.cial;
    }
}
