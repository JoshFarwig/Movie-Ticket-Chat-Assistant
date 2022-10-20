import java.util.ArrayList;
import java.util.Scanner;

public class Pathways { 
    // Intializing Movies
    ArrayList<Object> allMovies = new ArrayList<Object>(){
        {
        add(new Movie("Black Adam", ));
        }
    };
    // Intializing Seats 
    Seat[][] allSeats = {{new Seat("A1", false),new Seat("A2", false), new Seat("A3", false)}, 
                         {new Seat("B1", false),new Seat("B2", false), new Seat("B3", false)}, 
                         {new Seat("C1", false),new Seat("C2", false), new Seat("C3", false)}, 
                         {new Seat("D1", false),new Seat("D2", false), new Seat("D3", false)}};
    // Intializing Temporary Customer Storage Array
    // intializing MovieTicket Storage Array

    public static void main(String[] args) { 

        System.out.println("Hello. How may I help you?");
        System.out.println("1. Book a Ticket \n2. Amend your booking \n3. Cancel your booking");

        Scanner sc = new Scanner(System.in);  
        int sel = sc.nextInt();
   
        if (sel == 1){
            System.out.println("Input your email: ");
            String email = sc. next(); 
            
        }



    }


}