public class Employee {
    private String empNo;
    private String lastName;
    private String firstName;
    private String job;
    private double salary;

    public Employee(String empNo, String lastName, String firstName, String job, double salary) {
        this.empNo = empNo;
        this.lastName = lastName;
        this.firstName = firstName;
        this.job = job;
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

    public String getJob() {
        return job;
    }

    public double getSalary() {
        return salary;
    }
}
