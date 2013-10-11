package immunizationrecords.immunizations;

import immunizationrecords.Range;
import immunizationrecords.Requirement;
import immunizationrecords.Student;
import java.util.ArrayList;
import java.util.TreeMap;

public abstract class Immunization {
  
  private TreeMap<Range, ArrayList<Requirement>> details;
  
  public abstract boolean isSatisfied(Student s);
  
  public abstract String getName();
  
}
