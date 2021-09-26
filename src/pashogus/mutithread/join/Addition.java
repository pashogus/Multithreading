package pashogus.mutithread.join;

public class Addition implements Runnable {

	int a;
	int b;
	int c;
	
	
	
	public Addition(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}
	
	
	public void add()
	{
		for(int i=0; i<20;i++)
		{
		c=a+b+i;
		System.out.println("inside Addition method of : "+Thread.currentThread().getName()+" and value is:"+ c);
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
