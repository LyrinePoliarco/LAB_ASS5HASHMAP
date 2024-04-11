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
        if (employee != null) {
            employees.add(employee);
            totalSalary += employee.getSalary(); // Siguraduhing hindi null ang employee bago gamitin ang getSalary() method
        }
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

}
