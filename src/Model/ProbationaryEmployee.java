package Model;

public class ProbationaryEmployee extends Employee{
    public ProbationaryEmployee(int employeeID, String lastName, String firstName, String status, String position, String immediateSupervisor, int basicSalary, double hourlyRate) {
        super(employeeID, lastName, firstName, status, position, immediateSupervisor, basicSalary, hourlyRate);
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
