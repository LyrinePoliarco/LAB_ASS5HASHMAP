import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.text.DecimalFormat;

public class DepartmentDA {
    private HashMap<String, Department> departmentMap;

    DepartmentDA() {
        this.departmentMap = readDepartments();
    }

    public HashMap<String, Department> readDepartments() {
        HashMap<String, Department> departments = new HashMap<>();
        try {
            Scanner departmentFile = new Scanner(new FileReader("dep.csv"));
            departmentFile.nextLine();

            while (departmentFile.hasNext()) {
                String departmentLine = departmentFile.nextLine();
                String[] depArr = departmentLine.split(",");
                Department department = new Department();
                department.setDepCode(depArr[0].trim());
                department.setDepName(depArr[1].trim());
                departments.put(depArr[0].trim(), department);
            }

            departmentFile.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return departments;
    }

    public Employee createEmployee(String empNo) {
        EmployeeDA employeeDA = new EmployeeDA(empNo);
        return employeeDA.getEmployee();
    }

    public void readDepEmp(Department department) {
        try {
            Scanner depEmpFile = new Scanner(new FileReader("deptemp.csv"));
            depEmpFile.nextLine();
            HashMap<String, Employee> employeeMap = new HashMap<>();
            while (depEmpFile.hasNext()) {
                String depEmpLine = depEmpFile.nextLine();
                String[] depEmpArr = depEmpLine.split(",");
                if (department.getDepCode().equals(depEmpArr[0].trim())) {
                    Employee employee = createEmployee(depEmpArr[1].trim());
                    employee.setSalary(Double.parseDouble(depEmpArr[2]));
                    employeeMap.put(employee.getEmpNo(), employee);
                    department.setDepTotalSalary(department.getDepTotalSalary() + employee.getSalary());
                }
            }
            department.setEmpMap(employeeMap);
            depEmpFile.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void generateReports() {
        for (Map.Entry<String, Department> entry : departmentMap.entrySet()) {
            Department department = entry.getValue();
            readDepEmp(department);
            printDepartment(department);
        }
    }

    public void printDepartment(Department department) {
        DecimalFormat df = new DecimalFormat("#,###.00");
        System.out.println("Department Code: " + department.getDepCode());
        System.out.println("Department Name: " + department.getDepName());
        System.out.println("Department total Salary: " + df.format(department.getDepTotalSalary()));
        System.out.println();
        System.out.println("------------Details----------------");
        System.out.printf("%-10s %-20s %10s\n", "EmpNo", "EmployeeName", "Salary");
        for (Map.Entry<String, Employee> entryMap : department.getEmpMap().entrySet()) {
            Employee employee = entryMap.getValue();
            System.out.printf("%-10s %-20s %10s\n", entryMap.getKey(),
            employee.getLastName() + ", " + employee.getFirstName(), df.format(employee.getSalary()));
        }
    }
}