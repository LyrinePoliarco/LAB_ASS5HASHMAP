import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmployeeDA {
    private Map<String, Employee> employeeMap;

    public EmployeeDA(String employeeFile) throws FileNotFoundException {
        this.employeeMap = new HashMap<>();
        loadEmployees(employeeFile);
    }

    private void loadEmployees(String employeeFile) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("emp.csv"));
        while (scanner.hasNextLine()) {
            String[] fields = scanner.nextLine().split(",");
            String empNo = fields[0].trim();
            String lastName = fields[1].trim();
            String firstName = fields[2].trim();
            String job = fields[3].trim();
            double salary = Double.parseDouble(fields[4].trim());
            Employee employee = new Employee(empNo, lastName, firstName, job, salary);
            employeeMap.put(empNo, employee);
        }
        scanner.close();
    }

    public Map<String, Employee> getEmployeeMap() {
        return employeeMap;
    }
}
