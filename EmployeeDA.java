import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmployeeDA {
    private Map<String, Employee> employeeMap;

    public EmployeeDA(String empFile) throws FileNotFoundException {
        this.employeeMap = new HashMap<>();
        loadEmployees(empFile);
    }

    private void loadEmployees(String empFile) throws FileNotFoundException {
        try (Scanner file = new Scanner(new FileReader(empFile))) {
            file.nextLine(); // Skip header
            while (file.hasNextLine()) {
                String[] lineArray = file.nextLine().split(",");
                String empNo = lineArray[0].trim();
                String lastName = lineArray[1].trim();
                String firstName = lineArray[2].trim();
                double salary = Double.parseDouble(lineArray[3].trim());
                employeeMap.put(empNo, new Employee(empNo, lastName, firstName, salary));
            }
        }
    }

    public Map<String, Employee> getEmployeeMap() {
        return employeeMap;
    }
}
