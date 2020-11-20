import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Movies {
    private int movieId;
    private String movieName;
    private String movieDate;
    private String movieUrl;
    private String movieGenre;
    public static final String MOVIELINE = "****************";

    public Movies(int id, String name, String date, String url, String genre) {
        this.movieId = id;
        this.movieName = name;
        this.movieDate = date;
        this.movieUrl = url;
        this.movieGenre = genre;
    }

    private static BufferedReader openMovieFile() throws FileNotFoundException {
        return new BufferedReader(new FileReader("data/movies.dat"));
    }

    private static Map<Integer, Movies> readMovieFile() throws IOException {
        Map<Integer, Movies> movieMap = new HashMap<Integer, Movies>();
        BufferedReader movieReader = openMovieFile();
        String line = null;

        while ((line = movieReader.readLine()) != null) {
            String[] movieInputs = parseLine(line);
            int movieId = Integer.parseInt(movieInputs[0]);            
            String movieName = movieInputs[1];
            String movieDate = movieInputs[2];
            String movieUrl = movieInputs[4];
            String movieGenre = movieGenre(movieInputs);
            movieMap.put(movieId, new Movies(movieId, movieName, movieDate, movieUrl, movieGenre));
        }
        movieReader.close();
        return movieMap;
    }

    private static String movieGenre(String[] movieInputs) {
        String Genre;
        if (movieInputs[5].equals("1"))
        {
            Genre = "Action";
        }
        else if (movieInputs[6].equals("1"))
        {
            Genre = "Adventure";
        }
        else if (movieInputs[7].equals("1"))
        {
            Genre = "Animation";
        }
        else if (movieInputs[8].equals("1"))
        {
            Genre = "Childrens";
        }
        else if (movieInputs[9].equals("1"))
        {
            Genre = "Comedy";
        }
        else if (movieInputs[10].equals("1"))
        {
            Genre = "Crime";
        }
        else if (movieInputs[11].equals("1"))
        {
            Genre = "Documentary";
        }
        else if (movieInputs[12].equals("1"))
        {
            Genre = "Drama";
        }
        else if (movieInputs[13].equals("1"))
        {
            Genre = "Fantasy";
        }
        else if (movieInputs[14].equals("1"))
        {
            Genre = "Film-Noir";
        }
        else if (movieInputs[15].equals("1"))
        {
            Genre = "Horror";
        }
        else if (movieInputs[16].equals("1"))
        {
            Genre = "Musical";
        }
        else if (movieInputs[17].equals("1"))
        {
            Genre = "Mystery";
        }
        else if (movieInputs[18].equals("1"))
        {
            Genre = "Romance";
        }
        else if (movieInputs[19].equals("1"))
        {
            Genre = "Sci-Fi";
        }
        else if (movieInputs[20].equals("1"))
        {
            Genre = "Thriller";
        }
        else if (movieInputs[21].equals("1"))
        {
            Genre = "War";
        }
        else if (movieInputs[22].equals("1"))
        {
            Genre = "Western";
        }
        else {
            Genre = "Not Found";
        }
        return Genre;
    }


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
            System.out.println("Movie Id: " + moviesMap.get(mSearchId).getID());
            System.out.println("Movie Name: " + moviesMap.get(mSearchId).getName());
            System.out.println("Movie Date: " + moviesMap.get(mSearchId).getDate());
            System.out.println("Movie Url: " + moviesMap.get(mSearchId).getUrl());
            mSearchAgain();
        }
        else {
            System.out.println("Movie Id Not Found");
            mSearchAgain();
        }

    }
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
