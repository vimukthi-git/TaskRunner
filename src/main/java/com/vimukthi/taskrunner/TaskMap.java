/**
 * 
 */
package com.vimukthi.taskrunner;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

/**
 * Holds tasks for the taskrunner.
 * @author Vimukthi
 *
 */
@SuppressWarnings("serial")
public class TaskMap extends TreeMap<Integer, Set<Task>> {
	
	private int taskSetCount;
	
	public void addTask(Task task){
		if (containsKey(task.getOrder())){
			get(task.getOrder()).add(task);
		} else {
			taskSetCount++;
			Set<Task> temp = new HashSet<Task>();
			temp.add(task);
			put(task.getOrder(), temp);
		}
	}

	/**
	 * @return the taskSetCount
	 */
	public int getTaskSetCount() {
		return taskSetCount;
	}
}
