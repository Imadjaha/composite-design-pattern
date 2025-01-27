package naiveSolution;

public class Main {
    public static void main(String[] args) {

        Employee employee1 = new Employee("Alex", 1000.0);
        Employee employee2 = new Employee("Max", 5000.0);
        Department department = new Department();
        department.addEmployee(employee1);
        department.addEmployee(employee2);

        Department subDepartment = new Department();
        subDepartment.addEmployee(new Employee("Charlie", 4100));

        department.addSubDepartement(subDepartment);
        System.out.println("Total salary: " + department.calculateTotalSalary());
    }
}