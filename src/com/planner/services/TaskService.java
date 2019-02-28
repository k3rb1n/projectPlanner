/**
 * 
 */
package com.planner.services;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.planner.beans.Project;
import com.planner.beans.Task;
import com.planner.constants.Constant;
import com.planner.utils.Utils;

/**
 * @author kervin
 *
 */
public class TaskService {
	
	/*
	 * This will get task input from the user.
	 */
	public List<Task> generateTaskList(Project project) {
		// Initialize list that will hold the list of task input from user.
		List<Task> taskList = new ArrayList<>();
		
		// Prompt user to add task.
		Boolean addTask = Utils.prompt(Constant.ADD_TASK).equalsIgnoreCase(Constant.Y_YES) ? Boolean.TRUE : Boolean.FALSE ;
		while (addTask) {
			// Generate and add task to taskList.
			taskList.add(createTask(taskList, project.getStartDate()));
			// Prompt to add another task.
			addTask = Utils.prompt(Constant.ADD_ANOTHER_TASK).equalsIgnoreCase(Constant.Y_YES) ? Boolean.TRUE : Boolean.FALSE ;
		}
		// Return generated taskList.
		return taskList;
	}
	
	/*
	 * This will create task from user input.
	 */
	private Task createTask(List<Task> taskList, LocalDate projectStartDate) {
		// Initialize task and set attributes.
		Task task = new Task();
		task.setTaskName(Utils.prompt(Constant.TASK_NAME));
		task.setDuration(Integer.parseInt(Utils.prompt(Constant.DURATION)));
		
		// Check if taskList is empty.
		// If empty then adding dependency is not possible.
		// Skip adding dependency
		if (!taskList.isEmpty()) {
			// Add dependency to task.
			task.setDependencyList(generateDependency(taskList));
		} 
		
		// Add start and end date of task.
		if (task.getDependencyList() == null || task.getDependencyList().isEmpty()) {
			// No dependency is added generate start and end date of task.
			task.setStartDate(projectStartDate);
			task.setEndDate(Utils.generateEndDateUsingStartDateAndDuration(projectStartDate, task.getDuration()));
		} else {
			// Task has dependency to consider.
			
			// Initialize temporary start and end date of task.
			LocalDate tempStartDate = projectStartDate;
			LocalDate tempEndDate = projectStartDate;
			
			// Iterate through all the dependency of the task.
			for (Task dependency : task.getDependencyList()) {
				// Check each dependency end date and compare to temporary start date.
				if (tempStartDate.isBefore(dependency.getEndDate()) ||
						tempStartDate.isEqual(dependency.getEndDate())) {
					
					// Process start date of task.
					// Start day of task should start after end date of dependency.
					tempStartDate = dependency.getEndDate().plusDays(1);
					
					// Check if tempStartDate falls on saturday or sunday.
					if (tempStartDate.getDayOfWeek() == DayOfWeek.SATURDAY) {
						tempStartDate = tempStartDate.plusDays(2);
					} else if (tempStartDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
						tempStartDate = tempStartDate.plusDays(1);
					}
					
					// Process end date of task.
					tempEndDate = Utils.generateEndDateUsingStartDateAndDuration(tempStartDate, task.getDuration());
				}
			}
			// Set start and end date of task.
			task.setStartDate(tempStartDate);
			task.setEndDate(tempEndDate);
		}
		return task;
	}
	
	/*
	 * This will generate dependency list.
	 */
	private List<Task> generateDependency(List<Task> taskList) {
		// Initialize list that will hold dependency list.
		List<Task> dependencyList = new ArrayList<>();
		
		// Prompt user to add dependency.
		Boolean addDependency = Utils.prompt(Constant.ADD_DEPENDENCY).equalsIgnoreCase(Constant.Y_YES) ? Boolean.TRUE : Boolean.FALSE ;
		if (addDependency) {
			System.out.println(Constant.NEW_LINE + Constant.TASK_LIST);
		}
		
		while (addDependency) {
			for (int ctr = 0; ctr < taskList.size(); ctr++) {
				// Display task list with corresponding index.
				System.out.println(Constant.OPEN_PARENTHESIS + ctr + Constant.CLOSE_PARENTHESIS + Constant.SPACE + taskList.get(ctr).getTaskName());
			}
			int taskIndex = Integer.parseInt(Utils.prompt(Constant.ENTER_TASK_INDEX));
			dependencyList.add(taskList.get(taskIndex));
			addDependency = Utils.prompt(Constant.ADD_ANOTHER_DEPENDENCY).equalsIgnoreCase(Constant.Y_YES) ? Boolean.TRUE : Boolean.FALSE ;
		}
		
		return dependencyList;
	}
	
	
	
}
