/**
 * 
 */
package com.planner.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.planner.constants.Constant;
import com.planner.utils.Utils;

/**
 * @author kervin
 *
 */
public class ProjectService {
	/*
	 * This will get project input from the user.
	 */
	public String getProjectName() {
		return Utils.prompt(Constant.ENTER_PROJECT_NAME);
	}
	
	/*
	 * This will get project start date from the user.
	 */
	public LocalDate getProjectStartDate() {
		String strStartDate = Utils.prompt(Constant.PROJECT_START_DATE);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constant.DATE_PATTERN_YYYY_MM_DD);
		LocalDate startDate = LocalDate.parse(strStartDate, formatter);
		return startDate;
	}
}
