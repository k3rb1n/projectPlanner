/**
 * 
 */
package com.planner.main;

import com.planner.constants.Constant;
import com.planner.controller.Controller;

/**
 * @author kervin
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(Constant.PROJECT_PLANNER_APPLICATION + Constant.NEW_LINE);
		Controller controller = new Controller();
		controller.runProjectPlanner();
	}

}
