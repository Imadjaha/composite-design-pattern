package naiveSolution;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private List<Employee> employees;
    private List<Department> subDepartments;

    public Department() {
       employees = new ArrayList<>();
       subDepartments = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    public void addSubDepartement(Department subDepartment){
        subDepartments.add(subDepartment);
    }

    public double calculateTotalSalary(){
        double totalEmployeeSalaries = employees.stream().mapToDouble(Employee::getSalary).sum();

        double subDepartmentSalaryCalculation = subDepartments.stream().mapToDouble(Department::calculateTotalSalary).sum();

        return  totalEmployeeSalaries + subDepartmentSalaryCalculation;
    }
}
