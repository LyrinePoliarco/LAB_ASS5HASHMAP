import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class DepartmentDA {
    private HashMap<String, Department> departmentMap;

    public DepartmentDA() throws FileNotFoundException {
        departmentMap = new HashMap<>();
        loadDepartments("dep.csv", "deptemp.csv");
    }

    private void loadDepartments(String depFile, String salaryFile) throws FileNotFoundException {
        // Load department data
        Scanner deptScanner = new Scanner(new FileReader(depFile));
        deptScanner.nextLine(); // Skip header
        while (deptScanner.hasNextLine()) {
            String rawLine = deptScanner.nextLine();
            String[] lineArray = rawLine.split(",");
            if (lineArray.length == 3) {
                String depCode = lineArray[0].trim();
                String depName = lineArray[1].trim();
                String location = lineArray[2].trim();
                Department department = new Department(depCode, depName, location);
                departmentMap.put(depCode, department);
            }
        }
        deptScanner.close();

        // Associate employees with departments
        Scanner salaryScanner = new Scanner(new FileReader(salaryFile));
        salaryScanner.nextLine(); // Skip header
        while (salaryScanner.hasNextLine()) {
            String rawLine = salaryScanner.nextLine();
            String[] lineArray = rawLine.split(",");
            if (lineArray.length == 3) {
                String deptCode = lineArray[0].trim();
                String empNo = lineArray[1].trim();
                double salary = Double.parseDouble(lineArray[2].trim()); // Assuming salary is in the third element
                Employee employee = new Employee(empNo, "", "", salary); // Create temporary Employee object with salary only
                Department department = departmentMap.get(deptCode);
                if (department != null) {
                    department.addEmployee(employee);
                }
            }
        }
        salaryScanner.close();
    }

    public HashMap<String, Department> getDepartmentMap() {
        return departmentMap;
    }
}
