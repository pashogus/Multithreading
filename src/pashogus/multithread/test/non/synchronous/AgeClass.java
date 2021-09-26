package pashogus.multithread.test.non.synchronous;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AgeClass implements Runnable{
	
	public void age(){
//		ageMap.put("Pashogus1", new Pashogus("Pashogus1").setAge(20).Build());
//		ageMap.put("Pashogus2", new Pashogus("Pashogus2").setAge(20).Build());
//		ageMap.put("Pashogus3", new Pashogus("Pashogus3").setAge(20).Build());
//		
//		ageList.add(new Pashogus("Pashogus1").setAge(24).Build());
//		ageList.add(new Pashogus("Pashogus2").setAge(25).Build());
//		ageList.add(new Pashogus("Pashogus3").setAge(26).Build());
//		
		List<String> list = new ArrayList<>(3);
		list.add("Pashogus1");
		list.add("Pashogus2");
		list.add("Pashogus3");
		
		int count=20;
		for(String name : list)
		{
			System.out.println("From AGE Thread");
		 Pashogus temp= Master.masterMap.get(name);
		 temp.setAge(count++).Build();
		 Master.masterMap.put(name, temp);
			System.out.println(Master.masterMap.values());
		}
//		System.out.println(ageList);
//		System.out.println(ageMap.values());

	}
	
	public void age1()
	{
		for(int i=0;i<1000;i++)
		{
			System.out.println("inside age: "+i);
		}
	}

	@Override
	public void run() {
//		age();
		age1();
		
	}

	
	}	


