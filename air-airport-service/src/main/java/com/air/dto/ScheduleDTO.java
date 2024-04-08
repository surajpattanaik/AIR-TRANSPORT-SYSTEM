package com.air.dto;

public class ScheduleDTO {
    
    private String id;
    private String planeId;
    private String sourceAirportId;
    private String destinationAirportId;
    private String departureTime;
    private String arrivalTime;

    public ScheduleDTO() {
    }

    public ScheduleDTO(String id, String planeId, String sourceAirportId, String destinationAirportId, String departureTime, String arrivalTime) {
        this.id = id;
        this.planeId = planeId;
        this.sourceAirportId = sourceAirportId;
        this.destinationAirportId = destinationAirportId;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlaneId() {
        return planeId;
    }

    public void setPlaneId(String planeId) {
        this.planeId = planeId;
    }

    public String getSourceAirportId() {
        return sourceAirportId;
    }

    public void setSourceAirportId(String sourceAirportId) {
        this.sourceAirportId = sourceAirportId;
    }

    public String getDestinationAirportId() {
        return destinationAirportId;
    }

    public void setDestinationAirportId(String destinationAirportId) {
        this.destinationAirportId = destinationAirportId;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
