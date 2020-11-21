import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Ratings {

    // Private variables for creating objects of the class
    private int userid;
    private int movieid;
    private int rating;

    public static final String RATINGLINE = "****************";

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

    // Private methods for returning a new Scanner Object
    private static Scanner averageMovie() {
        return new Scanner(System.in);
    }

    private static Scanner reAverageMovie() {
        return new Scanner(System.in);
    }

    private static Scanner averageUser() {
        return new Scanner(System.in);
    }

    private static Scanner reAverageUser() {
        return new Scanner(System.in);
    }
    // Allows user to search for the Average Movie Rating again
    // converts input into lower and then compares
    // If input == y runs function again otherwise returns to menu
    private static void reAverageMovieRating() throws FileNotFoundException{
        System.out.println(RATINGLINE);
        System.out.println("Would you like to Calculate a new Movie Average?    Y/N");
        System.out.println(RATINGLINE);
        boolean reAverageMovieLoop = true;
        while (reAverageMovieLoop)
        {
            Scanner reAverageMovieScanner = reAverageMovie();
            String reAverageMovie = reAverageMovieScanner.nextLine().toLowerCase();
            if (reAverageMovie.equals("y"))
            {
                System.out.println("Searching Again");
                reAverageMovieLoop = false;
                averageMovieRating();
            }
            else if (reAverageMovie.equals("n"))
            {
                System.out.println("Returning to Menu");
                reAverageMovieLoop = false;
                Moviedb.menu();
            }
            else {
                System.out.println("Invalid Input, please Enter Y or N");
            }
        }
    }
    // Public method for calculating the average Rating of a movie
    // Creates an instance of the List and loops through the file when a movieId is specitfied
    // Reads through the ratingList and every Instance is added to another list called AverageMovie.
    // Checks if the new list is empty and if so throws an error
    // Otherwise the list loops through the new list and adds to the total (All Ratings added together)
    // The Total is then divided by the size of the new list to create the average and it is then outputted
    public static void averageMovieRating() throws FileNotFoundException{
        List<Ratings> ratingList = readRatings();
        List<Integer> averageMovie = new ArrayList<Integer>();
        boolean movieRatingLoop = true;
        while (movieRatingLoop)
        {
            try {
                Scanner averageMovieScanner = averageMovie();
                System.out.println(RATINGLINE);
                System.out.println("Enter a MovieID to Calculate the Average Movie Rating");
                System.out.println(RATINGLINE);
                int userMovieRatingID = averageMovieScanner.nextInt();
                int movieTotal = 0;
                for (int i = 0; i < ratingList.size(); i++ )
                {
                    if ((ratingList.get(i).getmovieRatings()) == userMovieRatingID )
                    {
                        averageMovie.add(ratingList.get(i).getratings());
                    }
                }
                if (averageMovie.isEmpty())
                {
                    System.out.println("No Ratings Found For that ID");
                    movieRatingLoop = false;
                    reAverageMovieRating();
                }
                else {
                    for (int i = 0; i < averageMovie.size(); i++) 
                    {
                        movieTotal += averageMovie.get(i);
                    }
                    int movieAverage = (movieTotal / averageMovie.size());
                    System.out.println("Average Rating for Movie " + userMovieRatingID + " is: " + movieAverage);
                    movieRatingLoop = false;
                    reAverageMovieRating();
                }
            }
            catch (InputMismatchException rME)
            {
                System.out.println("Invalid Input, Please Enter a MovieID");
            }
        }
    }

    private static void reAverageUserRating() throws FileNotFoundException{
        System.out.println(RATINGLINE);
        System.out.println("Would you like to calculate a new User Average?     Y/N");
        System.out.println(RATINGLINE);
        boolean reAverageUserLoop = true;
        while (reAverageUserLoop)
        {
            Scanner reAverageUserScanner = reAverageUser();
            String reAverageUser = reAverageUserScanner.nextLine().toLowerCase();

            if (reAverageUser.equals("y"))
            {
                System.out.println("Searching Again");
                reAverageUserLoop = false;
                averageUserRating();
            }
            else if (reAverageUser.equals("n"))
            {
                System.out.println("Returning to Menu");
                reAverageUserLoop = false;
                Moviedb.menu();
            }
        }
    }

    public static void averageUserRating() throws FileNotFoundException{
        List<Ratings> ratingList = readRatings();
        List<Integer> averageUser = new ArrayList<Integer>();
        boolean averageUserLoop = true;
        while (averageUserLoop)
        {
            try {
                Scanner averageUserScanner = averageUser();
                System.out.println(RATINGLINE);
                System.out.println("Enter a UserID to calculate the average User Rating");
                System.out.println(RATINGLINE);
                int ratingUserId = averageUserScanner.nextInt();
                int userTotal = 0;
                for (int i = 0; i < ratingList.size(); i++)
                {
                    if (ratingList.get(i).getuserRatings() == ratingUserId) 
                    {
                        averageUser.add(ratingList.get(i).getratings());
                    }
                }
                if (averageUser.isEmpty())
                {
                    System.out.println("No Ratings found for UserID");
                    averageUserLoop = false;

                }
                else {
                    for (int i = 0; i < averageUser.size(); i++)
                    {
                        userTotal += averageUser.get(i);
                    }
                    int userAverage = userTotal / averageUser.size();
                    System.out.println("Average Rating for UserID " + ratingUserId + " is: " + userAverage);
                    averageUserLoop = false;
                }
            }
            catch (InputMismatchException uME)
            {
                System.out.println("Invalid Input, please Enter a valid UserID");
            }
        }

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
