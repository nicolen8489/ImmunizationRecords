package immunizationrecords.immunizations;

import immunizationrecords.Date;
import immunizationrecords.Student;
import java.util.TreeSet;

public class MMRImmunization extends Immunization {

  @Override
  public boolean isSatisfied(Student s) {
    if(s.getAge() >= 15) {
      TreeSet<Date> dates = s.getImmunizationDates(getName());
      if(s.getAgeAt(dates.last()) >= 12) {
        return true;
      }
      return false;
    }
    return true;
  }

  @Override
  public String getName() {
    return "MMR";
  }
}
