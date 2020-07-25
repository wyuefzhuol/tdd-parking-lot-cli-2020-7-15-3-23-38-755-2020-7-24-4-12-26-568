package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {
    private List<ParkingLot> parkingLots;

    public ParkingBoy(int parkingLotsCount) {
        parkingLots = new ArrayList<>();
        for (int parkingLotsIndex = 0; parkingLotsIndex < parkingLotsCount; parkingLotsIndex++) {
            parkingLots.add(new ParkingLot());
        }
    }

    public ParkingTicket parkingCar(Car car) {
        ParkingTicket parkingTicket = new ParkingTicket(car.getCarId());
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getPosition() > 0) {
                parkingLot.parkingCarToParkingLot(car);
                break;
            }
        }
        return parkingTicket;
    }

    public Car fetchCar(ParkingTicket parkingTicket) {
        Car car = new Car("the ticket is wrong");
        for (ParkingLot parkingLot : parkingLots) {
            car = parkingLot.fetchCarFromParkingLot(parkingTicket);
            if (!car.getCarId().equals("the ticket is wrong")) {
                return car;
            }
        }
        return car;
    }

    public List<ParkingTicket> parkingBoyParkingCars(List<Car> cars) {
        List<ParkingTicket> parkingTickets = new ArrayList<>();
        for (Car car : cars) {
            parkingTickets.add(parkingCar(car));
        }
        return parkingTickets;
    }

    public String checkTicket(ParkingTicket parkingTicket) {
        if (parkingTicket == null) {
            return "please provide your parking ticket";
        }
        List<Car> carList = parkingLots.get(0).getCarList();
        for (Car car : carList) {
            if (car.getCarId().equals(parkingTicket.getCarId()) && !parkingTicket.getBeenUsed()) {
                return "the ticket is valid";
            }
        }
        return "unrecognized parking ticket";
    }

    public String checkParkingLotPosition() {
        for (ParkingLot parkingLot : this.parkingLots) {
            if (parkingLot.getPosition() > 0) {
                return "enough";
            }
        }
        return "not enough position";
    }

    public List<ParkingLot> checkParkingOrder() {
        return this.parkingLots;
    }
}
