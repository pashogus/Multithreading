package pashogus.multithread.test.synchronous;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AgeClass {
	
	InitalList list;
	
	 AgeClass(InitalList list)
	{
		this.list=list;
	}
	
	LinkedList<Pashogus> ageList= new LinkedList<>();
	Map<String,Pashogus> ageMap = new HashMap<>(3);
	
	
	public void age1() throws InterruptedException
	{
		synchronized(this.list)
		{
			try {
				while(Master.check)
				{
					System.out.println(Thread.currentThread().getName()+"From Age Class : Waiting for Inital List Notification");
				this.list.wait();
				
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for(int i=0;i<10;i++)
			{
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName()+": Log form age thread");
			}
	}
	}
	
	public void age()
	{
		
		synchronized(this.list)
		{
			try {
				while(Master.check)
				{
					System.out.println("From Age Class : Waiting for Inital List Notification");
				this.list.wait();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		ageMap.put("Pashogus1", new Pashogus("Pashogus1").setAge(20).Build());
		ageMap.put("Pashogus2", new Pashogus("Pashogus2").setAge(20).Build());
		ageMap.put("Pashogus3", new Pashogus("Pashogus3").setAge(20).Build());
		
		ageList.add(new Pashogus("Pashogus1").setAge(24).Build());
		ageList.add(new Pashogus("Pashogus2").setAge(25).Build());
		ageList.add(new Pashogus("Pashogus3").setAge(26).Build());
		
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

	
	}	

}
