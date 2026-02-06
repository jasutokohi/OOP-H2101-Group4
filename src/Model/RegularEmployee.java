
package Model;

public class RegularEmployee extends Employee {

    public RegularEmployee() {
    }

    public RegularEmployee(int employeeID, String lastName, String firstName, String status, String position, String immediateSupervisor, int basicSalary, double hourlyRate) {
        super(employeeID, lastName, firstName, status, position, immediateSupervisor, basicSalary, hourlyRate);
    }
    
    @Override
    public String toString(){
        return null;
    }

}
