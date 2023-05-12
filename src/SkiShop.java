import java.util.*;                                     // Needed for Scanner and ArrayLists objects
import java.io.*;                                       // Needed for reading and writing to files

/**
 * Lead Author(s):
 * @author Emmanuel Rivera
 * 
 * References:
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * Retrieved from https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 *  
 * Version/date: 1.0
 * 
 * Responsibilities of class:
 * A ski shop which allows a customer to login, search through inventory,
 * add items to a cart or wishlist, checkout, and make a purchase
 */

public class SkiShop
{
    private String shopName;                            // The ski shop HAS-A name
    private Customer customer = new Customer();         // The ski shop HAS-A customer
    private Cart cart = new Cart();                     // The ski shop HAS-A cart which holds the desired products to purchase
    private Scanner input = new Scanner(System.in);     // The ski shop HAS-A Scanner object for user input

    // The ski shop HAS-MANY types of products                                                   
    private String[] types = {"Skis", "Snowboard", "Boots", "Bindings", "Poles"};

    /**
     * Purpose: main method to start program
     */
    public static void main(String[] args) throws Exception
    {
        // Create instance of program
        SkiShop skitopia = new SkiShop("Skitopia");

         // Try-catch block to start program that might throw exceptions
         try 
         {  
            // Call method to start program
            skitopia.enter();
         }
         // Catch and handle any exceptions thrown during program execution
         catch (Exception anyExceptions)
         {
            // Display error message
            System.out.println("Error encountered, please try again.");
            // Restart program
            skitopia.enter();
         }
    }
   
    /**
     * Purpose: constructor that takes a shopName as the argument
     * @param shopName name of shop
     */
    public SkiShop(String shopName)
    {
        // Assign shop name
        this.shopName = shopName;
    }

    /**
     * Purpose: enter and begin your shopping experience
     * @throws Exception
     */
    public void enter() throws Exception
    {
        // Try block to run searches that may throw exceptions
        try 
        {
            // Call welcome method for store greeting
            welcome();
        }
        // Catch block to catch any exceptions thrown from search methods
        catch (Exception anyExceptions)
        {
            // Display error message
            System.out.println("Error encountered, please try again.");
            // Recall welcome method to restart program
            welcome();
        }
    }

    /**
     * Purpose: display welcome message
     * @throws Exception
     */
    public void welcome() throws Exception
    {
        // Create an intro/welcome message when entering shop for reuse
        String intro = "Welcome to " + shopName + "!\n\nOur ski shop is the " +
                            "one-stop shop for all the gear and equipment " +
                            "necessary\nfor an epic run on the slopes. Whether " +
                            "you're a skier or a snowboarder,\na beginner at " +
                            "the bunny slopes or an expert tearing up the park,\n" +
                            "we have everything you need to tackle the mountains " +
                            "\nand ride the powder with confidence!";
        // Display welcome message
        System.out.println(intro);
        // Call login method
        login();
    }

    /**
     * Purpose: ask user to login / create a new login / or checkout as a guest
     * @throws Exception
     */
    public void login() throws Exception
    {
        // Create string to ask for login for reuse
        String login = "\nEnter email to login\n(\"new\" to create a new user or " +
                        "\"guest\" to checkout as a guest):";
        // Display login message
        System.out.println(login);
        // Ask for user input
        String user = input.nextLine().toLowerCase();
        // If user enters "guest", display greetings message
        if (user.equals("guest"))
        {
            System.out.println("\nGreetings guest!");
            mainMenu();
        }
        // If user enters "new", call createLogin() method
        else if (user.equals("new"))
        {
            createLogin();
            mainMenu();
        }
        // If entry contains a domain name, display greetings message
        else if ((user.contains("@gmail.com")) || (user.contains("@hotmail.com")) || (user.contains("@yahoo.com")))
        {
            System.out.println("\nGreetings " + user + "!");
            mainMenu();
        }
        // Otherwise, if entry doesn't contain any of the above, call login() method to restart
        else 
        {
            login();
        }
    }

