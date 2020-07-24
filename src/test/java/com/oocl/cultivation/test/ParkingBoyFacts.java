package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.ParkingTicket;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ParkingBoyFacts {
    @Test
    void write_your_first_test() {

    }

    @Test
    void should_return_1_ticket_when_parking_boy_parking_car_given_parking_boy_1_car() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car("P1");

        //when
        ParkingTicket parkingTicket = parkingBoy.parkingBoyParkingCar(car);

        //then
        assertNotNull(parkingTicket);
    }

    @Test
    void should_return_1_car_when_parking_boy_fetch_car_given_parking_boy_1_ticket_parking_lot() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingTicket parkingTicket = new ParkingTicket("P1");
        ParkingLot parkingLot = new ParkingLot();

        //when
        Car car = parkingBoy.parkingBoyFetchCar(parkingTicket, parkingLot);

        //then
        assertNotNull(car);
    }

    @Test
    void should_return_2_tickets_when_parking_boy_parking_car_given_parking_boy_2_cars() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        List<Car> cars = new ArrayList<>();
        Car carP1 = new Car("P1");
        cars.add(carP1);
        Car carP2 = new Car("P2");
        cars.add(carP2);

        //when
        List<ParkingTicket> parkingTickets = parkingBoy.parkingBoyParkingCars(cars);

        //then
        assertEquals(2, parkingTickets.size());
    }
}
