/* The program sort student data by the method of sorting ID, First name, Last name, or GPA. 
 * 
 * Created Pornthep Sangthongkhamsuk ID: 63070503431 
 */

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {
    
    private String sortBy;

    public StudentComparator(String sortBy) {
        this.sortBy = sortBy;
    }

    @Override
    public int compare(Student s1, Student s2) {
        switch (sortBy) {
            case "id":
                return Integer.compare(s1.getId(), s2.getId());
            case "firstName":
                return s1.getFirstName().compareTo(s2.getFirstName());
            case "lastName":
                return s1.getLastName().compareTo(s2.getLastName());
            case "gpa":
                return Double.compare(s1.getGpa(), s2.getGpa());
            default:
                throw new IllegalArgumentException("Invalid sort criteria");
        }
    }
}
