/**
 * 
 */
package com.planner.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * @author kervin
 *
 */
public class Utils {
	
	/*
	 * This will display text on console and ask for user input.
	 */
	public static String prompt(String text) {
		System.out.print(text);
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
	
	/*
	 * This will generate end date using start date and duration.
	 */
	public static LocalDate generateEndDateUsingStartDateAndDuration(LocalDate baseDate, Integer duration) {
		LocalDate tempDate = baseDate;
		
		int dayCount = 1;
		while (dayCount < duration) {
			tempDate = tempDate.plusDays(1);
			if (tempDate.getDayOfWeek() != DayOfWeek.SATURDAY &&
					tempDate.getDayOfWeek() != DayOfWeek.SUNDAY) {
				dayCount++;
			}
		}
		
		return tempDate;
	}
}
