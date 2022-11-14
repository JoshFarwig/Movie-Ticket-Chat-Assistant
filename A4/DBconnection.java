import java.sql.*;
import java.util.ArrayList;

public class DBconnection {  
    
  
    Connection con = null;  
    public DBconnection(){  
       
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

    public void createCustomer(String name, String gender, String email, String bdate) { 
        try{ 
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO customer(name, gender, email, bdate) VALUES(?, ?, ?, ?)"); 
            pstmt.setString(1, name);  
            pstmt.setString(2, gender);  
            pstmt.setString(3, email);    
            pstmt.setString(4, bdate); 
            pstmt.execute(); 
        } catch (SQLException e) {
            System.out.println(e);
        }
    }  
    
    public String getCustGender(String email) { 
        try{ 
            PreparedStatement pstmt = con.prepareStatement("SELECT gender FROM customer WHERE email = ?"); 
            pstmt.setString(1, email); 
            ResultSet rs = pstmt.executeQuery(); rs.next(); 
            return rs.getString("gender");
        } catch (SQLException e) {
            System.out.println(e); 
            return "couldn't get custgender";
        }
    }
    
    public String getCustName(String email) {  
          try{ 
            PreparedStatement pstmt = con.prepareStatement("SELECT name FROM customer WHERE email = ?"); 
            pstmt.setString(1, email); 
            ResultSet rs = pstmt.executeQuery(); rs.next(); 
            return rs.getString("name");
        } catch (SQLException e) {
            System.out.println(e); 
            return "couldn't get custname";
        }
    }

    public void createMovieTicket(String email, String movie, int seatID, String movietime) {  
        try{   
            PreparedStatement getMoviecost = con.prepareStatement("SELECT cost FROM movie WHERE name = ?"); 
            getMoviecost.setString(1, movie); 
            ResultSet rs = getMoviecost.executeQuery();  rs.next();  
            double cost = rs.getDouble("cost"); 
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO movieticket(cemail, mname, seatID, totalPrice) VALUES(?, ?, ?, ?)"); 
            pstmt.setString(1, email);  
            pstmt.setString(2, movie);   
            pstmt.setInt(3, seatID);  
            pstmt.setDouble(4, cost);  
            pstmt.execute(); 
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
     
    public String showMovieTicket(int movieticketid) {  
        try{   
            PreparedStatement pstmt = con.prepareStatement("SELECT mt.mtid, m.name, m.dateofmovie, m.timeofmovie, s.srowcol, mt.totalPrice FROM movieticket mt JOIN movie m ON mt.mname = m.name JOIN seat s ON mt.seatID = s.sid WHERE mtid = ?"); 
            pstmt.setInt(1, movieticketid);  
            ResultSet rs = pstmt.executeQuery(); rs.next();  
            return String.format("TicketID: %d, Movie: %s Date: %s Time: %s Seat: %s Ticket Cost: %f", rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6)); 
        } catch (SQLException e) {
            System.out.println(e); 
            return "You do not have a movieticket!";
        } 
    }  

    public void updateSeatInTicket(int movieticketid, int seatid) { 
        try{   
            PreparedStatement pstmt = con.prepareStatement("UPDATE movieticket SET seatID = ? WHERE mtid = ? "); 
            pstmt.setInt(2, seatid);
            pstmt.setInt(2, movieticketid);  
            pstmt.execute(); 
        } catch (SQLException e) {
            System.out.println(e); 
        } 
    }

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

    public int getMovieTicketID(String email) {   
        try{    
            PreparedStatement pstmt = con.prepareStatement("SELECT mtid FROM movieticket WHERE cemail = ?"); 
            pstmt.setString(1, email);  
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
            ResultSet rs = stmt.executeQuery("SELECT * FROM movie");  
            while(rs.next()) { 
                output.add(String.format("%s, Genre: %s, Date: %s, Time: %s",rs.getString("name"),rs.getString("genre"),rs.getString("dateofmovie"), rs.getString("timeofmovie"))); 
            } 
            return output; 
        } catch (SQLException e){ 
            System.out.println(e);    
            output.add("Unable to generate movie data..."); 
            return output; 
        }
    }  
    
    public ArrayList<String> getMovieTimes(String movie) {  
        ArrayList<String> output = new ArrayList<>(); 
        try {   
            PreparedStatement pstmt = con.prepareStatement("SELECT movietime FROM movietimes WHERE mname = ?");  
            pstmt.setString(1, movie);
            ResultSet rs = pstmt.executeQuery();  
            while(rs.next()) { 
                output.add(rs.getString("movietime"));
            } 
            return output; 
        } catch (SQLException e){ 
            System.out.println(e);    
            output.add("Unable to generate movie data..."); 
            return output; 
        }
    }

    public ArrayList<String> showAvailableSeats(String movie) { 
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
    
    public void unselectSeat(int seatid) { 
        try { 
            PreparedStatement pstmt = con.prepareStatement("UPDATE seat SET cemail = NULL WHERE sid = ?"); 
            pstmt.setInt(1, seatid); 
            pstmt.execute(); 
        } catch (SQLException e) { 
            System.out.println(e);
        }
    }    
    
    public int getSeatID(String email, String movie) {  
        try { 
            PreparedStatement pstmt = con.prepareStatement("SELECT sid FROM seat WHERE cemail = ? and mname = ?"); 
            pstmt.setString(1, email); 
            pstmt.setString(2, movie); 
            ResultSet rs = pstmt.executeQuery(); rs.next();
            return rs.getInt("sid");
        } catch (SQLException e) { 
            System.out.println(e);
            return -1;
        }
    
    }
}
