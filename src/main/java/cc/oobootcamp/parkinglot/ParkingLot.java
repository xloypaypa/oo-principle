package cc.oobootcamp.parkinglot;

public class ParkingLot {

    private final int capacity;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }


    public Ticket park(Car car) {
        return new Ticket();
    }
}
