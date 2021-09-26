package pashogus.multithread.test.non.synchronous;

public class ThreadClass {

	public static void main(String[] args) {

		Long startTime = System.currentTimeMillis();
		InitalList initial = new InitalList();
		initial.intialList();
		
		
         AgeClass age = new AgeClass();
         AddressClass address = new AddressClass();
		
        Thread ageThread = new Thread(age);
		Thread addressThread = new Thread(address);
        ageThread.start();
		addressThread.start();
		
	
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Long endTime = System.currentTimeMillis();
		System.out.println("Total Time"+ (startTime-endTime));
		System.out.println("******************");
		
		
		Long startTime1 = System.currentTimeMillis();
		System.out.println("Start: "+startTime1);
		InitalList initial1 = new InitalList();
		initial1.intialList();
		
		
         AgeClass age1 = new AgeClass();
         AddressClass address1 = new AddressClass();
         age1.age();
         address1.address();
		Long endTime1 = System.currentTimeMillis();
		System.out.println("end: "+endTime1);
		System.out.println("Total Time"+ (startTime1-endTime1));
		
		
}
}
