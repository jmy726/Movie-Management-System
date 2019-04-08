import java.util.List;
import java.util.ArrayList;

/**
 * Class for validation data.
 * 
 * @author Mayue Jiang
 * @version 2017.05.24
 */
public class Validation 
{
    private List<Movie> list;
    
    /**
     * Default constructor of Validation class
     */
	public Validation() 
	{
	    list = new ArrayList<>();
	}
	
	/**
     * Constructor of Validation class
     * @param list The list of movies
     */
	public Validation(List<Movie> list) 
	{
	    this.list = list;
	}

	/**
     * Method to vaildate Movie's title
     * @param title The title of movie
     * @param list The list of movies
     */
	public static boolean validMovie(String title, List<Movie> list) 
	{
		for (Movie oldMovie : list) 
		{
			if (oldMovie.getTitle().equals(title)) 
			{
				System.out.println("Same title, please enter again");
				return false;
			}
		}
		return true;
	}
}
