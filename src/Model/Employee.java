package Model;

public class Employee{
    private String employeeID;
    private String employeeName;
    private String birthday;
    private String gender;
    private String lastName;
    private String firstName;
<<<<<<< Updated upstream
<<<<<<< Updated upstream
    private String position;
    private String phoneNumber;
=======
=======
>>>>>>> Stashed changes
    private String status;
    private String position;
    private String immediateSupervisor;
    private int basicSalary;
    private double hourlyRate;
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
    
    //Constructors
    public Employee(){
    }
<<<<<<< Updated upstream
    
    public Employee(String EmployeeID, String EmployeePosition, String LastName, String FirstName, String EmployeeGender) {
        this.employeeID = EmployeeID;
        this.position = EmployeePosition;
        this.lastName = LastName;
        this.firstName = FirstName;
        this.gender = EmployeeGender;
=======

    public Employee(int employeeID, String lastName, String firstName, String status, String position, String immediateSupervisor, int basicSalary, double hourlyRate) {
        this.employeeID = employeeID;
        this.lastName = lastName;
        this.firstName = firstName;

        this.status = status;
        this.position = position;
        this.immediateSupervisor = immediateSupervisor;
        this.basicSalary = basicSalary;
        this.hourlyRate = hourlyRate;
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
    }
    
    public Employee(String EmployeeID, String EmployeePosition, String LastName, String FirstName, String EmployeeGender, String Birthday, String PhoneNumber){
        this.employeeID = EmployeeID;
        this.position = EmployeePosition;
        this.lastName = LastName;
        this.firstName = FirstName;
        this.gender = EmployeeGender;
        this.birthday = Birthday;
        this.phoneNumber = PhoneNumber;
    }
    
    //Makes the CSV employee information to string
    @Override
    public String toString(){ 
        return """             
               Employee ID: """ + employeeID + "\nPosition: " + position + "\nFirst Name: " + firstName + 
                "\nLast Name: " + lastName + "\nEmployee Gender: " + gender + "\nBirthday: " + birthday +"\nPhone Number: " 
                + phoneNumber;
    }
    
    //getter methods
    public String getEmployeeID() {
    return employeeID;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

<<<<<<< Updated upstream
<<<<<<< Updated upstream
    public String getBirthday() {
        return birthday;
    }

    public String getGender() {
        return gender;
    }

=======
=======
>>>>>>> Stashed changes
    public String getStatus() {
        return status;
    }
    
>>>>>>> Stashed changes
    public String getPosition() {
        return position;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }
<<<<<<< Updated upstream
=======
    
    @Override
    public int getBasicSalary(){
       return basicSalary; 
    }

    @Override
    public double getHourlyRate() {
        return hourlyRate;
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

<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
}
