package pashogus.multithread.test.synchronous;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AddressClass {

	InitalList list;
	
	AddressClass(InitalList list)
	{
		this.list=list;
	}
	LinkedList<Pashogus> ageList= new LinkedList<>();
	Map<String,Pashogus> addressMap = new HashMap<>(3);
	
	

	public void address1() throws InterruptedException
	{
		
	synchronized(this.list)
	{
		try {
			while(Master.check)
			{
				System.out.println(Thread.currentThread().getName()+"From address Class : Waiting for Inital List Notification");
				this.list.wait();
				
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0;i<100;i++)
		{
			System.out.println(Thread.currentThread().getName()+": Log form address thread");
		}
	}
	}
	
	public void address()
	{
		
	synchronized(this.list)
	{
		try {
			while(Master.check)
			{
				System.out.println("From address Class : Waiting for Inital List Notification");
				this.list.wait();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addressMap.put("Pashogus1", new Pashogus("Pashogus1").setAddress("fsdaf").Build());
		addressMap.put("Pashogus2", new Pashogus("Pashogus2").setAddress("fsdafas").Build());
		addressMap.put("Pashogus3", new Pashogus("Pashogus3").setAddress("ereter").Build());
		
		ageList.add(new Pashogus("Pashogus1").setAddress("xyz").Build());
		ageList.add(new Pashogus("Pashogus2").setAddress("xyzds").Build());
		ageList.add(new Pashogus("Pashogus3").setAddress("fdsfas").Build());
		
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
	}

}
