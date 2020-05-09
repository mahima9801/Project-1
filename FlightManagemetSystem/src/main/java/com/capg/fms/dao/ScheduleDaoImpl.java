package com.capg.fms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capg.fms.model.Schedule;

@Repository
public class ScheduleDaoImpl implements ScheduleDao {
	@PersistenceContext
	EntityManager entityManager;

	/* Method:addSchedule
	 * This method is used to add the schedule in the Schedule table.
	 * Type:boolean
	 * Parameter:Schedule
	 * Author Name:Mahima Mishra
	 * Version:
	 */
	@Override
	public Schedule addSchedule(Schedule schedule) {
		entityManager.persist(schedule);
		return schedule;
	}
	
	/* Method:retrieveSchedule
	 * This method is used to retrieve the schedule from the Schedule table.
	 * Type:List<Schedule>
	 * Parameter:scheduleId
	 * Author Name:Mahima Mishra
	 * Version:
	 */
	@Override
	public Schedule retrieveSchedule(int scheduleId) {
		return entityManager.find(Schedule.class, scheduleId);
	}
	
	/* Method:retrieveAllSchedule
	 * This method is used to retrieve all schedules from the Schedule table.
	 * Type:List<Schedule>
	 * Parameter:-
	 * Author Name:Mahima Mishra
	 * Version:
	 */
	@Override
	public List<Schedule> retrieveAllSchedule() {
			String query = "select schedule from Schedule schedule";
			TypedQuery<Schedule> q = entityManager.createQuery(query, Schedule.class);
			return q.getResultList();
		}

	/* Method:updateSchedule
	 * This method is used to update the schedule in the Schedule table.
	 * Type:boolean
	 * Parameter:Schedule
	 * Author Name:Mahima Mishra
	 * Version:
	 */	
	@Override
	public boolean updateSchedule(Schedule schedule) {
		entityManager.getTransaction().begin();
		entityManager.merge(schedule);
		entityManager.getTransaction().commit();
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
		Schedule schedule = entityManager.find(Schedule.class, scheduleid);
		if(schedule!=null)
		{
			entityManager.remove(schedule);
			return true;
		}
		else 
		return false;
		
	}
}


