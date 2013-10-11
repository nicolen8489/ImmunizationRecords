package immunizationrecords.immunizations;

import immunizationrecords.Student;

public class HibImmunization extends Immunization {

  @Override
  public boolean isSatisfied(Student s) {
    if(s.getAge() >= 2 && s.getAge() <= 11) {
      if(s.getImmunizationDates(getName()).size() >= 2) {
        return true;
      }
      return false;
    } else if(s.getAge() >= 12 && s.getAge() <= 59) {
      if(s.getAgeAt(s.getImmunizationDates(getName()).last()) >= 12) {
        return true;
      }
      return false;
    }
    return true;
  }

  @Override
  public String getName() {
    return "Hib";
  }
  
}
