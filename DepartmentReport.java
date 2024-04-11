import java.io.FileNotFoundException;
import java.util.*;

public class DepartmentReport {
    public static void main(String[] args) {
        try {
            DepartmentDA departmentDA = new DepartmentDA();
            EmployeeDA employeeDA = new EmployeeDA();

            HashMap<String, Department> departmentMap = departmentDA.getDepartmentMap();
            HashMap<String, Employee> employeeMap = employeeDA.getEmployeeMap();

            for (Department department : departmentMap.values()) {
                System.out.println("Department code: " + department.getCode());
                System.out.println("Department name: " + department.getName());
                System.out.println("Department total salary: " + department.getTotalSalary());
                System.out.println("---------------------Details -------------------------");
                for (Employee employee : department.getEmployees()) {
                    System.out.printf("%-10s %-20s %.2f%n", employee.getEmpNo(), employee.getLastName() + ", " + employee.getFirstName(), employee.getSalary());
                }
                System.out.println();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
