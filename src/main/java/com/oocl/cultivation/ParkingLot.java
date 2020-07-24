package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<Car> carList;

    public ParkingLot() {
        this.carList = new ArrayList<>();
    }

    public Car fetchCarInParkingLot(ParkingTicket parkingTicket) {
        return new Car("P1");
    }

    public void parkingCar(Car car) {
        this.carList.add(car);
    }
}
