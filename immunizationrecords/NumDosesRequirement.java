
package immunizationrecords;

public class NumDosesRequirement implements Requirement {
  
  private int numDoses;
  
  public NumDosesRequirement(int num) {
    numDoses = num;
  }

  @Override
  public boolean isMet(Student s, String immunization) {
    if(s.getImmunizationDates(immunization).size() >= numDoses) {
      return true;
    }
    return false;
  }
  
}
