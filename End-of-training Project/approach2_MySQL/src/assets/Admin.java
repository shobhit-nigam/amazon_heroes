package assets;

/**
 * The class Admin is a Singleton implementation which contains hard-coded Admin Login Credentials
 * and is the single place where Admin credentials are defined.
 * It supports only storage and retrieval of Admin Credentials, and acts as POJO.
 **/

public class Admin {

  private static Admin admin;

  private String adminId;
  private String password;

  private Admin() {
  }

  public static Admin getAdminInstance() {
    if (admin == null) {
      admin = new Admin();

      admin.adminId = "ADMIN";
      admin.password = "ADMIN";
    }
    return admin;
  }

  public String getAdminId() {
    return adminId;
  }

  public String getPassword() {
    return password;
  }
}