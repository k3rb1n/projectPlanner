/**
 * 
 */
package com.planner.services;

import com.planner.beans.Project;
import com.planner.beans.Task;
import com.planner.constants.Constant;

/**
 * @author kervin
 *
 */
public class DisplayService {
	public void displayProjectDetails(Project project) {
		System.out.println(Constant.LINE_HYPHEN);
		System.out.println(Constant.NEW_LINE + Constant.DETAILS_PROJECT_NAME + project.getProjectName());
		System.out.println(Constant.DETAILS_PROJECT_START_DATE + project.getStartDate().toString());
		
		System.out.println(Constant.NEW_LINE + Constant.TASK_LIST);
		for(Task task : project.getTaskList()) {
			System.out.println(Constant.NEW_LINE + Constant.DETAILS_TASK_NAME  + task.getTaskName());
			System.out.println(Constant.DETAILS_TASK_DURATION + task.getDuration());
			System.out.println(Constant.DETAILS_TASK_START_DATE + task.getStartDate().toString());
			System.out.println(Constant.DETAILS_TASK_END_DATE + task.getEndDate().toString());
		}
		System.out.println(Constant.LINE_HYPHEN);
		System.out.println(Constant.LINE_EQUALS);
	}
}
