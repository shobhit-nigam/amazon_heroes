package information;

/*
 * hard coded Admin Login credentials 
 * storage & retrieval of Admin credentials 
 * Singleton implementation
 */

public class Admin {
	private static Admin adminobj;
	
	private String adminID;
	private String adminPassword;
	
	public static Admin getAdminobjInstance() {
		if(adminobj == null) {
			adminobj = new Admin();
			adminobj.adminID = "admin";
			adminobj.adminPassword = "admin@123";
		}
		return adminobj;
	}
	
	public String getAdminID() {
		return adminID;
	}
	
	public String getAdminPassword() {
		return adminPassword;
	}
	
	

}
