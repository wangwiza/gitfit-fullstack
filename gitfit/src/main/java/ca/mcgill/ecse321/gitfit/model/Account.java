/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/



// line 9 "model.ump"
// line 96 "model.ump"
public class Account
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Account Attributes
  private String email;
  private String password;
  private String lastName;
  private String firstName;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Account(String aEmail, String aPassword, String aLastName, String aFirstName)
  {
    email = aEmail;
    password = aPassword;
    lastName = aLastName;
    firstName = aFirstName;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setEmail(String aEmail)
  {
    boolean wasSet = false;
    email = aEmail;
    wasSet = true;
    return wasSet;
  }

  public boolean setPassword(String aPassword)
  {
    boolean wasSet = false;
    password = aPassword;
    wasSet = true;
    return wasSet;
  }

  public boolean setLastName(String aLastName)
  {
    boolean wasSet = false;
    lastName = aLastName;
    wasSet = true;
    return wasSet;
  }

  public boolean setFirstName(String aFirstName)
  {
    boolean wasSet = false;
    firstName = aFirstName;
    wasSet = true;
    return wasSet;
  }

  public String getEmail()
  {
    return email;
  }

  public String getPassword()
  {
    return password;
  }

  public String getLastName()
  {
    return lastName;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+
            "email" + ":" + getEmail()+ "," +
            "password" + ":" + getPassword()+ "," +
            "lastName" + ":" + getLastName()+ "," +
            "firstName" + ":" + getFirstName()+ "]";
  }
}