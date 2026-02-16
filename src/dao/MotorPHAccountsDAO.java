package dao;

import Model.Authentication;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;


public class MotorPHAccountsDAO {
    private static final String FILE_PATH = "files/AuthenticationDetails.csv";
    private static final String[] HEADERS = {"Username", "Password"};


    
    //Saves Details of the employees
    public static void saveDetails(Authentication authentication) {
        try {
            //Ensure folder exists
            File folder = new File("files");
            if (!folder.exists()) {
                folder.mkdir();
            }

            File file = new File(FILE_PATH);
            boolean fileExists = file.exists();
            boolean needsHeader = true;

            //Checks Header
            if (fileExists) {
                try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                    String firstLine = br.readLine();
                    if (firstLine != null && firstLine.toLowerCase().contains("employee id")) {
                        needsHeader = false;
                    }
                }
            }

            //Appends/Creates to file
            try (CSVWriter writer = new CSVWriter(new FileWriter(file, true))) {
                if (!fileExists || needsHeader) {
                    writer.writeNext(HEADERS, false);
                }
                //Structure of login credentials for Writing to CSVfile
                String[] row = {
                    authentication.getUsername(),
                    authentication.getPassword()
                };

                writer.writeNext(row);
            }
        } catch (IOException e) {
            System.err.println("Error Writing to CSV: " + e.getMessage());

        }

    }
    
    //Method that verifies login if true or false
     public static boolean verifyAuthentication(String Username, String Password, HashMap<String,String> user){
            try{
            //Ensure folder exists
            File folder = new File("files");
            if(!folder.exists()){
                folder.mkdir();
            }
            
            File file = new File(FILE_PATH);
            
            //create file with headers if doesn't exist
            if(!file.exists()){
                try(CSVWriter writer = new CSVWriter(new FileWriter(file,true))) {
                    writer.writeNext(HEADERS, false);
                }
                
            } 
            //Read CSV
            try(CSVReader reader = new CSVReader(new FileReader(file))){
            List<String[]> rows = reader.readAll();

            for(int i = 1; i < rows.size(); i++){
                    String[] row = rows.get(i);
                if(row.length >= 2){
                     String username = row[0].trim();
                     String password = row[1].trim();
                    user.put(username,password);
                }
            }
        }    
            return user.containsKey(Username) && user.get(Username).equals(Password);   
        }catch(CsvException | IOException e){
            System.err.println("Error reading from CSV: " + e.getMessage());
        }
        return false;
 }    
     
}
     


 
    

