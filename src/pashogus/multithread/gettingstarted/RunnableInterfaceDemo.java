package pashogus.multithread.gettingstarted;

public class RunnableInterfaceDemo {

	
	
	public static void main(String[] args) {
		Runnable r = new RunnableWorker();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		Thread t3 = new Thread(r);
		
		t1.start();
		t2.start();
		t3.start();
	}

}
