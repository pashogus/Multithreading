package pashogus.daemonthread.vs.userthread;

public class DeamonVsUserThread {

	public static void main(String[] args) {
		
		/*
		 * 
		 * A thread inherits daemon status from its parent thread - the one that created it. 
		 * The purpose of daemon threads is serving user threads, there’s no need to keep daemon threads 
		 * running if all user threads terminate. That’s why the JVM will exit if there are only daemon threads 
		 * running.
		 */
	
		        Thread userThread = new Thread(new Runnable() {
		            public void run() {
		                int x = 10;
		 
		                while (x > 0) {
		                    System.out.println("User thread: " + x--);
		 
		                    try {
		                        Thread.sleep(1000);
		                    } catch (InterruptedException ex) { ex.printStackTrace(); }
		                }
		            }
		        });
		        userThread.start();
		 
		        Thread daemonThread = new Thread(new Runnable() {
		            public void run() {
		                while (true) {
		                    System.out.println("Daemon thread is running...");
		                    try {
		                        Thread.sleep(100);
		                    } catch (InterruptedException ex) { ex.printStackTrace(); }
		 
		                }
		            }
		        });
		 
		        daemonThread.setDaemon(true);
		        daemonThread.start();
		    }

}
