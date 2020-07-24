package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {
    public ParkingTicket parkingBoyParkingCar(Car car, ParkingLot parkingLot) {
        ParkingTicket parkingTicket = new ParkingTicket("P1");
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
