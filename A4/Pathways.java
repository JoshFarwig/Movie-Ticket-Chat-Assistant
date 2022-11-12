
 
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Pathways {
	// Intializing Movies
	static ArrayList<Movie> allMovies = new ArrayList<Movie>() {
		{
			add(new Movie("Black Adam", "9:30pm", "September 14, 2022"));
			add(new Movie("Smile", "7:15pm", "May 29, 2022"));
			add(new Movie("Thor", "8:45pm", "October 14, 2022"));
		}
	};
	// Intializing Temporary Customer Storage Array
	static ArrayList<Customer> customers = new ArrayList<Customer>() {
		{
			add(new Customer("Zeyad", 1234, 'M', null, "zee@gmail.com"));
		}
	};
	// intializing MovieTicket Storage Array
	static ArrayList<MovieTicket> ticket_array = new ArrayList<MovieTicket>();
	public static void main(String[] args) {
		boolean checked = true;
		while(checked){
			System.out.println("Hello. How may I help you?");
			System.out.println("1. Book a Ticket \n2. Amend your booking \n3. Cancel your booking");

			Scanner sc = new Scanner(System.in);
			int sel = sc.nextInt();
			String email = "";
			String custName = null;
			char custGender = 0;
			String movieName = null;
			String movieTime = null;

			switch(sel) {
				case 1: {
						System.out.println("Input your email: ");
						email = sc.next(); 
						sc.nextLine(); 

						/*
						* Checking if customer is existing, if yes then print welcome back and save
						* index of this customer so we can create ticket
						*/
						for (int i = 0; i < customers.size(); i++) {
							if (customers.get(i).getEmail().compareTo(email) == 0) {
								System.out.println("Welcome back!");
								custName = customers.get(i).getName();
								custGender = customers.get(i).getGender();
							} else {
								System.out.println("Welcome");
								System.out.print("Please enter your name: ");
								custName = sc.nextLine(); 
								System.out.println("Please enter your gender: (M/F)");
								custGender = sc.next().charAt(0); 
								sc.nextLine();
								customers.add((new Customer(custName, 0, custGender, null, email)));
								break;
							}

						}
					System.out.println("Select a movie: ");
					for (int i = 0; i < allMovies.size(); i++) {
						System.out.println(i + 1 + ". " + allMovies.get(i).getMovieName() + " ");
					}

					// functionality of selecting Movie
					int mov = sc.nextInt();
					boolean isValid = true;
					Movie custMovie = null;
					while (isValid) {
						// if valid
						if (mov <= allMovies.size() && mov > 0) {

							custMovie = allMovies.get(mov-1);
							movieName = custMovie.getMovieName();
							movieTime = custMovie.getReleaseDate() + " " + custMovie.getShowTime();
							System.out.println("Available Timings: " + movieTime);
							isValid = false;
						} else {
							System.out.print("Invalid Input. Please try again: ");
							mov = sc.nextInt();
							custMovie = allMovies.get(mov - 1);
						}
					}

					// functionality of selecting seats
					sc.nextLine();
					custMovie.allSeatsToString(); // displays all seats
					System.out.print("Select your seat: "); // asks for user input
					String custSeat = sc.nextLine(); // saves user input in custSeat
					custMovie.ifSeatExist(custSeat); // checking validity of seat ??? @Josh -zee
					boolean seatValid = custMovie.ifSeatExist(custSeat);
					while (!seatValid) {
						
						System.out.println("Invalid or Taken Seat. Please Try Again: ");
						custSeat = sc.nextLine();
						seatValid = custMovie.ifSeatExist(custSeat);

					}

					System.out.println("Your selected seat is: " + custSeat);
					seatValid = false;

					//getSummary(custName, email, custGender, movieName, movieTime, custSeat.toUpperCase());

					System.out.println("Would you to continue or cancel");
					String confirm = sc.next().toLowerCase();
					if(confirm.equals("continue")){
						System.out.println("Redirecting to payment...");
						checked=false; 
						int ticketId = (int) ((Math.random() * 10000) + 100);
						Email send = new Email(email,"Movie Booking Confirmation", "Thank you for your order! Your ticket ID is : " + ticketId + "\nOrder Summary\nCustomer Information\n\tName: " + custName + "\n\tEmail: " + email + "\n\tGender: " + custGender + "\nBooking Confirmation\n\tMovie Name: " + movieName + "\nMovie Time: " + movieTime + "\nYour Selected Seat: " + custSeat);
					}		
					else{
						custMovie.cancelSeat(custSeat);
						continue;
					}
				} break; 
			case 2: { 
				System.out.println("Enter the email used to book your ticket: "); 
				email = sc.next();
				boolean isValid = true;
				while(isValid){
					for (int i = 0; i < customers.size(); i++) {
						if (customers.get(i).getEmail().compareTo(email) == 0) {
						custName = customers.get(i).getName();
						isValid = false;
					} else {
						System.out.println("You have entered an invalid email. Try again: ");
						email = sc.next();
						i=0;
					
					} }
							}
	
					}
			case 3: { 
				System.out.println("Input your email: ");
				email = sc.next();
				boolean check = true;
				while(check){
					for (int i = 0; i < customers.size(); i++) {
						if (customers.get(i).getEmail().compareTo(email) == 0) {
							System.out.println("Welcome back!");
							custName = customers.get(i).getName();
							custGender = customers.get(i).getGender();
							
							check =false;
							break;
						}
					System.out.println("Incorrect Email, Please check and retry: ");
					email=sc.next();
					}
					
				}

			}
			}
		}
		
		
	}
	

	public static void getSummary(String name, String email, char gender, String movieName, String movieTime,
			String customerSeat) {
		int ticketId = (int) ((Math.random() * 10000) + 100);
		System.out.println();
		System.out.println();
		System.out.println("Thank you for your order! Your ticket ID is : " + ticketId + "\nOrder Summary\nCustomer Information\n\tName: " + name + "\n\tEmail: " + email + "\n\tGender: " + gender + "\nBooking Confirmation\n\tMovie Name: " + movieName + "\nMovie Time: " + movieTime + "\nYour Selected Seat: " + customerSeat);
		System.out.println();
		System.out.println("Order Summary:");
		System.out.println();
		System.out.println("Customer Information");
		System.out.println("\tName: " + name);
		System.out.println("\tE-Mail: " + email);
		System.out.println("\tGender: " + gender);
		System.out.println();
		System.out.println("Booking Information");
		System.out.println("\tMovie Name: " + movieName);
		System.out.println("\tMovie Time: " + movieTime);
		System.out.println("\tYour Selected Seat: " + customerSeat);
		


	}

}
