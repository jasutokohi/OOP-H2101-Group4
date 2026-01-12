package Class;

public class Employee{
    private String EmployeeID;
    private String EmployeeName;
    private String Birthday;
    private String Gender;
    private String LastName;
    private String FirstName;
    private String Position;
    private String PhoneNumber;
    
    //Constructors
    public Employee(String EmployeeID, String EmployeePosition, String LastName, String FirstName, String EmployeeGender) {
        this.EmployeeID = EmployeeID;
        this.Position = EmployeePosition;
        this.LastName = LastName;
        this.FirstName = FirstName;
        this.Gender = EmployeeGender;
    }
    
    public Employee(String EmployeeID, String EmployeePosition, String LastName, String FirstName, String EmployeeGender, String Birthday, String PhoneNumber){
        this.EmployeeID = EmployeeID;
        this.Position = EmployeePosition;
        this.LastName = LastName;
        this.FirstName = FirstName;
        this.Gender = EmployeeGender;
        this.Birthday = Birthday;
        this.PhoneNumber = PhoneNumber;
    }
    
    //Makes the CSV employee information to string
    @Override
    public String toString(){ 
        return """             
               Employee ID: """ + EmployeeID + "\nPosition: " + Position + "\nFirst Name: " + FirstName + 
                "\nLast Name: " + LastName + "\nEmployee Gender: " + Gender + "\nBirthday: " + Birthday +"\nPhone Number: " 
                + PhoneNumber;
    }
    
    //getter methods
    public String getEmployeeID() {
    return EmployeeID;
    }

    public String getLastName() {
        return LastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getBirthday() {
        return Birthday;
    }

    public String getGender() {
        return Gender;
    }

    public String getPosition() {
        return Position;
    }

    public String getPhoneNumber(){
        return PhoneNumber;
    }
}
