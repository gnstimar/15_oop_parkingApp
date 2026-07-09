package se.lexicon;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Reservation {
    private final UUID uuid;
    private int spotId;
    private Person person;
    private LocalDateTime arrivalTime;
    private long durationMin;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public Reservation(int spotId, Person person, LocalDateTime arrivalTime, long durationMin) {
        this.uuid = java.util.UUID.randomUUID();
        this.spotId = spotId;
        this.person = person;
        this.arrivalTime = arrivalTime;
        this.durationMin = durationMin;
    }

    public Person getPerson() {
        return person;
    }

    public long getDurationMin() {
        return durationMin;
    }

    public UUID getUuid() {
        return uuid;
    }

    public int getSpotId() {
        return spotId;
    }

    public String calculateEndTime() {
        return arrivalTime.plusMinutes(durationMin).format(formatter);
    }

    public double calculateFee() {
        return person.getPersonType().feePerHour() / 60 * durationMin;
    }
}
