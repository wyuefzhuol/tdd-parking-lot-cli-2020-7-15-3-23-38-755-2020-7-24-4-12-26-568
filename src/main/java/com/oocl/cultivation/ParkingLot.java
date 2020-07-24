package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<Car> carList;

    public ParkingLot() {
        this.carList = new ArrayList<>();
    }

    public Car fetchCarInParkingLot(ParkingTicket parkingTicket) {
        String carId = parkingTicket.getCarId();
        for (Car car: this.carList) {
            if (car.getCarId().equals(carId)) {
                parkingTicket.hasBeenUsed();
                return car;
            }
        }
        return new Car("the ticket is wrong");
    }

    public void parkingCar(Car car) {
        this.carList.add(car);
    }
}
