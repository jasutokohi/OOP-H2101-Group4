package Model;

public class Authentication {
    private String username;
    private String password;
    
    //Constructor for Authentication/login
    public Authentication(String Username, String Password){
    this.username = Username;
    this.password = Password;
    }

    //getter methods
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
}
