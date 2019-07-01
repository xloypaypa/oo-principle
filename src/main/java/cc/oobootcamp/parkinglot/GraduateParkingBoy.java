package cc.oobootcamp.parkinglot;

import java.util.List;

public class GraduateParkingBoy {

    private final List<ParkingLot> parkingLots;

    public GraduateParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) {
        for (ParkingLot parkingLot : this.parkingLots) {
            Ticket ticket = parkingLot.park(car);
            if (ticket != null) {
                return ticket;
            }
        }
        throw new NoSpaceException();
    }

    public Car pick(Ticket ticket) {
        for (ParkingLot parkingLot : parkingLots) {
            Car car = parkingLot.pickUpCarBy(ticket);
            if (car != null) {
                return car;
            }
        }
        return null;
    }
}
