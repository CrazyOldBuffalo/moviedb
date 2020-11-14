import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Movies {


    public void openMovieFile() {
        try {
            BufferedReader movieReader = new BufferedReader(new FileReader("data/movies.dat"));
            System.out.println("Movies File Opened Successfully");
            readMovieFile(movieReader);
        } catch (IOException ioe) {
            System.out.println("File Failed to Open");
        }
    }

    public void readMovieFile(BufferedReader movieReader) throws IOException {
        String line;
        while ((line = movieReader.readLine()) != null) {
            String[] movieInputs = parseLine(line);
            int id = Integer.parseInt(movieInputs[0]);            
            String name = movieInputs[1];
            String date = movieInputs[2];
        } 
    }

    private String[] parseLine(String line) 
    {
        return line.split("::|\t|\\|");
    }
}
