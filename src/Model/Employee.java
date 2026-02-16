package Model;

public class Employee{
    private String employeeID;
    private String employeeName;
    private String birthday;
    private String gender;
    private String lastName;
    private String firstName;
    private String position;
    private String phoneNumber;
    
    //Constructors
    public Employee(){
    }
    
    public Employee(String EmployeeID, String EmployeePosition, String LastName, String FirstName, String EmployeeGender) {
        this.employeeID = EmployeeID;
        this.position = EmployeePosition;
        this.lastName = LastName;
        this.firstName = FirstName;
        this.gender = EmployeeGender;
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

    public String getBirthday() {
        return birthday;
    }

    public String getGender() {
        return gender;
    }

    public String getPosition() {
        return position;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }
}
