import java.util.ArrayList;
import java.util.Scanner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class testPathways {
	
	private static Pathways path;
    	private static DBconnection dbcon;
    
	static Connection con1;
	
    	@BeforeClass
	public static void init() throws Exception {		
		path = new Pathways();
		String url = "jdbc:mysql://localhost/mtbs";
        	String uid = "root";
        	String pw = "310rootpw"; 
		try { 
		    con1 = DriverManager.getConnection(url, uid, pw); 
		} catch (SQLException e) {
		    System.out.println(e);
		}	
	}
	
	@Test
        public void testAccountCreation() throws SQLException{
		dbcon = new DBconnection();
		dbcon.createCustomer("osho", "M", "osho@gmail.com", "01-01-2001");
		StringBuilder output = new StringBuilder();

		String returnStudents = "SELECT email from customer";
		PreparedStatement pstmt = con1.prepareStatement(returnStudents); 
		ResultSet rst = pstmt.executeQuery();
		output.append("email\n"); 
		
		while(rst.next()){
		    output.append(rst.getString("email") + "\n");
		} 

		output.deleteCharAt(output.length() - 1);
		String result = output.toString();
		String answer = "email" + "\njosh96753@gmail.com" + "\nosho@gmail.com" + "\nzee@gmail.com";
	 	assertEquals(answer, result);
	 }
	
	 @Test
	 public void testCheckExisting() throws SQLException{
		dbcon = new DBconnection();
		dbcon.createCustomer("chinmay", "M", "chinmay@gmail.com", "01-01-2001"); 
		boolean exists = dbcon.checkExistingCust("chinmay@gmail.com");
		assertEquals(exists, true); 
		boolean exists2 = dbcon.checkExistingCust(null);
		assertEquals(exists2, false);
	 }
	
	@Test	
	 public void testTicketDeletion() throws SQLException{
		dbcon = new DBconnection();
		dbcon.createMovieTicket("osho@gmail.com", "Smile", 13, null );
		dbcon.deleteMovieTicket("osho@gmail.com", "Smile");
		StringBuilder output = new StringBuilder();
		String returnStudents = "SELECT cemail from movieticket WHERE cemail = ?";
		PreparedStatement pstmt = con1.prepareStatement(returnStudents);  
		pstmt.setString(1, "osho@gmail.com");
		ResultSet rst = pstmt.executeQuery();
		output.append("cemail\n"); 
		 
		while(rst.next()){
		    output.append(rst.getString("cemail") + "\n");
		}
		 
		output.deleteCharAt(output.length() - 1); 
		String result = output.toString();
		String answer = "cemail";
		assertEquals(answer, result);
	 }

	 @Test
	 public void testAmendTicket() throws SQLException{
		dbcon = new DBconnection();

		dbcon.createMovieTicket("osho@gmail.com", "Smile", 13, null );
		dbcon.chooseSeat("osho@gmail.com", "Smile", "A1");
		dbcon.createMovieTicket("chinmay@gmail.com", "Smile", 14, null );
		dbcon.chooseSeat("chinmay@gmail.com", "Smile", "A2");

		dbcon.unselectSeat(13);
		dbcon.unselectSeat(14);

		dbcon.deleteMovieTicket("osho@gmail.com", "Smile");
		dbcon.deleteMovieTicket("chinmay@gmail.com", "Smile");

		dbcon.createMovieTicket("osho@gmail.com", "Smile", 14, null );
		dbcon.chooseSeat("osho@gmail.com", "Smile", "A2");
		dbcon.createMovieTicket("chinmay@gmail.com", "Smile", 13, null );
		dbcon.chooseSeat("chinmay@gmail.com", "Smile", "A1");



		StringBuilder output = new StringBuilder();

        String returnStudents = "SELECT cemail, seatID from movieticket";
        PreparedStatement pstmt = con1.prepareStatement(returnStudents); 
        ResultSet rst = pstmt.executeQuery();
        output.append("cemail, seatID\n");
        while(rst.next()){
            output.append(rst.getString("cemail") + ", " + rst.getInt("seatID") + "\n");
        }
		output.deleteCharAt(output.length() - 1);
        String result = output.toString();
		String answer = "cemail, seatID" + 
						"\nosho@gmail.com, 14" +
						"\nchinmay@gmail.com, 13";

						assertEquals(answer, result);

	 }																																																						
	
}
