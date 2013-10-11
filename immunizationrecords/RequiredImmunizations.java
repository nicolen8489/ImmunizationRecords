package immunizationrecords;

import java.util.TreeMap;
import java.util.TreeSet;

public class RequiredImmunizations {
  private static TreeMap<String, TreeSet<Range>> immunRanges = new TreeMap<String, TreeSet<Range>>();
  
  static {
    // DTaP
    TreeSet<Range> ranges = new TreeSet<Range>();
    immunRanges.put("DTaP", ranges);
    ranges.add(new Range(1, 7, Range.YEARS));
    
    // Polio
    ranges = new TreeSet<Range>();
    immunRanges.put("Polio", ranges);
    ranges.add(new Range(1, 7, Range.YEARS));
    
    // MMR
    ranges = new TreeSet<Range>();
    immunRanges.put("MMR", ranges);
    ranges.add(new Range(15, Integer.MAX_VALUE, Range.MONTHS));
    
    // HIB
    ranges = new TreeSet<Range>();
    immunRanges.put("Hib", ranges);
    ranges.add(new Range(2, 12, Range.MONTHS));
    ranges.add(new Range(12, 60, Range.MONTHS));
    
    // Varicella
    ranges = new TreeSet<Range>();
    immunRanges.put("Varicella", ranges);
    ranges.add(new Range(19, Integer.MAX_VALUE, Range.MONTHS));
    
    // PCV/PPV
    ranges = new TreeSet<Range>();
    immunRanges.put("Pneumococcal", ranges);
    ranges.add(new Range(2, 12, Range.MONTHS));
    ranges.add(new Range(12, 60, Range.MONTHS));
    

  }
  
  public static TreeSet<String> getImmunizationTypes(int age) {
    TreeSet<String> immunizations = new TreeSet<String>();
    for(String immun : immunRanges.keySet()) {
      for(Range range : immunRanges.get(immun)) {
        if(range.isInRange(age)) {
          immunizations.add(immun);
          break;
        }
      }
    }
    return immunizations;
  }
}
