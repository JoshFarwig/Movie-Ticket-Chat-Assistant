

public class Seat{  
// attributes
    private String  seatID;  
    private boolean isTaken; 
   
//constructors
    public Seat(String seatID, boolean isTaken) { 
        this.seatID = seatID; 
        this.isTaken = isTaken; 
    } 


    public String getSeatID() {
        return seatID;
    }

    public void setSeatID(String seatID) {
        this.seatID = seatID;
    }

    public boolean isIsTaken() {
        return isTaken;
    }

    public void setIsTaken(boolean isTaken) {
        this.isTaken = isTaken;
    }

}
