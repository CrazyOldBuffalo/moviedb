import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Users {

    private BufferedReader openUserFile() throws FileNotFoundException {
        return new BufferedReader(new FileReader("data/users.dat"));
    }

    private Map readUserFile() throws IOException{
        Map<Integer,Users> users = new HashMap<Integer,Users>();
        BufferedReader userReader = openUserFile();
        String line = null;
        
        while ((line = userReader.readLine()) != null) {
            String[] userInput = parseLine(line);
            int userId = Integer.parseInt(userInput[0]);
            int userAge = Integer.parseInt(userInput[1]);
            String userGender = userInput[2];
            String userOccup = userInput[3];
            String userZip = userInput[4];
        }
        return users;
    }
    

    private String[] parseLine(String line) {
        return line.split("::|\t|\\|");

    }

    public void buildUsers() {
        try {
            openUserFile();
            System.out.println("User File Opened Successfully");
            readUserFile();
            System.out.println("User File Read Successfully");
        }
        catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
        catch (IOException ie) {
            System.out.println("IO Error");
        }
    }
}
