package pashogus.mutithread.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Division implements Runnable {

	private CountDownLatch latch;
	int a;
	int b;
	int c;
	
	
	
	public Division(int a, int b,CountDownLatch latch) {
		super();
		this.a = a;
		this.b = b;
		this.latch=latch;
	}
	
	
	public void division()
	{
		for(int i=0; i<20;i++)
		{
		c=a/b+i;
		System.out.println("inside Division method of : "+Thread.currentThread().getName()+" and value is:"+ c);
		}
		latch.countDown();
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
		System.out.println("inside Division of: "+Thread.currentThread().getName());
		division();
		
	}
	
}
