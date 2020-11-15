import java.util.InputMismatchException;
import java.util.Scanner;


public class Moviedb {
    public static void main(String[] args) {
        Users a = new Users();
        Movies m = new Movies();
        Ratings r = new Ratings();
        
        moviefunction(m);
        userfunction(a);
        ratingfunction(r);
        menu();
    }

    public static void userfunction(Users a) {
        a.buildUsers();
    }
    private static void moviefunction(Movies m) {
        m.openMovieFile();
    }
    private static void ratingfunction(Ratings r){
        r.openRatingFile();
    }

    private static void displaymenu()
    {
        String menuline = "*****************";
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
        Scanner menuin = new Scanner(System.in);
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
                    menuin.close();
                    break;
                }
                else if (choice == 2)
                {
                    System.out.println("Movie Search");
                    menuin.close();
                    break;
                }
                else if (choice == 3)
                {
                    System.out.println("Ratings");
                    menuin.close();
                    break;
                }
                else if (choice == 4)
                {
                    System.out.println("Quitting");
                    menuin.close();
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
