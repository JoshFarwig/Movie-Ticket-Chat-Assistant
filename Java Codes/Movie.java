import java.util.*;

public class Movie {
	private String movieName;		// Contains name of the movie
	private String genre;			// Contains the genre
	private Calendar releaseDate;	// Contains the release date of the movie
	private String[] starring;		// Contains the main actors of this movie (2)
	private Calendar endShowTime;	// Last time this movie shows at the theater
	private Calendar premiereTime;	// First time this movie shows at theater
	
	//Setters & Getters
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Calendar getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Calendar releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String[] getStarring() {
		return starring;
	}
	public void setStarring(String[] starring) {
		this.starring = starring;
	}
	public Calendar getEndShowTime() {
		return endShowTime;
	}
	public void setEndShowTime(Calendar endShowTime) {
		this.endShowTime = endShowTime;
	}
	public Calendar getPremiereTime() {
		return premiereTime;
	}
	public void setPremiereTime(Calendar premiereTime) {
		this.premiereTime = premiereTime;
	}
	
	
}
