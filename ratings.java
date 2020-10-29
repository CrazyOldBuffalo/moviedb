import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ratings {
    private int filmid; // ?
    private int userid; // ?
    private int rating;
    private int value; // ?
    public static void main(String[] args) {
        try {
            File file = new File("data/ratings.dat");
            System.out.println("File Opened Successfully");
            Scanner scanner = new Scanner(file);
            scanner.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
        
    }
}
