package pashogus.multithread.nonstatic.testing;

public class Testing {

	public static void main(String[] args) 
	{


//https://www.javatpoint.com/java-thread-notify-method
		
		try {
			
			
			/*
			Addition add = new Addition(5,6);
			Thread addThread = new Thread(add);		
			new Thread(add,"Add").start();
			
			Subraction sub = new Subraction(add.getC(),10);
			Thread subThread = new Thread(sub);
			subThread.start();
			
			addThread.start();
			Thread.sleep(2000);
			System.out.println("5/7 :"+add.getC());
			System.out.println("Main thread");
			*/
			
			Addition addition = new Addition(5,6);
			
			new Thread(new Runnable(){
				@Override
				public void run(){
				addition.subraction();
				}}
			).start();
			
			new Thread(new Runnable(){
				@Override
				public void run(){
				addition.multilication();
				}}
			).start();

			new Thread(new Runnable(){

				@Override
				public void run(){ 	
				addition.addition();
				}}
			).start();
			
			
			
			
//			new Thread(()-> 	
//				addition.subraction()		
//			).start();
			
			Thread.sleep(2000);
			System.out.println("****************");
			System.out.println(addition.getC());
			System.out.println(addition.getD());
			System.out.println(addition.getE());
			System.out.println("****************");
			
			
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}

}
