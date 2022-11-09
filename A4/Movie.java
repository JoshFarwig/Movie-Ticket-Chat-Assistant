
import java.util.*;

public class Movie {
	private String movieName; // Contains name of the movie
	private String genre; // Contains the genre
	private String releaseDate; // Contains the release date of the movie
	private String[] starring; // Contains the main actors of this movie (2)
	private String movieDuration; // movie duration
	private String premiereTime; // First time this movie shows at theater 
	private String showTime;
	private Seat[][] allSeats = {{new Seat("A1", false),new Seat("A2", false), new Seat("A3", false)}, 
							   {new Seat("B1", false),new Seat("B2", false), new Seat("B3", false)}, 
							   {new Seat("C1", false),new Seat("C2", false), new Seat("C3", false)},
							   {new Seat("D1", false),new Seat("D2", false), new Seat("D3", false)}}; // Array of all Seats in Movie

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
	
	public Seat[][] getAllSeats() { 
		return allSeats; 
	} 

	public void setAllSeats(Seat[][] allSeats) {
		this.allSeats = allSeats; 
	}  
	
	public void allSeatsToString() { //toString methods to print out all Available seats
		for(int i = 0; i < allSeats.length; i++) {   
			for(int j = 0; j < allSeats[0].length; j++) {   
				String temp; 
				System.out.print("[" + allSeats[i][j].getSeatID() + " " + (temp = (allSeats[i][j].isIsTaken()) ? "X" : "O") + "]");
			} 
			System.out.println();

		}
	} 
	// method to locate a seat with sameID user inputed, if not return an invalid statement
	public boolean ifSeatExist(String seatID) {
		for(int i = 0; i < allSeats.length; i++) { 
			for(int j = 0; j < allSeats[0].length; j++) { 
				if(allSeats[i][j].getSeatID().compareToIgnoreCase(seatID) == 0) { 
					allSeats[i][j].setIsTaken(true); 
					return true; 
				}
			}
		}  
		return false; 

	} 

	public void cancelSeat(String seatID) { 
		for(int i = 0; i < allSeats.length; i++) { 
			for(int j = 0; j < allSeats[0].length; j++) { 
				if(allSeats[i][j].getSeatID().compareToIgnoreCase(seatID) == 0) { 
					allSeats[i][j].setIsTaken(false); 
				}
			}
		}
	}
	


}
