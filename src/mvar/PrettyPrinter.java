package mvar;

import java.util.List;

public class PrettyPrinter {

	private String startValue = "";
	
	public void print(String string) {
		printLn(string);
	}
	
	public void printPushers(List<Pusher> pushers) {
		Integer overAll = 0;
		for(int i = 0; i<pushers.size(); i++) {
		    Pusher pusher = pushers.get(i);
		    int count = 0;
		    for (int j = 0; j<pusher.getNumbers().size(); j++) {
		    	count = count + pusher.getNumbers().get(j);
		    }
		    overAll = overAll + count;
			printLn(pusher.getName() + ": " + String.valueOf(count));
		}
		printLn("Overall pushers: " + String.valueOf(overAll));
	}
	
	public void printPullers(List<Puller> pullers) {
		Integer overAll = 0;
		for(int i = 0; i<pullers.size(); i++) {
		    Puller puller = pullers.get(i);
		    int count = 0;
		    for (int j = 0; j<puller.getNumbers().size(); j++) {
		    	count = count + puller.getNumbers().get(j);
		    }
		    overAll = overAll + count;
			printLn(puller.getName() + ": " + String.valueOf(count));
		}
		printLn("Overall pullers: " + String.valueOf(overAll));
	}
	
	public void compare(List<Puller> pullers, List<Pusher> pushers) {
		Integer overAllPullers = 0;
		for(int i = 0; i<pullers.size(); i++) {
		    Puller puller = pullers.get(i);
		    int count = 0;
		    for (int j = 0; j<puller.getNumbers().size(); j++) {
		    	count = count + puller.getNumbers().get(j);
		    }
		    overAllPullers = overAllPullers + count;
		}
		Integer overAllPushers = 0;
		for(int i = 0; i<pushers.size(); i++) {
		    Pusher pusher = pushers.get(i);
		    int count = 0;
		    for (int j = 0; j<pusher.getNumbers().size(); j++) {
		    	count = count + pusher.getNumbers().get(j);
		    }
		    overAllPushers = overAllPushers + count;
		}
		if (startValue.isEmpty()) {
			startValue = "StartValue: " + String.valueOf(overAllPullers + overAllPushers);
		}
		printLn(startValue);
		printLn("Overall: " + String.valueOf(overAllPullers + overAllPushers));
		
		
	}
	
	private void printLn(String string) {
		System.out.println(string);
	}
}
