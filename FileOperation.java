import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class for input and output of movielist file.
 * 
 * @author Mayue Jiang
 * @version 2017.05.24
 */
public class FileOperation 
{
    private List<Movie> movieList;
    
    /**
     * Default constructor of FileOperation class
     *
     */
	public FileOperation() 
	{
	    movieList = new ArrayList<>();
	}
	
	/**
     * Constructor of FileOperation class
     * @param movieList The list of movies
     *  
     */
	public FileOperation(List<Movie> movieList) 
	{
	    this.movieList = movieList;
	}

	/**
     * Static method of reading file
     * @param movieList The list of movies
     *  
     */
	public static void read(List<Movie> movieList) 
	{
		try 
		{
			String fileName = "myvideos.txt";
			FileReader fileReader = new FileReader(fileName);
			Scanner sc = new Scanner(fileReader);
			while (sc.hasNextLine()) 
			{
				String line = sc.nextLine();
				String[] stringArray = line.split(",");
				Movie movie = new Movie();
				movie.setTitle(stringArray[0]);
				movie.setDirector(stringArray[1]);
				String actors = stringArray[2];
				movie.setActor(actors.split("，"));
				int rating = Integer.parseInt(stringArray[3]);
				movie.setRating(rating);
				movieList.add(movie);
			}
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("File is not found");
		}
	}
	
	/**
     * Static method of writing file
     * @param movieList The list of movies
     *  
     */
	public static void write(List<Movie> movieList) 
	{
		File file = new File("myvideos.txt");
		try 
		{
			PrintWriter printWriter = new PrintWriter(file);
			for (int i = 0; i < movieList.size(); i++) 
			{
				String title = movieList.get(i).getTitle();
				String director = movieList.get(i).getDirector();
				String[] actor = movieList.get(i).getActor();
				int rating = movieList.get(i).getRating();
				String printStr = title + "," + director + ",";
				for (int j = 0; j < actor.length; j++) 
				{
					printStr += actor[j] + "，";
				}

				printStr += "," + rating;
				printWriter.println(printStr);
				printWriter.flush();
			}
			printWriter.close();
		} 
		catch (FileNotFoundException f) 
		{
			System.out.print("File is not found");
		}
	}
}
