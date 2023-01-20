package managers;

import customExceptions.*;

public class BaseManager {
	
	public static BaseManager getInstance() throws AppException {
		throw new AppException("Class not implemented");
	}

}
