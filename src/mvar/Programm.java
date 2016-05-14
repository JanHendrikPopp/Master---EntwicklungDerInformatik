package mvar;

import java.util.ArrayList;
import java.util.List;

public class Programm extends Thread {

	public static final PrettyPrinter PRINTER = new PrettyPrinter();
	
	private MVar mVar;
	private List<Pusher> pushers = new ArrayList<>();
	private List<Puller> pullers = new ArrayList<>();
	
	public Programm() {
		mVar = new MVar<Integer>();
		pushers.add(new Pusher("Pusher1", mVar));
		pushers.add(new Pusher("Pusher2", mVar));
		pushers.add(new Pusher("Pusher3", mVar));
		pushers.add(new Pusher("Pusher4", mVar));
		pushers.add(new Pusher("Pusher5", mVar));
		pushers.add(new Pusher("Pusher6", mVar));
		pushers.add(new Pusher("Pusher7", mVar));
		
		pullers.add(new Puller("Puller1", mVar));
		pullers.add(new Puller("Puller2", mVar));
		pullers.add(new Puller("Puller3", mVar));
		pullers.add(new Puller("Puller4", mVar));
		pullers.add(new Puller("Puller5", mVar));
		pullers.add(new Puller("Puller6", mVar));
		pullers.add(new Puller("Puller7", mVar));
		
	}
	
	public void run() {
		while(true) {
			PRINTER.printPushers(pushers);
			PRINTER.printPullers(pullers);
			PRINTER.compare(pullers, pushers);
		}
	}
	
	public MVar getmVar() {
		return mVar;
	}


	public void setmVar(MVar mVar) {
		this.mVar = mVar;
	}


	public List<Pusher> getPushers() {
		return pushers;
	}


	public void setPushers(List<Pusher> pushers) {
		this.pushers = pushers;
	}


	public List<Puller> getPullers() {
		return pullers;
	}


	public void setPullers(List<Puller> pullers) {
		this.pullers = pullers;
	}


	public static void main(String[] args) {
		Programm programm = new Programm();
		PRINTER.print("Pushers initialited: ");
		PRINTER.printPushers(programm.getPushers());
		PRINTER.print("Pullers initialited: ");
		PRINTER.printPullers(programm.getPullers());
		PRINTER.compare(programm.getPullers(), programm.getPushers());
		
		for(int i = 0; i<programm.getPushers().size(); i++) {
		    programm.getPushers().get(i).start();
		}
		
		for(int i = 0; i<programm.getPullers().size(); i++) {
		    programm.getPullers().get(i).start();
		}
		
		programm.start();

	}

}
