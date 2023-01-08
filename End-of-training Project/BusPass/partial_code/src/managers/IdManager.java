package managers;

import customExceptions.*;

public class IdManager extends BaseManager{
	private static IdManager idManager;
	
	public static IdManager getInstance() {
		if (idManager == null) {
			idManager = new IdManager();
		}
		return idManager;
	}
	
	public int getNewId(String objectName) throws AppException {
		// code to generate newID
		
		// change the following return value, once id-generator-code is implemented 
		return 100;
	}

}
