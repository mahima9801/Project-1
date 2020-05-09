package com.capg.fms.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Schedule")
public class Schedule {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="Schedule_Id")
	private int scheduleId;
	
	@Column(name="Source")
	private String source;
	
	@Column(name="Destination")
	private String destination;
	
	@Column(name="Arrival_Date_Time")
	private LocalDateTime arrivaltime;
	
	@Column(name="Departure_Date_Time")
	private LocalDateTime departuretime;
	

	public Schedule() {
		super();
	}

	public Schedule(int scheduleId, String source, String destination, LocalDateTime arrivaltime,
			LocalDateTime departuretime) {
		super();
		this.scheduleId = scheduleId;
		this.source = source;
		this.destination = destination;
		this.arrivaltime = arrivaltime;
		this.departuretime = departuretime;
	}

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalDateTime getArrivaltime() {
		return arrivaltime;
	}

	public void setArrivaltime(LocalDateTime arrivaltime) {
		this.arrivaltime = arrivaltime;
	}

	public LocalDateTime getDeparturetime() {
		return departuretime;
	}

	public void setDeparturetime(LocalDateTime departuretime) {
		this.departuretime = departuretime;
	}

	@Override
	public String toString() {
		return "Schedule [scheduleId=" + scheduleId + ", source=" + source + ", destination=" + destination
				+ ", arrivaltime=" + arrivaltime + ", departuretime=" + departuretime + "]";
	}

	
	
	

}
