package com.stackroute.smartparkingapp.dto;

/**
 * This class represents the Parking data transfer object
 **/
public class ParkingDto {

    /**
     * This class should have a field of type Integer (parkingId) ,two fields of type String
     * (vehicleType,dimensions)
     **/
    private int parkingId;
    private String vehicleType;
    private String dimensions;

    /**
     * No Args constructor
     */
    public ParkingDto() {

    }

    /**
     * parameterised constructor
     */
    public ParkingDto(int parkingId, String vehicleType, String dimensions) {
        this.parkingId = parkingId;
        this.vehicleType = vehicleType;
        this.dimensions = dimensions;
    }
/**
     * Getters and setters
     */
    public int getParkingId() {
        return parkingId;
    }

    public void setParkingId(int parkingId) {
        this.parkingId = parkingId;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }
}
