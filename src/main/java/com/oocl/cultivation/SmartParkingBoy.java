package com.oocl.cultivation;

public class SmartParkingBoy extends ParkingBoy {
    public SmartParkingBoy(int parkingLotsCount) {
        super(parkingLotsCount);
    }

    @Override
    public ParkingTicket parkingCar(Car car) {
        ParkingTicket parkingTicket = new ParkingTicket(car.getCarId());
        int bestParkingLotNumber = 0;
        int maxPosition = parkingLots.get(bestParkingLotNumber).getPosition();
        for (int parkingLotNumber = 0; parkingLotNumber < parkingLots.size(); parkingLotNumber++) {
            if (parkingLots.get(parkingLotNumber).getPosition() > maxPosition) {
                bestParkingLotNumber = parkingLotNumber;
                maxPosition = parkingLots.get(parkingLotNumber).getPosition();
            }
        }
        parkingLots.get(bestParkingLotNumber).parkingCarToParkingLot(car);
        return parkingTicket;
    }
}
