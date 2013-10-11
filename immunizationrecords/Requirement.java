package immunizationrecords;

public interface Requirement {
  public boolean isMet(Student s, String immunization);
}
