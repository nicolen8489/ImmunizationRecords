package immunizationrecords.immunizations;

import immunizationrecords.Date;
import immunizationrecords.Student;
import java.util.TreeSet;

public class DTaPImmunization extends Immunization {

  @Override
  public boolean isSatisfied(Student s) {
    if(s.getAge() >= 12 && s.getAge() < 83) {
      TreeSet<Date> dates = s.getImmunizationDates(getName());
      if(dates.size() == 4) {
        if(s.getAgeAt(dates.last()) >= 48) {
          return true;
        }
      } else if (dates.size() == 5) {
        return true;
      }
      return false;
    }
    return true;
  }

  @Override
  public String getName() {
    return "DTaP";
  }
}
