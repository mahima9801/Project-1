package com.capg.fms.service;

import java.util.List;

import com.capg.fms.exceptions.ScheduleIdExistsException;
import com.capg.fms.exceptions.ScheduleIdNotFoundException;
import com.capg.fms.model.Schedule;

public interface ScheduleService {
	public Schedule newSchedule(Schedule schedule) throws ScheduleIdExistsException;
	public Schedule getSchedule(int scheduleid) throws ScheduleIdNotFoundException;
	public List<Schedule> getAllSchedule();
	public boolean modifySchedule(Schedule schedule);
	public boolean deleteSchedule(int scheduleid);
}
