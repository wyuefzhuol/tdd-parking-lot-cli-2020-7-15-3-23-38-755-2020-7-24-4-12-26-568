package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.ParkingTicket;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyFacts {
    @Test
    void write_your_first_test() {

    }

    @Test
    void should_return_1_ticket_when_parking_boy_parking_car_given_parking_boy_1_car() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(1);
        Car car = new Car("P1");

        //when
        ParkingTicket parkingTicket = parkingBoy.parkingCar(car);

        //then
        assertNotNull(parkingTicket);
    }

    @Test
    void should_return_1_car_when_parking_boy_fetch_car_given_parking_boy_1_ticket_parking_lot() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(1);
        Car carInParkingLot = new Car("P1");
        ParkingTicket parkingTicket = parkingBoy.parkingCar(carInParkingLot);

        //when
        Car car = parkingBoy.fetchCar(parkingTicket);

        //then
        assertNotNull(car);
    }

    @Test
    void should_return_2_tickets_when_parking_boy_parking_car_given_parking_boy_2_cars() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(1);
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

    @Test
    void should_return_P2_car_when_parking_boy_fetch_car_given_parking_boy_P2_ticket_parking_lot() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(1);
        Car carInParkingLot = new Car("P2");
        ParkingTicket parkingTicket = parkingBoy.parkingCar(carInParkingLot);

        //when
        Car correctCar = parkingBoy.fetchCar(parkingTicket);

        //then
        assertEquals(carInParkingLot.getCarId(), correctCar.getCarId());
    }

    @Test
    void should_return_the_ticket_is_wrong_when_parking_boy_fetch_car_given_parking_boy_wrong_ticket() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(1);
        ParkingTicket parkingTicket = new ParkingTicket("P3");
        ParkingLot parkingLot = new ParkingLot();
        Car carInParkingLot = new Car("P1");
        parkingLot.parkingCarToParkingLot(carInParkingLot);

        //when
        Car car = parkingBoy.fetchCar(parkingTicket);

        //then
        assertEquals("the ticket is wrong", car.getCarId());
    }

    @Test
    void should_return_the_ticket_has_been_used_when_parking_boy_fetch_car_given_parking_boy_used_ticket() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(1);
        Car carInParkingLot = new Car("P3");
        ParkingTicket usedTicket = parkingBoy.parkingCar(carInParkingLot);
        parkingBoy.fetchCar(usedTicket);

        //when
        String responseMessage = parkingBoy.checkTicket(usedTicket);

        //then
        assertEquals("unrecognized parking ticket", responseMessage);
    }

    @Test
    void should_return_parking_lot_has_no_position_when_parking_boy_parking_car_given_parking_boy_parking_lot_car() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(1);
        for (int i = 0; i < 10; i++) {
            parkingBoy.parkingCar(new Car("P"+i));
        }

        //when
        String parkingLotMessage = parkingBoy.checkParkingLotPosition();

        //then
        assertEquals("not enough position", parkingLotMessage);
    }

    @Test
    void should_return_unrecognized_parking_ticket_when_check_ticket_given_parking_boy_wrong_ticket() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(1);
        ParkingTicket wrongTicket = new ParkingTicket("P3");
        Car carInParkingLot = new Car("P1");
        parkingBoy.parkingCar(carInParkingLot);

        //when
        String responseMessage = parkingBoy.checkTicket(wrongTicket);

        //then
        assertEquals("unrecognized parking ticket", responseMessage);
    }

    @Test
    void should_return_unrecognized_parking_ticket_when_check_ticket_given_parking_boy_used_ticket() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(1);
        Car carInParkingLot = new Car("P3");
        ParkingTicket usedTicket = parkingBoy.parkingCar(carInParkingLot);
        parkingBoy.fetchCar(usedTicket);

        //when
        String responseMessage = parkingBoy.checkTicket(usedTicket);

        //then
        assertEquals("unrecognized parking ticket", responseMessage);
    }

    @Test
    void should_return_please_provide_your_parking_ticket_when_check_ticket_given_parking_boy() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(1);

        //when
        String responseMessage = parkingBoy.checkTicket(null);

        //then
        assertEquals("please provide your parking ticket", responseMessage);
    }

    @Test
    void should_return_not_enough_position_when_check_parking_lot_position_given_parking_boy() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(1);
        for (int i = 0; i < 10; i++) {
            parkingBoy.parkingCar(new Car("P"+i));
        }

        //when
        String parkingLotMessage = parkingBoy.checkParkingLotPosition();

        //then
        assertEquals("not enough position", parkingLotMessage);
    }

    @Test
    void return_1_full_parking_lot_1_empty_parking_lot_when_check_parking_order_parking_boy_who_has_2_parking_lots_10_cars() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(2);
        for (int i = 0; i < 10; i++) {
            parkingBoy.parkingCar(new Car("P"+i));
        }

        //when
        List<ParkingLot> parkingLots = parkingBoy.checkParkingOrder();

        //then
        assertEquals(0, parkingLots.get(0).getPosition());
        assertEquals(10, parkingLots.get(1).getPosition());
    }

    @Test
    void return_1_full_parking_lot_1_parking_lot_has_2_cars_when_check_parking_order_parking_boy_who_has_2_parking_lots_12_cars() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(2);
        for (int i = 0; i < 12; i++) {
            parkingBoy.parkingCar(new Car("P"+i));
        }

        //when
        List<ParkingLot> parkingLots = parkingBoy.checkParkingOrder();

        //then
        assertEquals(0, parkingLots.get(0).getPosition());
        assertEquals(8, parkingLots.get(1).getPosition());
    }
}
