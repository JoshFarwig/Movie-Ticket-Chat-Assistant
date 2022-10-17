# Class Descriptions

### **Movie** :
Contains variables that reference the movie such as name, actors, genre, etc
### **AddOn (Interface):**
Contains abstract variables that are relevant to all addOns such as price, category, etc
### **Snack (Inherits AddOn):**
Contains the actual list of snacks listed as an array as well as an array of prices + methods such as buySnack()
### **Collectible (Inherits AddOn):**
Contains prices, relevant movie + methods
### **MovieTransaction:**
Contains the buy and cancel methods for MovieTicket
### **MovieTicket:**
Contains ticketID, what movie it’s for, number of people, names of said people, etc
### **Customer:**
Contains customer name, customerID, gender, birthDate, e-mail, favorite movie
### **Seats:**
Contains a boolean (isReserved) as well as an array containing all seats and their status
