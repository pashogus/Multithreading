package pashogus.multithread.reentrantlock;



public class ReentrantLockCLass {

	public static void main(String[] args) {
	
		/**
		 * https://www.programmersought.com/article/35466999534/
		 * 
		 * 1. Fairness. Synchronized does not support fairness. Once the lock is released, any thread can obtain the lock, 
		 * and it is impossible to specify which thread can obtain the lock first; on the other hand, we can specify the fairness 
		 * attribute when creating the ReentrantLock instance. 
		 * In the process of competing for locks, by specifying fairness, 
		 * we can provide a lock for the longest waiting thread 
		 * (that is, the thread waiting for the longest lock).
      ReentrantLock has two constructors. The following code shows that the constructor without parameters is unfair.

2.The second major difference is the tryLock method. ReentrantLock provides the tryLock method, 
which can be acquired if and only if the lock is available and not held by other threads.
 This alleviates the blocking of threads while waiting for the lock.
3. ReentrantLock provides an interrupt while waiting to acquire the lock, that is, we can interrupt 
the process of acquiring the lock. In synchronized, a thread will always be blocked while waiting for the lock. 
If it is caught in an infinite wait, we have no way to control this process. 
And ReentrantLock provides a lockInterruptibly method, when the thread is waiting to acquire the lock,
 we can use this method to interrupt the thread. At the same time, we can also specify a timeout period for tryLock.
 If the lock is not obtained within this time range, false is returned.
		 */
		
		Addition add = new Addition(5,6);
		Subraction sub = new Subraction(5,6);
		Thread addThread = new Thread(add,"AddThread");
		Thread subThread = new Thread(sub,"SubThread");
		Thread addThread1 = new Thread(add,"AddThread1");
		addThread.start();
		subThread.start();
		addThread1.start();
		
		try {
			addThread.join();
			subThread.join();
			addThread1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Value of Addition: "+add.getC());
		System.out.println("Value of Subraction: "+sub.getC());
	

	}

}
