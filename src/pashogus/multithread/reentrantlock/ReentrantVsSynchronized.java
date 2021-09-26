package pashogus.multithread.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantVsSynchronized {


		    //An unfair ReentrantLock
		    private final ReentrantLock lock = new ReentrantLock();
		    private int count = 0;
		    //Acquire the lock on lock and release the lock in finally
		    public int getCount() {
		        lock.lock();
		        try {
		            System.out.println(Thread.currentThread().getName() + "The getCount method gets the value of count:" + count);
		            return count++;
		        } finally {
		            lock.unlock();
		        }
		    }
		    //Use synchronized implicit lock
		    public synchronized int getCountTwo() {
		        System.out.println(Thread.currentThread().getName() + "The getCountTwo method gets the value of count:" + count);
		        return count++;
		    }
		    public static void main(String args[]) {
		        final ReentrantVsSynchronized counter = new ReentrantVsSynchronized();
		        Thread t1 = new Thread() {
		            public void run() {
		                while (counter.getCount() < 6) {
		                    try {
		                        Thread.sleep(100);
		                    } catch (InterruptedException e) {
		                        e.printStackTrace();
		                    }
		                }
		            }
		        };

		        Thread t2 = new Thread() {
		            public void run() {
		                while (counter.getCount() < 6) {
		                    try {
		                        Thread.sleep(100);
		                    } catch (InterruptedException e) {
		                        e.printStackTrace();
		                    }
		                }
		            }
		        };

		        t1.start();
		        t2.start();
		    }
		}




