/**
 * 
 */
package com.planner.classes;

import java.time.LocalDate;
import java.util.List;

/**
 * @author kervin
 *
 */
public class Task {
	private String taskName;
	private Integer duration;
	private List<Task> dependencyList;
	private LocalDate startDate;
	private LocalDate endDate;

	/**
	 * @return the taskName
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * @param taskName
	 *            the taskName to set
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/**
	 * @return the duration
	 */
	public Integer getDuration() {
		return duration;
	}

	/**
	 * @param duration
	 *            the duration to set
	 */
	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	/**
	 * @return the dependencyList
	 */
	public List<Task> getDependencyList() {
		return dependencyList;
	}

	/**
	 * @param dependencyList
	 *            the dependencyList to set
	 */
	public void setDependencyList(List<Task> dependencyList) {
		this.dependencyList = dependencyList;
	}

	/**
	 * @return the startDate
	 */
	public LocalDate getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public LocalDate getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
}
