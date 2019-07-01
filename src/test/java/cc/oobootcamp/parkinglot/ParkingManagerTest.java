package cc.oobootcamp.parkinglot;

import org.junit.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ParkingManagerTest {

    @Test
    public void should_get_a_ticket_and_can_get_car_by_parking_boy_when_park_car_given_the_parking_boy_have_available_parking_lot() {
        ParkingBoy parkingBoy = new GraduateParkingBoy(Collections.singletonList(new ParkingLot(1)));
        ParkingManager parkingManager = new ParkingManager(Collections.singletonList(new ParkingLot(1)),
                Collections.singletonList(parkingBoy));
        Car car = new Car();

        Ticket ticket = parkingManager.park(car);

        assertNotNull(ticket);
        assertNotNull(parkingBoy.pick(ticket));
    }

    @Test
    public void should_get_a_ticket_and_can_not_get_car_by_parking_boy_when_park_car_given_the_parking_boy_without_available_parking_lot() {
        ParkingBoy parkingBoy = new GraduateParkingBoy(Collections.singletonList(new ParkingLot(1)));
        ParkingManager parkingManager = new ParkingManager(Collections.singletonList(new ParkingLot(1)),
                Collections.singletonList(parkingBoy));
        parkingBoy.park(new Car());
        Car car = new Car();

        Ticket ticket = parkingManager.park(car);

        assertNotNull(ticket);
        assertNull(parkingBoy.pick(ticket));
    }
}
