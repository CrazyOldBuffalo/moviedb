import java.io.BufferedReader;
import java.io.IOException;

public class Users {
    private int userId;

    public void openUserFile(BufferedReader userReader)
    {
        System.out.println("User File Opened Successfully");
    }

    public void readfile(BufferedReader userReader) throws IOException{
            String line;
            while ((line = userReader.readLine()) != null) {
                String[] Userinputs = parseLine(line);
                int id = Integer.parseInt(Userinputs[0]);
                int age = Integer.parseInt(Userinputs[1]);
                String gender = Userinputs[2];
                String occupation = Userinputs[3];
                String zip = Userinputs[4];
                System.out.println(id + age + gender + occupation + zip);
            }
            userReader.close();
    }

    private String[] parseLine(String line) {
        return line.split("::|\t|\\|");

    }

    //public void getuserFile(){
        
   //     a.getuserFile();
   //     while ((line = userReader.readLine()) != null)
    //        {
    //            String[] data = parseLine(line);
    //            String id = data[0]; 
    //            System.out.println(id);
    //        }
    //        userReader.close();
    //    }
    //    catch (IOException e) {
   //     System.out.println("File Not Found");
    //    }
}
