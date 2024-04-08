package com.air.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class PlaneDTO {
    
    private String id;
    
    private String name;
    
    private int capacity;

    @JsonProperty(value = "schedules")
    private List<ScheduleDTO> sdto;
    
    @JsonProperty(value = "bookings")
    private List<BookingDTO> bdto;


    public PlaneDTO(String id, String name, int capacity, List<ScheduleDTO> sdto, List<BookingDTO> bdto) {
		super();
		this.id = id;
		this.name = name;
		this.capacity = capacity;
		this.sdto = sdto;
		this.bdto = bdto;
	}


	public PlaneDTO() {
    }

    
	public PlaneDTO(String id, String name, int capacity) {
		super();
		this.id = id;
		this.name = name;
		this.capacity = capacity;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getCapacity() {
		return capacity;
	}


	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}


	public List<ScheduleDTO> getSdto() {
		return sdto;
	}


	public void setSdto(List<ScheduleDTO> sdto) {
		this.sdto = sdto;
	}


	public List<BookingDTO> getBdto() {
		return bdto;
	}


	public void setBdto(List<BookingDTO> bdto) {
		this.bdto = bdto;
	}

    
}