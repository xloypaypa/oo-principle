package cc.oobootcamp.parkinglot;

import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy extends ParkingBoy {

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public Ticket park(Car car) {
        ParkingLot parkingLot = this.parkingLots.stream()
                .filter(ParkingLot::haveAvailableSpace)
                .max(Comparator.comparingInt(ParkingLot::getAvailableSpace))
                .orElseThrow(NoSpaceException::new);
        return parkingLot.park(car);
    }
}
