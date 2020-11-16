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

    private static Map readRatingsFile() throws IOException{
        Map <Integer, Ratings> ratings = new HashMap<Integer, Ratings>();
        BufferedReader ratingsReader = openRatingFile();
        String line = null;
        
        while ((line = ratingsReader.readLine()) != null)
        {
            String[] ratingInputs = parseline(line);
            int userid = Integer.parseInt(ratingInputs[0]);
            int movieid = Integer.parseInt(ratingInputs[1]);
            int rating = Integer.parseInt(ratingInputs[2]);
            int timestamp = Integer.parseInt(ratingInputs[3]);
        }
        ratingsReader.close();
        return ratings;
    }

    private static String[] parseline(String line) {
        return line.split("::|\t|\\|");
    }

    public static void buildRatings() {
        try {
            readRatingsFile();
            System.out.println("Ratings File Opened Successfully");
        }
        catch (FileNotFoundException fe) {
            System.out.println("Ratings File not Found");
        }
        catch (IOException ie) {
            System.out.println("IO Exception Occurred");
        }
    }
}
