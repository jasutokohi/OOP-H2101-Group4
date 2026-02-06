package Model;

public abstract class Employee implements EmployeeOperations{
    private int employeeID;
    private String lastName;
    private String firstName;
    private String position;
    private String phoneNumber;
    private String status;
    private String immediateSupervisor;
    private int basicSalary;
    private double hourlyRate;
    
    //Constructors
    public Employee(){
    }

    public Employee(int employeeID, String lastName, String firstName, String status, String position, String immediateSupervisor, int basicSalary, double hourlyRate) {
        this.employeeID = employeeID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.status = status;
        this.position = position;
        this.immediateSupervisor = immediateSupervisor;
        this.basicSalary = basicSalary;
        this.hourlyRate = hourlyRate;
    }
    
    
    //getter methods
    public int getEmployeeID() {
    return employeeID;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getStatus() {
        return status;
    }

    public String getPosition() {
        return position;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    
    @Override
    public int getBasicSalary(){
       return basicSalary; 
    }

    @Override
    public double getHourlyRate() {
        return hourlyRate;
    }
    
    
    //Setter methods
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setImmediateSupervisor(String immediateSupervisor) {
        this.immediateSupervisor = immediateSupervisor;
    }

    public void setBasicSalary(int basicSalary) {
        this.basicSalary = basicSalary;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
    
    //Abstract methods that are needed for each employee type
                
    @Override
    public abstract String toString();
}
