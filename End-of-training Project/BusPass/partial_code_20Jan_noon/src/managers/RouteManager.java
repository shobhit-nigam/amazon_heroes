package managers;

import customExceptions.AppException;

public class RouteManager extends BaseManager{
	private static RouteManager routeManager;

	public static RouteManager getInstance() {
		if (routeManager == null) {
			routeManager = new RouteManager();
		}
		return routeManager;
	}
	
	public boolean displayAllRoutes() throws AppException {
		
		// fetch data from database/dataSource
		
		return true;
	}

}
