package SourceCode.model.classes;

public abstract class Vehicles {

    private String licensePlate;
    private String chassisNumber;
    private String brand;
    private Integer power;
    private String ownerDNI;
    private String registrationDate;

    protected Vehicles(
            String licensePlate, String ownerDNI, String chassisNumber, String brand, Integer power,
            String registrationDate) {

        this.licensePlate = licensePlate;
        this.chassisNumber = chassisNumber;
        this.brand = brand;
        this.power = power;
        this.ownerDNI = ownerDNI;
        this.registrationDate = registrationDate;
    }

    public abstract int itv();

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public String getOwnerDNI() {
        return ownerDNI;
    }

    public void setOwnerDNI(String ownerDNI) {
        this.ownerDNI = ownerDNI;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }
}
