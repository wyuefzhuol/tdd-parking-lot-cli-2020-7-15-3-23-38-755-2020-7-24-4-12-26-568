package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {
    public ParkingTicket parkingBoyParkingCar(Car car, ParkingLot parkingLot) {
        ParkingTicket parkingTicket = new ParkingTicket(car.getCarId());
        if (parkingLot.getPosition() <= 0) {
            return new ParkingTicket("parking lot has no position");
        }
        parkingLot.parkingCar(car);
        return parkingTicket;
    }

    public Car parkingBoyFetchCar(ParkingTicket parkingTicket, ParkingLot parkingLot) {
        if (parkingTicket.getBeenUsed()) {
            return new Car("the ticket has been used");
        }
        Car car = parkingLot.fetchCarInParkingLot(parkingTicket);
        return car;
    }

    public List<ParkingTicket> parkingBoyParkingCars(List<Car> cars, ParkingLot parkingLot) {
        List<ParkingTicket> parkingTickets = new ArrayList<>();
        for (Car car : cars) {
            parkingTickets.add(parkingBoyParkingCar(car, parkingLot));
        }
        return parkingTickets;
    }
}
