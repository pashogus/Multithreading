package pashogus.multithread.test.non.synchronous;

public class Pashogus {

	String name;
	int age;
	String address;
	
	public Pashogus(String name)
	{
		this.name=name;
	}
	
	
	
	public String getName() {
		return name;
	}



	public Pashogus setName(String name) {
		this.name = name;
		return this;
	}



	public int getAge() {
		return age;
	}



	public Pashogus setAge(int age) {
		this.age = age;
		return this;
	}



	public String getAddress() {
		return address;
	}



	public Pashogus setAddress(String address) {
		this.address = address;
		return this;
	}



	private Pashogus() {
		// TODO Auto-generated constructor stub
	}



	public Pashogus Build()
	{
		Pashogus pashogus = new Pashogus();
		pashogus.address=this.address;
		pashogus.age=this.age;
		pashogus.name=this.name;
		return pashogus;
		
	}



	@Override
	public String toString() {
		return "Pashogus [name=" + name + ", age=" + age + ", address=" + address + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pashogus other = (Pashogus) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
}
