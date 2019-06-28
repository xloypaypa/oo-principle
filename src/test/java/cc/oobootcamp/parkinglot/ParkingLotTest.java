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

    @Test
    void should_not_return_a_ticket_when_park_car_given_the_parking_lot_with_available_space() {
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park(new Car());
        Car car = new Car();

        Ticket ticket = parkingLot.park(car);

        assertNull(ticket);
    }

    @Test
    void should_not_save_the_car_into_parking_lot_when_park_car_given_the_parking_lot_with_available_space() {
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park(new Car());
        Car car = new Car();

        parkingLot.park(car);

        assertFalse(parkingLot.getAllCars().contains(car));
    }

    @Test
    void should_get_the_car_which_match_ticket_when_pick_up_car_given_the_ticket_is_valid() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);

        Car theCarPickedUp = parkingLot.pickUpCarBy(ticket);

        assertEquals(car, theCarPickedUp);
    }
}
