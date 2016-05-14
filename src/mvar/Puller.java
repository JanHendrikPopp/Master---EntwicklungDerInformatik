package mvar;

import java.util.ArrayList;
import java.util.List;

public class Puller extends Thread {

	private String name;
	private MVar<?> mVar;
	private boolean running;
	private List<Integer> numbers = new ArrayList<>();
	
	public Puller(String name, MVar<?> mVar) {
		this.name = name;
		this.mVar = mVar;
	}
	
	public void run() {
		while (true) {
			try {
				numbers.add((Integer) mVar.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	public void setNumbers(List<Integer> numbers) {
		this.numbers = numbers;
	}
	
}
