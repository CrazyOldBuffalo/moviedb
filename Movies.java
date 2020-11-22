import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Movies {

    // Private variables applied to the class when creating the object
    private int movieId;
    private String movieName;
    private String movieDate;
    private String movieUrl;
    private String movieGenre;

    // Variable for outputting a line for the class when operating the functions
    public static final String MOVIELINE = "****************";

    // Constructor for creating an object for the class
    public Movies(int id, String name, String date, String url, String genre) {
        this.movieId = id;
        this.movieName = name;
        this.movieDate = date;
        this.movieUrl = url;
        this.movieGenre = genre;
    }

    // Method for creating a buffered reader using the file
    private static BufferedReader openMovieFile() throws FileNotFoundException {
        return new BufferedReader(new FileReader("data/movies.dat"));
    }

    // Method for creating a Map of all the movies, using the ID as a key
    // And an object for each movie
    private static Map<Integer, Movies> readMovieFile() throws IOException {
        Map<Integer, Movies> movieMap = new HashMap<Integer, Movies>();
        BufferedReader movieReader = openMovieFile();
        String line = null;

        // Loops through the file until there are no more lines available
        // Each line is Split using the parseLine method and assigned to a variable
        // Each variable is then placed in the .put() as a class object

        while ((line = movieReader.readLine()) != null) {
            String[] movieInputs = parseLine(line);
            int movieId = Integer.parseInt(movieInputs[0]);            
            String movieName = movieInputs[1];
            String movieDate = movieInputs[2];
            String movieUrl = movieInputs[4];
            String movieGenre = movieGenre(movieInputs);
            movieMap.put(movieId, new Movies(movieId, movieName, movieDate, movieUrl, movieGenre));
        }
        // Closes and returns the reader.
        movieReader.close();
        return movieMap;
    }

    // Method For Assigning the genre Variable for the object in the above method
    // Changes the genre varaible depending on which index in the array is 1 and returns it for assignment
    private static String movieGenre(String[] movieInputs) {
        String genre = "";
        StringBuilder regenre = new StringBuilder(genre);
        if (movieInputs[5].equals("1"))
        {
            regenre.insert(0, "| Action |");
        }
        if (movieInputs[6].equals("1"))
        {
            regenre.insert(0, "| Adventure |");
        }
        if (movieInputs[7].equals("1"))
        {
            regenre.insert(0, "| Animation |");
        }
        if (movieInputs[8].equals("1"))
        {
            regenre.insert(0, "| Childrens |");
        }
        if (movieInputs[9].equals("1"))
        {
            regenre.insert(0, "| Comedy |");
        }
        if (movieInputs[10].equals("1"))
        {
            regenre.insert(0, "| Crime |");
        }
        if (movieInputs[11].equals("1"))
        {
            regenre.insert(0, "| Documentary |");
        }
        if (movieInputs[12].equals("1"))
        {
            regenre.insert(0, "| Drama |");
        }
        if (movieInputs[13].equals("1"))
        {
            regenre.insert(0, "| Fantasy |");
        }
        if (movieInputs[14].equals("1"))
        {
            regenre.insert(0, "| Film-Noir |");
        }
        if (movieInputs[15].equals("1"))
        {
            regenre.insert(0, "| Horror |");
        }
        if (movieInputs[16].equals("1"))
        {
            regenre.insert(0, "| Musical |");
        }
        if (movieInputs[17].equals("1"))
        {
            regenre.insert(0, "| Mystery |");
        }
        if (movieInputs[18].equals("1"))
        {
            regenre.insert(0, "| Romance |");
        }
        if (movieInputs[19].equals("1"))
        {
            regenre.insert(0, "| Sci-Fi |");
        }
        if (movieInputs[20].equals("1"))
        {
            regenre.insert(0, "| Thriller |");
        }
        if (movieInputs[21].equals("1"))
        {
            regenre.insert(0, "| War |");
        }
        if (movieInputs[22].equals("1"))
        {
            regenre.insert(0, "| Western |");
        }
        if (regenre.length() == 0) {
            regenre.replace(0, regenre.length(), "Not Found");
        }
        return regenre.toString();
    }

    // Allows the user to search for a movie again using a loop
    // If user enters yes - the search function runs again
    // Otherwise it returns them to the menu
    private static void mSearchAgain() {
        System.out.println(MOVIELINE);
        System.out.println("Would you Like to Search Again?     Y/N");
        System.out.println(MOVIELINE);
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
        Map <Integer, Movies> moviesMap = readMovieFile();
        Scanner mSearch = mSearchScanner();
        System.out.println(MOVIELINE);
        System.out.println("Enter a MovieID: ");
        System.out.println(MOVIELINE);
        int mSearchId = mSearch.nextInt();
        if (moviesMap.containsKey(mSearchId))
        {
            System.out.println("Movie Id Found");
            System.out.println(MOVIELINE);
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
        Map<Integer, Movies> movieMap = readMovieFile();
        System.out.println("Movie Id: " + movieMap.get(userMovieID).getID());
        System.out.println("Movie Name: " + movieMap.get(userMovieID).getName());
        System.out.println("Movie Date: " + movieMap.get(userMovieID).getDate());
        System.out.println("Movie URL: " + movieMap.get(userMovieID).getUrl());
        System.out.println("Movie Genre: " + movieMap.get(userMovieID).getGenre());

    }

    // Private method that splits the line in the scanner 
    private static String[] parseLine(String line) 
    {
        return line.split("::|\t|\\|");
    }

    // Methods to create new Scanners for Search and ReSearch
    private static Scanner mSearchScanner() {
        return new Scanner(System.in);
    }

    private static Scanner mReSearchScanner() {
        return new Scanner(System.in);
    }

    // Public Getters
    public int getID() {
        return this.movieId;
    }

    public String getName() {
        return this.movieName;
    }

    public String getDate() {
        return this.movieDate;
    }

    public String getUrl() {
        return this.movieUrl;
    }

    public String getGenre() {
        return this.movieGenre;
    }
    
    //Public Method to open and Read the file, Checks for errors
    public static void buildMovies() {
        try {
            readMovieFile();
            System.out.println("Movie File Opened Successfully");
        }
        catch (FileNotFoundException fe) {
            System.out.println("File Not Found");
        }
        catch (IOException ie) {
            System.out.println("IO Error Occurred");
        }
    }
}
