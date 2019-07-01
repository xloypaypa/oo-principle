package cc.oobootcamp.parkinglot;

import java.util.List;

public class ParkingBoy {

    private final List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) {
        for (ParkingLot parkingLot : this.parkingLots) {
            Ticket ticket = parkingLot.park(car);
            if (ticket != null) {
                return ticket;
            }
        }
        return null;
    }
}
