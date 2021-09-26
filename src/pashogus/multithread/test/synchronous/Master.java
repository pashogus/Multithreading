package pashogus.multithread.test.synchronous;

import java.util.concurrent.ConcurrentHashMap;

public class Master {
	
	/*
	 * For thread safe , go to ConcurrentHashMap
	 */
	static ConcurrentHashMap<String,Pashogus> masterMap = new ConcurrentHashMap<>(3);
	static Boolean check=true;

	
	/*
	 * if we want to use wait and notify , then we only able to apply it in synchronization block of same object
	 * 
	 * if we use synchronous block , then only only thread is allowed to perform task at a time,
	 * all other thread will not be permitted to enter the synchronization block until the current thread is 
	 * processed , 
	 *    - this is not required if we are not going to access same method from two different threads
	 *    - if we are not going to modify same attribute of an object by two different threads
	 * 
	 * 
	 * if three differnet objects needs to be synchronized, then use this keyword and autowire the object in other objects
	 * and add synchronization for the this object - refer AgeClass,AdressClass and InitalList, in this case object lock 
	 * is based on initialList.class
	 * 
	 * we can simply access the same Map/List , if we are not using any synchronization
	 * and if two thread is not updating same attributes.
	 *  it will increase the performance , refer SignficanceOfMultiThreading
	 * 
	 */
}
