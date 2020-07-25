package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {
    private ParkingLot parkingLot;
    private List<ParkingLot> parkingLots;

    public ParkingBoy() {
        this.parkingLot = new ParkingLot();
    }

    public ParkingBoy(int parkingLotsCount) {
        parkingLots = new ArrayList<>();
        for (int parkingLotsIndex = 0; parkingLotsIndex < parkingLotsCount; parkingLotsIndex++) {
            parkingLots.add(new ParkingLot());
        }
    }

    public ParkingTicket parkingBoyParkingCar(Car car) {
        ParkingTicket parkingTicket = new ParkingTicket(car.getCarId());
        parkingLot.parkingCar(car);
        return parkingTicket;
    }

    public Car parkingBoyFetchCar(ParkingTicket parkingTicket) {
        Car car = parkingLot.fetchCarInParkingLot(parkingTicket);
        return car;
    }

    public List<ParkingTicket> parkingBoyParkingCars(List<Car> cars) {
        List<ParkingTicket> parkingTickets = new ArrayList<>();
        for (Car car : cars) {
            parkingTickets.add(parkingBoyParkingCar(car));
        }
        return parkingTickets;
    }

    public String checkTicket(ParkingTicket parkingTicket) {
        if (parkingTicket == null) {
            return "please provide your parking ticket";
        }
        List<Car> carList = parkingLot.getCarList();
        for (Car car : carList) {
            if (car.getCarId().equals(parkingTicket.getCarId()) && !parkingTicket.getBeenUsed()) {
                return "the ticket is valid";
            }
        }
        return "unrecognized parking ticket";
    }

    public String checkParkingLotPosition() {
        if (this.parkingLot.getPosition() <= 0) {
            return "not enough position";
        }
        return "enough";
    }

    public List<ParkingLot> checkParkingOrder() {
        return this.parkingLots;
    }
}
