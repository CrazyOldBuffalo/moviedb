import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Moviedb {

    // Main Function for running each function required to build and use the program
    public static void main(String[] args) {        
        moviefunction();
        userfunction();
        ratingfunction();
        menu();
    }

    // Private scanner method for menu Input
    private static Scanner MenuScanner() {
        return new Scanner(System.in);
    }

    // Public functions used to create the class and use it's methods
    public static void userfunction() {
        Users.buildUsers();
    }

    public static void moviefunction() {
        Movies.buildMovies();
    }

    public static void ratingfunction(){
        try {
            Ratings.readRatings();
        }
        catch (FileNotFoundException rfe)
        {
            System.out.println("Ratings File Not found");
        }
    }

    // Public Function to access the Search Functionality of each Class
    public static void userSearch() {
        try {
            Users.uSearch();
        }
        catch (IOException ioe)
        {
            System.out.println("IO Error" );
        }
    }

    public static void movieSearch() {
        try {
            Movies.mSearch();
        }
        catch (IOException mioe)
        {
            System.out.println("IO Error");
        }
    }

    public static void ratingSearch() {
        try {
            Ratings.averageMovieRating();
        }
        catch (IOException rioe)
        {
            System.out.println("IO Error");
        }
    }


    // Private method to display a menu to the user
    // Called at the start of the menu method
    private static void displaymenu()
    {
        String menuline = "**********************";
        System.out.println(menuline);
        System.out.println("Movie DB");
        System.out.println("Main Menu");
        System.out.println(menuline);
        System.out.println("1:      Find User");
        System.out.println("2:      Find Movie");
        System.out.println("3:      Find Ratings");
        System.out.println("4:      Quit");
        System.out.println(menuline);
        System.out.println("Make a Selection: ");
        System.out.println(menuline);
    }

    // Menu Method that allows the user to enter their search term
    // Loops if the user enters an incorrect statement and catches errors if the user enters a character or symbol
    // User input takes them to a corresponding method for searching the Map
    public static void menu() {
        Scanner menuin = MenuScanner();
        boolean menuloop = true;
        while (menuloop)
        {
            displaymenu();
            try
            {
                int choice = menuin.nextInt();
                if (choice == 1)
                {
                    System.out.println("User Search");
                    menuloop = false;
                    userSearch();
                    break;
                }
                else if (choice == 2)
                {
                    System.out.println("Movie Search");
                    menuloop = false;
                    movieSearch();
                    break;
                }
                else if (choice == 3)
                {
                    System.out.println("Ratings");
                    menuloop = false;
                    ratingSearch();
                    break;
                }
                else if (choice == 4)
                {
                    System.out.println("Quitting");
                    menuloop = false;
                    System.exit(1);
                }
                else {
                    System.out.println("Invalid input");
                }
            }
            catch (InputMismatchException mis)
            {
                System.out.println("Invalid input");
                menuin.next();
            }
            
        }
    }
    
}