    /**
     * Purpose: to create a new login
     */
    public void createLogin()
    {
        // Display login message
        System.out.println("\nLet's create a new login!");
        // Create string to ask for email for reuse
        String enterEmail = "Enter your email:";
        // Initialize a variable for exiting loop
        int exitLoop = -1;
        // Continue to ask for email if no domain name was entered
        while (exitLoop < 0)
        {
            // Display "enter email" message
            System.out.println(enterEmail);
            // Assign user input to email
            String email = input.nextLine();
            // If input contains an email domain name, increment variable to exit loop
            if ((email.contains("@gmail.com")) || (email.contains("@hotmail.com")) || (email.contains("@yahoo.com")))
            {
                customer.setEmailAddress(email);
                exitLoop++;
            }
        }
        // Ask for first name
        System.out.println("\nEnter your first name:");
        // Set as customer's first name
        customer.setFirstName(input.nextLine());
        // Ask for last name
        System.out.println("\nEnter your last name:");
        // Set as customer's last name
        customer.setLastName(input.nextLine());
        // Ask for shoe size
        System.out.println("\nEnter your shoe size:");
        // Set as customer's shoe size
        customer.setShoeSize(Integer.valueOf(input.nextLine()));
        // Display greetings message
        System.out.println("\nGreetings " + customer.getFirstName() + "!");
    }

    /**
     * Purpose: start the main menu
     * @throws Exception
     */
    public void mainMenu() throws Exception
    {   
        // Display prompt asking customer if they know the specific item they're searching for
        System.out.println("\nMain Menu\nDo you already know the product you want?\n" +
                            "(Enter a brand, model, keyword, or \"no\" to continue):");

        // Assign input to keyword
        String keyword = input.nextLine().toLowerCase();
        // Try block to run searches that may throw exceptions
        try 
        {
            // If input equals "no", continue to advanced search method
            if (keyword.equals("no"))
            {
                advancedSearch();
            }
            // Otherwise perform broad item search
            else
            {
                broadSearch(keyword);
            }
        }
        // Catch block to catch any exceptions thrown from search methods
        catch (Exception anyExceptions)
        {
            // Display error message
            System.out.println("Error finding product, please try again.");
            // Restart program from main menu
            mainMenu();
        }
        
    }

    /**
     * Purpose: perform broad search through all inventory
     * @throws Exception
     */
    public void broadSearch(String keyword) throws Exception
    {
        // Create a Product array for all search results
        Product[] productArray;
        // Create a String array for keyword
        String[] fields = new String[]{keyword};
        // Create a cart to add search results to
        Cart searchResults = new Cart();
        // Search through each inventory file
        for (int i = 0; i < types.length; i++)
        {
            // Scan the inventory file and assign the cart's array of products to "productArray"
            productArray = scanInventory(types[i], keyword).getProducts();
            if (productArray != null)
            {
                // Search through each product in array
                for (Product product : productArray)
                {
                    // Add each product to the seach results cart
                    searchResults.addToCart(product);
                }
            }
        }
        // Display results
        displayResults(searchResults, fields);
    }

