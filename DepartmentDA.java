import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DepartmentDA {
    private Map<String, Department> departmentMap;

    public DepartmentDA(String departmentFile) throws FileNotFoundException {
        this.departmentMap = new HashMap<>();
        loadDepartments(departmentFile);
    }

    private void loadDepartments(String departmentFile) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("dep.csv"));
        while (scanner.hasNextLine()) {
            String[] fields = scanner.nextLine().split(",");
            String deptCode = fields[0].trim();
            String deptName = fields[1].trim();
            String location = fields[2].trim();
            Department department = new Department(deptCode, deptName, location);
            departmentMap.put(deptCode, department);
        }
        scanner.close();
    }

    public Map<String, Department> getDepartmentMap() {
        return departmentMap;
    }
}
