package com.skillstorm.tasks;

import java.util.List;

import com.skillstorm.models.Office;
import com.skillstorm.services.OfficeService;

import sailpoint.api.SailPointContext;
import sailpoint.object.Attributes;
import sailpoint.object.TaskResult;
import sailpoint.object.TaskSchedule;
import sailpoint.task.BasePluginTaskExecutor;
import sailpoint.tools.GeneralException;

// TaskExecutors must extend this class to function properly
public class ClearExtraOfficesExecutor extends BasePluginTaskExecutor {
	
	// something we can change to indicate success or failure
	boolean success = true;
	
	private OfficeService service() {
		return new OfficeService(this);
	}

	// this method is what runs when we execute our task, either manually or on a schedule
	// inputs gets filled with whatever inputs you describe in your TaskDefinition (or nothing if you don't)
	// we will add our results to the result Map for display on the task result screen
	@Override
	public void execute(SailPointContext context, TaskSchedule schedule, TaskResult result, Attributes<String, Object> inputs)
			throws Exception {
		
		/*
		 * 1. See how many offices there are
		 * 2. If there are 3 or fewer, do nothing (perhaps fail the task)
		 * 3. If there are more than 3, delete all over the first 3
		 * 4. Add to result - key: numberOfOfficesDeleted, value: the number
		 */
		
		int officeCount = service().countOffices();
		
		if (officeCount <= 3) {
			success = false;
			throw new GeneralException("3 or fewer Offices in the database!");
		} else {
			int numberOfOfficesDeleted = service().deleteExtraOffices();
			result.put("numberOfOfficesDeleted", numberOfOfficesDeleted);
			
			List<Office> offices = service().getAllOffices();
			String remainingOffices = "";
			for (Office office : offices) {
				remainingOffices += (office.getDepartment() + ", ");
			}
			
			remainingOffices = remainingOffices.substring(0, remainingOffices.length() - 2);
			
			result.put("officesRemaining", remainingOffices);
			
			success = true;
		}
		
	}

	// this method runs when the task is complete
	// if it was successful, return true; otherwise, return false
	@Override
	public boolean terminate() {
		return success;
	}

	@Override
	public String getPluginName() {
		return "ExamplePlugin";
	}

}
