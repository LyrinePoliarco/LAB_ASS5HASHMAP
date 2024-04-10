import java.util.HashMap;
import java.util.Map;

public class Department {
    private String deptCode;
    private String deptName;
    private String location;
    private double depTotalSalary;
    private Map<String, Employee> employeeMap;

    public Department(String deptCode, String deptName, String location) {
        this.deptCode = deptCode;
        this.deptName = deptName;
        this.location = location;
        this.depTotalSalary = 0.0;
        this.employeeMap = new HashMap<>();
    }

    public String getDeptCode() {
        return deptCode;
    }

    public String getDeptName() {
        return deptName;
    }

    public String getLocation() {
        return location;
    }

    public double getDepTotalSalary() {
        return depTotalSalary;
    }

    public void setDepTotalSalary(double depTotalSalary) {
        this.depTotalSalary = depTotalSalary;
    }

    public Map<String, Employee> getEmployeeMap() {
        return employeeMap;
    }

    public void addEmployee(Employee employee) {
        employeeMap.put(employee.getEmpNo(), employee);
        depTotalSalary += employee.getSalary();
    }
}
