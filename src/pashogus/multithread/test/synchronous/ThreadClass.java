package pashogus.multithread.test.synchronous;

public class ThreadClass {

	public static void main(String[] args) {

		InitalList initial = new InitalList();
		AgeClass age = new AgeClass(initial);
		AddressClass address = new AddressClass(initial);
		
		
		/*
		 * 
		 * All synchronized blocks synchronized on the same object can only have one thread executing inside 
		 * them at the same time. All other threads attempting to enter the synchronized block 
		 * are blocked until the thread inside the synchronized block exits the block
		 */
		
		Thread three = new Thread(new Runnable(){

			@Override
			public void run() {
				
				initial.intialList();	
			}
			
		});
		
		Thread one=new Thread(new Runnable(){

			@Override
			public void run() {
				try {
					age.age1();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		Thread two =new Thread(new Runnable(){

			@Override
			public void run() {
				try {
					address.address1();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		Thread four =new Thread(new Runnable(){

			@Override
			public void run() {
				try {
					address.address1();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		two.start();
		three.start();
		one.start();
		four.start();
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
;