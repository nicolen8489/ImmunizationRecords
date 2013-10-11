package immunizationrecords;

/*
 * The lower bound is inclusive.
 * The upper bound is exclusive.
 */
public class Range {
  private int bottom;
  private int top;
  private int incrementType;
  public static final int MONTHS = 0;
  public static final int YEARS = 1;
  
  public Range(int bottom, int top, int incrementType) {
    this.top = top;
    this.bottom = bottom;
    this.incrementType = incrementType;
  }
  
  public boolean isInRange(int ageInMonths) {
    if(incrementType == Range.YEARS) {
      if(ageInMonths >= bottom * 12 && ageInMonths < top * 12) {
        return true;
      }
    } else {
      if(ageInMonths >= bottom && ageInMonths < top) {
        return true;
      }
    }
    return false;    
  }
}
