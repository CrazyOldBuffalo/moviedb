import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Ratings {
    private static BufferedReader openRatingFile() throws FileNotFoundException {
        return new BufferedReader(new FileReader("data/ratings.dat"));
    }


    
   // public static List<Ratings> readRatings() throws FileNotFoundException {
   //     List<Ratings> ratingList = new ArrayList<Ratings>();
   //     BufferedReader ratingsReader = null;
   //     String line = null;
   // } 
    
    private static String[] parseline(String line) {
        return line.split("::|\t|\\|");
    }

}
