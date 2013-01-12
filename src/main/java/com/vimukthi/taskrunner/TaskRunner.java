/**
 * 
 */
package com.vimukthi.taskrunner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * TaskRunner is a utility to run a set of tasks while respecting the ordering
 * of tasks such that tasks with the same order executes concurrently.
 * 
 * Provide a {@link TaskMap } with populated with a set of tasks each implementing
 * {@link Task} interface.
 * 
 * @author Vimukthi
 *
 */
public class TaskRunner {
	
	private TaskMap map;
	
	/**
	 * 
	 * @param map of tasks to be run
	 */
	public TaskRunner(TaskMap map) {
		super();
		this.map = map;
	}	
	
	/**
	 * Run the map of tasks provided in the constructor
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public void run() throws InterruptedException, ExecutionException {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (Entry<Integer, Set<Task>> entry : map.entrySet()) {
			List<Future<?>> futures = new ArrayList<Future<?>>();
			
			// submit each task in the set to the executor
			for (Task task : entry.getValue()){
				futures.add(exec.submit(task));
			}
			
			// iterate the futures to see if all the tasks in the set have finished execution
			for (Iterator<Future<?>> iterator = futures.iterator(); iterator.hasNext();) {
				Future<?> future = (Future<?>) iterator.next();
				if (future.get() == null);
			}
		}
		exec.shutdown();
	}
}
