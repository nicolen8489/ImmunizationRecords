package immunizationrecords;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class ImmunizationRecords {

  public static TreeMap<Name, Student> currentStudents;
  private TreeMap<Name, Student> disenrolledStudents;
  private TreeSet<Name> missingImmunizations;

  public ImmunizationRecords() {
    currentStudents = new TreeMap<>();
    disenrolledStudents = new TreeMap<>();
    missingImmunizations = new TreeSet<>();
  }

  private void run() {
    readMissingImmunizations();
    readCurrentStudents();
    readDisenrolledStudents();
    new ImmunizationRecordsWindow().setVisible(true);
  }

  private void readMissingImmunizations() {
    try {
      Scanner scn = new Scanner(new File("C:/Documents/Immunizations/StudentsMissingImmunizations.csv"));
      while (scn.hasNextLine()) {
        String[] student = scn.nextLine().split(",");
        missingImmunizations.add(new Name(student[0], student[1]));
      }
    } catch (FileNotFoundException ex) {
      System.out.println("Unable to read C:/Documents/Immunizations/StudentsMissingImmunizations.csv");
    }
  }

  private void readCurrentStudents() {
    try {
      Scanner scn = new Scanner(new File("C:/Documents/Immunizations/CurrentStudents.csv"));
      while (scn.hasNextLine()) {
        String line = scn.nextLine();
        String[] studentData = line.split(",");
        String[] dob = studentData[2].split("/");
        Student currentStudent = new Student(new Name(studentData[0], studentData[1]),
                new Date(Integer.parseInt(dob[2]), Integer.parseInt(dob[1]), Integer.parseInt(dob[0])));
        currentStudent.setImmunizations(RequiredImmunizations.getImmunizationTypes(currentStudent.getAge()));
        for (int i = 3; i < studentData.length; i++) {
          String[] immun = studentData[i].split("-");
          for (int j = 1; j < immun.length; j++) {
            String[] date = immun[j].split("/");
            currentStudent.updateImmunization(immun[0], 
                    new Date(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0])));
          }
        }
        currentStudents.put(currentStudent.getName(), currentStudent);
        boolean isMissing = missingImmunizations.contains(currentStudent.getName());
        if (currentStudent.isUpToDate() && isMissing) {
          missingImmunizations.remove(currentStudent.getName());
        } else if (!currentStudent.isUpToDate() && !isMissing) {
          missingImmunizations.add(currentStudent.getName());
        }
      }
    } catch (FileNotFoundException ex) {
      System.out.println("Unable to read C:/Documents/Immunizations/CurrentStudents.csv");
    }
  }

  private void readDisenrolledStudents() {
    try {
      Scanner scn = new Scanner(new File("C:/Documents/Immunizations/DisenrolledStudents.csv"));
      while (scn.hasNextLine()) {
        String line = scn.nextLine();
        String[] studentData = line.split(",");
        String[] dob = studentData[2].split("/");
        Student currentStudent = new Student(new Name(studentData[0], studentData[1]),
                new Date(Integer.parseInt(dob[2]), Integer.parseInt(dob[1]), Integer.parseInt(dob[0])));
        currentStudent.setImmunizations(RequiredImmunizations.getImmunizationTypes(currentStudent.getAge()));
        for (int i = 3; i < studentData.length; i++) {
          String[] immun = studentData[i].split("-");
          for (int j = 1; j < immun.length; j++) {
            String[] date = immun[j].split("/");
            currentStudent.updateImmunization(immun[0], 
                    new Date(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0])));
          }
        }
        currentStudent.update();
        disenrolledStudents.put(currentStudent.getName(), currentStudent);
      }
    } catch (FileNotFoundException ex) {
      System.out.println("Unable to read C:/Documents/Immunizations/DisenrolledStudents.csv");
    }
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    ImmunizationRecords records = new ImmunizationRecords();
    records.run();
  }
}
