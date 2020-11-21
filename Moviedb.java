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
    private static Scanner menuScanner() {
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
            System.out.println("User IO Error" );
        }
    }

    public static void movieSearch() {
        try {
            Movies.mSearch();
        }
        catch (IOException mioe)
        {
            System.out.println("Movie IO Error");
        }
    }

    public static void averageMovieSearch() {
        try {
            Ratings.averageMovieRating();
        }
        catch (IOException rioe)
        {
            System.out.println("Rating IO Error");
        }
    }

    public static void averageUserSearch() {
        try {
            Ratings.averageUserRating();
        }
        catch (IOException uioe)
        {
            System.out.println("Rating IO Error");
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
        System.out.println("3:      Average Movie Rating");
        System.out.println("4:      Average User Rating");
        System.out.println("5:      Average User Rating of 2 Users");
        System.out.println("6:      Quit");
        System.out.println(menuline);
        System.out.println("Make a Selection: ");
        System.out.println(menuline);
    }

    // Menu Method that allows the user to enter their search term
    // Loops if the user enters an incorrect statement and catches errors if the user enters a character or symbol
    // User input takes them to a corresponding method for searching the Map
    public static void menu() {
        Scanner menuin = menuScanner();
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
                }
                else if (choice == 2)
                {
                    System.out.println("Movie Search");
                    menuloop = false;
                    movieSearch();
                }
                else if (choice == 3)
                {
                    System.out.println("Average Movie Rating");
                    menuloop = false;
                    averageMovieSearch();
                }
                else if (choice == 4)
                {
                    System.out.println("Average User Rating");
                    menuloop = false;
                    averageUserSearch();
                }
                else if (choice == 5)
                {
                    System.out.println("Average Rating of 2 Users");
                    System.out.println("NOT IMPLEMENTED YET!");
                }
                else if (choice == 6)
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
