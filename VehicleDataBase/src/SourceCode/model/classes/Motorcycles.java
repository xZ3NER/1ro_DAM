package SourceCode.model.classes;

public class Motorcycles extends Vehicles {

    public Motorcycles(
            String licensePlate, String ownerDNI, String chassisNumber, String brand, Integer power,
            String registrationDate) {

        super(licensePlate, ownerDNI, chassisNumber, brand, power, registrationDate);
    }

    @Override
    public int itv() {
        return 5;
    }
}
