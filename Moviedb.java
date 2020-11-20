import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Moviedb {
    public static void main(String[] args) {        
        moviefunction();
        userfunction();
        //ratingfunction();
        menu();
    }

    public static void userfunction() {
        Users.buildUsers();
    }
    
    private static Scanner MenuScanner() {
        return new Scanner(System.in);
    }

    public static void userSearch() {
        try {
            Users.uSearch();
        }
        catch (IOException ioe)
        {
            System.out.println("IO Error" );
        }
    }

    public static void menuSearch() {
        try {
            Movies.mSearch();
        }
        catch (IOException mioe)
        {
            System.out.println("IO Error");
        }
    }

    public static void moviefunction() {
        Movies.buildMovies();
    }
    //public static void ratingfunction(){
    //    Ratings.buildRatings();
    //}

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
                    menuSearch();
                    break;
                }
                else if (choice == 3)
                {
                    System.out.println("Ratings");
                    menuloop = false;
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
