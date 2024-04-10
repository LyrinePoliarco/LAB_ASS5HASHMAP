import java.io.FileNotFoundException;
import java.util.Map;

public class DepartmentReport {
    public static void main(String[] args) {
        try {
            DepartmentDA departmentDA = new DepartmentDA("C:\\Users\\lyyri\\GitHub\\LAB_ASS5HASHMAP\\dep.csv");
            EmployeeDA employeeDA = new EmployeeDA("C:\\Users\\lyyri\\GitHub\\LAB_ASS5HASHMAP\\deptemp.csv");

            Map<String, Department> departmentMap = departmentDA.getDepartmentMap();
            Map<String, Employee> employeeMap = employeeDA.getEmployeeMap();

            for (Department department : departmentMap.values()) {
                System.out.println("Department code: " + department.getDeptCode());
                System.out.println("Department name: " + department.getDeptName());
                System.out.println("Department total salary: " + department.getDepTotalSalary());
                System.out.println("---------------------Details -------------------------");
                for (Employee employee : department.getEmployeeMap().values()) {
                    System.out.println("EmpNo\t Employee Name\tSalary");
                    System.out.println(employee.getEmpNo() + "\t" + employee.getLastName() + ", " + employee.getFirstName() + "\t" + employee.getSalary());
                }
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
