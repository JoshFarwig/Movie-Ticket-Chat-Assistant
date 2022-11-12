import java.util.ArrayList;
import java.util.Scanner;

import

public class testAccountCreation {
    static ArrayList<Customer> customers = new ArrayList<Customer>() {
		{
			add(new Customer("Zeyad", 1234, 'M', null, "zee@gmail.com"));
		}
	};

    public static void test(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input your email: ");
        String email = sc.next(); 
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
    }
}
