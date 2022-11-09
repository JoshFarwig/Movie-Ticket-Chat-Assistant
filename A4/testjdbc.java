package A4;

import java.sql.*;

public class testjdbc
{   public static void main(String[] args)
    {   String url = "jdbc:mysql://localhost/mtbs";
        String uid = "root";
        String pw = "310rootpw";              
              
        try ( Connection con = DriverManager.getConnection(url, uid, pw);
              Statement stmt = con.createStatement();) 
        {
            ResultSet rst = stmt.executeQuery("SELECT mname FROM movie");
            System.out.println("Movie names");
            while (rst.next())
            {   System.out.println(rst.getString("mname"));
            }
        }
        catch (SQLException ex)
        {
            System.err.println("SQLException: " + ex);
        }
    }
}