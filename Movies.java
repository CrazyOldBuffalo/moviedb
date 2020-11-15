import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Movies {


    private BufferedReader openMovieFile() throws FileNotFoundException {
        return new BufferedReader(new FileReader("data/movies.dat"));
    }

    public Map readMovieFile() throws IOException {
        Map<Integer,Movies> movies = new HashMap<Integer, Movies>();
        BufferedReader movieReader = openMovieFile();
        String line = null;

        while ((line = movieReader.readLine()) != null) {
            String[] movieInputs = parseLine(line);
            int movieId = Integer.parseInt(movieInputs[0]);            
            String movieName = movieInputs[1];
            String movieDate = movieInputs[2];
        } 
        return movies;
    }

    private String[] parseLine(String line) 
    {
        return line.split("::|\t|\\|");
    }

    public void buildMovies() {
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
