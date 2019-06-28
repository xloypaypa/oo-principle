package cc.oobootcamp.parkinglot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private final int capacity;
    private final Map<Ticket, Car> cars;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.cars = new HashMap<>();
    }

    public Ticket park(Car car) {
        if (this.cars.size() < this.capacity) {
            Ticket ticket = new Ticket();
            this.cars.put(ticket, car);
            return ticket;
        } else {
            return null;
        }
    }

    public Collection<Car> getAllCars() {
        return this.cars.values();
    }

    public Car pickUpCarBy(Ticket ticket) {
        return this.cars.get(ticket);
    }
}
