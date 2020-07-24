package com.oocl.cultivation;

public class ParkingBoy {
    public ParkingTicket parkingBoyParkingCar(Car car) {
        ParkingTicket parkingTicket = new ParkingTicket("P1");
        return parkingTicket;
    }

    public Car parkingBoyFetchCar(ParkingTicket parkingTicket, ParkingLot parkingLot) {
        Car car = parkingLot.fetchCarInParkingLot(parkingTicket);
        return car;
    }
}
