import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ratings {

    // Private variables for creating objects of the class
    private int userid;
    private int movieid;
    private int rating;


    // Constructor for creating objects of the class for each record in the file
    public Ratings(int uID, int mID, int rating) {
        this.userid = uID;
        this.movieid = mID;
        this.rating = rating;

    }

    // Private Method for creating a buffered Reader for the ratings file
    private static BufferedReader openRatingFile() throws FileNotFoundException {
        return new BufferedReader(new FileReader("data/ratings.dat"));
    }

    // Private Method for splitting the line read from the ratings file
    private static String[] parseline(String line) {
        return line.split("::|\t|\\|");
    }

  
        
    // Public Method for creating the Rating Array List, each list item is created as an object of the class
    // Like before each line is read from the file and passed into the split method to fill an array
    // and then assigned to a variable bofore being stored as an object in the list
    // Any errors are handled in the method
    public static List<Ratings> readRatings() throws FileNotFoundException {
        List<Ratings> ratingList = new ArrayList<Ratings>();
        BufferedReader ratingsReader = null;
        String line = null;
        try {
            ratingsReader = openRatingFile();
            while ((line = ratingsReader.readLine()) != null)
            {
                String[] ratingInput = parseline(line);
                int userId = Integer.parseInt(ratingInput[0]);
                int movieId = Integer.parseInt(ratingInput[1]);
                int rating = Integer.parseInt(ratingInput[2]);
                ratingList.add(new Ratings(userId, movieId, rating));
            }
            ratingsReader.close();
        }
        catch (FileNotFoundException rfnf)
        {
            System.out.println("Ratings File Not Found");
        }
        catch (IOException rioe) {
            System.out.println("Ratings IO Exception");
        }
        return ratingList;
   } 

   // Public Getters for the Object Variables
   public int getuserRatings() {
       return this.userid;
   }

   public int getmovieRatings() {
       return this.movieid;
   }

   public int getratings() {
       return this.rating;
   }

}
