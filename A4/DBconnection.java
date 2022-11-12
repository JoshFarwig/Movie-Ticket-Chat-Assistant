

import java.sql.*;;

public class DBconnection {  
    
    private Connection con;  

    public DBconnection() {  
        String url = "jdbc:mysql://localhost/sys_database";
        String uid = "root";
        String pw = "password"; 

        try { 
            con = DriverManager.getConnection(url, uid, pw); 
        } catch (SQLException e) {
            System.out.println(e);
        }
    

    } 

    public String[] getAllMovies() {   
        try { 
            Statement stmt = con.createStatement();   
            ResultSet rs = stmt.executeQuery("SELECT mname, genre, releasedate, duration FROM movie");
        
        
        } catch (SQLException e){ 
            System.out.println(e);
        }


    }
    
}
