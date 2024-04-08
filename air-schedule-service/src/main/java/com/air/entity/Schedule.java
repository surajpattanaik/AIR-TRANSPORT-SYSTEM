package com.air.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Schedule {
    
    @Id
    @Column(name = "id")
    private String id;
    
    @Column(name = "plane_id")
    private String planeId;
    
    @Column(name = "source_airport_id")
    private String sourceAirportId;
    
    @Column(name = "destination_airport_id")
    private String destinationAirportId;
    
    @Column(name = "departure_time")
    private String departureTime;
    
    @Column(name = "arrival_time")
    private String arrivalTime;

    public Schedule() {
    }

    public Schedule(String planeId, String sourceAirportId, String destinationAirportId, String departureTime, String arrivalTime) {
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
