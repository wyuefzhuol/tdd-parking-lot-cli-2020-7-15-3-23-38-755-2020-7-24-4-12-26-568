package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<Car> carList;
    private int position;

    public ParkingLot() {
        this.carList = new ArrayList<>();
        this.position = 10;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public Car fetchCarInParkingLot(ParkingTicket parkingTicket) {
        String carId = parkingTicket.getCarId();
        for (Car car : this.carList) {
            if (car.getCarId().equals(carId)) {
                parkingTicket.hasBeenUsed();
                for (int i = 0; i < carList.size(); i++) {
                    if (carList.get(i).equals(carId)) {
                        carList.remove(i);
                    }
                }
                this.position++;
                return car;
            }
        }
        return new Car("the ticket is wrong");
    }

    public void parkingCar(Car car) {
        this.carList.add(car);
        this.position--;
    }

    public int getPosition() {
        return position;
    }
}
