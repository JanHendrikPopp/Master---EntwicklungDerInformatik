package model;

public class Phil2 extends Thread {
	
	int n;
	Stick sl;
	Stick sr;
	
	Phil2(int number, Stick stickL, Stick strickR) {
		n = number;
		sl = stickL;
		sr = strickR;
	}
	
	private void print(String s) {
		System.out.println(n + " " + s);
	}
	
	public void run() {
		try {
			while(true) {
				print("is thinking");
				sl.take();
				print("took sl");
				if (sr.isAvailable()) {
					sr.take();
					print("took sr");
					print("is eating");
					sl.put();
					sr.put();
				} else {
					print("sr is not available");
					sl.put();
				}
			}
		}
		catch (InterruptedException e) {
		}
	}
	
	public static void main(String[] a) {
		Stick s1 = new Stick();
		Stick s2 = new Stick();
		Stick s3 = new Stick();
		Stick s4 = new Stick();
		Stick s5 = new Stick();
		
		new Phil2(1, s1, s2).start();
		new Phil2(2, s2, s3).start();
		new Phil2(3, s3, s4).start();
		new Phil2(4, s4, s5).start();
		// deadlock
		new Phil2(5, s5, s1).start();
		// withoud deadlock
		//new Phil(5, s1, s5).start();
		
	}
}
