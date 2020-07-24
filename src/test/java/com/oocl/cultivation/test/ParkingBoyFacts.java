package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingTicket;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ParkingBoyFacts {
    @Test
    void write_your_first_test() {

    }

    @Test
    void should_return_1_ticket_when_parking_boy_parking_car_given_parking_boy_1_car() {
        //given
        Car car = new Car("P1");
        ParkingBoy parkingBoy = new ParkingBoy();

        //when
        ParkingTicket parkingTicket = parkingBoy.parkingBoyParkingCar(car);

        //then
        assertNotNull(parkingTicket);
    }
}
