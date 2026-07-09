package se.lexicon;

public class ParkingSpot {
    private boolean isFree;
    private final int spotId;

    public ParkingSpot( int number) {
        this.isFree = true;
        this.spotId = number;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public int getSpotId() {
        return spotId;
    }

    public void free() {
        setFree(true);
    }

    public void occupy() {
        setFree(false);
    }
}
