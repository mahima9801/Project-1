package com.capg.fms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capg.fms.model.Schedule;
import com.capg.fms.model.ScheduledFlights;

@Repository
public class ScheduledFlightsDaoImpl implements ScheduledFlightsDao{

	@PersistenceContext
	EntityManager entityManager;
	
	/* Method:addScheduledFlights
	 * This method is used to add the scheduled flight in the ScheduledFlights table.
	 * Type:boolean
	 * Parameter:ScheduledFlights
	 * Author Name:Mahima Mishra
	 * Version:
	 */
	@Override
	public boolean addScheduledFlights(ScheduledFlights sflight) {
		entityManager.persist(sflight);
		return true;
	}
	
	/* Method:retrieveScheduledFlights
	 * This method is used to retrieve the scheduled flight from the Schedule, ScheduledFlights and Flight table.
	 * Type:List<Schedule>
	 * Parameters:source and destination
	 * Author Name:Mahima Mishra
	 * Version:
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Schedule> retrieveScheduledFlights(String source, String destination) {
		Query query = entityManager.createQuery("select s.scheduleId,s.source,s.destination,s.arrivaltime,s.departuretime,f.flightNumber,f.carrierName,f.seatCapacity from Schedule s INNER JOIN ScheduledFlights sf ON s.scheduleId=sf.scheduleId INNER JOIN Flight f on sf.flightId=f.flightNumber where s.source="+source+"AND s.destination="+destination);
		return query.getResultList();
	}
	
	/* Method:retrieveAllScheduledFlights
	 * This method is used to retrieve all scheduled flight from the ScheduledFlights table.
	 * Type:List<ScheduledFlights>
	 * Parameter:-
	 * Author Name:Mahima Mishra
	 * Version:
	 */

	@Override
	public List<ScheduledFlights> retrieveAllScheduledFlights() {
		String query = "select s.serialNo,s.schedule,s.flight from ScheduledFlights s";
		TypedQuery<ScheduledFlights> q = entityManager.createQuery(query, ScheduledFlights.class);
		return q.getResultList();
	}
	
	/* Method:retriveScheduledFlight
	 * This method is used to retrieve the scheduled flight from the ScheduledFlights table.
	 * Type:List<ScheduledFlights>
	 * Parameter:scheduleId
	 * Author Name:Mahima Mishra
	 * Version:
	 */
	@SuppressWarnings("unchecked")
	public List<ScheduledFlights> retrieveScheduledFlight(int scheduleId){
		Query query = entityManager.createQuery("select s from ScheduledFlights s where Schedule Id="+scheduleId);
		return query.getResultList();
	}
	
	/* Method:updateScheduledFlights
	 * This method is used to update the scheduled flight in the ScheduledFlights table.
	 * Type:boolean
	 * Parameter:ScheduledFlights
	 * Author Name:Mahima Mishra
	 * Version:
	 */
	@Override
	public boolean updateScheduledFlights(ScheduledFlights sflight) {
		entityManager.getTransaction().begin();
		entityManager.merge(sflight);
		entityManager.getTransaction().commit();
		return true;
	}
	
	/* Method:deleteScheduledFlights
	 * This method is used to delete the scheduled flight in the ScheduledFlights table.
	 * Type:boolean
	 * Parameter:scheduleId
	 * Author Name:Mahima Mishra
	 * Version:
	 */
	@Override
	public boolean deleteScheduledFlights(int scheduleId) {
		ScheduledFlights sflight =entityManager.find(ScheduledFlights.class, scheduleId);
		if(sflight !=null)
		{
			entityManager.remove(sflight);
			return true;
		}
		else 
		return false;
	}
}
