import java.util.*;

public class Movie {
	private String movieName; // Contains name of the movie
	private String genre; // Contains the genre
	private String releaseDate; // Contains the release date of the movie
	private String[] starring; // Contains the main actors of this movie (2)
	private String movieDuration; // movie duration
	private String premiereTime; // First time this movie shows at theater 
	private String showTime;

	// Class constructor 

	public Movie(String movieName, String genre, String releaseDate, String[] starring, Calendar endShowTime, Calendar premierTime ){

		
	}

	public Movie(String movieName, String showTime, String releaseDate){
		this.movieName=movieName;
		this.showTime=showTime;
		this.releaseDate=releaseDate;

	}
	// Setters & Getters
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

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String[] getStarring() {
		return starring;
	}

	public void setStarring(String[] starring) {
		this.starring = starring;
	}

	public String getmovieDuration() {
		return movieDuration;
	}

	public void setMovieDuration(String movieDuration) {
		this.movieDuration = movieDuration;
	}

	public String getPremiereTime() {
		return premiereTime;
	}

	public void setPremiereTime(String premiereTime) {
		this.premiereTime = premiereTime;
	}

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

}
