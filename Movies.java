import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Movies {
    private int movieId;
    private String movieName;
    private String movieDate;
    private String movieUrl;
    private String movieGenre;

    public Movies(int id, String name, String date, String url) {
        movieId = id;
        movieName = name;
        movieDate = date;
        movieUrl = url;
        //movieGenre = genre;
    }

    private static BufferedReader openMovieFile() throws FileNotFoundException {
        return new BufferedReader(new FileReader("data/movies.dat"));
    }

    private static Map readMovieFile() throws IOException {
        Map<Integer, Movies> movieMap = new HashMap<Integer, Movies>();
        BufferedReader movieReader = openMovieFile();
        String line = null;

        while ((line = movieReader.readLine()) != null) {
            String[] movieInputs = parseLine(line);
            int movieId = Integer.parseInt(movieInputs[0]);            
            String movieName = movieInputs[1];
            String movieDate = movieInputs[2];
            String movieUrl = movieInputs[4];

            
            movieMap.put(movieId, new Movies(movieId, movieName, movieDate, movieUrl));
        }
        String getMovie = movieMap.get(1).movieName;
        System.out.println(getMovie);
        movieReader.close();
        return movieMap;
    }

    private static String[] parseLine(String line) 
    {
        return line.split("::|\t|\\|");
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
}
