import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;
import javax.swing.*;


public class Bot extends JFrame {
    private JTextArea Chatarea = new JTextArea();
    private JTextField chatbox = new JTextField();
    private JButton b = new JButton("Book a ticket");
    private JButton b2 = new JButton("Amend your booking");
    private JButton b3 = new JButton("Cancel your booking");
    private JButton c = new JButton("Cancel");
    DBconnection db = new DBconnection(); 
    
    String g = "";
    int count = 0;

public Bot(){
    //setting up JFrame
    res("Hi, how can I help you?");
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.setResizable(false);
    frame.setSize(600, 800);
    frame.setTitle("Virtual Assistant");
   
   
    //adding all textfield and buttons
    frame.add(Chatarea);
    frame.add(chatbox);
    frame.add(b);
    frame.add(b2);
    frame.add(b3);

    //Scroll Pane
    JScrollPane sp = new JScrollPane(Chatarea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    frame.add(sp);

    Chatarea.setSize(500,600);
    Chatarea.setLocation(2,2);

    chatbox.setSize(580,50);
    chatbox.setLocation(2,674);

    b.setSize(198,70);
    b.setLocation(2, 602);

    b2.setSize(198,70);
    b2.setLocation(202, 602);

    b3.setSize(198,70);
    b3.setLocation(402, 602);

    //Actions
chatbox.addActionListener(new ActionListener() {
            String custName = null;
			char custGender = 0;
			String movieName = null;
            String custBdate = null;
            String seat = null;
            String email = "";
            String confirm = "";
            int mov = 0;
        @Override
        public void actionPerformed(ActionEvent e) {
            g = chatbox.getText();
            Chatarea.append("You: " + g + "\n");
            chatbox.setText("");
            
            if (count == 1) {
                email = g;
            
                if (db.checkExistingCust(email)){
                    res("Welcome back!");
                    res2("Select a movie: ");
                    //custGender = db.getCusGender
                    //custGender = db.getCusName
                    for (int i = 0; i < db.getAllMovies().size(); i++) {
                        res2(i + 1 + ". " + db.getAllMovies().get(i) + " ");
                       
                }
                count = 5;
                }
                else {
                   res("Welcome");
                        res("Please enter your name: ");
                        count++;
						
                }
               
            }
            else if (count == 2) {
                custName = g;
                res("Please enter your gender: (M/F)");
                count++;
            }
            else if (count == 3) {
                custGender = g.charAt(0); 
                res("Please enter your birth date: (yyyy-mm-dd)");
                count++;
            }
            else if (count == 4) {
                custBdate = g;
                db.createCustomer(custName, custGender+ "", email, custBdate);
                res("Account created!");
                res("Select a movie: ");
                for (int i = 0; i < db.getAllMovies().size(); i++) {
                        res2(i + 1 + ". " + db.getAllMovies().get(i) + " ");
                }
                count++;
            }
            else if (count == 5) {
                mov = Integer.parseInt(g);
                movieName = db.getAllMovies().get(mov-1).substring(0,db.getAllMovies().get(mov-1).indexOf(',')).toString();
                res("Select your seat: ");
                res2(db.showAvailableSeats(db.getAllMovies().get(mov).substring(0,db.getAllMovies().get(mov).indexOf(','))).toString());
                count++;
			}
            else if (count == 6) {
                seat = g;
                res(seat);
                db.chooseSeat(email, movieName, seat);
                res("Seat selected successfully!");
                res("Confirm your booking: (y/n)");
                res2("\nOrder Summary\nCustomer Information\n\tName: " + custName + "\n\tEmail: " + email + "\n\tGender: " + custGender + "\nBooking Confirmation\n\tMovie Name: " + movieName +  "\nYour Selected Seat: " + seat);
                count++;
            }

            else if (count == 7) {
                confirm = g;
                if (confirm.equals("y")){
                    db.createMovieTicket(email, movieName);
                    Email send = new Email(email,"Movie Booking Confirmation", "Thank you for your order! Your ticket ID is : " + db.getMovieTicketID(email, movieName) + "\nOrder Summary\nCustomer Information\n\tName: " + custName + "\n\tEmail: " + email + "\n\tGender: " + custGender + "\nBooking Confirmation\n\tMovie Name: " + movieName + "\nMovie Time: " + "\nYour Selected Seat: " + seat);
                    res("The receipt has been sent to your email.");
                }
                else if (confirm.equals("n")){

                }
            }
            }
        }
    );
//booking a ticket
b.addActionListener(new ActionListener() {
			
        @Override
        public void actionPerformed(ActionEvent e) {
            if (b.getText().equals("Cancel")){
            
                b.setText("Book a Ticket");
                count = 0;
                res("Returning to main menu.");
                return;
            }
            count++;
            b.setText("Cancel");

            res("Okay, I can help you with that. \nEnter your email: ");
            String email = g;
           }
        
        });

//amending a ticket
b2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){

        }
});



}


private void res(String string){
    Chatarea.append("Sally: " + string + "\n");
}
private void res2(String string){
    Chatarea.append(string + "\n");
}



public static void main(String[] args) {
    new Bot();
    
}

}
