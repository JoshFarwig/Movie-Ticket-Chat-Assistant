
public class MovieTicket {
	// attributes
	private int ticketID; // contains ID for associated Ticket
	private String relatedMovie; // contains reference to Movie Object
	private String relatedCustomerEmail; // contains reference to Customer
	private String relatedSeat; // contains reference to Seat

	// constructor
	public MovieTicket(int ticketID, String relatedMovie, String relatedCustomerEmail, String relatedSeat) {
		this.ticketID = ticketID;
		this.relatedMovie = relatedMovie;
		this.relatedCustomerEmail = relatedCustomerEmail;
		this.relatedSeat = relatedSeat;
	}

	// getters and setters
	public int getTicketID() {
		return ticketID;
	}

	public void setTicketID(int ticketID) {
		ticketID = this.ticketID;
	}

	public String getRelatedMovie() {
		return relatedMovie;
	}

	public void setRelatedMovie(String relatedMovie) {
		this.relatedMovie = relatedMovie;
	}

	public String getRelatedCustomer() {
		return relatedCustomerEmail;
	}

	public void setRelatedCustomer(String relatedCustomerEmail) {
		this.relatedCustomerEmail = relatedCustomerEmail;
	}

	public String getRelatedSeat() {
		return relatedSeat;
	}

	public void setRelatedSeat(String relatedSeat) {
		this.relatedSeat = relatedSeat;
	}

}
