package cc.oobootcamp.parkinglot;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class SmartGraduateParkingBoyTest {

    @Test
    public void should_return_a_ticket_and_can_get_car_from_second_parking_lot_when_second_parking_lot_have_more_space_than_first() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(firstParkingLot, secondParkingLot));

        Ticket ticket = smartParkingBoy.park(new Car());

        assertNotNull(ticket);
        assertNull(firstParkingLot.pickUpCarBy(ticket));
        assertNotNull(secondParkingLot.pickUpCarBy(ticket));
    }

    @Test
    public void should_return_a_ticket_and_can_get_car_from_second_parking_lot_when_park_car_give_two_parking_lot_and_only_second_have_enough_space() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        firstParkingLot.park(new Car());
        ParkingLot secondParkingLot = new ParkingLot(1);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(firstParkingLot, secondParkingLot));

        Ticket ticket = smartParkingBoy.park(new Car());

        assertNotNull(ticket);
        assertNull(firstParkingLot.pickUpCarBy(ticket));
        assertNotNull(secondParkingLot.pickUpCarBy(ticket));
    }

    @Test(expected = NoSpaceException.class)
    public void should_get_no_space_exception_when_park_car_given_both_two_parking_lot_not_have_enough_space() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        firstParkingLot.park(new Car());
        ParkingLot secondParkingLot = new ParkingLot(1);
        secondParkingLot.park(new Car());
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(firstParkingLot, secondParkingLot));

        smartParkingBoy.park(new Car());

        fail();
    }

    @Test
    public void should_get_a_car_when_pick_car_give_the_ticket_is_match_the_car_parked_by_parking_boy() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(firstParkingLot, secondParkingLot));
        Car carParked = new Car();
        Ticket ticket = smartParkingBoy.park(carParked);

        Car carPicked = smartParkingBoy.pick(ticket);

        assertSame(carParked, carPicked);
    }

    @Test
    public void should_not_get_a_car_when_pick_car_give_the_ticket_is_not_match_any_car_parked_by_parking_boy() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(firstParkingLot, secondParkingLot));

        Car carPicked = smartParkingBoy.pick(new Ticket());

        assertNull(carPicked);
    }
}
