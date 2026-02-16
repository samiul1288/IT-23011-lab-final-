public class Student {

    private int id;
    private String departmentName;
    private int numberOfStudents;

    public Student() {
    }

    public Student(String departmentName, int numberOfStudents) {
        this.departmentName = departmentName;
        this.numberOfStudents = numberOfStudents;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }
}
