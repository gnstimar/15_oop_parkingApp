package se.lexicon;

public class ParkingSpot {
    private boolean isFree;
    private final int number;

    public ParkingSpot( int number) {
        this.isFree = true;
        this.number = number;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public int getNumber() {
        return number;
    }

    public void free() {
        setFree(true);
    }

    public void occupy() {
        setFree(false);
    }
}
