package cc.oobootcamp.parkinglot;

import java.util.List;

public class ParkingManager extends ParkingBoy {

    private List<ParkingBoy> parkingBoys;

    public ParkingManager(List<ParkingLot> parkingLots, List<ParkingBoy> parkingBoys) {
        super(parkingLots);
        this.parkingBoys = parkingBoys;
    }

    @Override
    public Ticket park(Car car) {
        for (ParkingBoy parkingBoy : this.parkingBoys) {
            try {
                return parkingBoy.park(car);
            } catch (NoSpaceException ignored) {
            }
        }
        return null;
    }
}
