package pashogus.multithread.test.non.synchronous;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class InitalList {
		
		public void intialList()
		{
			synchronized(this)
			{			
		LinkedList<Pashogus> initial = new LinkedList<>();
		 Map<String,Pashogus> intialMap = new HashMap<>(3);
		intialMap.put("Pashogus1", new Pashogus("Pashogus1"));
		intialMap.put("Pashogus2", new Pashogus("Pashogus2"));
		intialMap.put("Pashogus3", new Pashogus("Pashogus3"));
		Master.masterMap.put("Pashogus1", new Pashogus("Pashogus1"));
		Master.masterMap.put("Pashogus2", new Pashogus("Pashogus2"));
		Master.masterMap.put("Pashogus3", new Pashogus("Pashogus3"));
		initial.add(new Pashogus("Pashogus1"));
		initial.add(new Pashogus("Pashogus2"));
		initial.add(new Pashogus("Pashogus3"));
		Master.check=false;
		this.notifyAll();
		}
//		System.out.println("*******");
//		System.out.println(initial);
//		System.out.println("*******");
//		
		

	}
}


