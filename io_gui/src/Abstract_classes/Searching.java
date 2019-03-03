package Abstract_classes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Searching {
	
	//protected String GenresArray[]= {"thriller", "sci-fi","family","drama","comedy"};
	protected ArrayList<Movie> ListOfMovies = new ArrayList<Movie>();
	protected ArrayList<Movie> FilteredMovies = new ArrayList<Movie>();
	
	public ArrayList<Movie> Search(String title, String director, Integer year, String genre ) {
		FilteredMovies.clear();
		FileReader fileReader;
		
		try {
			fileReader = new FileReader("C:\\Users\\User\\Desktop\\filmy.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			int number=Integer.parseInt(bufferedReader.readLine());
			
			for(int i=0; i<number; i++) {			  
			    int temp_id = Integer.parseInt(bufferedReader.readLine());
			    String temp_title = bufferedReader.readLine();
			    String temp_genre = bufferedReader.readLine();
			    float temp_price = Float.parseFloat(bufferedReader.readLine());
			    int temp_year = Integer.parseInt(bufferedReader.readLine());
			    String temp_director = bufferedReader.readLine();
				Movie temp_movie = new Movie(temp_title, temp_genre, temp_director, temp_id, temp_year, temp_price);
				
				ListOfMovies.add(temp_movie);
			}	    
			
			bufferedReader.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		  
		for(Movie current : ListOfMovies) {
			
			if(current.Title.equals(title) || title == null) {
				FilteredMovies.add(current);
			}
		}
		
		if(director != null || year!=null || genre!=null) {
			
			AdvSearch(director, year, genre);
		}
	  
		
		return FilteredMovies;
	}
	
	private void AdvSearch(String director, Integer year, String genre) {
		FilteredMovies.removeIf(movie -> director != null && !movie.Director.equals(director) ||
								genre != null && !movie.Genre.equals(genre) ||
								year != null && movie.Year != year);
	}

}
