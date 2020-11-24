import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class MovieSearch {
        
    // Variable for outputting a line for the class when operating the functions
    private static String movieLine = "****************";

    // Allows the user to search for a movie again using a loop
    // If user enters yes - the search function runs again
    // Otherwise it returns them to the menu
    private static void mSearchAgain() {
        System.out.println(movieLine);
        System.out.println("Would you Like to Search Again?     Y/N");
        System.out.println(movieLine);
        boolean mResearchLoop = true;
        while (mResearchLoop)
        {
            Scanner mResearchScanner = mReSearchScanner();
            String mResearch = mResearchScanner.nextLine().toLowerCase();

            if (mResearch.equals("y"))
            {
                System.out.println("Searching Again");
                mResearchLoop = false;
                try {
                    mSearch();
                }
                catch (IOException mioe)
                {
                    System.out.println("Error Occurred");
                    Moviedb.menu();
                }  
            }
            else if (mResearch.equals("n"))
            {
                System.out.println("Returning to Menu");
                mResearchLoop = false;
                Moviedb.menu();
            }
            else {
                System.out.println("Please Enter Y or N");
            }
        }

    }

    // Method that searches for a MovieID from input
    // Checks if the ID is in the Map and returns it using the integer as a key
    // Otherwise prints that it couldn't be found
    // Moves to the Re-Search function once complete
    public static void mSearch() throws IOException{
        Map <Integer, Movies> moviesMap = Movies.buildMovieSearch();
        Scanner mSearch = mSearchScanner();
        System.out.println(movieLine);
        System.out.println("Enter a MovieID: ");
        System.out.println(movieLine);
        int mSearchId = mSearch.nextInt();
        if (moviesMap.containsKey(mSearchId))
        {
            System.out.println("Movie Id Found");
            System.out.println(movieLine);
            System.out.println("Movie Id: " + moviesMap.get(mSearchId).getID());
            System.out.println("Movie Name: " + moviesMap.get(mSearchId).getName());
            System.out.println("Movie Date: " + moviesMap.get(mSearchId).getDate());
            System.out.println("Movie Url: " + moviesMap.get(mSearchId).getUrl());
            System.out.println("Movie Genre: " + moviesMap.get(mSearchId).getGenre());
        }
        else {
            System.out.println("Movie Id Not Found");
            
        }
        mSearchAgain();
    }

    public static void ratingsMovies(Integer userMovieID) throws IOException{
        Map<Integer, Movies> movieMap = Movies.buildMovieSearch();
        System.out.println("Movie Id: " + movieMap.get(userMovieID).getID());
        System.out.println("Movie Name: " + movieMap.get(userMovieID).getName());
        System.out.println("Movie Date: " + movieMap.get(userMovieID).getDate());
        System.out.println("Movie URL: " + movieMap.get(userMovieID).getUrl());
        System.out.println("Movie Genre: " + movieMap.get(userMovieID).getGenre());

    }

    public static String twoUserMovies(Integer twoUserMovieId) throws IOException {
        Map<Integer, Movies> movieMap = Movies.buildMovieSearch();
        return movieMap.get(twoUserMovieId).getName();
    }

    // Methods to create new Scanners for Search and ReSearch
    private static Scanner mSearchScanner() {
        return new Scanner(System.in);
    }

    private static Scanner mReSearchScanner() {
        return new Scanner(System.in);
    }
}
