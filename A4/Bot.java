package A4;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;
import A4.Pathways;
import javax.swing.*;


public class Bot extends JFrame {
    private JTextArea Chatarea = new JTextArea();
    private JTextField chatbox = new JTextField();
    private JButton b = new JButton("Book a ticket");
    private JButton b2 = new JButton("Amend your booking");
    private JButton b3 = new JButton("Cancel your booking");
    String g = "";

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

public Bot(){
    //setting up JFrame
    bot("Hi, how can I help you?");
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.setResizable(false);
    frame.setLayout(null);
    frame.setSize(600, 600);
    frame.setTitle("Virtual Assistant");
   

    //adding all textfield and buttons
    frame.add(Chatarea);
    frame.add(chatbox);
    frame.add(b);
    frame.add(b2);
    frame.add(b3);

    Chatarea.setSize(600,400);
    Chatarea.setLocation(2,2);

    chatbox.setSize(580,50);
    chatbox.setLocation(2,500);

    b.setSize(198,70);
    b.setLocation(2, 402);

    b2.setSize(198,70);
    b2.setLocation(202, 402);

    b3.setSize(198,70);
    b3.setLocation(402, 402);

    //Actions
chatbox.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            g = chatbox.getText();
            Chatarea.append("You: " + g + "\n");
            chatbox.setText("");
            
        }
    });
//booking a ticket
b.addActionListener(new ActionListener() {
			String custName = null;
			char custGender = 0;
			String movieName = null;
			String movieTime = null;
        @Override
        public void actionPerformed(ActionEvent e) {
            bot("Okay, I can help you with that. \n Enter your email: ");
            String email = g;
            for (int i = 0; i < customers.size(); i++) {
                if (customers.get(i).getEmail().compareTo(email) == 0) {
                    bot("Welcome back!");
                    custName = customers.get(i).getName();
                    custGender = customers.get(i).getGender();
                } else {
                    bot("Welcome");
                    bot("Please enter your name: ");
                    custName = g; 
                    bot("Please enter your gender: (M/F)");
                    custGender = g.charAt(0); 
                    customers.add((new Customer(custName, 0, custGender, null, email)));
                    break;
                }

        }
}});
}
private void bot(String string){
    Chatarea.append("Sally: " + string + "\n");
}



public static void main(String[] args) {
    new Bot();
    
}

}
