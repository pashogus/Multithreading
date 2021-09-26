package pashogus.multithread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import pashogus.mutithread.join.Addition;
import pashogus.mutithread.join.Subraction;

public class ThreadPoolClass {

	public static void main(String[] args) {

		/*
		 * ExecutorService service = Executors.newFixedThreadPool(6); , six threads are created at once
		 * inside Addition of: pool-1-thread-1
inside Addition of: pool-1-thread-4
inside Subraction of: pool-1-thread-2
inside Subraction of: pool-1-thread-5
inside Subraction of: pool-1-thread-6
inside Addition of: pool-1-thread-3
inside Subraction method of: pool-1-thread-6 and value is:1
inside Subraction method of: pool-1-thread-5 and value is:1
inside Subraction method of: pool-1-thread-2 and value is:1
inside Subraction method of: pool-1-thread-2 and value is:2
		 * 
		 * 
		 */
		
		
		/*
		 * ExecutorService service = Executors.newFixedThreadPool(2); Only two thread are created in Pool
		 * inside Subraction of: pool-1-thread-2
inside Addition of: pool-1-thread-1
inside Subraction method of: pool-1-thread-2 and value is:1
inside Addition method of : pool-1-thread-1 and value is:11
inside Addition method of : pool-1-thread-1 and value is:12
		 * 
		 */
		ExecutorService service = Executors.newFixedThreadPool(2);
		Addition add = new Addition(5,6);
		Subraction sub = new Subraction(5,6);
		Addition add1 = new Addition(5,6);
		Subraction sub1 = new Subraction(5,6);
		Addition add2 = new Addition(5,6);
		Subraction sub2 = new Subraction(5,6);
		
		/*
		Thread addThread = new Thread(add,"AddThread");
		Thread subThread = new Thread(sub,"SubThread");
		Thread addThread1 = new Thread(add1,"AddThread1");
		Thread subThread1 = new Thread(sub1,"SubThread1");
		Thread addThread2 = new Thread(add2,"AddThread2");
		Thread subThread2 = new Thread(sub2,"SubThread2");
		*/
		
		/*
		addThread.start();
		subThread.start();
		addThread1.start();
		subThread1.start();
		addThread2.start();
		subThread2.start();
		*/
		
		service.execute(add);
		service.execute(sub);
		service.execute(add1);
		service.execute(add2);
		service.execute(sub1);
		service.execute(sub2);
		service.shutdown();
		

	}

}
