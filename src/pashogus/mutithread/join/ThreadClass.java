package pashogus.mutithread.join;

public class ThreadClass {

	public static void main(String[] args) {
		
		System.out.println("Start of Main Thread");
		
		Addition add = new Addition(5,6);
			Subraction sub = new Subraction(5,6);
			Thread addThread = new Thread(add,"AddThread");
			Thread subThread = new Thread(sub,"SubThread");
			addThread.start();
			subThread.start();
			
			try {
				addThread.join();
				subThread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("Value of Addition: "+add.getC());
			System.out.println("Value of Subraction: "+sub.getC());
		
		
		
		
		
		
	}

}
