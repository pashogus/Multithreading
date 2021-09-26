package pashogus.multithread.test.non.synchronous;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AddressClass implements Runnable {

	
	
	
	public void address()
	{
		
	
//		addressMap.put("Pashogus1", new Pashogus("Pashogus1").setAddress("fsdaf").Build());
//		addressMap.put("Pashogus2", new Pashogus("Pashogus2").setAddress("fsdafas").Build());
//		addressMap.put("Pashogus3", new Pashogus("Pashogus3").setAddress("ereter").Build());
//		
//		ageList.add(new Pashogus("Pashogus1").setAddress("xyz").Build());
//		ageList.add(new Pashogus("Pashogus2").setAddress("xyzds").Build());
//		ageList.add(new Pashogus("Pashogus3").setAddress("fdsfas").Build());
		
		List<String> list = new ArrayList<>(3);
		list.add("Pashogus1");
		list.add("Pashogus2");
		list.add("Pashogus3");
		
		String address="wrewt";
		for(String name : list)
		{
			System.out.println("From Address Thread");
		 Pashogus temp= Master.masterMap.get(name);
		 temp.setAddress(address).Build();
		 Master.masterMap.put(name, temp);
		 System.out.println(Master.masterMap.values());
		}
//		System.out.println(ageList);
//		System.out.println(addressMap.values());
		
		
	}
	
	
	public void address1()
	{
		for(int i=0;i<1000;i++)
		{
			System.out.println("inside address: "+i);
		}
	}

	@Override
	public void run() {
		//address();
		address1();
		
	}
	}


