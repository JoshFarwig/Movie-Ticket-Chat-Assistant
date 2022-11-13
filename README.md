
# Movie Virtual Assistant 
## Project Description:

A virtual assistant that allows for customers to book/change/cancel new or current movie ticket bookings. After confirming their booking, the customer gets their ticket sent to them via email. The entire project was developed using Java and utilized libraries such as JDBC, JSwing, Java AWT, and Java Mail for our features. We went with a simple, straight-forward design for our assistant's user interface. The user has two input options, either by directly typing into the chatbox or by clicking one of the buttons right above it. After the user has finished their interaction and their request was met, they receive a confirmation email of the interaction via the email on file.    

## New Features: 
### Amending an Existing Movie Ticket 
Users can now finally edit their existing tickets. There are several ways to access this feature. User can either type in that they would like to edit/amend their ticket or click the relevant button at the beginning of the interaction. Once the process has started the user can amend any detail relating to the ticket. However, the customer details cannot be amended once saved on the database. This improves our system by being more forgiving with mistakes and providing the user with an option to edit their tickets in case they cannot make it to the current booked movie time.

***INSERT AMENDING SAMPLE OUTPUT*** 
### Cancelling an Existing Movie Ticket
Users can cancel an existing ticket if they choose to. By canceling a ticket, the seat selected by the user becomes unoccupied. Canceling a ticket can be done through clicking the "Cancel Booking" button as soon as the program starts or by typing it into the chatbox. By allowing users to delete their tickets, we're including a fundamental feature that needs to be implemented. In our previous version of the assistant, all bookings were final and non-editable. 
### Email Confirmation
After confirming their ticket booking, users are sent an email including a full summary of their order and a link for payment. Another case is when the user ammends their ticket, they are sent a new ticket summary with the new information. Upon deleting a ticket, users are sent an email confirming the cancellation of their booking and a refund request link. By sending users an email of their order, we provide them with the option of keeping a permanent record of their reservations outside our database.
### Stand-alone Database Storage
We used MySQL, JDBC library and Docker to create a database to store customer, movie and seat information as well as using foreign keys to reference other tables in the database to create a more concise and complete way of storing information. In our previous version, we used ArrayLists for data storage which proved to be difficult as we had no option for reliable offline data storage or support for multi-users.
### Pattern Matching

