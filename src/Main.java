
/**
 *
 * @author Zahra
 */

import java.util.Scanner;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Movie myMovie = new Movie();
        Menu MainMenu = new Menu();
        List<Movie> MovieRentals = new ArrayList<Movie>();

        MainMenu.DisplayMenu();
        int chosen = SCANNER.nextInt();
        //int index = SCANNER.nextInt();
        //int Money = SCANNER.nextInt();;
        //int Charge;
        while (chosen < 4) {
            switch (chosen) {
                case 1:
                    myMovie.AddMovie();
                    MovieRentals.add(myMovie);
                    break;
                case 2:
                    if (MovieRentals.isEmpty()) {
                        System.out.println("NO MOVIE FOUND");
                    } else {
                        System.out.println(" ID " + "\t" + " Title " + "\t" + " Genre " + "\t" + " Rating " + "\t" + " Price ");
                        for (Movie MovieRental : MovieRentals) {
                            System.out.println(MovieRental);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Choose index movie [numeric only]                               : ");
                    break;
                case 4:
                    System.out.println("Program Terminated");
                    break;
            }
        MainMenu.DisplayMenu();
        chosen = SCANNER.nextInt();
        }
    }
}
