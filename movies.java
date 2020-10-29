import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.Scanner;


public class movies {
    private int movieid;    
    private String name;
    private Date date;
    private URL IMDB;
    // 20 other random things at the end of the file?

    public static void main(String[] args) {
        try {
            File movies = new File("data/movies.dat");
            Scanner scanner = new Scanner(movies);
            System.out.println("File Opened Successfully");
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }

}
