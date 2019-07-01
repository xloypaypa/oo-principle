package cc.oobootcamp.parkinglot;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ParkingBoyTest {

    @Test
    public void should_return_a_ticket_and_can_get_car_from_frist_parking_lot_when_park_car_give_two_parking_lot_with_enough_space() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(firstParkingLot, secondParkingLot));

        Ticket ticket = parkingBoy.park(new Car());

        assertNotNull(ticket);
        assertNotNull(firstParkingLot.pickUpCarBy(ticket));
        assertNull(secondParkingLot.pickUpCarBy(ticket));
    }

    @Test
    public void should_return_a_ticket_and_can_get_car_from_second_parking_lot_when_park_car_give_two_parking_lot_and_only_second_have_enough_space() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        firstParkingLot.park(new Car());
        ParkingLot secondParkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(firstParkingLot, secondParkingLot));

        Ticket ticket = parkingBoy.park(new Car());

        assertNotNull(ticket);
        assertNull(firstParkingLot.pickUpCarBy(ticket));
        assertNotNull(secondParkingLot.pickUpCarBy(ticket));
    }
}
