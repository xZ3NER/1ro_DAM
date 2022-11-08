package SourceCode.model.classes;

public class Bus extends Vehicles {

    private Integer numberOfPlaces;
    private String serviceType;

    public Bus(String licensePlate, String ownerDNI, String chassisNumber, String brand, Integer power,
               String registrationDate, Integer numberOfPlaces, String serviceType) {

        super(licensePlate, ownerDNI, chassisNumber, brand, power, registrationDate);

        this.numberOfPlaces = numberOfPlaces;
        this.serviceType = serviceType;
    }

    public Integer getNumberOfPlaces() {
        return numberOfPlaces;
    }

    public void setNumberOfPlaces(Integer numberOfPlaces) {
        this.numberOfPlaces = numberOfPlaces;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    @Override
    public int itv() {
        return 2;
    }
}
