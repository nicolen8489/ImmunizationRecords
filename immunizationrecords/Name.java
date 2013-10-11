package immunizationrecords;

public class Name implements Comparable<Name> {
  private String firstName;
  private String lastName;
  
  public Name(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Override
  public int compareTo(Name name) {
    int compare = lastName.compareTo(name.lastName);
    if(compare == 0) {
      return firstName.compareTo(name.firstName);
    }
    return compare;
  }
  
  
}
