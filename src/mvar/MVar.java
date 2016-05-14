package mvar;

import java.util.Optional;

public class MVar<T> {

	Object r = new Object();
	Object w = new Object();
	
	T content;
	boolean empty;
	
	public MVar() {
		empty = true;
	}
	
	public MVar(T value) {
		content = value;
		empty = false;
	}
	
	public T take() throws InterruptedException {
		synchronized(r) {
			while (empty) {
				r.wait();
			}
			synchronized (w) {
				empty = true;
				w.notify();
				return content;
			}
		}
	}
	
	public void put(T value) throws InterruptedException {
		synchronized (w) {
			while (!empty) {
				w.wait();
			}
			synchronized (r) {
				content = value;
				empty = false;
				r.notify();
			}
		}
	}
	
	// Aufgabe 4
	
	public T read() throws InterruptedException {
		synchronized (r) {
			while (empty) {
				r.wait();
			}
			r.notify();
			return content;
		}
	}
	
	public Boolean tryPut(T value) {
		synchronized (w) {
			if (empty) {
				synchronized (r) {
					content = value;
					empty = false;
					r.notify();
				}
			}
			return false;
		}
	}
	
	public Optional<T> tryTake() {
		synchronized (r) {
			if (!empty) {
				synchronized (w) {
					empty = true;
					w.notify();
					return Optional.of(content);
				}
			}
			return Optional.empty();
		}
	}
	
	public T swap(T value) throws InterruptedException {
		synchronized (r) {
			while (empty) {
				r.wait();
			}
			synchronized (w) {
				T c = content;
				content = value;
				r.notify();
				return c;
			}
		}
	}
	
	public T take(long milis) throws InterruptedException {
		synchronized(r) {
			while (empty) {
				wait(milis);
			}
			synchronized (w) {
				empty = true;
				w.notify();
				return content;
			}
		}
	}
	
	public void clear() {
		synchronized (r) {
			if (!empty) {
				synchronized (w) {
					empty = true;
					w.notify();
				}
			}
			r.notify();
		}
	}
	
	
}
