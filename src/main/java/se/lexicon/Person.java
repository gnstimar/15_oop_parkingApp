package se.lexicon;

public class Person {
    private String name;
    private String phoneNumber;
    private String vehicleRegistration;
    private PersonType personType;

    public Person(String name, String phoneNumber, String vehicleRegistration, PersonType personType) {
        setName(name);
        setPhoneNumber(phoneNumber);
        setVehicleRegistration(vehicleRegistration);
        setPersonType(personType);
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isBlank()) {
            throw new IllegalArgumentException("Phone number cannot be empty.");
        }
        this.phoneNumber = phoneNumber;
    }

    public void setVehicleRegistration(String vehicleRegistration) {
        if (vehicleRegistration == null || vehicleRegistration.isBlank()) {
            throw new IllegalArgumentException("Vehicle registration cannot be empty.");
        }
        this.vehicleRegistration = vehicleRegistration;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }
}
