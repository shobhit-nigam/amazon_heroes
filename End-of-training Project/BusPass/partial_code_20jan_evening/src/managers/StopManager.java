package managers;

import information.Stop;
import customExceptions.*;

public class StopManager {
	
	private static StopManager stopManager;
	
	public static StopManager getInstance() {
		if(stopManager == null) {
			stopManager = new StopManager();
		}
		return stopManager;
	}
	
	public boolean displayAllStops() throws AppException {
		
		return true;
	}
	

}
