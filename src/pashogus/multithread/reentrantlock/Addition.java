package pashogus.multithread.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class Addition implements Runnable {


	int a;
	int b;
	int c;
	ReentrantLock lock = new ReentrantLock();
	
	
	public Addition(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	
	}
	
	
	public void add()
	{
		/**
		 * without this lock, two thread can simultaneously access this method
		 */
		lock.lock();
		//if there is any exception , we can't able to unlock , so always unlock should be in finally method
		try{
		for(int i=0; i<20;i++)
		{
		c=a+b+i;
		System.out.println("inside Addition method of : "+Thread.currentThread().getName()+" and value is:"+ c +" and loop Count is: "+i);
		}
		}
		finally{
		lock.unlock();
		}
	
	}
	
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}
	
	@Override
	public String toString() {
		return "Addition [a=" + a + ", b=" + b + ", c=" + c + "]";
	}


	@Override
	public void run() {
		System.out.println("inside Addition of: "+Thread.currentThread().getName());
	add();
		
	}
	
}
