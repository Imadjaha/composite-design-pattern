package enhancedSolution;

import java.util.ArrayList;
import java.util.List;

public class Department implements OrganisationUnit{

    private List<OrganisationUnit> organisationUnits;
    public Department() {
       organisationUnits = new ArrayList<>();

    }

    public void addOrganisationUnit(OrganisationUnit organisationUnit){
        organisationUnits.add(organisationUnit);
    }

    @Override
    public double calculateTotalSalary(){
        return organisationUnits.stream().mapToDouble(OrganisationUnit::calculateTotalSalary).sum();
    }
}
