import java.util.Scanner;

public class Pathways { 
    // Intializing Movies 
    // Intializing Seats 
    Seat[][] allSeats = {{new Seat("A1", false),new Seat("A2", false), new Seat("A3", false)}, 
                         {new Seat("B1", false),new Seat("B2", false), new Seat("B3", false)}, 
                         {new Seat("C1", false),new Seat("C2", false), new Seat("C3", false)}, 
                         {new Seat("D1", false),new Seat("D2", false), new Seat("D3", false)}};
    // Intializing Temporary Customer Storage Array
    	// PLEASE NAME THIS ARRAY "customers" - Zee
    
    // intializing MovieTicket Storage Array

    public static void main(String[] args) { 

        System.out.println("Hello. How may I help you?");
        System.out.println("1. Book a Ticket \n2. Amend your booking \n3. Cancel your booking");

        Scanner sc = new Scanner(System.in);  
        int sel = sc.nextInt();
        String email;
        int existingCustomerIdx;
        String custName;
        char custGender;
   
        if (sel == 1){
            System.out.println("Input your email: ");
            email = sc.nextLine(); 
            
        }
        
        /*Checking if customer is existing, if yes then print welcome back and save
        * index of this customer so we can create ticket
        */
        for(int i = 0; i < customers.size; i++ ) {
        	if(customers.get(i).getEmail().compareTo(email) == 0) {
        		System.out.println("Welcome back!");
        		existingCustomerIdx = i;
        	}
        	else {
        	System.out.println("Welcome");
        	System.out.print("Please enter your name: ");
        	custName = sc.nextLine();
        	System.out.println("Please enter your gender: (M/F)");
        	custGender = sc.nextLine().charAt(0);
        	customers.add(custName,custGender, email);
        	}
        	
        }
        
        


    }


}