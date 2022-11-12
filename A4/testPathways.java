import java.util.ArrayList;
import java.util.Scanner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Tests bot database program.
 */
public class testAccountCreation {
 /**
	 * Class being tested
	 */
	private static Pathways path;
    private static DBconnection dbcon;
    	/**
	 * Connection to the database
	 */
	private static Connection con;
	
	
	/**
	 * Requests a connection to the database.
	 * 
	 * @throws Exception
	 * 		if an error occurs
	 */
    @BeforeClass
	public static void init() throws Exception 
	{		
		path = new Pathways();
        dbcon = new DBconnection();
		con = dbcon.connect();		
	}
    /**
	 * Closes connection.
	 * 
	 * @throws Exception
	 * 		if an error occurs
	 */
	
     @Test
     public void testAccountCreation() throws SQLException
	
}
