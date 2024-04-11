import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class EmployeeDA {
    public HashMap<String, Employee> employeeMap;

    public EmployeeDA() {
        employeeMap = new HashMap<>(); // Initialize the employeeMap
    }

    public HashMap<String, Employee> getEmployeeMap() {
        return employeeMap;
    }

    public void loadEmployees(String empFile, String salaryFile) throws FileNotFoundException {
        // Load employee data
        Scanner empScanner = new Scanner(new FileReader(empFile));
        empScanner.nextLine(); // Skip header
        while (empScanner.hasNextLine()) {
            String rawLine = empScanner.nextLine();
            String[] lineArray = rawLine.split(",");
            if (lineArray.length == 3) {
                String empNo = lineArray[0].trim();
                String lastName = lineArray[1].trim();
                String firstName = lineArray[2].trim();
                // Assume the job information is not needed for now
                employeeMap.put(empNo, new Employee(empNo, lastName, firstName, 0));
            }
        }
        empScanner.close();

        // Load salary data and update employee salaries
        Scanner salaryScanner = new Scanner(new FileReader("deptemp.csv"));
        salaryScanner.nextLine(); // Skip header
        while (salaryScanner.hasNextLine()) {
            String rawLine = salaryScanner.nextLine();
            String[] lineArray = rawLine.split(",");
            if (lineArray.length == 3) {
                String empNo = lineArray[1].trim(); // Use empNo from deptemp.csv to identify employee
                double salary = Double.parseDouble(lineArray[2].trim());
                Employee employee = employeeMap.get(empNo);
                if (employee != null) {
                    employee.setSalary(salary);
                }
            }
        }
        salaryScanner.close();
    }
}
