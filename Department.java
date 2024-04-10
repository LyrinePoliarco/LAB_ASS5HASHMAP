import java.util.ArrayList;
import java.util.List;

public class Department {
    private String code;
    private String name;
    private String location;
    private List<Employee> employees = new ArrayList<>();
    private double totalSalary;

    public Department(String code, String name, String location) {
        this.code = code;
        this.name = name;
        this.location = location;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        totalSalary += employee.getSalary();
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(double totalSalary) {
        this.totalSalary = totalSalary;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Department code: ").append(code).append("\n");
        builder.append("Department name: ").append(name).append("\n");
        builder.append("Department total salary: ").append(String.format("%.2f", totalSalary)).append("\n");
        builder.append("---------------------Details -------------------------\n");
        builder.append("EmpNo\t\tEmployee Name\tSalary\n");
        for (Employee emp : employees) {
            builder.append(emp.getEmpNo()).append("\t\t").append(emp.getLastName()).append(", ").append(emp.getFirstName()).append("\t").append(String.format("%.2f", emp.getSalary())).append("\n");
        }
        return builder.toString();
    }
}
