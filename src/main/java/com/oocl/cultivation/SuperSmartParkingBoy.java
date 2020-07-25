package com.oocl.cultivation;

import java.math.BigDecimal;

public class SuperSmartParkingBoy extends ParkingBoy {
    public SuperSmartParkingBoy(int parkingLotsCount) {
        super(parkingLotsCount);
    }

    public SuperSmartParkingBoy(int parkingLotsCount, int[] parkingLotsPosition) {
        super(parkingLotsCount, parkingLotsPosition);
    }

    @Override
    public ParkingTicket parkingCar(Car car) {
        ParkingTicket parkingTicket = new ParkingTicket(car.getCarId());
        int bestParkingLotNumber = 0;
        float maxPositionRate = ((float)parkingLots.get(0).getPosition())/parkingLots.get(0).getMaxPosition();
        for (int parkingLotNumber = 0; parkingLotNumber < parkingLots.size(); parkingLotNumber++) {
            float positionRate = ((float)parkingLots.get(parkingLotNumber).getPosition())/parkingLots.get(parkingLotNumber).getMaxPosition();
            if (positionRate > maxPositionRate) {
                bestParkingLotNumber = parkingLotNumber;
                maxPositionRate = positionRate;
            }
        }
        parkingLots.get(bestParkingLotNumber).parkingCarToParkingLot(car);
        return parkingTicket;
    }
}
