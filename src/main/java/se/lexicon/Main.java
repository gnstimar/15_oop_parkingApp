package se.lexicon;

public class Main {
    static void main() {
        ParkingLot lexicon = new ParkingLot(20);

        lexicon.printFreeSpots();

        Person teacher = new Person("Mr. Smith", "1234567", "JVM-123", PersonType.STAFF);
        Person student = new Person("Otto", "987654", "MMA-123", PersonType.STUDENT);
        Person visitor = new Person("Viktor the visitor", "65656565", "VVV-675", PersonType.VISITOR);
        Person visitor2 = new Person("Giorgio the visitor", "62222565", "VVV-111", PersonType.VISITOR);

        lexicon.takeSpot(teacher, (8*60));
        lexicon.takeSpot(student, (6*60));
        lexicon.takeSpot(visitor, 120);

        lexicon.takeSpot(visitor2, 100);

        lexicon.releaseSpot(visitor);
        lexicon.takeSpot(visitor2, 10);

    }
}
