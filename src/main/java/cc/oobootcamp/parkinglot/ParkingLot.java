package cc.oobootcamp.parkinglot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ParkingLot {

    private final int capacity;
    private final List<Car> cars;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.cars = new ArrayList<>();
    }

    public Ticket park(Car car) {
        this.cars.add(car);
        return new Ticket();
    }

    public Collection<Object> getAllCars() {
        return new ArrayList<>(this.cars);
    }
}
