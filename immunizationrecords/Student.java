package immunizationrecords;

import java.util.Calendar;
import java.util.TreeMap;
import java.util.TreeSet;

public class Student {

  private Name name;
  private Date birthday;
  // <Immunization, Set<Dates>>
  private TreeMap<String, TreeSet<Date>> immunizations = new TreeMap<String, TreeSet<Date>>();;
  private boolean upToDate = false;
  private int ageInMonths = -1;

  public Student(Name name, Date birthday) {// int birthYear, int birthMonth, int birthDay) {
    this.name = name;
    this.birthday = birthday;
  }

  public Student(Name name, Date birthday, int ageInMonths) {
    super();
    this.ageInMonths = ageInMonths;
  }

  public void updateImmunization(String immunization, Date date) {
    immunizations.get(immunization).add(date);
  }
  
  public void setImmunizations(TreeSet<String> immuns) {
    for(String immun : immuns) {
      immunizations.put(immun, new TreeSet<Date>());
    }
  }
  
  public TreeSet<Date> getImmunizationDates(String immunization) {
    return immunizations.get(immunization);
  }

  public Name getName() {
    return name;
  }
  
  public Date getBirthday() {
    return birthday;
  }

  public void setName(Name name) {
    this.name = name;
  }

  public boolean isUpToDate() {
    return upToDate;
  }

  public void update() {
    
    int age = calculateAgeInMonths(new Date(Calendar.getInstance().get(Calendar.YEAR),
            Calendar.getInstance().get(Calendar.MONTH) + 1,
            Calendar.getInstance().get(Calendar.DATE)));
    if (age != ageInMonths) {
      ageInMonths = age;
      updateImmunizations();
    }
  }

  private int calculateAgeInMonths(Date d) {
    int yearx = d.getYear() - birthday.getYear();
    int monthx = d.getMonth() - birthday.getMonth();
    if(monthx < 0) {
      yearx -= 1;
      monthx = 12 + monthx;
    }
    int dayx = d.getDay() - birthday.getDay();
    if(dayx < 0) {
      monthx -= 1;
    }
    return yearx * 12 + monthx;
  }

  private void updateImmunizations() {
  }

  /**
   * Returns the age in months
   */
  public int getAge() {
    return ageInMonths;
  }
  
  public int getAgeAt(Date d) {
    return calculateAgeInMonths(d);
  }
  
  public String studentDataString() {
    String data = name.getFirstName() + "," + name.getLastName() + "," + birthday;
    for(String immun : immunizations.keySet()) {
      data += "," + immun;
      for(Date date : immunizations.get(immun)) {
        data += "-" + date;
      }
    }
    return data;
  }
}
