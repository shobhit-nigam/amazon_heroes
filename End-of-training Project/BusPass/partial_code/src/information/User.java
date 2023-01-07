package information;

/*
 * entity details for a user (various attributes like empID, name etc... ) 
 * retrieval & storage of stop details 
 * used in upperLayer-to-MiddleLayer data transmission 
 * data transmission to manager/operations
 */

public class User {
	private String firstName;
	private String lastName;
	private int empId;
	private String email;
	private String contactNo;
	private String password;
	private String bloodGroup;
	private String emergencyContactNo;
	private String address;
	
	public User(String firstName, String lastName, int empId, String email, String contactNo, String password,
			String bloodGroup, String emergencyContactNo, String address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.empId = empId;
		this.email = email;
		this.contactNo = contactNo;
		this.password = password;
		this.bloodGroup = bloodGroup;
		this.emergencyContactNo = emergencyContactNo; 
		this.address = address;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public int getEmpId() {
		return empId;
	}
	public String getEmail() {
		return email;
	}
	public String getContactNo() {
		return contactNo;
	}
	public String getPassword() {
		return password;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public String getEmergencyContactNo() {
		return emergencyContactNo;
	}
	public String getAddress() {
		return address;
	}
}
