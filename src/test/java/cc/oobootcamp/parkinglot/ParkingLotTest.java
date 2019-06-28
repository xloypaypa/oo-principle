package cc.oobootcamp.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {

    @Test
    void should_return_a_ticket_when_park_car_given_the_parking_lot_with_available_space() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();

        Ticket ticket = parkingLot.park(car);

        assertNotNull(ticket);
    }

    @Test
    void should_save_the_car_into_parking_lot_when_park_car_given_the_parking_lot_with_available_space() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();

        parkingLot.park(car);

        assertTrue(parkingLot.getAllCars().contains(car));
    }
}
