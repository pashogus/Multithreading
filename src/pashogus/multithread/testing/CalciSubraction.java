package pashogus.multithread.testing;

public class CalciSubraction implements Runnable {
	
	private static  Object sub = new Object();

	static int a;
	static int b;
	static int c;

	/**
	 * 
	 * @param a
	 */
	public static void setA(int a) {
		CalciSubraction.a = a;
	}

	/**
	 * 
	 * @param b
	 */
	public static void setB(int b) {
		CalciSubraction.b = b;
	}

	/**
	 * 
	 */
	public  static void subraction()
	{
	synchronized(sub)
	{
		try {
			sub.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (a > b) {
			CalciSubraction.c = a - b;
		} else {
			CalciSubraction.c = b - a;
		}
		
		System.out.println("Value after Subraction :"+ CalciSubraction.c);
	}
	
	}

	/**
	 * 
	 */
	@Override
	public void run() {	
		
		CalciSubraction.subraction();
	}
	
	
}
