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
    private static Map readUserFile() throws IOException{
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
    
    private static String[] parseLine(String line) {
        return line.split("::|\t|\\|");
    }

    private static Scanner uSearchScanner() {
        return new Scanner(System.in);
    }

    private static Scanner SearchScanner() {
        return new Scanner(System.in);
    }

    private static void uSearchAgain() {
        System.out.println(USERLINE);
        System.out.println("Would You Like to Search Again?     Y/N");
        System.out.println(USERLINE);
        boolean uResearchloop = true;
        while(uResearchloop)
        {
            Scanner uResearchScanner = uSearchScanner();
            String uResearch = uResearchScanner.nextLine().toLowerCase();
            if (uResearch.equals("y"))
            {
                System.out.println("Yes");
                uResearchloop = false;
                try {
                    uSearch();
                }
                catch (IOException ioe)
                {
                    System.out.println("Error Occurrred");
                    Moviedb.menu();
                }
                
            }
            else if (uResearch.equals("n"))
            {
                Moviedb.menu();
                System.out.println("No");
            }
            else {
                System.out.println("Please Enter Either Y or N");
            }
        }
    }
    
    public static void uSearch() throws IOException{
        Map userMap = readUserFile();
        Scanner uSearch = SearchScanner();
        System.out.println(USERLINE);
        System.out.println("Enter the User ID: ");
        System.out.println(USERLINE);
        int uSearchId = uSearch.nextInt();
        if (userMap.containsKey(uSearchId))
        {
            System.out.println("");
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
