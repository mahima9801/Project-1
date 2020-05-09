package com.capg.fms.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.fms.dao.ScheduleDao;
import com.capg.fms.exceptions.ScheduleIdExistsException;
import com.capg.fms.exceptions.ScheduleIdNotFoundException;
import com.capg.fms.model.Schedule;


@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService{
	
	@Autowired
	private ScheduleDao scheduleDao;

	/* Method:newSchedule
	 * This method is used to add the schedule in the Schedule table.
	 * Type:boolean
	 * Parameter:Schedule
	 * Author Name:Mahima Mishra
	 * Version:
	 */
	@Override
	public Schedule newSchedule(Schedule schedule) throws ScheduleIdExistsException{
		List<Schedule> list = getAllSchedule();
		Optional<Schedule> optional = list.stream().filter(f1->f1.getScheduleId()==schedule.getScheduleId()).findFirst();
		if(optional.isPresent()) {
			return scheduleDao.addSchedule(schedule);
		}
		else
			throw new ScheduleIdExistsException("This id is already taken");
	}

	/* Method:getSchedule
	 * This method is used to retrieve the schedule from the Schedule table.
	 * Type:List<Schedule>
	 * Parameter:scheduleId
	 * Author Name:Mahima Mishra
	 * Version:
	 */
	@Override
	public Schedule getSchedule(int scheduleId) throws ScheduleIdNotFoundException{
		List<Schedule> list  = getAllSchedule();
		Optional<Schedule> optional = list.stream().filter(f1->f1.getScheduleId()==scheduleId).findFirst();
		if(optional.isPresent()) {
			return scheduleDao.retrieveSchedule(scheduleId);
	}
		else
			throw new ScheduleIdNotFoundException("Id doesn't exist");
			
	}

	/* Method:getAllSchedule
	 * This method is used to retrieve all schedules from the Schedule table.
	 * Type:List<Schedule>
	 * Parameter:-
	 * Author Name:Mahima Mishra
	 * Version:
	 */
	@Override
	public List<Schedule> getAllSchedule() {
		return scheduleDao.retrieveAllSchedule();
	}

	/* Method:modifySchedule
	 * This method is used to update the schedule in the Schedule table.
	 * Type:boolean
	 * Parameter:Schedule
	 * Author Name:Mahima Mishra
	 * Version:
	 */	
	@Override
	public boolean modifySchedule(Schedule schedule) {
		scheduleDao.updateSchedule(schedule);
		return true;
	}

	/* Method:deleteSchedule
	 * This method is used to delete the schedule in the Schedule table.
	 * Type:boolean
	 * Parameter:scheduleId
	 * Author Name:Mahima Mishra
	 * Version:
	 */
	@Override
	public boolean deleteSchedule(int scheduleid) {
		return scheduleDao.deleteSchedule(scheduleid);
	}

	
	
	

}
