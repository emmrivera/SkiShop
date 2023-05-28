# SkiShop
Demonstrates Object-Oriented Programming in Java with a Ski Shop website

Project Proposal

Planned Working Time
I will allocate 3 hours every Saturday and Sunday from 0500 to 0800 for a total of 6 hours each week to work on this project. 

Project Pitch
Skitopia (ski shop) is designed to provide a user-friendly experience where you can seamlessly find the gear you need for hitting the slopes. Our shop has a variety of products which includes skis, snowboards, boots, bindings, and poles. Additionally, services such as waxing, fitting, and installation are complimentary for our customers. We hope you enjoy your shopping experience with us and look forward to seeing you slopeside!
Website Features:
If you want to expedite the checkout process with saved account information you can do so by logging in or creating a new username.
Our ski shop offers a comprehensive search function. You can search for a specific product by name or keyword, or you can browse through our menu of products categorized by various criteria such as gender, price, size, etc.
To select each option, simply click on the desired product from the results displayed. Once selected, you can view the product (price, description, etc.), choose your size, add the item to your cart, proceed to checkout, or return to the list of options from your search. 

UML Diagram

[UML Diagram insert]

Object-Oriented Design

Link to a video explaining how this project implements object-oriented design:
https://youtu.be/H7fULXN92wg

Learning Outcomes

LO1: Employ design principles of object-oriented programming
My project will demonstrate LO1 through the use of multiple classes and objects (representing different products) along with fields and methods belonging to each
LO2: Construct programs utilizing single and multidimensional arrays
My project will demonstrate LO2 by utilizing arrays to store, sort, and display an inventory of products (snowboards, skis, etc.)
LO3: Construct programs utilizing object and classes in object-oriented programming, including aggregation
My project will demonstrate LO3 through object aggregation with a SkiShop having (HAS) Customers, Products, and Carts
LO4: Construct programs utilizing inheritance and polymorphism, including abstract classes and interfaces
My project will demonstrate LO4 through inheritance with Products extending subclasses (Snowboards, Skis, etc.) as well as the implementation of abstract classes (Product) and interfaces (Waxable, Wearable, etc.)
LO5: Construct programs utilizing exception handling
My project will demonstrate LO5 by preventing the program from halting due to invalid user input or an out-of-stock Product
LO6: Construct programs utilizing text file I/O
My project will demonstrate LO6 by allowing the storage and retrieval of Product inventory and descriptions
LO9: Construct programs utilizing graphical user interfaces utilizing event-driven programming.
My project will demonstrate LO9 through the user interaction with the website’s GUI (buttons, combo boxes, etc.)

Timeline

[Timeline insert]

Project Timeline Goals
Week 1
Pushed to Week 2
Continuation from Project 1 with implementation of a GUI (LO7) and data structures (LO8) - *[ArrayLists already implemented in Project 1]*
Week 2
Begin writing project page.
Write the project proposal.
Design the GUI (sketch).
Create updated UML diagram
Submit code written so far (Project 1).
Week 3
Write code to create a non-functional GUI.
Determine which other classes/methods are needed to support the GUI.
Add event handling to make the GUI functional.
Test, test, test, debug, and test some more.
Update project page with progress details.
Submit code written so far.
Week 4
Debug any remaining problems.
Create project demonstration video, including information about how LO7 and LO8 is used as part of the project.
Submit final code on Canvas and add videos to the project page.

Github Repository

Link to Github repository of project:
https://github.com/emmrivera/SkiShop
 
Week 2: Updates
This week, I started my Project 2 with the Project Page which includes the proposal (continuation from Project 1), a sketch of the possible GUI for my ski shop website, and an updated UML diagram from all the classes already written from Project 1. Since we’ll be working with GitHub for this Project, I’ve gone ahead and uploaded and committed my current Project to the repository (link provided above). 

I have a lot of work to do in regards to writing the code to implement the GUI, however for this week, I’ll submit my code to get checked off for the requirements of utilizing data structures in our program. I had already utilized ArrayLists in Project 1 in order to manipulate the cart by adding and removing Products which are shown in the Cart class in the addProductToArray() and removeProductFromArray() methods as well as other methods in the Cart class for retrieving or sorting Products in the cart including getProducts(), getModels(), and sortBySize().

For this upcoming week, I will be focused on creating the GUI widgets and event handlers. I will implement a JFrame for the window, combo boxes for the Products menu, a text field for a search bar, a text area for the welcome message, a button for the login function, and potentially icons to display featured items. 

Week 3: Updates
This week, I first started by creating a non-functional main/front page of GUI which included the title drawn up from my sketch, a Product menu button with a popup drop-down menu, a search bar with a button to search for Products, a login button to sign in or create new login, a cart button to see Products added, and a welcome message (screenshots attached below).

I haven’t gotten to formatting yet (label fonts/styling, etc) and also the primary function of my program which is to search for a Product and add or remove them from the cart. I spent a lot of time trying to understand and determine how to alternate between panels or components in order to keep the header of the page visible (title, product menu and search bar, login and cart buttons) while only manipulating the center panel on display (referred to as “displayPanel” in the SkiShop class) based on the function the Customer wants to interact with.

For example, if the Customer wants to login (by clicking the login button), it will hide the welcome message on the center panel and in place display a label and text field prompting the Customer to enter an email, create a new login, or continue as a guest. The cart button works in a similar fashion by clearing the center panel and displaying the products in the cart. By implementing these functions, it eliminated a few of the methods in the SkiShop class such as login(), createLogin(), and checkout(). 

The Product menu and search bar are my next tasks to work on. As of right now, the Product menu will only display a drop-down menu of the different Product types (Skis, Snowboard, Boots, etc) - action listeners are still needed for each of these submenus. Lastly, the search bar and button has action listeners but does not have any functionality yet. Since time is of the essence as we are in the last week of this class, working on the functionality of the Product menu and search bar are my main priorities.

Week 4: Project Wrap-up

Here is a link to my final video presentation, demonstrating how LO7 (GUIs) and LO8 (Data structures) were implemented in my program:
https://sdccd.us-west-2.instructuremedia.com/embed/d75126e4-35ff-48e3-888e-6ef38b69b81f

This final week, I worked on implementing functionality to the GUI components that I created last week, mainly the broadSearch() method via the product “Menu” button with its drop down (Popup menu) and the search bar with the text field and search button. Once I finished implementing those functions, I went ahead and tried to clean up and improve the overall layout, spacing, and style of my program. For example, displaying the products in the center (display panel) with a prompt text field at the bottom asking the user to select which size of the product they desire and whether they would like to add the product to the cart. I also added an “About” menu which displays a frame including my developer info (name, email, phone).

Lastly, I worked on implementing the advancedSearch() method with an additional “Filters” button which allows the user to select options for further filtering of a desired product using categories such as brands, models, price, etc. This was very action listener intensive since there were a lot of components to work with and to also make sure those components would integrate smoothly with the previous code already created within the advancedSearch() method which was text-based. 

Overall, the product functions as intended allowing a Customer to create a login or login as a guest, check the products in the cart, restart or exit the program via the “File” menu, display program developer info, perform a broad search based on product type (Skis, Snowboard, etc.), perform a broad search based on keyword using a search bar, and lastly, perform an advanced (filtered) search based on options selected by the Customer. I have attached screenshots of the working program below. Hope you enjoy your shopping experience at Skitopia!
