import java.util.Random;
import java.util.Scanner;


public class Movie {
    private static final Scanner SCANNER = new Scanner(System.in);
    String MovieTitle; // must be 3-20 characters
    String MovieGenre; // Horror, Action, and Comedy only
    int MovieRating; // between 1 and 10
    String MovieID; // XXYYY; X => char and Y => number
    int AdditionalPrice; // based on Genre
    int TotalPrice; // (Movie’s Title Char Length * 500) + Additional Price

    public String getMovieTitle() {
        return MovieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        if (((movieTitle.length() >= 3) && (movieTitle.length() <= 20))) {
            this.MovieTitle = movieTitle;
        } else
            System.out.println("Warning! Please input between 3-20 characters.");
    }

    public String getMovieGenre() {
        return MovieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        String Genre1 = "Horror";
        String Genre2 = "Action";
        String Genre3 = "Comedy";

        if (movieGenre.contentEquals(Genre1) || movieGenre.contentEquals(Genre2) || movieGenre.contentEquals(Genre3)) {
            this.MovieGenre = movieGenre;
        } else
            System.out.println("Warning! Please input: Horror/Action/Comedy.");
    }

    public int getMovieRating() {
        return MovieRating;
    }

    public void setMovieRating(int movieRating) {
        if (((movieRating >= 1) && (movieRating <= 10))) {
            this.MovieRating = movieRating;
        } else
            System.out.println("Warning! Please input between 1-10.");
        this.MovieRating = movieRating;
    }

    public String getMovieID() {
        return MovieID; 
    }

    public void setMovieID() {
        // XXYYY. 5 chars. X => char and Y => number.
        Random random = new Random();
        StringBuilder Code = new StringBuilder();
        int min = 0;
        int max = 999;
        
        while (Code.length() < 2) { 
            char randomizedCharacter = (char) (random.nextInt(26) + 'a');
            Code.append(randomizedCharacter);
        }
        int randomizedInt = (int) (Math.random() * (max - min + 1) + min);
        Code.append(randomizedInt);
        String MovieCode = Code.toString().toUpperCase();
        this.MovieID = MovieCode;
    }

    public int getAdditionalPrice() {
        return AdditionalPrice;
    }

    public void setAdditionalPrice() {
        //Will calculate additional price based on genre
        String CalculateGenre = getMovieGenre();
        if (CalculateGenre.contentEquals("Horror")) {this.AdditionalPrice = 3000;} 
        else if (CalculateGenre.contentEquals("Action")) {this.AdditionalPrice = 4000;}
        else if (CalculateGenre.contentEquals("Comedy")) {this.AdditionalPrice = 5000;}
        else System.out.println("Warning! Please input: Horror/Action/Comedy.");       
    }

    public int getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice() {
        int LengthTitle = getMovieTitle().length();
        int TempPrice = getAdditionalPrice();
        this.TotalPrice = (LengthTitle * 500 ) + TempPrice;
    }

    public void AddMovie(){
        System.out.print("Input Movie Title (Length must be 3-20 characters!)           : ");
        String myTitle = SCANNER.nextLine();
        this.setMovieTitle(myTitle);
        System.out.print("Input Movie Genre (Horror/Action/Comedy)                      : ");
        String myGenre = SCANNER.nextLine();
        this.setMovieGenre(myGenre);
        this.setAdditionalPrice();
        System.out.print("Input Movie Rating (1-10)                                     : ");
        int myRating = SCANNER.nextInt();
        this.setMovieRating(myRating);
        this.setMovieID();
        System.out.println("Generated Movie ID                                            : " + (getMovieID()));
        this.setTotalPrice();
        System.out.println("Total Price                                                   : " + (getTotalPrice()));
    }

    @Override
    public String toString(){
        return getMovieID() + "\t" + getMovieTitle() + "\t" + getMovieGenre() + "\t" + getMovieRating() + "\t" + getTotalPrice();
    }
}
