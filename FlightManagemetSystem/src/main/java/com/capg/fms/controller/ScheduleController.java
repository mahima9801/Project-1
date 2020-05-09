package com.capg.fms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.fms.exceptions.ScheduleIdExistsException;
import com.capg.fms.exceptions.ScheduleIdNotFoundException;
import com.capg.fms.model.Schedule;
import com.capg.fms.service.ScheduleService;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
	
	@Autowired
	private ScheduleService scheduleService;
	
	/* Method 	  : getScheduleById
	 * Description: This is a GetMethod(Http) by "scheduleId" is used to get the schedule from the database.
	 * Type 	  : ResponseEntity<List<Schedule>>
	 * Parameters : scheduleId
	 * Author 	  : Mahima Mishra
	 * Version 	  : 
	 */
	@GetMapping("/getScheduleById/{scheduleId}")
	public Schedule getScheduleById(@PathVariable int scheduleId) throws ScheduleIdNotFoundException{
		return scheduleService.getSchedule(scheduleId);
	}
	
	/* Method 	  : getAllSchedule
	 * Description: This is a GetMethod(Http) by "scheduleId" is used to get all schedules from the database.
	 * Type 	  : ResponseEntity<List<Schedule>>
	 * Parameters : -
	 * Author 	  : Mahima Mishra
	 * Version 	  : 
	 */
	@GetMapping("/getAllSchedule")
	public List<Schedule> getAllSchedule(){
		return scheduleService.getAllSchedule();
		
	}
	
	/* Method 	  : addSchedule
	 * Description: This is a PostMethod(Http) is used to add the schedule in the database.
	 * Type 	  : ResponseEntity<String>
	 * Parameters : Schedule(Class)
	 * Author 	  : Mahima Mishra
	 * Version 	  : 
	 */
	@PostMapping(value="/addSchedule")
	public Schedule addSchedule(@RequestBody Schedule schedule) throws ScheduleIdExistsException {
		return scheduleService.newSchedule(schedule);
		}
	
	/* Method 	  : updateSchedule
	 * Description: This is a PutMethod(Http) is used to update the schedule in the database.
	 * Type 	  : ResponseEntity<String>
	 * Parameters : Schedule(Class)
	 * Author 	  : Mahima Mishra
	 * Version 	  : 
	 */
	@PutMapping("/updateSchedule")
	public String updateSchedule(@RequestBody Schedule schedule) {
		scheduleService.modifySchedule(schedule);
		return "Schedule modified successfully";
	}
	
	/* Method 	  : deleteSchedule
	 * Description: This is a DeleteMethod(Http) by "scheduleId" is used to delete the schedule in the database.
	 * Type 	  : ResponseEntity<String>
	 * Parameters : scheduleId
	 * Author 	  : Mahima Mishra
	 * Version 	  : 
	 */
	@DeleteMapping("/deleteSchedule/{scheduleId}")
	public boolean deleteSchedule(@PathVariable int scheduleId) {
		return scheduleService.deleteSchedule(scheduleId);
	
	}
	

}
