package pashogus.mutithread.countdownlatch;

import java.util.concurrent.CountDownLatch;



public class CountDownLatchClass {

	public static void main(String[] args) {
		
		
		/**
		 * Thread join method wait for joined thread to finish the execution before the main thread on which join method 
		 * is called to starts its execution. Whereas in CountDownLatch, latch.await doesn't wait for the thread that calls 
		 * latch.countDown() to be finished, it proceeds once the counter value reaches 0 
		 * and it has no association with the state of the thread that calls countDown().
		 * 
		 */
		
		/**
		 * 
		 * We can call join method when we have control over the threads but while using ExecutorService we don't have 
		 * control over individual threads instead we deal with just submitting the task to framework and it 
		 * internally manages threads in this situation using CountDownLatch is right approach.
		 */
		
		
		/**
		 * 
		 * Usage:

Example 1:
CountDownLatch is useful in Multiplayer games, Lets say we have a online chess game that can only 
be played when two player joins, in this case we will initialize the CountDownLatch to 2 and starts 
the game only after 2 threads(player) joins(calls countDown()).

Example 2:
Lets say we have some Timer task that we want to start only after all the modules of the application
 get loaded or when all the services is up.
		 */
	
		CountDownLatch latch = new CountDownLatch(2);
		Addition add = new Addition(5,6,latch);
		Subraction sub = new Subraction(5,6,latch);
		Thread addThread = new Thread(add,"AddThread");
		Thread subThread = new Thread(sub,"SubThread");
		addThread.start();
		subThread.start();
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Value of Addition: "+add.getC());
		System.out.println("Value of Subraction: "+sub.getC());

		CountDownLatch latch1 = new CountDownLatch(2);
		Multiplication multiply = new Multiplication(5,6,latch1);
		Division divide = new Division(5,6,latch1);
		Thread multiplyThread = new Thread(multiply,"MultiplyThread");
		Thread divisionThread = new Thread(divide,"DivisionThread");
		multiplyThread.start();
		divisionThread.start();
		
		try {
			latch1.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Value of Multiplication: "+multiply.getC());
		System.out.println("Value of Division: "+divide.getC());
		
	}

}
