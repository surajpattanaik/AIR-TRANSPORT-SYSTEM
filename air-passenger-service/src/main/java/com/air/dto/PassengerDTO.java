package com.air.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PassengerDTO {

    private String id;

    private String name;

    @JsonProperty(value = "bookings")
    private List<BookingDTO> bdto;

    public PassengerDTO(String id, String name, List<BookingDTO> bdto) {
		super();
		this.id = id;
		this.name = name;
		this.bdto = bdto;
	}

	public PassengerDTO() {
    }

    public PassengerDTO(String id, String name) {
        this.id = id;
        this.name = name;
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

	public List<BookingDTO> getBdto() {
		return bdto;
	}

	public void setBdto(List<BookingDTO> bdto) {
		this.bdto = bdto;
	}
    
}
