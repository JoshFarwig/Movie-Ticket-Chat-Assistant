# Movie Virtual Assistant 
## Project Description:
A virtual assistant that allows for customers to book/change/cancel new or current movie ticket bookings, as well as allow users to purchase add-ons such as food, drinks, and movie collectibles.

## Class Organization:
- Movie:
    - Contains variables that reference the movie such as name, actors, genre, etc
- AddOn (Interface)
    - Contains abstract variables that are relevant to all addOns such as price, category, etc
- Snack (Inherits AddOn)
    - Contains the actual list of snacks listed as an array as well as an array of prices + methods such as buySnack()
- Collectible (Inherits AddOn)
    - Contains prices, relevant movie + methods
- MovieTransaction
    - contains the buy and cancel methods for MovieTicket
- MovieTicket
    - contains ticketID, what movie it’s for, number of people, names of said people, etc
- Customer
    - contains customer name, customerID, gender, birthDate, e-mail, favorite movie
