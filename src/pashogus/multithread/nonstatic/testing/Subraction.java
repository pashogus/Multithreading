package pashogus.multithread.nonstatic.testing;

public class Subraction implements Runnable {

	int a;
	int b;
   volatile int c=2;
   

	public int getC() {
	return c;
}



	public Subraction(int a, int b) {
		this.a = a;
		this.b = b;
	}


	@Override
	public void run() {
		subraction();
		
	}
	
	public void subraction()
	{
		synchronized(this)
		{
			try {
				wait();
				System.out.println("inside subraction , a/b : "+this.a+"/"+this.b);
				if(this.a>this.b)
				{
				this.c=this.a-this.b;
				}
				else
				{
					this.c=this.b-this.a;
				}
				System.out.println("Post Subraction:" + this.c);
				}
			 catch (InterruptedException e) {

				e.printStackTrace();
			}
		
	}
	
}
}

	
