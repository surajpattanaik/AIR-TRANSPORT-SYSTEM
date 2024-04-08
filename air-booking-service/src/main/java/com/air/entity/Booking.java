package com.air.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Booking {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    private String id;

    @Column(name = "schedule_id", nullable = false)
    private String scheduleId;

    @Column(name = "passenger_id", nullable = false)
    private String passengerId;

    @Column(name = "seat_number")
    private Integer seatNumber;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}

	public Integer getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(Integer seatNumber) {
		this.seatNumber = seatNumber;
	}

	public Booking(String id, String scheduleId, String passengerId, Integer seatNumber) {
		super();
		this.id = id;
		this.scheduleId = scheduleId;
		this.passengerId = passengerId;
		this.seatNumber = seatNumber;
	}

	public Booking() {
	}


}
