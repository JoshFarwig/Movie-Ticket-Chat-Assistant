
import java.util.*; 


public class Customer { 

    // attributes

    private String name; // Name of Customer
    private int customerID; // ID of Customer
    private char gender; // Gender of Customer
    private Calendar birthDate; // BirthDate of Customer
    private String email; // email of Customer 

    // class constructor

    public Customer(String name, int customerID, char gender, Calendar birthDate, String email) {
        this.name = name; 
        this.customerID = customerID;
        this.gender = gender; 
        this.birthDate = birthDate; 
        this.email = email; 
    } 

    // other Methods  
    
    // Getters and Setters 
    public String getName(){ 
        return this.name; 
    }  

    public void setName(String name) { 
        this.name = name;         
    }
    
    public char getGender() { 
        return this.gender; 
    } 
    
    public void setGender(char gender) { 
        this.gender = gender; 
    } 

    public String getEmail() { 
        return this.email; 
    } 

    public void setEmail(String email) { 
        this.email = email; 
    }  

    public Calendar getBirthDate() { 
        return this.birthDate; 
    }

    public void setBirthDate(Calendar birthDate) { 
        this.birthDate = birthDate; 
    }
        



}
