package immunizationrecords;

public class Date implements Comparable<Date> {
  private int year;
  private int month;
  private int day;
 
  public Date(int year, int month, int day) {
    this.year = year;
    this.month = month;
    this.day = day;
  }

  public int getYear() {
    return year;
  }

  public int getMonth() {
    return month;
  }

  public int getDay() {
    return day;
  }

  @Override
  public int compareTo(Date date) {
    if(year < date.year) {
      return -1;
    } else if (year > date.year) {
      return 1;
    } else {
      if(month < date.month) {
        return -1;
      } else if (month > date.month) {
        return 1;
      } else {
        if(day < date.day) {
          return -1;
        } else if (day > date.day) {
          return 1;
        } else {
          return 0;
        }
      }
    }
  }
  
  public String toString() {
    return month + "/" + day + "/" + year;
  }
}
