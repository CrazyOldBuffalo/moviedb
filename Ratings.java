import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ratings {
    private int userid;
    private int movieid;
    private int rating;

    public Ratings(int uID, int mID, int rating) {
        this.userid = uID;
        this.movieid = mID;
        this.rating = rating;

    }
    private static BufferedReader openRatingFile() throws FileNotFoundException {
        return new BufferedReader(new FileReader("data/ratings.dat"));
    }

    private static String[] parseline(String line) {
        return line.split("::|\t|\\|");
    }

    public static void averageMovieRating() throws FileNotFoundException{
        List<Ratings> ratingList = readRatings();
        int total = 0;
        int count = 0;
        for (int i = 0; i < ratingList.size(); i++ )
        {
            if ((ratingList.get(i).getmovieRatings()) == 21 )
            {
                total += ratingList.get(i).getratings();
                count++;
                System.out.println(ratingList.get(i).getuserRatings() + " " + ratingList.get(i).getmovieRatings() + " " + ratingList.get(i).getratings());
            }
        }
        if (total <= 0 || count <= 0)
        {
            System.out.println("No Ratings Found");
        }
        else {
            int average = (total / count);
            System.out.println("Average Rating: " + average);
            System.out.println("Total Rating: " + total);
            System.out.println("Number of Ratings Found: " + count);
        }
    }

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
