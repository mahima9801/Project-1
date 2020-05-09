package com.capg.fms.service;

import java.util.List;

import com.capg.fms.exceptions.ScheduleIdExistsException;
import com.capg.fms.exceptions.ScheduleIdNotFoundException;
import com.capg.fms.model.Schedule;
import com.capg.fms.model.ScheduledFlights;

public interface ScheduledFlightsService {
	public boolean newScheduledFlights(ScheduledFlights sflight) throws ScheduleIdExistsException;
	public List<Schedule> getScheduledFlight(String source, String destination);
	public List<ScheduledFlights> getScheduledFlight(int scheduleId) throws ScheduleIdNotFoundException;
	public List<ScheduledFlights> getAllScheduledFlights();
	public boolean modifyScheduledFlights(ScheduledFlights sflight);
	public boolean deleteScheduledFlights(int scheduleId);
}
