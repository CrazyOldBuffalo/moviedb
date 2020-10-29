import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class users {
    private int userid;
    private int age;
    private String gender;
    private String occupation;
    private int value; // ?
    public static void main(String[] args) {
        // Attemptng to Open File

        try {
            File file = new File("data/users.dat");
            System.out.println("File Opened Successfully!");
            Scanner fileread = new Scanner(file);
            fileread.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("File Not Found!");
        }
    
    }
}