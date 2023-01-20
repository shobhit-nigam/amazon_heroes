package managers;

public class UserManager extends BaseManager{
	
	private static UserManager userManager;

	public static UserManager getInstance() {
		if (userManager == null) {
			userManager = new UserManager();
		}
		return userManager;
	}

	public boolean isValidUserPassword(int userId, String existingPassword) {
		// has to be coded
		return false;
	}

}
