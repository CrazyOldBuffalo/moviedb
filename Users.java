import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Users {
    // Variables to store data for each class
    private int userId;
    private int userAge;
    private String userGender;
    private String userOccup;
    private String userZip;


    // Constructor for Class
    public Users(int id, int age, String gender, String occup, String zip) {
        this.userId = id;
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
    private static Map<Integer, Users> readUserFile() throws IOException{
        Map<Integer,Users> userMap = new HashMap<Integer,Users>();
        BufferedReader userReader = openUserFile();
        String line = null;
        
        // While Loop that pulls data from the file and assigns it to a variable to 
        // create an object and store it in a map
        while ((line = userReader.readLine()) != null) {
            String[] userInput = parseLine(line);
            int id = Integer.parseInt(userInput[0]);
            int age = Integer.parseInt(userInput[1]);
            String gender = userInput[2];
            String occup = userInput[3];
            String zip = userInput[4];
            userMap.put(id, new Users(id, age, gender, occup, zip));
        }
        //Closes the Reader Instance and returns the Map
        userReader.close();
        return userMap;
    }
    
    // Takes the line input and performs a .split to seperate the data
    private static String[] parseLine(String line) {
        return line.split("::|\t|\\|");
    }

   

    // Public Getter Methods for accessing object data
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

    public static Map<Integer, Users> buildUserFile() throws IOException{
        return readUserFile();
    }
    // Public method for opening and reading the user file and creating objects
    // Accessed in the Main, catches any errors from running the function
    // and Outputs an error before quitting
    public static void buildUsers() {
        try {
            readUserFile();
            System.out.println("User File Opened Successfully");
        }
        catch (FileNotFoundException fe) {
            System.out.println("File Not Found");
            System.exit(0);
        }
        catch (IOException ie) {
            System.out.println("IO Error");
            System.exit(0);
        }
    }
}
