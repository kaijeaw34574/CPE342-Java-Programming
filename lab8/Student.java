/* The program stores student data and show student data.
 * 
 * Created Pornthep Sangthongkhamsuk ID: 63070503431 
 */

public class Student {
    
    private int id;
    private String firstName;
    private String lastName;
    private double gpa;

    public Student(int id, String firstName, String lastName, double gpa) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return "Student{" + "ID = " + id + ", First name = " + firstName + ", Last name = " + lastName + ", GPA = " + gpa + "}";
    }
}
