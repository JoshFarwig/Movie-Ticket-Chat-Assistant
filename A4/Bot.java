import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import javax.swing.*; 
import java.util.regex.*; 


public class Bot extends JFrame {
    private JTextArea Chatarea = new JTextArea();
    private JTextField chatbox = new JTextField();
    private JButton b = new JButton("Book a Ticket");
    private JButton b2 = new JButton("Amend your booking");
    private JButton b3 = new JButton("Cancel your booking");
    private JButton c = new JButton("Cancel"); 
    DBconnection db = new DBconnection(); 



    String g = "";
    int count = 0;
    String custName = null;
    char custGender = 0;
    String movieName = null;
    String custBdate = null;
    String seat = null;
    String email = "";
    String confirm = ""; 
    String phone = ""; 
    int seatid;
    int mov = 0;
    ActionEvent a;

    public static void main(String[] args) {
        new Bot();
    }
    
    public Bot(){
        //setting up JFrame
        Chatarea.setText("Sally: Hi, how can I help you? \n");
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
        Chatarea.setEditable(false);
        Chatarea.setLocation(2,2);
        Chatarea.setBorder(BorderFactory.createLineBorder(Color.black));

        chatbox.setSize(580,50);
        chatbox.setLocation(2,674);
        chatbox.setBorder(BorderFactory.createLineBorder(Color.black));

        b.setSize(198,70);
        b.setLocation(2, 602);
        b.setBorder(BorderFactory.createLineBorder(Color.black));

        b2.setSize(198,70);
        b2.setLocation(202, 602); 
        b2.setBorder(BorderFactory.createLineBorder(Color.black));

        b3.setSize(198,70);
        b3.setLocation(402, 602); 
        b3.setBorder(BorderFactory.createLineBorder(Color.black));

    //User Chat Pathways for booking, amending, and canceling
    chatbox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent a) {
                g = chatbox.getText();
                if (!g.equals("")){ 
                    Chatarea.append("You: " + g + "\n"); 
                } 
                
                chatbox.setText("");

                    String [] listMovie = {"List all movies", "Recommedations", "Recommend movies", "Recommend", "All movies", "List movies"};
                    if(patternMatcher(listMovie, g)){
                        for (int i = 0; i < db.getAllMovies().size(); i++) {
                            res2(i + 1 + ". " + db.getAllMovies().get(i).substring(0,db.getAllMovies().get(i).indexOf(",")) + " ");
                    }
                    b.setVisible(true);
                    b2.setVisible(true);
                    b3.setVisible(true);
                    }

                    String [] contactOptions = {"Contact", "contact", "Contact Information", "Contact information", "contact information", "Contact Us", "Contact us","contact us", "Phone Number", "Phone number","phone number", "Location", "location"};     
                    if(patternMatcher(contactOptions, g)){
                        res2("Phone Number: 1-800-333-0061");
                        res2("Location: 160-1876 Cooper Road, Kelowna, BC V1Y 9N6");
                        res2("Email: ticketbookingsytem@gmail.com");
                        b.setVisible(true);
                        b2.setVisible(true);
                        b3.setVisible(true);
                    }           
                
                
                if (count == 1) {
                    email = g; 
                    // validating email with java regex method at bottom of page
                    if(!emailVerification(email)) { 
                        res("Invalid email, please enter an appropiate email: ");  
                        count = 1;
                    } 
                    else if (db.checkExistingCust(email)){
                        res("Welcome back!");
                        res2("Select a movie: ");
                        custGender = db.getCustGender(email).charAt(0);
                        custName = db.getCustName(email); 

                        for (int i = 0; i < db.getAllMovies().size(); i++) {
                            res2(i + 1 + ". " + db.getAllMovies().get(i) + " ");
                        
                        } 
                        
                        count = 5;
                        b.setVisible(true);
                    }
                    else {
                        res("Welcome");
                                res("Please enter your name: ");
                                count++;
                                b.setVisible(true);		
                        }
                }
                else if (count == 2) {
                    custName = g.strip();
                    res("Please enter your gender: (M/F)");
                    count++;
                    b2.setVisible(true);
                    b.setText("Male");
                    b2.setText("Female");
                    b.setVisible(true);
                }
                else if (count == 3) {
                    String[] maleOptions = {"M","m","Man","man","Male","male"};
                    String[] femaleOptions = {"F","f","Female","female","Woman","woman"};
                    if(patternMatcher(maleOptions, g))
                        custGender = 'M';
                    else if(patternMatcher(femaleOptions,g))
                        custGender = 'F';
                    else 
                        custGender = 'X';
                    res("Please enter your birth date: (mm/dd/yyyy)");
                    count++;
                    b.setText("Cancel");
                    b.setVisible(true);
                    b2.setText("Amend your booking");
                    b2.setVisible(false);
                    b.setVisible(true);
                }
                // Adding new count pathway for asking for user phonenumber for next feature
                else if (count == 4) {
                    b.setVisible(true);
                    custBdate = g;
                    // validating birthdate with java regex method at bottom of page
                    if(!birthDateVerification(custBdate)) { 
                        res("Invalid Birth Date, please enter an appropiate birth date: ");  
                        count = 4; 
                    } else {
                        res("Please enter your phone number: XXX XXX XXXX"); 
                        count++;  
                    }
                } 
                else if (count == 5) { 
                    phone = g;  
                    // strip phone number of all spaces, dashes or periods
                    phone = phone.replaceAll("\\s","");  
                    phone = phone.replaceAll("-","");  
                    phone = phone.replaceAll("\\.",""); 
                    // validating phonenumber with java regex method at bottom of page
                    if(!phoneVerification(phone)) { 
                        res("Invalid phone, please enter an appropiate phone number: ");
                        count = 5; 
                    } else {
                        db.createCustomer(custName, custGender+"", email, phone, custBdate);
                        Chatarea.setText("");
                        res("Account created!");
                        res("Select a movie: ");
                        for (int i = 0; i < db.getAllMovies().size(); i++) {
                                res2(db.getAllMovies().get(i) + " ");
                            }
                        count++;
                    }
                }
                else if (count == 6) {
                    b.setVisible(true);
                    String [] b_adam = {"Black Adam", "black adam", "black Adam"};
                        String [] smile =  {"Smile", "smile"}; 
                        String [] thor = {"Thor: Love and Thunder", "Thor Love and Thunder","Thor love and thunder", "thor love and thunder", "Thor", "thor"};
                        
                    if(patternMatcher(b_adam, g)){
                        movieName = "Black Adam";
                    }
                    else if (patternMatcher(smile, g)){
                        movieName = "Smile";
                    }
                    else if (patternMatcher(thor, g)){
                        movieName = "Thor: Love and Thunder";                
                    }
                    res("Select your seat: ");
                    res(movieName);
                    String s = "";
                    for(int i = 0; i < db.showAvailableSeats(movieName).size(); i++){
                        s += ("[" + db.showAvailableSeats(movieName).get(i)) + "] ";
                    }
                    res2(s);
                    
                    count++;
                    b.setVisible(true);
                }
                else if (count == 7) {
                    seat = g;
                    res(seat); 
                    db.chooseSeat(email, movieName, seat); 
                    seatid = db.getSeatID(email, movieName); 
                    res("Seat selected successfully!");
                    res("Confirm your booking: (y/n)");
                    b.setText("Yes");
                    b2.setText("No");
                    b2.setVisible(true);
                    res2("\nOrder Summary\nCustomer Information\n\tName: " + custName + "\n\tEmail: " + email + "\n\tGender: " + custGender + "\nBooking Confirmation\n\tMovie Name: " + movieName +  "\nYour Selected Seat: " + seat);
                    count++;
                    b.setVisible(true);
                }

                else if (count == 8) {
                    confirm = g;
                    if (confirm.equals("y")){
                        db.createMovieTicket(email, movieName, seatid, "");
                        Chatarea.setText("");
                        Email send = new Email(email,"Movie Booking Confirmation", "Thank you for your order! Your ticket ID is : " + db.getMovieTicketID(email) + "\nOrder Summary\nCustomer Information\n\tName: " + custName + "\n\tEmail: " + email + "\n\tGender: " + custGender + "\nBooking Confirmation\n\tMovie Name: " + movieName + "\nMovie Time: " + "\nYour Selected Seat: " + seat); 
                        String message = "Thank you for your order! Your ticket ID is : " + db.getMovieTicketID(email) + "\nOrder Summary\nCustomer Information\n\tName: " + custName + "\n\tEmail: " + email + "\n\tGender: " + custGender + "\nBooking Confirmation\n\tMovie Name: " + movieName + "\nYour Selected Seat: " + seat;  
                        // new Text functionality using Twilio API refer to SMS class
                        SMS textToCust = new SMS(); 
                        textToCust.sendMessage(phone, message);
                        res("The receipt has been sent to your email and through a text.");
                        res("How can I help you?");
                        b2.setText("Amend your booking");
                        b.setText("Book a Ticket");
                        b.setVisible(true);
                        b2.setVisible(true);
                        b3.setVisible(true);
                        b.setVisible(true);
                    }
                    else if (confirm.equals("n")){
                        count = 0;
                        Chatarea.setText("");
                        res("How can I help you?");
                        b2.setText("Amend your booking");
                        b.setText("Book a Ticket");
                        b.setVisible(true);
                        b2.setVisible(true);
                        b3.setVisible(true);
                    }
                }

                else if (count == 9){ 
                    email = g;
                    while(!emailVerification(email)) { 
                        res("Invalid email, please enter an appropriate email: ");
                        email = g; 
                    }
                    if (db.getMovieTicketID(email) == -1){
                        res("You do not have a ticket registered to this email. \nHow else can I be of assistance? ");
                        b.setText("Book a Ticket");
                        b2.setText("Amend your booking");
                        b.setVisible(true);
                        b2.setVisible(true);
                        b3.setVisible(true);
                    }
                    else {
                        res("Here is your ticket summary: ");
                        res(db.showMovieTicket(db.getMovieTicketID(email)));
                        res("What would you like to change");
                        b.setText("Movie");
                        b.setVisible(true);
                        b2.setText("Seat");
                        b2.setVisible(true);
                        b3.setVisible(false);
                    }
                }
                //deleting a movie ticket
                else if (count == 10){
                    email = g;
                    while(!emailVerification(email)) { 
                        res("Invalid email, please enter an appropriate email: ");
                        email = g; 
                    }
                    if (db.getMovieTicketID(email) == -1){
                        res("You do not have a ticket registered to this email. \nCan I help you with anything else?");
                        b.setText("Book a Ticket");
                        b2.setText("Amend your booking");
                        b.setVisible(true);
                        b2.setVisible(true);
                        b3.setVisible(true);
                    }
                    else {
                        res("Here is your ticket summary: ");
                        res(db.showMovieTicket(db.getMovieTicketID(email)));
                        res("Are you sure you want to delete your booking? ");
                        b.setText("Delete");
                        b.setVisible(true);
                        b2.setText("Keep");
                        b2.setVisible(true);
                        b3.setVisible(false);
                    }
                }
                } 
            
        }
        );


    //Button Listeners for Booking a Ticket pathway
    b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (b.getText().equals("Cancel")){
                    b.setText("Book a Ticket");
                    count = 0;
                    res("Returning to main menu.");
                    Chatarea.setText("");
                    res("Can I help you with anything else?");
                    b2.setVisible(true);
                    b3.setVisible(true);
                    b.setVisible(true);
                }
                else if (b.getText().equals("Movie")){
                    b.setText("Cancel");
                    b.setVisible(true);
                    b2.setText("Amend your booking");
                    b2.setVisible(false);
                    b3.setVisible(false);
                res("Select your movie: ");
                for (int i = 0; i < db.getAllMovies().size(); i++) {
                    res2(db.getAllMovies().get(i) + " ");
                }
                db.deleteMovieTicket(email, movieName);
                db.unselectSeat(seatid);
                count = 6;
                
                }
                else if (b.getText().equals("Delete")){
                    db.deleteMovieTicket(email, movieName);
                    db.unselectSeat(seatid);
                    res("Booking deleted! Email sent.");
                    Email send = new Email(email,"Movie Booking Deleted", "Thank you! We hope to see you again soon.");
                    b.setText("Book a Ticket");
                    b2.setText("Amend your booking");
                    b.setVisible(true);
                    b2.setVisible(true);
                    b3.setVisible(true);
                    res2("How else can I help you?");
                }
            
                else if (b.getText().equals("Book a Ticket")){
                b.setText("Cancel");
                count = 1;
                b2.setVisible(false);
                b3.setVisible(false);
                b.setVisible(true);
                res("Okay, I can help you with that. \nEnter your email: ");
                }
                else if (b.getText().equals("Male")){
                count = 4;
                custGender = 'M';
                res("Please enter your birth date: (mm/dd/yyyy)");
                b2.setText("Amend your booking");
                b2.setVisible(false);
                b.setText("Cancel");
                b.setVisible(true);
                
                }
                else if(b.getText().equals("Yes")){
                    confirm = "y";
                    count = 8;
                    db.createMovieTicket(email, movieName, seatid, "");
                    Chatarea.setText("");
                        Email send = new Email(email,"Movie Booking Confirmation", "Thank you for your order! Your ticket ID is : " + db.getMovieTicketID(email) + "\nOrder Summary\nCustomer Information\n\tName: " + custName + "\n\tEmail: " + email + "\n\tGender: " + custGender + "\nBooking Confirmation\n\tMovie Name: " + movieName + "\nYour Selected Seat: " + seat + "\nPayment link: www.paypal.me/zeyad1910");
                        res("The receipt has been sent to your email.");
                        res2("Can I help you with anything else?");
                    b.setText("Book a Ticket");
                    b2.setText("Amend your booking");
                    b.setVisible(true);
                    b2.setVisible(true);
                    b3.setVisible(true);
                }
            }
            
            });

    // Button listeners for Amending a Ticket
    b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(b2.getText().equals("Female")){
                    count = 4;
                    custGender = 'F';
                    res("Please enter your birth date: (mm/dd/yyyy)");
                    b2.setText("Amend your booking");
                    b2.setVisible(false);
                    b.setText("Cancel");
                    b.setVisible(true);
                
                }
                else if(b2.getText().equals("Seat")){
                    count = 7;
                    b.setText("Cancel");
                    b.setVisible(true);
                    b2.setText("Amend your booking");
                    b2.setVisible(false);
                    b3.setVisible(false);
                    res("Select your seat: ");
                    res(movieName);
                
                    String s = "";
                    for(int i = 0; i < db.showAvailableSeats(movieName).size(); i++){
                        s += ("[" + db.showAvailableSeats(movieName).get(i)) + "] ";
                    }
                    db.unselectSeat(seatid);
                    db.deleteMovieTicket(email, movieName);
                    res2(s);
                }
                else if(b2.getText().equals("Keep")) {
                    count = 0;
                    b.setText("Book a Ticket");
                    b2.setText("Amend your booking");
                    b.setVisible(true);
                    b2.setVisible(true);
                    b3.setVisible(true);
                    res2("How else can I help you?");
                }
                else if(b2.getText().equals("Amend your booking")){
                    b.setText("Cancel");
                    b.setVisible(true);
                    b2.setVisible(false);
                    b3.setVisible(false);
                    res("Sure, I can help you with that. Please enter your email: ");
                    count = 9;
                }
                else if(b2.getText().equals("No")){
                    count = 0;
                    Chatarea.setText("");
                    res("How can I help you?");
                    b2.setText("Amend your booking");
                    b.setText("Book a Ticket");
                    b.setVisible(true);
                    b2.setVisible(true);
                    b3.setVisible(true);
                }
            }
    });

    // Button Listener for Canceling a Ticket
    b3.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            if (b3.getText().equals("Cancel your booking")){
                res("Enter your email: ");
                b.setText("Cancel");
                b.setVisible(true);
                b2.setVisible(false);
                b3.setVisible(false);
                count = 10;
            }
    }

    });



    }

    // Output for chatbox
    private void res(String string){
            Chatarea.append("Sally: " + string + "\n"); 
        }
    
    private void res2(String string){
            Chatarea.append(string + "\n");
        }


    // Bruteforce pattern matcher method for simple inputs 
    public boolean patternMatcher(String[] pattern, String input){
            return Arrays.stream(pattern).anyMatch(input::contains);
        } 

    private static boolean emailVerification(String email) { 
        // pattern rejects local / username inputs that have . at beginning or end, consecutive ., or over 64 chars
        // pattern rejects domain inputs that have - / . at beginning or end and consective .
        Pattern verifiedPattern = Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");  
        Matcher input = verifiedPattern.matcher(email); 
        return input.matches(); 
    } 

    private static boolean birthDateVerification(String bdate) { 
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        // uses a try catch to parse string inputed into the pattern of the dtf formater
        // if catches exception, not proper date format 
        try { 
            dtf.parse(bdate);
        } catch (DateTimeParseException e) { 
            return false; 
        }
        return true; 

    } 
    
    private static boolean phoneVerification(String phone) {  
        //validates phone length 
        // Assumes phone number is +1 country 
        // checks using regex syntax is string has 10 digits  
        // all other inputs have been parsed in bot code, so just have to check if it has ten digits.
        if (phone.matches("\\d{10}"))  
            return true;  
        else  
            return false; 
    }
}
