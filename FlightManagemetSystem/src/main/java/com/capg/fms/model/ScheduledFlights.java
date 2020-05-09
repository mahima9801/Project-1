package com.capg.fms.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ScheduledFlights")
public class ScheduledFlights {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int serialNo;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="Schedule_Id")
	private Schedule schedule;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="Flight_Id")
	private Flight flight;
	
	public ScheduledFlights() {
		super();
	}

	public ScheduledFlights(Schedule schedule, Flight flight) {
		super();
		this.schedule = schedule;
		this.flight = flight;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	@Override
	public String toString() {
		return "ScheduledFlights [schedule=" + schedule + ", flight=" + flight + "]";
	}
	
}
