/**
 * 
 */
package com.planner.controller;

import com.planner.beans.Project;
import com.planner.constants.Constant;
import com.planner.services.DisplayService;
import com.planner.services.ProjectService;
import com.planner.services.TaskService;
import com.planner.utils.Utils;

/**
 * @author kervin
 *
 */
public class Controller {
	
	// Initialize services to be used.
	private ProjectService projectService = new ProjectService();
	private TaskService taskService = new TaskService();
	private DisplayService displayService = new DisplayService();
	
	public void runProjectPlanner() {
		// Create new project and set attributes.
		Project project = new Project();
		project.setProjectName(projectService.getProjectName());
		project.setStartDate(projectService.getProjectStartDate());
		project.setTaskList(taskService.generateTaskList(project));
		
		// Prompt to generate schedule.
		Boolean generateSched = Utils.prompt(Constant.GENERATE_SCHEDULE).equalsIgnoreCase(Constant.Y_YES) ? Boolean.TRUE : Boolean.FALSE ;
		if (generateSched) {
			// Display the generated project details including schedule.
			displayService.displayProjectDetails(project);
		} else {
			System.out.println(Constant.PROJECT_IS_NOT_GENERATED);
		}
		
		System.out.println(Constant.NEW_LINE + Constant.LINE_EQUALS + Constant.NEW_LINE);
		
		// Prompt to plan another project.
		Boolean planProject = Utils.prompt(Constant.PLAN_ANOTHER_PROJECT).equalsIgnoreCase(Constant.Y_YES) ? Boolean.TRUE : Boolean.FALSE ;
		if (planProject) {
			// Execute project planner.
			this.runProjectPlanner();
		} else {
			System.out.println(Constant.APPLICATION_TERMINATED);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
