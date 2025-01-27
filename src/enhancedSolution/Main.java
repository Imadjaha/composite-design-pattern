package enhancedSolution;


public class Main {
    public static void main(String[] args) {


        Department itDepartment = new Department();
        itDepartment.addOrganisationUnit(new Employee("Aimad", 1000.2));
        itDepartment.addOrganisationUnit(new Employee("Ali", 2220.2));

        Department teamPerformanceSubDepartment = new Department();

        teamPerformanceSubDepartment.addOrganisationUnit(new Employee("Youssef", 5000.0));
        itDepartment.addOrganisationUnit(teamPerformanceSubDepartment);

        System.out.println("Total Salary: " + itDepartment.calculateTotalSalary());

    }
}