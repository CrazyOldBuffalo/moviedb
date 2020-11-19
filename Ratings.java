import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Ratings {
    private static BufferedReader openRatingFile() throws FileNotFoundException{
        return new BufferedReader(new FileReader("data/ratings.dat"));
    }

    
    
    private static String[] parseline(String line) {
        return line.split("::|\t|\\|");
    }

}
