/**
 * 
 */
package com.vimukthi.taskrunner.tests;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.vimukthi.taskrunner.Task;
import com.vimukthi.taskrunner.TaskMap;
import com.vimukthi.taskrunner.TaskRunner;

/**
 * @author Vimukthi
 *
 */
public class TestMain {
	
	static int taskCount = 0;
	final static int secsToComplete = 2;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		TaskMap tasks = createTaskMap(5);
		TaskRunner runner = new TaskRunner(tasks);
		long startTime = System.currentTimeMillis();
		try {			
			runner.run();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long stopTime = System.currentTimeMillis();
	    long elapsedTime = stopTime - startTime;
	    
	    System.out.println("Time it would have taken if executed sequentially - " + taskCount * secsToComplete + " seconds");
	    System.out.println("Actual time taken - " + elapsedTime / 1000 + " seconds");
		
	}

	/**
	 * creates the given number of task sets with each of the tasks 
	 * in them taking 'secsToComplete' seconds to complete.
	 * @return
	 */
	private static TaskMap createTaskMap(int numberOfTaskSets) {
		TaskMap tasks = new TaskMap();
		for (int i = numberOfTaskSets; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				final int order = i;
				final String id = "TaskSet " + i + " - Task " + j;
				Task task = new Task() {
					
					public void run() {
						System.out.println(id + " started");
						try {
							TimeUnit.SECONDS.sleep(secsToComplete);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println(id + " ended");
					}
					
					public String getTaskId() {
						return id;
					}
					
					public Integer getOrder() {
						return order;
					}
				};
				tasks.addTask(task);
				taskCount++;
			}
		}
		System.out.println(taskCount + " tasks added to queue with each taking " + secsToComplete +" seconds to complete..");
		return tasks;
	}

}
