package model;

public class Stick {

	boolean available;
	
	Stick () {
		available = true;
	}
	
	synchronized void take() throws InterruptedException {
		if (!available) {
			wait();
		}
		available = false;
	}
	
	synchronized void put() {
		available = true;
		notify();
	}
	
	synchronized boolean isAvailable() {
		return available;
	}
}
