package cc.oobootcamp.parkinglot;

import java.util.List;

public abstract class ParkingBoy {
    final List<ParkingLot> parkingLots;

    ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public abstract Ticket park(Car car);

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
