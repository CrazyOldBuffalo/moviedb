import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Users {
    private int userId, userage;
    private String userGender, userOccup, userZip;

    public void openUserFile()
    {
        try {
            BufferedReader userReader = new BufferedReader(new FileReader("data/users.dat"));
            System.out.println("User File Opened Successfully");
            readUserFile(userReader);
        }
        catch (IOException ioe)
        {
            System.out.println("File Failed to Open");
        }
    }

    public void readUserFile(BufferedReader userReader) throws IOException{
            String line;
            while ((line = userReader.readLine()) != null) {
                String[] Userinputs = parseLine(line);
                int id = Integer.parseInt(Userinputs[0]);
                int age = Integer.parseInt(Userinputs[1]);
                String gender = Userinputs[2];
                String occupation = Userinputs[3];
                String zip = Userinputs[4];
            }
            userReader.close();
    }

    

    private String[] parseLine(String line) {
        return line.split("::|\t|\\|");

    }
}
