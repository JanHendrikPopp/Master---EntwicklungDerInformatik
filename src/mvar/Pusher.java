package mvar;

import java.util.ArrayList;
import java.util.List;

public class Pusher extends Thread {

	private String name;
	private MVar mVar;
	private List<Integer> numbers = new ArrayList<>();
	
	public Pusher(String name, MVar mVar) {
		this.name = name;
		this.mVar = mVar;
		for(int i = 0; i<200; i++) {
		     numbers.add((int)(Math.random()*1000));
		}
	}
	
	public void run() {
		while (true) {
			if (numbers.size() > 0) {
				try {
					int number = numbers.remove(0);
					mVar.put(number);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	public void setNumbers(List<Integer> numbers) {
		this.numbers = numbers;
	}
	
}
