package com.oocl.cultivation;

public class ParkingTicket {
    private String carId;
    private Boolean beenUsed;

    public ParkingTicket(String carId) {
        this.carId = carId;
        this.beenUsed = false;
    }

    public String getCarId() {
        return carId;
    }

    public Boolean getBeenUsed() {
        return beenUsed;
    }

    public void hasBeenUsed() {
        this.beenUsed = true;
    }
}
