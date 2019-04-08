/**
 * Details of movies: title, director, actor and rating.
 * 
 * @author Mayue Jiang
 * @version 2017.05.24
 */
public class Movie 
{
	private String title;
	private String director;
	private String[] actor;
	private int rating;

	/**
     * Default constructor of Movie class 
     */
	public Movie() 
	{
		title = "";
		director = "";
		actor = new String[3];
		rating = 0;
	}

	/**
     * Constructor of Movie class
     * @param title The name of each movie.
     * @param director The director of each movie.
     * @param actor The main actors of each movie.
     * @param rating The rate of each movie.
     */
	public Movie(String title, String director, String[] actor, int rating) 
	{
		if (Movie.validTitle(title))
			this.title = title;

		if (Movie.validTitle(director))
			this.director = director;

		if (Movie.validActor(actor))
			this.actor = actor;

		if (Movie.validRating(rating))
			this.rating = rating;
	}

	/**
     * Method for displaying movies' details
     */
	public void display() 
	{
		String actors = "";
		for (int i = 0; i < actor.length; i++) 
		{
			actors += actor[i] + ",";
		}
		System.out.println(title + "," + director + "," + actors + rating);
	}
	
	/**
     * @return The actor.
     */
	public String[] getActor() 
	{
		return actor;
	}
	
	/**
     * @return The director.
     */
	public String getDirector() 
	{
		return director;
	}
	
	/**
     * @return The rating.
     */
	public int getRating() 
	{
		return rating;
	}
	
	/**
     * @return The title.
     */
	public String getTitle() 
	{
		return title;
	}

	/**
	 * Method of seting movie's actors
     * @param sctor The main actors of each movie.
     */
	public void setActor(String[] actor) 
	{
		if (Movie.validActor(actor))
			this.actor = actor;
	}
	
	/**
	 * Method of seting movie's director
     * @param director The director of each movie.
     */
	public void setDirector(String director) 
	{
		if (Movie.validTitle(director))
			this.director = director;
		else
			System.out.println("Error：director can't be null");
	}

	/**
	 * Method of giving movie's rate
     * @param rating The rate of each movie.
     */
	public void setRating(int rating) 
	{
		if (Movie.validRating(rating))
			this.rating = rating;
	}
	
	/**
	 * Method of seting movie's title
     * @param title The name of each movie.
     */
	public void setTitle(String title) 
	{
		if (Movie.validTitle(title))
			this.title = title;
	}

	/**
     * Method to validate movies' actor
     * @param actor The actors of movie
     */
	public static boolean validActor(String[] actor) 
	{
		if (actor.length > 0) 
		{
			for (int i = 0; i < actor.length; i++) 
			{
				if (actor[i].trim().length() != 0)
					return true;
			}
		}
		System.out.println("actor cannot be null, please enter again");
		return false;
	}

	/**
     * Method to validate movies' director
     * @param director The director of movie
     */
	public static boolean validDirector(String director) 
	{
		if (director.trim().length() != 0)
			return true;
		System.out.println("director cannot be null, please enter again");
		return false;
	}

	/**
     * Method to validate movies' rate
     * @param rating The rate of movie
     */
	public static boolean validRating(int rating) 
	{
		if (rating > 0 && rating < 11)
			return true;
		System.out.println("rating must be integer 1-10,please enter again");
		return false;
	}
	
	/**
     * Method to validate movies' title
     * @param title The title of movie
     */
	public static boolean validTitle(String title) 
	{
		if (title.trim().length() != 0)
			return true;
		System.out.println("title cannot be null, please enter again");
		return false;
	}
}
