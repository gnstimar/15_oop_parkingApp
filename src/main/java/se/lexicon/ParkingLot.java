package se.lexicon;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ParkingLot {
    private int amountOfSpots;
    private ParkingSpot[] parkingSpots;
    private List<Reservation> activeReservations = new ArrayList<>();

    public ParkingLot(int amountOfSpots) {
        this.amountOfSpots = amountOfSpots;
        this.parkingSpots = new ParkingSpot[amountOfSpots];
        for (int i = 0; i < amountOfSpots; i++) {
            ParkingSpot spot = new ParkingSpot(i + 1);
            parkingSpots[i] = spot;
        }
    }

    public ParkingSpot[] getParkingSpots() {
        return parkingSpots;
    }

    public Reservation getReservationById(UUID uuid) {
        for (Reservation reservation : activeReservations) {
            if (reservation.getUuid().equals(uuid)) {
                return reservation;
            }
        }
        return null;
    }

    public Reservation getReservationByPerson(Person person) {
        for (Reservation reservation : activeReservations) {
            if (reservation.getPerson().equals(person)) {
                return reservation;
            }
        }
        return null;
    }

    public List<Reservation> getActiveReservations() {
        return activeReservations;
    }

    public void printFreeSpots() {
        int counter = 0;
        for (int i = 0; i < parkingSpots.length; i++) {
            if (parkingSpots[i].isFree()) {
                counter++;
            }
        }
        if (counter <= 1) {
            System.out.printf("There is %1s/%1s free spot.%n", counter, amountOfSpots);
        } else {
            System.out.printf("There are %1s/%1s free spots.%n", counter, amountOfSpots);
        }
    }

    public void takeSpot(Person person, long durationMin) {
        if (activeReservations.size() == amountOfSpots) {
            System.out.printf("Sorry %10s, there is no free parking spot at the moment.%n", person.getName());
        } else {
            for (ParkingSpot spot : parkingSpots) {
                if (spot.isFree()) {
                    Reservation newReservation = new Reservation(spot.getSpotId(), person, LocalDateTime.now(), durationMin);
                    activeReservations.add(newReservation);
                    spot.occupy();
                    System.out.printf("Spot %d is taken by %10s.%n", spot.getSpotId(), person.getName());
                    break;
                }
            }
        }
    }

    public void releaseSpot(Person person) {
        Reservation reservationToRelease = getReservationByPerson(person);
        for (ParkingSpot spot : parkingSpots) {
            if (spot.getSpotId() == reservationToRelease.getSpotId()) {
                System.out.printf("Spot %d is released:%n", spot.getSpotId());
                printTicket(reservationToRelease.getUuid());
                activeReservations.remove(reservationToRelease);
                spot.free();
                break;
            }
        }
    }

    public void printTicket(UUID reservationId) {
        Reservation reservation = getReservationById(reservationId);
        if (reservation == null) {
            IO.println("ERROR: not valid reservation id.");
        } else {
            System.out.printf("  Person: %-15s | Spot: %-2d | Parking interval: %-3s min | Parking fee: %3.2f kr.%n",
                    reservation.getPerson().getName(),
                    reservation.getSpotId(),
                    reservation.getDurationMin(),
                    reservation.calculateFee());
        }
    }
}
