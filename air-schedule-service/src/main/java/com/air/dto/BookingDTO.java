package com.air.dto;

public class BookingDTO {

    private String id;
    private String scheduleId;
    private String passengerId;
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

	public BookingDTO(String id, String scheduleId, String passengerId, Integer seatNumber) {
		super();
		this.id = id;
		this.scheduleId = scheduleId;
		this.passengerId = passengerId;
		this.seatNumber = seatNumber;
	}

	public BookingDTO() {
	}

    
}
