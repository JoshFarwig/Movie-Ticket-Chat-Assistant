
# Movie Virtual Assistant 
## Project Description:

A virtual assistant that allows for customers to book/change/cancel new or current movie ticket bookings. After confirming their booking, the customer gets their ticket sent to them via email. The entire project was developed using Java and utilized libraries such as JDBC, JSwing, Java AWT, and Java Mail for our features. We went with a simple, straight-forward design for our assistant's user interface. The user has two input options, either by directly typing into the chatbox or by clicking one of the buttons right above it. After the user has finished their interaction and their request was met, they receive a confirmation email of the interaction via the email on file.    

## Class Organization: 
### Implemented 
    - Movie: 
        - Contains variables to reference movieName, genre, releaseDate, starring (actors), movieDuration, premierTime, showTime, and allSeats variable for all possible seats for a movie 
        - Contains methods for chosing and canceling a seat in allSeats, getters and setters, (methods will be added in the refactoring process in pathways)
    - movieTicket:
        - contains ticketID, the Customer who bought the ticket, the Movie associated with the ticket, and Seat associated with Customer who bought Ticket
    - Customer:
        - contains customer name, customerID, gender, birthDate, e-mail 
        - getters and setters for methods, (methods will be added to this class whenrefactoing pathways) 
    - Pathways:
        - .main method for running all code, contains arrayLists for storing information on Customers, movieTickets, and Movies
    - Seat:
        - contains a seatID, and an isTaken boolean 
### Not Implemented  
    - movieTransaction: (interface)
        - contains methods to buy and cancel tickets (added cancel functionality in book a ticket pathway so may not need)
    - AddOn: (Superclass)
        - Contains variables that are relevant to all addOns such as price, category, etc
    - Snack: (Extends AddOn)
        - Contains the actual list of snacks listed as an array as well as an array of prices + methods such as buySnack()
    - movieCollectible: (Extends AddOn)
        - Contains name of Object, what movie it references to, its price, etc.
