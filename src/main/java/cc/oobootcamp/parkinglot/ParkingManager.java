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
        for (ParkingLot parkingLot : this.parkingLots) {
            Ticket ticket = parkingLot.park(car);
            if (ticket != null) {
                return ticket;
            }
        }
        throw new NoSpaceException();
    }

    @Override
    public Car pick(Ticket ticket) {
        //todo: 前人智障要不要重构？讲道理其实应该是要根据异常来
        Car car = super.pick(ticket);
        if (car != null) {
            return car;
        }
        for (ParkingBoy parkingBoy : this.parkingBoys) {
            car = parkingBoy.pick(ticket);
            if (car != null) {
                return car;
            }
        }
        return null;
    }
}
