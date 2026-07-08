package se.lexicon;

public enum PersonType {
    STUDENT (10),
    STAFF (13),
    VISITOR (17);

    private final double feePerHour;

    PersonType(double feePerHour) {
        this.feePerHour = feePerHour;
    }

    public double feePerHour() {
        return feePerHour;
    }
}
