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
public class Example {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		TaskMap tasks = createTaskMap();
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

		System.out.println("Time taken - " + elapsedTime / 1000
				+ " seconds");

	}

	/**
	 * creates the given number of task sets with each of the tasks in them
	 * taking 'secsToComplete' seconds to complete.
	 * 
	 * @return
	 */
	private static TaskMap createTaskMap() {
		TaskMap tasks = new TaskMap();
		// Task 1
		Task task1 = new Task() {

			public void run() {
				System.out.println(getTaskId() + " started");
				try {
					// this is the mock runtime of the task
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(getTaskId() + " ended");
			}

			public String getTaskId() {
				return "Task-1";
			}

			public Integer getOrder() {
				return 1;
			}
		};
		tasks.addTask(task1);

		// Task 2
		Task task2 = new Task() {

			public void run() {
				System.out.println(getTaskId() + " started");
				try {
					// this is the mock runtime of the task
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(getTaskId() + " ended");
			}

			public String getTaskId() {
				return "Task-2";
			}

			public Integer getOrder() {
				return 2;
			}
		};
		tasks.addTask(task2);

		// Task 3
		Task task3 = new Task() {

			public void run() {
				System.out.println(getTaskId() + " started");
				try {
					// this is the mock runtime of the task
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(getTaskId() + " ended");
			}

			public String getTaskId() {
				return "Task-3";
			}

			public Integer getOrder() {
				return 2;
			}
		};
		tasks.addTask(task3);

		// Task 3
		Task task4 = new Task() {

			public void run() {
				System.out.println(getTaskId() + " started");
				try {
					// this is the mock runtime of the task
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(getTaskId() + " ended");
			}

			public String getTaskId() {
				return "Task-4";
			}

			public Integer getOrder() {
				return 3;
			}
		};
		tasks.addTask(task4);

		// Task 3
		Task task5 = new Task() {

			public void run() {
				System.out.println(getTaskId() + " started");
				try {
					// this is the mock runtime of the task
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(getTaskId() + " ended");
			}

			public String getTaskId() {
				return "Task-5";
			}

			public Integer getOrder() {
				return 3;
			}
		};
		tasks.addTask(task5);
		return tasks;
	}

}
