package actividadInterfaces.Interfaces;

public interface Salary {

    double TARGET_COMPLEMENT = 105.15;
    double TUTORING_COMPLEMENT = 0.05; //5%

    default double getSalary() {
        return 0;
    }
}
