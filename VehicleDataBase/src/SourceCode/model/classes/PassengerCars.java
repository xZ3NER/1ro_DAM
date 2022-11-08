package SourceCode.model.classes;

public class PassengerCars extends Vehicles {

    private Integer numberOfDoors;
    private Integer numberOfPlaces;
    private String possibility;

    public PassengerCars(
            String licensePlate, String ownerDNI, String chassisNumber, String brand, Integer power,
            String registrationDate, Integer numberOfPlaces, Integer numberOfDoors, String possibility) {

        super(licensePlate, ownerDNI, chassisNumber, brand, power, registrationDate);

        this.numberOfPlaces = numberOfPlaces;
        this.numberOfDoors = numberOfDoors;
        this.possibility = possibility;
    }

    public Integer getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(Integer numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public Integer getNumberOfPlaces() {
        return numberOfPlaces;
    }

    public void setNumberOfPlaces(Integer numberOfPlaces) {
        this.numberOfPlaces = numberOfPlaces;
    }

    public String getPossibility() {
        return possibility;
    }

    public void setPossibility(String possibility) {
        this.possibility = possibility;
    }

    @Override
    public int itv() {
        return 5;
    }
}
