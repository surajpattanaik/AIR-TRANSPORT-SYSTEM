package com.air.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AirportDTO {
    
    private String id;
    
    private String name;
    
    private String location;
    
    @JsonProperty(value = "schedules")
    private List<ScheduleDTO> sdto;
    
    @JsonProperty(value = "bookings")
    private List<BookingDTO> bdto;

    public AirportDTO() {
    }

    public AirportDTO(String id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

	public AirportDTO(String id, String name, String location, List<ScheduleDTO> sdto, List<BookingDTO> bdto) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.sdto = sdto;
		this.bdto = bdto;
	}
    
}