    /**
     * Purpose: Purpose: specific search using filters (via prompts) 
     * @throws Exception
     */
    public void advancedSearch() throws Exception
    {   
        // String for type of product
        String type = "";
        // String for desired type
        String desiredType = "";
        // Flag for while loop
        boolean validType = false;
        // Do-While loop to repeat until input is valid
        do 
        {
            // Narrow search critera based on category of gear
            System.out.println("\nWhat type of gear are you looking for?\n" +
                                            Arrays.toString(types).toLowerCase());
            // Store input
            type = input.nextLine().toLowerCase();
            // Check if entry is equal to one of the product types
            for (String eachType : types)
            {
                // If yes, assign true
                if (type.equals(eachType.toLowerCase()))
                {
                    validType = true;
                    // Assign desired type
                    desiredType = eachType;
                }
            }
        // Repeat question until a valid type is entered
        } while (!validType);

        // Narrow search critera based on brand
        System.out.println("\nDid you have a brand you prefer?\n" +
                            "(Enter brand or \"all\" to include all brands):");
        // Store input
        String brand = input.nextLine().toLowerCase();

        // Narrow search critera based on brand
        System.out.println("\nDo you know the model of the product?\n" +
                            "(Enter model or \"all\" to include all models):");
        // Store input
        String model = input.nextLine().toLowerCase();

        // Narrow search critera based on price
        System.out.println("\nWhat does your budget look like?\n" +
                            "(Enter max price or 0 to include all prices):");
        // Store input
        String budget = input.nextLine().toLowerCase();

        // Narrow search critera based on size
        System.out.println("\nDo you know your size?\n" +
                            "(Enter size or 0 to include all sizes):");
        // Store input
        String size = input.nextLine().toLowerCase();

        // Narrow search critera based on gender-specific gear
        System.out.println("\nAre you interested in Men's or Women's gear?\n" +
                            "(Enter \"mens\", \"womens\", or \"all\" to include both):");
        // Store input
        String gender = input.nextLine().toLowerCase();

        // Store all input into an ArrayList of Strings
        ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(type, brand, model, budget, size, gender));     

        // String for skill level
        String skillLevel = "";
        // String for sport
        String sport = "";
        
        // If type equals "skis" or "snowboard", continue
        if (type.equals("skis") || type.equals("snowboard"))
        {
            // Narrow search critera based on riding ability
            System.out.println("\nWould you consider yourself a beginner, intermediate, or advanced rider?\n" +
                                "(Enter \"beginner\", \"intermediate\", \"advanced\", or \"all\" to include all):");
            // Store input
            skillLevel = input.nextLine().toLowerCase();
            // Add skill level to ArrayList
            arrayList.add(skillLevel);
        }
        // If type equals "boots" or "bindings", continue
        else if (type.equals("boots") || type.equals("bindings"))
        {
            // Narrow search critera based on sport
            System.out.println("\nAre you a skier or snowboarder?\n" +
                                "(Enter \"ski\", \"snowboard\", or \"all\" to include both):");
            // Store input
            sport = input.nextLine().toLowerCase();  
            // Add sport to ArrayList
            arrayList.add(sport);
        }

        // Create a String array to copy fields from ArrayList to
        String[] fields = new String[arrayList.size()];
        // For loop to copy ArrayList to String array
        for (int i = 0; i < arrayList.size(); i++)
        {
            // Assign field
            fields[i] = arrayList.get(i);
        }

