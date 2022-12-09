package model;

import java.time.LocalTime;

public class Car {
    private int numPlate;
    private LocalTime checkIn;
    private LocalTime checkOut;
    private int minutesPermanence;
    private int serviceCost;

    public Car(int numPlate, LocalTime checkIn) {
        this.numPlate = numPlate;
        this.checkIn = checkIn;
    }

    public int getNumPlate() {
        return numPlate;
    }

    public void setNumPlate(int numPlate) {
        this.numPlate = numPlate;
    }

    public LocalTime getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalTime checkIn) {
        this.checkIn = checkIn;
    }

    public LocalTime getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalTime checkOut) {
        this.checkOut = checkOut;
    }

    public int getMinutesPermanence() {
        return minutesPermanence;
    }

    public void setMinutesPermanence(LocalTime chekIn, LocalTime chekOut) {
        this.minutesPermanence = checkOut.getMinute();
    }

    public int getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(int serviceCost) {
        this.serviceCost = serviceCost;
    }

}