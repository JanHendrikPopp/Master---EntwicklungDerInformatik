package model;

public class Phil extends Thread {

	int n;
	Object sl;
	Object sr;
	
	Phil(int number, Object stickL, Object strickR) {
		n = number;
		sl = stickL;
		sr = strickR;
	}
	
	public void run() {
		while(true) {
			System.out.println(n + " is thinking" );
			synchronized (sl) {
				synchronized (sr) {
					System.out.println(n + " is eating");
				}
			}
		}
	}
	
	public static void main(String[] a) {
		Object s1 = new Object();
		Object s2 = new Object();
		Object s3 = new Object();
		Object s4 = new Object();
		Object s5 = new Object();
		
		new Phil(1, s1, s2).start();
		new Phil(2, s2, s3).start();
		new Phil(3, s3, s4).start();
		new Phil(4, s4, s5).start();
		// deadlock
		new Phil(5, s5, s1).start();
		// withoud deadlock
		//new Phil(5, s1, s5).start();
		
	}
}
