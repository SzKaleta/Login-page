package Abstract_classes;

public class Movie {
	
	public String Title, Genre, Director;
	public int ID, Year;
	public float Price;
	
	public Movie(String t, String g, String d, int i, int y, float p) {
		this.ID=i;
		this.Title=t;
		this.Genre=g;
		this.Price=p;
		this.Year=y;
		this.Director=d;
	}
}
