import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Users {
    // Variables to store data for each class
    private int userId, userAge;
    private String userGender, userOccup, userZip;


    // Constructor for Class
    public Users(int Id, int age, String gender, String occup, String zip) {
        this.userId = Id;
        this.userAge = age;
        this.userGender = gender;
        this.userOccup = occup;
        this.userZip = zip;
    }

    // Method for Creating a Buffered Reader for Class
    private static BufferedReader openUserFile() throws FileNotFoundException {
        return new BufferedReader(new FileReader("data/users.dat"));
    }

    // Method for Reading File, Creates an instance of the Map & Reader for use
    private static Map readUserFile() throws IOException{
        Map<Integer,Users> userMap = new HashMap<Integer,Users>();
        BufferedReader userReader = openUserFile();
        String line = null;
        
        // While Loop that pulls data from the file and assigns it to a variable to 
        // create an object and store it in a map
        while ((line = userReader.readLine()) != null) {
            String[] userInput = parseLine(line);
            int Id = Integer.parseInt(userInput[0]);
            int Age = Integer.parseInt(userInput[1]);
            String Gender = userInput[2];
            String Occup = userInput[3];
            String Zip = userInput[4];
            userMap.put(Id, new Users(Id, Age, Gender, Occup, Zip));
        }
        //Closes the Reader Instance and returns the Map
        userReader.close();
        return userMap;
    }
    
    private static String[] parseLine(String line) {
        return line.split("::|\t|\\|");
    }

    public static void uSearch(int uSearchId) throws IOException{
        Map userMap = readUserFile();
        if (userMap.containsKey(uSearchId))
        {
            System.out.println("");
            int outId = ((Users) userMap.get(uSearchId)).getId();
            int outAge = ((Users) userMap.get(uSearchId)).getAge();
            String outGender = ((Users) userMap.get(uSearchId)).getGender();
            String outOccup = ((Users) userMap.get(uSearchId)).getOccup();
            String outZip = ((Users) userMap.get(uSearchId)).getZip();
            System.out.println("User ID: " + outId + "\n" + "User Age: " + outAge + "\n" + "User Gender: " + outGender + "\n" + "User Occupation: " + outOccup + "\n" + "User Zip: " + outZip);
        }
        else {
            System.out.println("Not found");
        }
        

    }

    public int getId() {
        return this.userId;
    }

    public int getAge() {
        return this.userAge;
    }

    public String getGender() {
        return this.userGender;
    }

    public String getOccup() {
        return this.userOccup;
    }

    public String getZip() {
        return this.userZip;
    }

    public static void buildUsers() {
        try {
            readUserFile();
            System.out.println("User File Opened Successfully");
        }
        catch (FileNotFoundException fe) {
            System.out.println("File Not Found");
        }
        catch (IOException ie) {
            System.out.println("IO Error");
        }
    }
}
