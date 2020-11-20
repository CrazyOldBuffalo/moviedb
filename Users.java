import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Users {
    // Variables to store data for each class
    private int userId;
    private int userAge;
    private String userGender;
    private String userOccup;
    private String userZip;
    public static final String USERLINE = "****************";


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

    // Creates a new instance of an input scanner for the user Re-search Method
    private static Scanner uReSearchScanner() {
        return new Scanner(System.in);
    }

    // Creates a new instance of an input scanner for the search Method
    private static Scanner uSearchScanner() {
        return new Scanner(System.in);
    }

    // Method that checks if the user would like to search for a user id again
    private static void uSearchAgain() {
        System.out.println(USERLINE);
        System.out.println("Would You Like to Search Again?     Y/N");
        System.out.println(USERLINE);
        boolean uResearchloop = true;
        // Loop ensures correct input before moving to next method
        while(uResearchloop)
        {
            Scanner uResearchScanner = uReSearchScanner();
            // Converts userinput to lower so only one condition has to be checked for
            String uResearch = uResearchScanner.nextLine().toLowerCase();
            // Allows user to search again
            if (uResearch.equals("y"))
            {
                System.out.println("Searching Again");
                uResearchloop = false;
                try {
                    uSearch();
                }
                //If a IOException is caught Prints an error and sends the user back to the menu
                catch (IOException ioe)
                {
                    System.out.println("Error Occurrred");
                    uResearchloop = false;
                    Moviedb.menu();
                }
                
            }
            // Returns user to the menu
            else if (uResearch.equals("n"))
            {
                System.out.println("Returning to Menu");
                uResearchloop = false;
                Moviedb.menu();
            }
            // An input that doesn't match sends the user back to the start of the loop
            else {
                System.out.println("Please Enter Either Y or N");
            }
        }
    }
    
    // Creates an instance of the map, takes a user input and checks if the map contains that input
    // If it does, a method collects the details of the object from the map and outputs it
    public static void uSearch() throws IOException{
        Map<Integer, Users> userMap = readUserFile();
        Scanner uSearch = uSearchScanner();
        System.out.println(USERLINE);
        System.out.println("Enter the User ID: ");
        System.out.println(USERLINE);
        int uSearchId = uSearch.nextInt();
        if (userMap.containsKey(uSearchId))
        {
            System.out.println("User Id Found");
            int outId = ((Users) userMap.get(uSearchId)).getId();
            int outAge = ((Users) userMap.get(uSearchId)).getAge();
            String outGender = ((Users) userMap.get(uSearchId)).getGender();
            String outOccup = ((Users) userMap.get(uSearchId)).getOccup();
            String outZip = ((Users) userMap.get(uSearchId)).getZip();
            System.out.println("User ID: " + outId + "\n" + "User Age: " + outAge + "\n" + "User Gender: " + outGender + "\n" + "User Occupation: " + outOccup + "\n" + "User Zip: " + outZip);
            uSearchAgain();
        }
        else {
            System.out.println("UserId Could not be found");
            uSearchAgain();
        }
        

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
