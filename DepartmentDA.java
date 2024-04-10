import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DepartmentDA {
    private Map<String, Department> departmentMap;

    public DepartmentDA(String depFile, String empFile) throws FileNotFoundException {
        this.departmentMap = new HashMap<>();
        loadDepartments(depFile);
        loadEmployees(empFile);
    }

   private void loadDepartments(String depFile) throws FileNotFoundException {
    try (Scanner file = new Scanner(new FileReader(depFile))) {
        while (file.hasNextLine()) {
            String[] lineArray = file.nextLine().split(",");
            if (lineArray.length == 3) { // Tiyakin na tama ang bilang ng mga bahagi ng bawat linya
                String code = lineArray[0].trim();
                String name = lineArray[1].trim();
                String location = lineArray[2].trim();
                departmentMap.put(code, new Department(code, name, location));
            } else {
                System.out.println("Invalid line format: " + Arrays.toString(lineArray));
            }
        }
    }
}

    private void loadEmployees(String empFile) throws FileNotFoundException {
        EmployeeDA employeeDA = new EmployeeDA(empFile);
        Map<String, Employee> employeeMap = employeeDA.getEmployeeMap();

        try (Scanner file = new Scanner(new FileReader(empFile))) {
            file.nextLine(); // Skip header
            while (file.hasNextLine()) {
                String[] lineArray = file.nextLine().split(",");
                String deptCode = lineArray[0].trim();
                String empNo = lineArray[1].trim();
                departmentMap.get(deptCode).addEmployee(employeeMap.get(empNo));
            }
        }
    }

    public Map<String, Department> getDepartmentMap() {
        return departmentMap;
    }
}