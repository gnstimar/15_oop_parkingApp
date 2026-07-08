package se.lexicon;

import java.time.LocalDateTime;

public class Reservation {
    private final String UUID;
    private ParkingSpot parkingSpot;
    private Person person;
    private LocalDateTime arrivalTime;
    private long parkingInterval;

    public Reservation(ParkingSpot parkingSpot, Person person, LocalDateTime arrivalTime, long parkingInterval) {
        this.UUID = java.util.UUID.randomUUID().toString();
        this.parkingSpot = parkingSpot;
        this.person = person;
        this.arrivalTime = arrivalTime;
        this.parkingInterval = parkingInterval;
    }

    public LocalDateTime calculateEndTime() {
        return null;
    }
}
