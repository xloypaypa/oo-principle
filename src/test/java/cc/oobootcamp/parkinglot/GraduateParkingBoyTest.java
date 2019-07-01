package cc.oobootcamp.parkinglot;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class GraduateParkingBoyTest {

    @Test
    public void should_return_a_ticket_and_can_get_car_from_first_parking_lot_when_park_car_give_two_parking_lot_with_enough_space() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(Arrays.asList(firstParkingLot, secondParkingLot));

        Ticket ticket = graduateParkingBoy.park(new Car());

        assertNotNull(ticket);
        assertNotNull(firstParkingLot.pickUpCarBy(ticket));
        assertNull(secondParkingLot.pickUpCarBy(ticket));
    }

    @Test
    public void should_return_a_ticket_and_can_get_car_from_second_parking_lot_when_park_car_give_two_parking_lot_and_only_second_have_enough_space() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        firstParkingLot.park(new Car());
        ParkingLot secondParkingLot = new ParkingLot(1);
        GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(Arrays.asList(firstParkingLot, secondParkingLot));

        Ticket ticket = graduateParkingBoy.park(new Car());

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
        GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(Arrays.asList(firstParkingLot, secondParkingLot));

        graduateParkingBoy.park(new Car());

        fail();
    }

    @Test
    public void should_get_a_car_when_pick_car_give_the_ticket_is_match_the_car_parked_by_parking_boy() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(Arrays.asList(firstParkingLot, secondParkingLot));
        Car carParked = new Car();
        Ticket ticket = graduateParkingBoy.park(carParked);

        Car carPicked = graduateParkingBoy.pick(ticket);

        assertSame(carParked, carPicked);
    }

    @Test
    public void should_not_get_a_car_when_pick_car_give_the_ticket_is_not_match_any_car_parked_by_parking_boy() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(Arrays.asList(firstParkingLot, secondParkingLot));

        Car carPicked = graduateParkingBoy.pick(new Ticket());

        assertNull(carPicked);
    }
}