        // Create a cart for results
        Cart cart = new Cart();
        // Create a product array to hold list of all products based on type
        Product[] array = scanInventory(desiredType, "").getProducts();  
        // Iterate through each product in array
        for (Product product : array)
        {
            // If the brand of product equals input, continue
            if (product.getBrand().toLowerCase().equals(brand) || brand.equals("all"))
            {   
                // If the model of product equals input, continue
                if (product.getModel().toLowerCase().equals(model) || model.equals("all"))
                { 
                    // If the price of product is less than input or input is 0, continue
                    if (product.getPrice() < Double.valueOf(budget) || Double.valueOf(budget) == 0)
                    {
                        // If the size of product equals input or input is 0, continue
                        if (product.getSize() == Integer.valueOf(size) || Integer.valueOf(size) == 0)
                        {
                            // If the gender of product equals input or input is "all", continue
                            if (product.getGender().toLowerCase().equals(gender) || product.getGender().equals("Unisex") || gender.equals("all"))
                            {
                                // If type equals "skis" or "snowboard", continue
                                if (type.equals("skis") || type.equals("snowboard"))
                                {
                                    // If the skill level of product equals input or input is "all", continue
                                    if (product.getSkillLevel().toLowerCase().equals(skillLevel) || skillLevel.equals("all"))
                                    {
                                        // If all fields are met, add product to cart
                                        cart.addToCart(product);
                                    }
                                }
                                // If type equals "boots" or "bindings", continue
                                else if (type.equals("boots") || type.equals("bindings"))
                                {
                                    // If the sport equals input or input is "all", continue
                                    if (product.getSport().toLowerCase().equals(sport) || product.getSport().equals("Unisex") || sport.equals("all"))
                                    {
                                        // If all fields are met, add product to cart
                                        cart.addToCart(product);
                                    }   
                                }
                                // Otherwise, if the type is none of those above
                                else 
                                {
                                    // If all fields are met, add product to cart
                                    cart.addToCart(product);
                                }
                            }
                        }
                    }
                }
            }
        }
        // Display results
        displayResults(cart, fields);
    }

    /**
     * Purpose: scan through inventory
     * @throws Exception
     */
    public Cart scanInventory(String type, String keyword) throws Exception
    {
        // Create a cart for the search results
        Cart searchResults = new Cart();
        // Open the inventory file associated to the type of product desired to search for
        File file = null;
        // Read desired inventory file with Scanner object 
        Scanner inputFile = null;
        // Try block to handle exceptions thrown from I/O operations
        try 
        {
            // Open the inventory file associated to the type of product desired to search for
            file = new File(type + "Inventory.txt");
            // Read desired inventory file with Scanner object 
            inputFile = new Scanner(file);
            // While loop to search through each line of file
            while (inputFile.hasNextLine())
            {
                // Assign the current line from the file to a String
                String line = inputFile.nextLine();
                // Split each word from the line and create an array
                String[] fields = line.split(" ");
                // For loop to check if any of the words from the line is equal to the desired item/keyword
                for (int i = 0; i < fields.length; i++)
                {
                    // If the word from line contains the desired item/keyword, add product to search results
                    if (fields[i].toLowerCase().contains(keyword))
                    {
                        // Use the words (fields) from the line to create a Product object
                        Product product = createProduct(fields, type);
                        // Assign the unique serial number of product to the product's item number
                        product.setItemNumber(Integer.valueOf(fields[0]));
                        // Set description of product based on brand and model
                        product.setDescription(product.getBrand(), product.getModel());
                        // Add product to search results (cart)
                        searchResults.addToCart(product);
                        // Assign the array length to "i" to exit loop
                        i = fields.length;
                    }
                }
            }
        }
        // Catch block if an exception was thrown during I/O operations
        catch (IOException exception) 
        {
            // Display the exception that was thrown
            System.out.println("Sorry, inventory file not found");
        }
        // Finally block to always close access to file
        finally 
        {
            if (inputFile != null)
            {
                // Close Scanner
                inputFile.close();
            }
        }
        // Return cart of products
        return searchResults;
    }

    /**
     * Purpose: display search results
     * @throws Exception
     */
    public void displayResults(Cart searchResults, String[] fields) throws Exception
    {
        // Call getModels() method to create array for different types of models of Products
        searchResults.getModels();
        // Initialize a count variable with quantity of different models in cart 
        int count = searchResults.getModelCount();
        // If at least 1 product found, display results
        if (count > 0)
        {
            // Display number of results
            System.out.println("\nWe found " + count + " result(s) for " + Arrays.toString(fields) + ":\n");
            // Display search results
            System.out.print(searchResults);
            // Display prompt asking if interested in products
            System.out.println("\nAre you interested in any of these products?\n" + 
                            "(Enter \"yes\" or \"no\"):");
            // Assign input
            String interested = input.nextLine().toLowerCase();
            // If input is "yes", add the product to cart, checkout, or continue shopping
            if (interested.equals("yes") || interested.equals("y"))
            {
                // Call interested() method for next step
                interested(searchResults);
            }
            // If the input wasn't "yes" (customer not interested in any of the products in the search results), then call method to return to main menu 
            else 
            {
                startOver();
            }
        }
        // Otherwise, display no results found
        else 
        {
            // Display number of results
            System.out.println("\nWe found no results:\n");
            // Call startOver() to return to main menu
            startOver();
        }
    }

    /**
     * Purpose: determine if customer would like to add any items to cart
     * @throws Exception
     */
    public void interested(Cart searchResults) throws Exception
    {
        // Initialize a variable for exiting the while loop
        int exitLoop = -1;
        // Initialize an integer for input
        int itemNumber = -1;
        // Repeat prompt asking for desired selection if input invalid
        while (exitLoop < 0)
        {   
            // Declare a boolean for while loop
            boolean validItemNumber = false;
            // Do-while loop to continue asking for input if invalid
            do
            {
                // Try-Block to handle exceptions thrown from invalid input
                try 
                {
                    // Display prompt to ask for desired item or if customer would like to proceed to checkout or continue shopping
                    System.out.println("\nEnter your desired selection\n" +
                            "(Enter Item #):");
                    // Store input
                    itemNumber = input.nextInt();
                    // Assign true to valid input
                    validItemNumber = true;

                }
                // Catch any exceptions from invalid input and display prompt
                catch (InputMismatchException exception)
                {
                    // Display prompt to ask customer to re-enter correct input
                    System.out.println("\nInvalid entry type, please enter an integer.\n");
                    // Clear buffer (prevents infinite loop)
                    input.nextLine();
                }
            } while (!validItemNumber);
            // Consume next line character
            input.nextLine();
            // Get model count
            int modelCount = searchResults.getModelCount();
            // Initialize a boolean variable for checking if the product is in the search results
            boolean itemInSearchResults = false;
            // If selection is within the search results, assign true
            if ((itemNumber > 0) && (itemNumber <= modelCount))
            {   
                // Assign true
                itemInSearchResults = true;
            }
            // Assign desired selection (based on item number / model index) to a Product array
            Product[] modelArray = searchResults.getSpecificModel(itemNumber);
            // If desired item is within the search results list, continue
            if (itemInSearchResults)
            { 
                // Display product description and available sizes
                System.out.println(searchResults.getModelDescription(modelArray));
                // Declare integer to store input
                int desiredSize = -1;
                // Declare a boolean for while loop
                boolean validSize = false;
                // Get array of available product sizes
                int[] productSizes = searchResults.getProductSizes();
                // Initialize a boolean variable for checking if the size of product is available
                boolean sizeAvailable = false;
                // Create an integer to store index of desired size
                int desiredIndex = -1;
                // Do-while loop to continue asking for input if invalid
                do
                {
                    // Try-Block to handle exceptions thrown from invalid input
                    try 
                    {
                        // Display prompt asking customer which size they would like
                        System.out.println("Which size would you like?\n(Enter available size):");
                        // Store input
                        desiredSize = input.nextInt();
                        // Assign true to valid input
                        validSize = true;
                        // Iterate through each available size
                        for (int size = 0; size < productSizes.length; size++)
                        {   
                            // If size is available, assign true
                            if (desiredSize == productSizes[size])
                            {
                                // Store index associated with desired size for next step
                                desiredIndex = size;
                                // Assign true
                                sizeAvailable = true;
                            }
                        }
                        // If size is not available, display message
                        if (!sizeAvailable)
                        {
                            // Display message
                            System.out.println("\nSize not available, please try again.\n");
                        }
                    }
                    // Catch any exceptions from invalid input and display prompt
                    catch (InputMismatchException exception)
                    {
                        // Display prompt to ask customer to re-enter correct input
                        System.out.println("\nInvalid entry type, please enter an integer.\n");
                        // Clear buffer (prevents infinite loop)
                        input.nextLine();
                    }
                // Repeat loop while entry type or size is not valid
                } while (!validSize || !sizeAvailable);
                // Declare integer to store input
                int quantity = -1;
                // Declare a boolean for while loop
                boolean validQuantity = false;
                // Initialize a boolean variable for checking if the quantity of product is available
                boolean quantityAvailable = false;
                // Get 2D array of Products (based on size)
                Product[][] multiSizes = searchResults.getMultiSizes();
                // Do-while loop to continue asking for input if invalid
                do
                {
                    // Try-Block to handle exceptions thrown from invalid input
                    try 
                    {
                        // Display prompt asking customer for desired quantity
                        System.out.println("\nHow many do you want?\n(Enter desired quantity):");
                        // Store input
                        quantity = input.nextInt();
                        // Assign true
                        validQuantity = true;
                        // If quantity of desired size is available (by checking associated product array length), assign true
                        if (quantity > 0 && quantity <= multiSizes[desiredIndex].length)
                        {   
                            // Assign true
                            quantityAvailable = true;
                        }
                        if (!quantityAvailable)
                        {
                            // Display error message
                            System.out.println("\nInvalid quantity entered, please try again.");
                        }
                    }
                    // Catch any exceptions from invalid input and display prompt
                    catch (InputMismatchException exception)
                    {
                        // Display prompt to ask customer to re-enter correct input
                        System.out.println("\nInvalid entry type, please enter an integer.\n");
                    }
                } while (!validQuantity || !quantityAvailable);
                // Consume next line character
                input.nextLine();
                // Display prompt asking customer if they would like to add product to cart
                System.out.println("\nWould you like to add to cart?\n(Enter \"yes\" or \"no\"):");
                // Assign input
                String addToCart = input.nextLine().toLowerCase();
                // If input equals "yes", continue
                if (addToCart.equals("yes"))
                {
                    // Iterate through each product in array associated with desired size (based on desired quantity)
                    for (int product = 0; product < quantity; product++)
                    {
                        // Initialize a boolean variable for checking if the product is already in the cart to prevent duplicates
                        boolean alreadyInCart = cart.contains(multiSizes[desiredIndex][product]);
                        // If the item is not in the cart, continue
                        if (!alreadyInCart)
                        {  
                            // Add product to cart
                            cart.addToCart(multiSizes[desiredIndex][product]);
                            // Remove product from search results
                            searchResults.removeFromCart(multiSizes[desiredIndex][product]);
                            // Remove product from inventory
                            multiSizes[desiredIndex][product].removeFromInventory(multiSizes[desiredIndex][product]);
                            // Display Product String
                            System.out.println("\n" + multiSizes[desiredIndex][product].toString() + "added to cart!");
                        }
                        // If item was already in the cart, display prompt
                        else 
                        {
                            // Display that the selected item was already in the cart
                            System.out.println("\nThe item you've selected is already in the cart.");
                        }
                    }
                    // If there are no more search results, display next prompt and exit loop
                    if (searchResults.getQuantity() < 1)
                    {
                        // Display prompt asking if customer would like to proceed to checkout or continue shopping
                        proceed();
                        // Exit loop if no more products remain
                        exitLoop++;
                    }
                    // If there are still more items in the search results that can be added to cart, display next prompt
                    else 
                    {
                        // Display prompt asking if customer would like to select more products
                        System.out.println("\nWould you like to select more products?\n" +
                                        "(Enter \"yes\" or \"no\"):");
                        // Assign input to a String
                        String selectMore = input.nextLine().toLowerCase();
                        // If input is "no", exit loop and call checkout() method
                        if (selectMore.equals("no"))
                        {
                            // Display prompt asking if customer would like to proceed to checkout or continue shopping
                            proceed();
                            // Exit loop if no more products remain
                            exitLoop++;
                        }
                    }
                }
                // Otherwise, return to main menu
                else 
                {
                    // Display prompt asking if customer would like to proceed to checkout or continue shopping
                    proceed();
                    // Exit loop if no more products remain
                    exitLoop++;
                }
            }
            // If the item number entered isn't equal to any of the item numbers in the search results, display prompt
            else 
            {
                // Display "invalid number entered" message
                System.out.println("\nItem not found in search results. Please try again.");
            }
        }
    }

    /**
     * Purpose: determine if customer would like to start over and repeat search
     * @throws Exception
     */
    public void startOver() throws Exception
    {
        // Display prompt asking if customer would like to return to main menu
        System.out.println("\nWould you like to start over?\n" +
                            "(Enter \"yes\" or \"no\"):");
        // Assign input to a String
        String repeat = input.nextLine().toLowerCase();
        // If input is "yes", then return to main menu
        if (repeat.equals("yes"))
        {
            mainMenu();
        }
        // Otherwise, proceed to checkout
        else 
        {
            checkout();
        }
    }

     /**
     * Purpose: create a product based on type entered
     * @param fields each attribute to pass into Product constructors (retrieved from Inventory file)
     * @param type the type of product (Snowboard/Skis/etc)
     */
    public Product createProduct(String[] fields, String type)
    {
        // Create Product reference variable
        Product product;
        // If the desired type is "Skis", create a Ski product
        if (type.equals("Skis"))
            {
                product = new Skis(fields[1], fields[2], Double.valueOf(fields[4]), Integer.valueOf(fields[5]), 
                                            fields[6], fields[7]);
                return product;
            }
        // If the desired type is "Snowboard", create a Snowboard product
        else if (type.equals("Snowboard"))
        {
            product = new Snowboard(fields[1], fields[2], Double.valueOf(fields[4]), Integer.valueOf(fields[5]), 
                                        fields[6], fields[7]);
            return product;
        }
        // If the desired type is "Boots", create a Boots product
        else if (type.equals("Boots"))
        {
            product = new Boots(fields[1], fields[2], Double.valueOf(fields[4]), Integer.valueOf(fields[5]), 
                                        fields[6], fields[7]);
            return product;
        }
        // If the desired type is "Bindings", create a Bindings product
        else if (type.equals("Bindings"))
        {
            product = new Bindings(fields[1], fields[2], Double.valueOf(fields[4]), Integer.valueOf(fields[5]), 
                                        fields[6], fields[7]);
            return product;
        }
        // If the desired type is "Poles", create a SkiPoles product
        else if (type.equals("Poles"))
        {
            product = new SkiPoles(fields[1], fields[2], Double.valueOf(fields[4]), 
                                                            Integer.valueOf(fields[5]), fields[6]);
            return product;
        }
        else
        {
            return null;
        }
    }

    /**
     * Purpose: prompt to ask if customer would like to proceed to checkout or continue shopping
     * @throws Exception
     */
    public void proceed() throws Exception
    {
        // Display prompt asking if customer would like to checkout or continue shopping
        System.out.println("\nWould you like to proceed to checkout or continue shopping?\n" + 
                                "(Enter \"checkout\" or \"shop\"):");
        // Assign input to a String
        String proceed = input.nextLine().toLowerCase();
        // If input is "checkout", exit loop and proceed to checkout
        if (proceed.equals("checkout"))
        {
            checkout();
        }
        // Otherwise, exit loop and return to main menu
        else 
        {
            mainMenu();
        }
    }

    /**
     * Purpose: checkout function to display products in cart and proceed to purchase if desired
     * @throws Exception
     */
    public void checkout() throws Exception
    {   
        if (cart.getQuantity() > 0)
        {
            // Display prompt
            System.out.println("\nHere are the product(s) in your cart: [Quantity: " + cart.getQuantity() + "]");
            // Display products
            System.out.print(cart);
        }
        else 
        {
            // Display prompt
            System.out.println("\nYou have 0 products in your cart.");
        }
    }
}