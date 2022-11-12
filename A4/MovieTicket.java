package A4;
public class MovieTicket {
	// attributes
	private int ticketID; // contains ID for associated Ticket
	private Movie relatedMovie; // contains reference to Movie Object
	private Customer relatedCustomer; // contains reference to Customer
	private Seat relatedSeat; // contains reference to Seat

	// constructor
	public MovieTicket(int ticketID, Movie relatedMovie, Customer relatedCustomer, Seat relatedSeat) {
		this.ticketID = ticketID;
		this.relatedMovie = relatedMovie;
		this.relatedCustomer = relatedCustomer;
		this.relatedSeat = relatedSeat;
	}

	// getters and setters
	public int getTicketID() {
		return ticketID;
	}

	public void setTicketID() {
		this.ticketID = ticketID;
	}

	public Movie getRelatedMovie() {
		return relatedMovie;
	}

	public void setRelatedMovie(Movie relatedMovie) {
		this.relatedMovie = relatedMovie;
	}

	public Customer getRelatedCustomer() {
		return relatedCustomer;
	}

	public void setRelatedMovie(Customer relatedCustomer) {
		this.relatedCustomer = relatedCustomer;
	}

	public Seat getRelatedSeat() {
		return relatedSeat;
	}

	public void setRelatedSeat(Seat relatedSeat) {
		this.relatedSeat = relatedSeat;
	}

}
