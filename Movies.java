import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Movies {

    // Private variables applied to the class when creating the object
    private int movieId;
    private String movieName;
    private String movieDate;
    private String movieUrl;
    private String movieGenre;

    // Constructor for creating an object for the class
    public Movies(int id, String name, String date, String url, String genre) {
        this.movieId = id;
        this.movieName = name;
        this.movieDate = date;
        this.movieUrl = url;
        this.movieGenre = genre;
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
    public static Map<Integer, Movies> buildMovieSearch() throws IOException{
        return readMovieFile();
    }
        
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

    // Private method that splits the line in the scanner 
    private static String[] parseLine(String line) 
    {
        return line.split("::|\t|\\|");
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
}
