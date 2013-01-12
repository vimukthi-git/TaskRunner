/**
 * 
 */
package com.vimukthi.taskrunner;

/**
 * Defines a task to be submitted for the task runner
 * @author Vimukthi
 *
 */
public interface Task extends Runnable {

	/**
	 * 
	 * @return Identifier for this task
	 */
	public String getTaskId();
	
	/**
	 * 
	 * @return Order of execution for this task
	 */
	public Integer getOrder();
}
