import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class UserSearch {

    private static String userLine = "****************";
    // Creates a new instance of an input scanner for the search Method
    private static Scanner userSearchScanner() {
        return new Scanner(System.in);
    }
    
    private static BufferedWriter userSearchFile() throws IOException{
        return new BufferedWriter(new FileWriter("UserSearchFile.txt", true));
    }

    // Method that checks if the user would like to search for a user id again
    private static void uSearchAgain() {
        System.out.println(userLine);
        System.out.println("Would You Like to Search Again?     Y/N");
        System.out.println(userLine);
        boolean uResearchloop = true;
        // Loop ensures correct input before moving to next method
        while(uResearchloop)
        {
            Scanner uResearchScanner = userSearchScanner();
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
        Map<Integer, Users> userMap = Users.buildUserFile();
        BufferedWriter uSearchFileWriter = userSearchFile();
        Scanner uSearch = userSearchScanner();
        System.out.println(userLine);
        System.out.println("Enter the User ID: ");
        System.out.println(userLine);
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
            uSearchFileWriter.append("You Searched for: " + uSearchId + "\n" + "User ID: " + outId + "\n" + "User Age: " + outAge + "\n" +"UserGender: " + "\n" + outGender + "User Occupation: " + outOccup + "\n" + "User Zip: " + outZip + "\n");
            uSearchFileWriter.append("=================================================================" + "\n");
            uSearchFileWriter.close();
        }
        else {
            System.out.println("UserId Could not be found");
 
        }
        uSearchAgain();
    }

    
    public static void userRating(Integer ratingUserID) throws IOException{
        Map<Integer, Users> userMap = Users.buildUserFile();
        System.out.println("UserID : " + userMap.get(ratingUserID).getId());
        System.out.println("User Age: " + userMap.get(ratingUserID).getAge());
        System.out.println("User Gender: " + userMap.get(ratingUserID).getGender());
        System.out.println("User Occupation: " + userMap.get(ratingUserID).getOccup());
        System.out.println("User Zip: " + userMap.get(ratingUserID).getZip());
	}
}
