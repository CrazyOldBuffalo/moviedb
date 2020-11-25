import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// Class specific for searching through the different Items on the list
public class RatingSearch {

    private static String ratingLine = "****************";

    // Private method for returning a new Scanner Object
    private static Scanner ratingsScanner() {
        return new Scanner(System.in);
    }

    private static BufferedWriter ratingSearchFile() throws IOException {
        return new BufferedWriter(new FileWriter("RatingSearchFile.txt", true));
    }
    // Allows user to search for the Average Movie Rating again converts input into lower and then 
    // compares If input == y runs function again otherwise returns to menu
    private static void reAverageMovieRating() throws IOException{
        System.out.println(ratingLine);
        System.out.println("Would you like to Calculate a new Movie Average?    Y/N");
        System.out.println(ratingLine);
        boolean reAverageMovieLoop = true;
        while (reAverageMovieLoop)
        {
            Scanner reAverageMovieScanner = ratingsScanner();
            String reAverageMovie = reAverageMovieScanner.nextLine().toLowerCase();
            if (reAverageMovie.equals("y"))
            {
                System.out.println("Searching Again");
                reAverageMovieLoop = false;
                averageMovieRating();
            }
            else if (reAverageMovie.equals("n"))
            {
                System.out.println("Returning to Menu");
                reAverageMovieLoop = false;
                Moviedb.menu();
            }
            else {
                System.out.println("Invalid Input, please Enter Y or N");
            }
        }
    }

    // Public method for calculating the average Rating of a movie. Creates an instance of the List
    // and loops through the file when a movieId is specified. Reads through the ratingList and every
    // Instance is added to another list called AverageMovie. Checks if the new list is empty and if so throws an error
    // Otherwise the list loops through the new list and adds to the total (All Ratings added together)
    // The Total is then divided by the size of the new list to create the average and it is then outputted
    public static void averageMovieRating() throws IOException {
        List<Ratings> ratingList = Ratings.readRatings();
        List<Integer> averageMovie = new ArrayList<Integer>();
        BufferedWriter movieRatingFileWriter = ratingSearchFile();
        boolean movieRatingLoop = true;
        while (movieRatingLoop)
        {
            try {
                Scanner averageMovieScanner = ratingsScanner();
                System.out.println(ratingLine);
                System.out.println("Enter a MovieID to Calculate the Average Movie Rating");
                System.out.println(ratingLine);
                int userMovieRatingID = averageMovieScanner.nextInt();
                int movieTotal = 0;
                for (int i = 0; i < ratingList.size(); i++ )
                {
                    if ((ratingList.get(i).getmovieRatings()) == userMovieRatingID )
                    {
                        averageMovie.add(ratingList.get(i).getratings());
                    }
                }
                if (averageMovie.isEmpty())
                {
                    System.out.println("No Ratings Found For that ID");
                    movieRatingLoop = false;
                    reAverageMovieRating();
                }
                else {
                    for (int i = 0; i < averageMovie.size(); i++) 
                    {
                        movieTotal += averageMovie.get(i);
                    }
                    int movieAverage = (movieTotal / averageMovie.size());
                    MovieSearch.ratingsMovies(userMovieRatingID);
                    System.out.println("Average Rating is: " + movieAverage);
                    movieRatingFileWriter.append("You Searched for average Movie Ratings by MovieID: " + userMovieRatingID + "\n" + "Average Movie Rating is: " + movieAverage + "\n");
                    movieRatingFileWriter.append("========================================================" + "\n");
                    movieRatingFileWriter.close();
                    movieRatingLoop = false;
                    reAverageMovieRating();
                }
            }
            catch (InputMismatchException rME)
            {
                System.out.println("Invalid Input, Please Enter a MovieID");
            }
        }
    }
    
    // Re-Search method for allowing the user to search for the average user rating
    // Loops until user enters Y or N
    private static void reAverageUserRating() throws IOException{
        System.out.println(ratingLine);
        System.out.println("Would you like to calculate a new User Average?     Y/N");
        System.out.println(ratingLine);
        boolean reAverageUserLoop = true;
        while (reAverageUserLoop)
        {
            Scanner reAverageUserScanner = ratingsScanner();
            String reAverageUser = reAverageUserScanner.nextLine().toLowerCase();
            if (reAverageUser.equals("y"))
            {
                System.out.println("Searching Again");
                reAverageUserLoop = false;
                averageUserRating();
            }
            else if (reAverageUser.equals("n"))
            {
                System.out.println("Returning to Menu");
                reAverageUserLoop = false;
                Moviedb.menu();
            }
        }
    }
    
