package A4; 

import java.sql.*;
import java.util.ArrayList;

public class DBconnection {  
    
    private Connection con;  

    public DBconnection() {  
        String url = "jdbc:mysql://localhost/mtbs";
        String uid = "root";
        String pw = "310rootpw"; 
        try { 
            con = DriverManager.getConnection(url, uid, pw); 
        } catch (SQLException e) {
            System.out.println(e);
        }
    
    }    

    public boolean checkExistingCust(String email) {  
        try {   
            PreparedStatement pstmt = con.prepareStatement("SELECT email FROM customer WHERE email = ?");   
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();   
            if(rs.next()) 
                return true;   
            else 
                return false;
        } catch (SQLException e){ 
            System.out.println(e);     
            return false; 
        } 
    }  

    public void createCustomer(String name, String gender, String email) { 
        try{ 
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO customer(cname, gender, email) VALUES(?, ?, ?)"); 
            pstmt.setString(1, name);  
            pstmt.setString(2, gender);  
            pstmt.setString(3, email);  
            pstmt.execute(); 
        } catch (SQLException e) {
            System.out.println(e);
        }
    } 

    public void createMovieTicket(String email, String movie) {  
        try{  
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO movieticket(cemail, mname) VALUES(?, ?)"); 
            pstmt.setString(1, email);  
            pstmt.setString(2, movie);  
            pstmt.execute(); 
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
   /*  public ArrayList<String> showMovieTicket(String email, String movie) { 
        ArrayList<String> output = new ArrayList<>();  
        try{   
            PreparedStatement pstmt = con.prepareStatement("SELECT"); 
            pstmt.setString(1, email);  
            pstmt.setString(2, movie);  
            pstmt.execute(); 
        } catch (SQLException e) {
            System.out.println(e);
        }

    }  */

    public void deleteMovieTicket(String email, String movie) {  
        try{   
            PreparedStatement pstmt = con.prepareStatement("DELETE FROM movieticket WHERE cemail = ? and mname = ?"); 
            pstmt.setString(1, email);  
            pstmt.setString(2, movie);  
            pstmt.execute(); 
        } catch (SQLException e) {
            System.out.println(e);
        } 
    } 

    public int getMovieTicketID(String email, String movie) {   
        try{    
            PreparedStatement pstmt = con.prepareStatement("SELECT mtid FROM movieticket WHERE cemail = ? and mname = ?"); 
            pstmt.setString(1, email);  
            pstmt.setString(2, movie);  
            ResultSet rs = pstmt.executeQuery(); rs.next(); 
            return rs.getInt("mtid"); 
        } catch (SQLException e) {
            System.out.println(e); 
            return -1; 
        } 
    }

    public ArrayList<String> getAllMovies() {    
        ArrayList<String> output = new ArrayList<>(); 
        try {   
            Statement stmt = con.createStatement();   
            ResultSet rs = stmt.executeQuery("SELECT mname, genre, releasedate, duration FROM movie");  
            while(rs.next()) { 
                output.add(String.format("%s, %s, %s, %s",rs.getString("mname"),rs.getString("genre"),rs.getString("releasedate"), rs.getString("duration"))); 
            } 
            return output; 
        } catch (SQLException e){ 
            System.out.println(e);    
            output.add("Unable to generate movie data..."); 
            return output; 
        }

    } 

    public ArrayList<String> showAvailabileSeats(String movie) { 
        ArrayList<String> output = new ArrayList<>();  
        try {   
            PreparedStatement pstmt = con.prepareStatement("SELECT srowcol FROM seat WHERE cemail IS NULL and mname = ?");   
            pstmt.setString(1, movie);
            ResultSet rs = pstmt.executeQuery(); 
            while(rs.next()) { 
                output.add(String.format("%s",rs.getString("srowcol"))); 
            } 
            return output; 
        } catch (SQLException e){ 
            System.out.println(e);    
            output.add("Unable to generate seat data..."); 
            return output; 
        }
    } 

    public void chooseSeat(String email, String movie, String seatpos) { 
        try { 
            PreparedStatement pstmt = con.prepareStatement("UPDATE seat SET cemail = ? WHERE mname = ? and srowcol = ?"); 
            pstmt.setString(1, email); 
            pstmt.setString(2, movie); 
            pstmt.setString(3, seatpos); 
            pstmt.execute(); 
        } catch (SQLException e) { 
            System.out.println(e);
        }
    } 
    
    public void unselectSeat(String email, String movie) { 
        try { 
            PreparedStatement pstmt = con.prepareStatement("UPDATE seat SET cemail = NULL WHERE mname = ? and cemail = ?"); 
            pstmt.setString(1, movie); 
            pstmt.setString(2, email); 
            pstmt.execute(); 
        } catch (SQLException e) { 
            System.out.println(e);
        }
    }  

    public ArrayList<String> showAllAddons(){ 
        ArrayList<String> output = new ArrayList<>();  
        try {   
            PreparedStatement pstmt = con.prepareStatement("SELECT srowcol FROM seat WHERE cemail IS NULL and mname = ?");   
            pstmt.setString(1, movie);
            ResultSet rs = pstmt.executeQuery(); 
            while(rs.next()) { 
                output.add(String.format("%s",rs.getString("srowcol"))); 
            } 
            return output; 
        } catch (SQLException e){ 
            System.out.println(e);    
            output.add("Unable to generate seat data..."); 
            return output; 
        }
    } 

    public void showCustomerAddons(){ 

    }

    public void addToCart() { 


    } 

    public void deleteFromCart() { 


    } 


    public void printTicketSummary(){

    }
    
}
