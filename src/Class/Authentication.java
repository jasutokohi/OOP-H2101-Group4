package Class;

public class Authentication {
    private String Username;
    private String Password;
    
    //Constructor for Authentication/login
    public Authentication(String Username, String Password){
    this.Username = Username;
    this.Password = Password;
    }

    //getter methods
    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }
    
}