    // Method for calulcating the average user rating a User gives
    // Works in same way as Movie Rating but checks if the USERID matches the searchterm instead
    public static void averageUserRating() throws IOException{
        List<Ratings> ratingList = Ratings.readRatings();
        List<Integer> averageUser = new ArrayList<Integer>();
        BufferedWriter userRatingFileWriter = ratingSearchFile();
        boolean averageUserLoop = true;
        while (averageUserLoop)
        {
            try {
                Scanner averageUserScanner = ratingsScanner();
                System.out.println(ratingLine);
                System.out.println("Enter a UserID to calculate the average User Rating");
                System.out.println(ratingLine);
                int ratingUserId = averageUserScanner.nextInt();
                int userTotal = 0;
                for (int i = 0; i < ratingList.size(); i++)
                {
                    if (ratingList.get(i).getuserRatings() == ratingUserId) 
                    {
                        averageUser.add(ratingList.get(i).getratings());
                    }
                }
                if (averageUser.isEmpty())
                {
                    System.out.println("No Ratings found for UserID");
                    averageUserLoop = false;
                    reAverageUserRating();
                }
                else {
                    for (int i = 0; i < averageUser.size(); i++)
                    {
                        userTotal += averageUser.get(i);
                    }
                    int userAverage = userTotal / averageUser.size();
                    UserSearch.userRating(ratingUserId);
                    System.out.println("Average Rating is: " + userAverage);
                    userRatingFileWriter.append("You Searched for Average Rating by UserID: " + ratingUserId + "\n" + "Average Rating = " + userAverage + "\n");
                    userRatingFileWriter.append("========================================================" + "\n");
                    userRatingFileWriter.close();
                    averageUserLoop = false;
                    reAverageUserRating();
                }
            }
            catch (InputMismatchException uME)
            {
                System.out.println("Invalid Input, please Enter a valid UserID");
            }
        }
    }
    
    private static void reTwoUsers() throws IOException{
        System.out.println(ratingLine);
        System.out.println("Would you like to find the number of films rated by the same user again?     Y/N");
        System.out.println(ratingLine);
        boolean reAverageUserLoop = true;
        while (reAverageUserLoop)
        {
            Scanner reAverageUserScanner = ratingsScanner();
            String reAverageUser = reAverageUserScanner.nextLine().toLowerCase();
            if (reAverageUser.equals("y"))
            {
                System.out.println("Searching Again");
                reAverageUserLoop = false;
                twoUsers();
            }
            else if (reAverageUser.equals("n"))
            {
                System.out.println("Returning to Menu");
                reAverageUserLoop = false;
                Moviedb.menu();
            }
        }
    }
    // Allows the user to enter the ID of 2 users, Checks if they're actual numbers (returns them back if not)
    // Loops through all ratings in the list for the userID, and adds it to a seperate sortList containing the movieID rated by each user
    // Once each list is complete it checks for all movieID's stored in both Lists by looping through whichever list is longer 
    //(to ensure all items are covered). The items found in both are added to a seperate List, this list is checked if it's empty
    // if so it prints out that no items were found, otherwise it prints the contents of the list.
    public static void twoUsers() throws IOException {
        Scanner twoUserScanner = ratingsScanner();
        BufferedWriter twoUserFileWriter = ratingSearchFile();
        List<Ratings> ratingList = Ratings.readRatings();
        List<Integer> sortLista = new ArrayList<Integer>();
        List<Integer> sortListb = new ArrayList<Integer>();
        List<Integer> sortedList = new ArrayList<Integer>();
        boolean twoUserLoop = true;
        while(twoUserLoop)
        {
            try {
                System.out.println("Enter the First userID: ");
                int usera = twoUserScanner.nextInt();
                System.out.println("Enter the Second userID: ");
                int userb = twoUserScanner.nextInt();
                twoUserLoop = false;
                for (int i = 0; i < ratingList.size(); i++)
                {
                    if (ratingList.get(i).getuserRatings() == usera)
                    {
                        sortLista.add(ratingList.get(i).getmovieRatings());
                    }
                    if (ratingList.get(i).getuserRatings() == userb)
                    {
                        sortListb.add(ratingList.get(i).getmovieRatings());
                    }
                }
                if (sortLista.size() > sortListb.size())
                {
                    for (int i = 0; i < sortLista.size(); i++)
                    {
                        if (sortLista.contains(sortLista.get(i)) && sortListb.contains(sortLista.get(i)))
                        {
                            sortedList.add(sortLista.get(i));
                        }
                    }
                }
                else if (sortListb.size() > sortLista.size())
                {
                    for (int i = 0; i < sortListb.size(); i++)
                    {
                        if (sortLista.contains(sortListb.get(i)) && sortListb.contains(sortListb.get(i)))
                        {
                            sortedList.add(sortListb.get(i));
                        }
                    }
                }
                else if (sortLista.size() == sortListb.size())
                {
                    for (int i = 0; i < sortLista.size(); i++)
                    {
                        if (sortLista.contains(sortLista.get(i)) && sortListb.contains(sortLista.get(i)))
                        {
                            sortedList.add(sortLista.get(i));
                        }
                    }
                }
                if (sortedList.isEmpty())
                {
                    System.out.println("No ratings for Both users found for a movieID");
                }
                else
                {
                    System.out.println("User " + usera + " & User " + userb + " Have Rated: ");
                    System.out.println(sortedList.size() + " Files in Total!");
                    System.out.println(ratingLine);
                    twoUserFileWriter.append("You Searched for: " + usera + " & " + userb + "\n" + "They Rated: " + sortedList.size() + " Files in Total!" + "\n");
                    for (int i = 0; i < sortedList.size(); i++)
                    {
                        System.out.println("Movie Id: " + sortedList.get(i) + "| Movie Name: " + MovieSearch.twoUserMovies(sortedList.get(i)));
                        twoUserFileWriter.append("Movie ID: " + sortedList.get(i) + "| Movie Name: " + MovieSearch.twoUserMovies(sortedList.get(i)) + "\n");
                    }
                    twoUserFileWriter.append("=================================================================" + "\n");
                    twoUserFileWriter.close();
                }
            }
            catch (InputMismatchException tuIME)
            {
                System.out.println("Please Enter A valid Number");
                twoUserScanner.next();
            }
        } 
        reTwoUsers();
    }
}
