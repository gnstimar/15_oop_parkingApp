package se.lexicon;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private int amountOfSpots;
    private ParkingSpot[] parkingSpots;
    private List<Reservation> activeReservations = new ArrayList<>();

    public ParkingLot(int amountOfSpots) {
        this.amountOfSpots = amountOfSpots;
        this.parkingSpots = new ParkingSpot[amountOfSpots];
        for (int i = 0; i < amountOfSpots; i++) {
            ParkingSpot spot = new ParkingSpot(i+1);
            parkingSpots[i]=spot;
        }
    }

    public ParkingSpot[] getParkingSpots() {
        return parkingSpots;
    }
}
