package immunizationrecords.immunizations;

import immunizationrecords.Student;
import immunizationrecords.immunizations.Immunization;
import java.util.TreeSet;

public class InfluenzaImmunization extends Immunization {
  
  @Override
  public boolean isSatisfied(Student s) {
    if(s.getAge() >= 6 && s.getAge() <= 59) {
      TreeSet<String> dates = s.getImmunizationDates(getName());
      
    }
    return true;
  }

  @Override
  public String getName() {
    return "Influenza";
  }
}
