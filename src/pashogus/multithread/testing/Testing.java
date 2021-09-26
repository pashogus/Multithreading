package pashogus.multithread.testing;

public class Testing {

	public static void main(String[] args) {
		
		try {
			Thread.sleep(100);
			CalciAddition.setA(5);
			CalciAddition.setB(10);
			Thread add= new Thread(new CalciAddition());
			CalciSubraction.setA(CalciAddition.c);
			CalciSubraction.setB(10);
			Thread sub = new Thread (new CalciSubraction());
			add.start();
			sub.start();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
