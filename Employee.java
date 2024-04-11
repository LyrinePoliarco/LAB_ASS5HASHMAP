public class Employee {
    private String empNo;
    private String lastName;
    private String firstName;
    private double salary;

    public Employee(String empNo, String lastName, String firstName, double salary) {
        this.empNo = empNo;
        this.lastName = lastName;
        this.firstName = firstName;
        this.salary = salary;
    }

    public String getEmpNo() {
        return empNo;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {

        throw new UnsupportedOperationException("Unimplemented method 'setSalary'");
    }
}