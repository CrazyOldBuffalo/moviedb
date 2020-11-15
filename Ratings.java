import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ratings {
    public void openRatingFile() {
        try {
            BufferedReader ratingReader = new BufferedReader(new FileReader("data/ratings.dat"));
            System.out.println("Ratings File Opened Successfully");
            readRatingsFile(ratingReader);
            } 
        catch (IOException ioe) {
            System.out.println("File Failed to Open");
            }
    }

    public void readRatingsFile(BufferedReader ratingReader) throws IOException{
        String line;
        while ((line = ratingReader.readLine()) != null)
        {
            String[] ratingInputs = parseline(line);
            int userid = Integer.parseInt(ratingInputs[0]);
            int movieid = Integer.parseInt(ratingInputs[1]);
            int rating = Integer.parseInt(ratingInputs[2]);
            int timestamp = Integer.parseInt(ratingInputs[3]);
        }
    }

    private String[] parseline(String line) {
        return line.split("::|\t|\\|");
    }
}
