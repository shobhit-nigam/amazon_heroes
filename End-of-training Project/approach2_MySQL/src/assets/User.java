package assets;

/**
 * The class User acts as a POJO which holds entity details for a User.
 * It supports retrieval and storage of Stop details. It is used in Upper Layer-to-Middle
 * Layer/Operations package-to-Managers package data transmission.
 * Employee ID is the Unique ID for instances of this class.
 **/

public class User {

  private int employeeId;
  private String firstName;
  private String lastName;
  private String email;
  private String contactNo;
  private String emergencyContactNo;
  private String emergencyContactName;
  private String bloodGroup;
  private String password;

  public User(int employeeId, String fName, String lName, String email,
              String contactNo, String emergencyContactNumber,
              String emergencyContactName, String bloodGroup,
              String password) {
    this.employeeId = employeeId;
    this.firstName = fName;
    this.lastName = lName;
    this.email = email;
    this.contactNo = contactNo;
    this.emergencyContactNo = emergencyContactNumber;
    this.emergencyContactName = emergencyContactName;
    this.bloodGroup = bloodGroup;
    this.password = password;
  }

  public int getEmployeeId() {
    return employeeId;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }

  public String getContactNo() {
    return contactNo;
  }

  public String getEmergencyContactNo() {
    return emergencyContactNo;
  }

  public String getEmergencyContactName() {
    return emergencyContactName;
  }

  public String getBloodGroup() {
    return bloodGroup;
  }

  public String getPassword() {
    return password;
  }
}