package pashogus.multithread.nonstatic.testing;

public class Addition {

	Boolean Check = true;
	int a;
	int b;
	int c;
	int d;
	int e;

	public int getC() {
		return c;
	}

	public int getD() {
		return d;
	}

	public int getE() {
		return e;
	}

	public Addition(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public void addition() {
		// Acquire lock on this object
		synchronized (this) {
			System.out.println("inside addition");
			System.out.println("inside addition , a/b : " + this.a + "/" + this.b);
			this.c = a + b;
			System.out.println("Post Addition:" + this.c);
			Check = false;
			this.notifyAll();
		}
	}

	public void subraction() {
		// Acquire lock on this object , we can only able to notify the object
		// which has lock
		// on the same object and it is waiting
		synchronized (this) {
			// Additional Condition to prevent from invoking this , when there
			// are many thread waiting
			while (c <= 0) {
				try {
					System.out.println("waiting for Subration");
					wait();
					System.out.println("start to proces Subraction");
					System.out.println("inside subraction , c/b : " + this.c + "/" + this.b);
					System.out.println("Multiplied Value in Subraction method" + this.d);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

		}

		if (this.c > this.b) {
			this.d = this.c - this.b;
		} else {
			this.d = this.b - this.c;
		}

		System.out.println("Post Subraction:" + this.d);

	}

	public void multilication() {
		synchronized (this) {
			/*
			 * if there is no while when calling notifyAll, it will invoke
			 * multiplication as well waiting Waiting for multiplication inside
			 * addition inside addition , a/b : 5/6 Post Addition:11 Start of
			 * Multiplication Multiplied Value in Multiplication method55 start
			 * to proces Subraction inside subraction , c/b : 11/6 Multiplied
			 * Value in Subraction method55 Post Subraction:5
			 * 
			 */
			while (c <= 0) {
				try {
					System.out.println("Waiting for multiplication");
					wait();
					System.out.println("Start of Multiplication");
					this.e = c * a;
					System.out.println("Multiplied Value in Multiplication method" + this.e);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
