package pashogus.multithread.testing;

public class CalciAddition implements Runnable{
	
	private static  Object add = new Object();
	 /**
	  * tried with Constructor Injection, but setting value to a static filed using constructor injection 
	  * is not recommended, as for every instance of object , same value might be applied to the field
	  * 
	  * so used setter injection to set the value for fields
	  */
	static int a;
	static int b;
	static int c;

	/**
	 * 
	 * @param a
	 */
	public static void setA(int a) {
		CalciAddition.a = a;
	}

	/**
	 * 
	 * @param b
	 */
	public static void setB(int b) {
		CalciAddition.b = b;
	}

	/**
	 * 
	 */
	public static void addition() throws InterruptedException
	{
		
		
		synchronized(add)
		{
			
			if (a > b) {
				CalciSubraction.c = a - b;
			} else {
				CalciSubraction.c = b - a;
			}
			
			CalciAddition.c=a+b;
			System.out.println("Value after addition :"+ CalciAddition.c);
			/*
			 * notify and notifyAll both wake up sleeping threads, but notify only rouses one, 
			 * while notifyAll rouses all of them. 
			 * Since notify might not wake up the right thread, notifyAll should be used instead.
			 */
			add.notifyAll();
		}

	}

	/**
	 * 
	 */
	@Override
	public void run() {	
		try {
			CalciAddition.addition();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
