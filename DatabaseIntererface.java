import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Provide a movie database system interface to user.
 * Five choices provide access to use this database system.
 * 
 *      One to search movies.
 *      
 *      One to allow user to add movies to database.
 *      
 *      One to allow user to delete movies from database.
 *      
 *      One to show your favorite movies according to your rating.
 *      
 *      One to exit this system.
 * 
 * @author Mayue Jiang 
 * @version 2017.05.25
 */
public class DatabaseIntererface 
{
    private MovieList movieList;
    private Scanner sc = new Scanner(System.in);

    /**
     * Default constructor for objects of class DatabaseIntererface
     */
    public DatabaseIntererface() 
    {
        movieList = new MovieList();
    }

    /**
     * Constructor for objects of class DatabaseIntererface
     * @param the list of movie
     */
    public DatabaseIntererface(MovieList movieList) 
    {
        this.movieList = movieList;
    }

    /**
     * Method of adding movies by entering title, director,
     * actors and rating. 
     */
    public void addMovie() 
    {
        String title = null;
        String director = null;
        int rating = 0;
        String[] actor = null;
        title = writeTitle(title);
        director = writeDirector(director);
        rating = writeRating(rating);
        actor = writeActor(actor);
        
        if (movieList.add(title, director, actor, rating))
            System.out.println("Add successfully");
        else
            System.out.println("Fail adding");
    }

    /**
     * Method of deleting movies by entering title. 
     */
    public void deleteMovie() 
    {
        String title;
        while (true) 
        {
            System.out.println("Please enter title: ");
            title = this.getInput();
            if (Movie.validTitle(title)) 
            {
                if (movieList.remove(title)) 
                {
                    System.out.println("Finish deleting");
                    break;
                }
                System.out.println("Movie doesn't exist");
                break;
            }
            continue;
        }
    }

    /**
     * Method of editing movies. Rating and actors are two fields can be edited.
     */
    public void editMovie() 
    {
        while (true) 
        {
            System.out.println("Please enter title: ");
            String title = this.getInput();
            if (Movie.validTitle(title)) 
            {
                Movie movie = movieList.searchOne(title);
                if (movie == null) 
                {
                    System.out.println("Movie doesn't exist");
                    return;
                }
                int rating = 0;
                String[] actor = null;
                rating = writeRating(rating);
                actor = writeActor(actor);
                movie.setRating(rating);
                movie.setActor(actor);
                System.out.println("Finish editing");
                return;
            }
        }
    }
    
    /**
     * Method of displaying your favorite movies according rating. 
     */
    public void favoriteMovie() 
    {
        int parseInt;
        while (true) 
        {
            System.out.println("Please enter 1-10 integer for rating");
            String input = this.getInput();
            try 
            {
                parseInt = Integer.parseInt(input);
            } 
            catch (NumberFormatException e) 
            {
                System.out.println("Error: Only can enter 1-10 integer");
                continue;
            }
            
            if (Movie.validRating(parseInt)) 
            {
                List<Movie> favoriteList = movieList.favouriteList(parseInt);
                for (Movie movie : favoriteList) 
                {
                    movie.display();
                }
                return;
            }
        }
    }

    /**
     * Method of reading input from the user. 
     */
    private String getInput() 
    {
        return sc.nextLine();
    }
    
    /**
     * Method of reading a series of choices from the user to interact. 
     * Stop when the user types '5'.
     */
    public void run() 
    {
        movieList.read();
        while (true) 
        {
            System.out.println("");
            System.out.println("=================================");
            System.out.println("Welecome to movie database system");
            System.out.println("(1) Search Movies");
            System.out.println("(2) Add Movie");
            System.out.println("(3) Delete Movie");
            System.out.println("(4) Display Favourite Movies");
            System.out.println("(5) Edit Movies");
            System.out.println("(6) Exit System");
            System.out.println("=================================");
            String input = this.getInput();
            switch (input) 
            {
                case "1":
                this.searchMovie();
                break;
                case "2":
                this.addMovie();
                break;
                case "3":
                this.deleteMovie();
                break;
                case "4":
                this.favoriteMovie();
                break;
                case "5":
                this.editMovie();
                break;
                case "6":
                System.out.println("Exit");
                movieList.write();
                return;
                default:
                System.out.println("Error: Please enter 1-6 choice");
                continue;
            }
        }
    }

    /**
     * Method of searching movies by entering title. 
     */
    public void searchMovie() 
    {
        System.out.println("Please make choice: ");
        System.out.println("(1) Search by title");
        System.out.println("(2) Search by director");
        String input = this.getInput();

        switch(input)
        {
            case "1":
            while (true) 
            {
                System.out.println("Please enter title: ");
                String title = this.getInput();
                if (Movie.validTitle(title)) 
                {
                    ArrayList<Movie> list = movieList.search(title);
                    if (list.size() > 0) 
                    {
                        for (Movie movie : list) 
                        {
                            movie.display();
                        }
                    } 
                    else 
                        System.out.println("Movie doesn't exist.");
                    break;
                }
                continue;
            }
            break;
            case "2":
            while (true) 
            {
                System.out.println("Please enter director: ");
                String director = this.getInput();
                if (Movie.validDirector(director)) 
                {
                    ArrayList<Movie> list = movieList.searchByDirector(director);
                    if (list.size() > 0) 
                    {
                        for (Movie movie : list) 
                        {
                            movie.display();
                        }
                    }
                    else 
                        System.out.println("不存在");
                    break;
                }
                continue;
            }
            break;
            default:
            System.out.println("Please enter choice 1 or 2");
            break;
        }
    }
    
    /**
     * Method of edit movie's actor. 
     * @param actor The actors of movie
     */
    private String[] writeActor(String[] actor) 
    {
        while (true) 
        {
            System.out.println("Please enter actor(use',' to split): ");
            String actors = this.getInput();
            actor = actors.split(",");
            if (actor.length > 3) 
            {
                String[] array = new String[3];
                for (int i = 0; i < 3; i++) 
                {
                    array[i] = actor[i];
                }
                actor = array;
            } 
            else if (actor.length == 1) 
            {
                String[] array = new String[3];
                array[0] = actor[0];
                array[1] = "";
                array[2] = "";
            } 
            else 
            {
                String[] array = new String[3];
                array[0] = actor[0];
                array[1] = actor[1];
                array[2] = "";
            }
            
            if (Movie.validActor(actor))
                break;
        }
        return actor;
    }

    /**
     * Method of input movie's director.
     * @param director The director of movie
     */
    private String writeDirector(String director) 
    {
        while (true) 
        {
            System.out.println("Please enter director: ");
            director = this.getInput();
            if (Movie.validDirector(director))
                break;
        }
        return director;
    }

    /**
     * Method of edit movie's rate. 
     * @param rating The rate of movie
     */
    private int writeRating(int rating) 
    {
        while (true) 
        {
            System.out.println("Please enter new integer rating 1-10: ");
            String ratingStr = this.getInput();
            try 
            {
                rating = Integer.parseInt(ratingStr);
            } 
            catch (NumberFormatException e)
            {
                System.out.println("error rating");
                continue;
            }
            
            if (Movie.validRating(rating))
                break;
        }
        return rating;
    }
    
    /**
     * Method of input movie's title.
     * @param title The title of movie
     */
    private String writeTitle(String title) 
    {
        while (true) 
        {
            System.out.println("Please enter title: ");
            title = this.getInput();
            if (Movie.validTitle(title) && 
                Validation.validMovie(title, movieList.getMovieList()))
                break;
        }
        return title;
    }
}