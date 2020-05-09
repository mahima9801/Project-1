package com.capg.fms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Flights")
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="Flight_Id")
	private long flightNumber;
	
	@Column(name="carrier_name")
	private String carrierName;
	
	@Column(name="seat_capacity")
	private int seatCapacity;
	
	public Flight() {
		super();
	}

	public Flight(long flightNumber, String carrierName, int seatCapacity) {
		super();
		this.flightNumber = flightNumber;
		this.carrierName = carrierName;
		this.seatCapacity = seatCapacity;
	}

	public long getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(long flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public int getSeatCapacity() {
		return seatCapacity;
	}

	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}

	@Override
	public String toString() {
		return "Flight [flightNumber=" + flightNumber + ", carrierName=" + carrierName + ", seatCapacity="
				+ seatCapacity + "]";
	}

	
	
	
	
	
}
