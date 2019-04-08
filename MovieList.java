import java.util.ArrayList;
import java.util.Iterator;

/**
 * The class for operating movielist.
 * Provide search, add, remove methods.
 * Provide methods to read and write movielist file.
 * 
 * @author Mayue Jiang
 * @version 2017.05.24
 */
public class MovieList 
{
    private ArrayList<Movie> movieList;

    /**
     * Default constructor of MovieList class
     *  
     */
    public MovieList() 
    {
        movieList = new ArrayList<Movie>();
    }

    /**
     * Constructor of MovieList class
     * @param movieList The list of movies
     */
    public MovieList(ArrayList<Movie> movieList) 
    {
        this.movieList = movieList;
    }

    /**
     * Method of adding movies
     * @param title The name of each movie.
     * @param director The director of each movie.
     * @param actor The main actors of each movie.
     * @param rating The rate of each movie.
     */
    public boolean add(String title, String director, String[] actor, int rating) 
    {
        Movie movie = new Movie(title, director, actor, rating);
        return movieList.add(movie);
    }

    /**
     * Method of showing favorite movies list by rating
     * @param rating The rate of each movie.
     */
    public ArrayList<Movie> favouriteList(int rating) 
    {
        ArrayList<Movie> list = new ArrayList<Movie>();
        for (Movie movie : movieList) 
        {
            if (movie.getRating() >= rating)
                list.add(movie);
        }
        return list;
    }
 
    /**
     * @return The movieList.
     */
    public ArrayList<Movie> getMovieList() 
    {
        return movieList;
    }
    
    /**
     * Method of reading movieList file
     */
    public void read() 
    {
        FileOperation.read(movieList);
    }
    
    /**
     * Method of removing movie's title
     * @param title The name of each movie.
     * @return true or false
     */
    public boolean remove(String title) 
    {
        Iterator<Movie> it = movieList.iterator();
        while (it.hasNext()) 
        {
            Movie mv = it.next();
            if (mv.getTitle().equals(title)) 
            {
                it.remove();
                return true;
            }
        }
        return false;
    }

    /**
     * Method of searching movie's title
     * @param title The name of each movie.
     * @return searchList
     */
    public ArrayList<Movie> search(String title) 
    {
        ArrayList<Movie> searchList = new ArrayList<Movie>();
        for (Movie movie : movieList) 
        {
            if (movie.getTitle().toLowerCase().contains(title.toLowerCase()))
                searchList.add(movie);
        }
        return searchList;
    }

    /**
	 * Method of searching movies by director
     * @param director The director of each movie.
     */
    public ArrayList<Movie> searchByDirector(String director) 
    {
        ArrayList<Movie> list = new ArrayList<Movie>();
        for (Movie movie : movieList) 
        {
            if (movie.getDirector().equals(director))
                list.add(movie);
        }
        return list;
    }

    /**
	 * Method of searching movies by title
     * @param title The title of each movie.
     */
    public Movie searchOne(String title) 
    {
        for (Movie movie : movieList) 
        {
            if (movie.getTitle().equals(title))
                return movie;
        }
        return null;
    }

    /**
	 * Method of seting movielist
     * @param movieList The list of movies.
     */
    public void setMovieList(ArrayList<Movie> movieList) 
    {
        this.movieList = movieList;
    }
    
    /**
     * Method of writing movieList file
     */
    public void write() 
    {
        FileOperation.write(movieList);
    }
}
