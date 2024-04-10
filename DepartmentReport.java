import java.io.FileNotFoundException;
import java.util.Map;

public class DepartmentReport {
    public static void main(String[] args) throws FileNotFoundException {
        DepartmentDA departmentDA = new DepartmentDA("dep.csv", "deptemp.csv");

        Map<String, Department> departmentMap = departmentDA.getDepartmentMap();

        for (Department department : departmentMap.values()) {
            System.out.println(department);
        }
    }
}