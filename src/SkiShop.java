import java.util.*;                                     // Needed for Scanner and ArrayLists objects
import java.io.*;                                       // Needed for reading and writing to files
import javax.swing.*;                                   // For creating GUIs and its graphical components   
import java.awt.*;                                      // For communicating to Operating System with GUIs

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
 * A ski shop website which allows a customer to login, search through inventory,
 * add items to a cart or wishlist, checkout, and make a purchase
 */

public class SkiShop extends JFrame 
{
    private String shopName,                            // The Ski Shop HAS-A name
                   typeFilter,                          // The Ski Shop HAS-A type filter selection
                   brandFilter = "all",                 // The Ski Shop HAS-A brand filter selection
                   modelFilter = "all",                 // The Ski Shop HAS-A model filter selection
                   sizeFilter = "0",                    // The Ski Shop HAS-A size filter selection
                   priceFilter = "0",                   // The Ski Shop HAS-A price filter selection
                   genderFilter = "all",                // The Ski Shop HAS-A gender filter selection
                   skillFilter,                         // The Ski Shop HAS-A skill filter selection
                   sportFilter;                         // The Ski Shop HAS-A sport filter selection
    private Customer customer = new Customer();         // The Ski Shop HAS-A customer
    private Cart cart = new Cart();                     // The Ski Shop HAS-A cart which holds the desired products to purchase
    private JPanel mainPanel,                           // The Ski Shop HAS-A main panel for all components
                   displayPanel,                        // The Ski Shop HAS-A panel for displaying login message, cart, login, etc
                   headerPanel,                         // The Ski Shop HAS-A panel for the header of page
                   searchPanel,                         // The Ski Shop HAS-A panel for searching for Products (within header)
                   topRightPanel;                       // The Ski Shop HAS-A panel for login and cart options (within header)
    private JLabel welcomeLabel,                        // The Ski Shop HAS-A label for welcome prompt
                   titleLabel,                          // The Ski Shop HAS-A label for the title of page
                   homeLabel;                           // The Ski Shop HAS-A label for a "home" page label                               
    private JTextArea welcomeTextArea;                  // The Ski Shop HAS-A text area for welcome message
    private JButton menuButton,                         // The Ski Shop HAS-A button for Product menu 
                    searchButton,                       // The Ski Shop HAS-A button for searching for Products
                    filterButton,                       // The Ski Shop HAS-A button for an advanced seacrch with filters
                    loginButton,                        // The Ski Shop HAS-A button for login options
                    cartButton,                         // The Ski Shop HAS-A button for cart options
                    homeButton;                         // The Ski Shop HAS-A button for returning to "home" page
    private JMenuBar menuBar;                           // The Ski Shop HAS-A menu bar       
    private JMenu aboutMenu,                            // The Ski Shop HAS-A about menu for developer info
                  fileMenu;                             // The Ski Shop HAS-A file menu
    private JPopupMenu productMenu,                     // The Ski Shop HAS-A popup menu for Product types
                       filterMenu;                      // The Ski Shop HAS-A popup menu for Product filters
    private JMenuItem skisItem,                         // The Ski Shop HAS-A menu item for skis
                      snowboardItem,                    // The Ski Shop HAS-A menu item for snowboards
                      bootsItem,                        // The Ski Shop HAS-A menu item for boots
                      bindingsItem,                     // The Ski Shop HAS-A menu item for bindings
                      polesItem,                        // The Ski Shop HAS-A menu item for ski poles
                      aboutMenuItem,                    // The Ski Shop HAS-A about menu item for developer info
                      exitMenuItem,                     // The Ski Shop HAS-A menu item for exiting program
                      restartMenuItem;                  // The Ski Shop HAS-A menu item for restarting program
    private JTextField searchBar;                       // The Ski Shop HAS-A text field for a search bar        

    // The ski shop HAS-MANY types of products                                                   
    private String[] types = {"Skis", "Snowboard", "Boots", "Bindings", "Poles"};

    /**
     * Purpose: main method to start program
     */
    public static void main(String[] args) throws Exception
    {
         // Try-catch block to start program that might throw exceptions
         try 
         {  
            // Create instance of program
            new SkiShop("Skitopia").enter();
         }
         // Catch and handle any exceptions thrown during program execution
         catch (Exception anyExceptions)
         {
            // Display stack trace
            anyExceptions.printStackTrace();
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
     * Purpose: Build GUI for Ski Shop website as you "enter" shop
     */
    public void enter()
    {
        // Create a panel for the main content
        mainPanel = new JPanel(new BorderLayout());
        // Set background color white
        mainPanel.setBackground(Color.WHITE);
        // Add main panel to frame
        add(mainPanel);

        // Set title of page
        setTitle(shopName);
        // Create title label
        titleLabel = new JLabel(new ImageIcon("Title.jpg"));
        // Add Mouse Listener to label to display "home" page
        titleLabel.addMouseListener(new TitleListener(this));

        // Build menu bar
        buildMenuBar();
        // Build display panel
        buildDisplayPanel();
        // Build header panel
        buildHeaderPanel();
        // Build search panel (within header)
        buildSearchPanel();
        // Build top right panel for login and cart options (within header)
        buildTopRightPanel();

        // Allow program to be exited by clicking on "X"
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set size of frame
        setPreferredSize(new Dimension(800, 500));
        // Pack all panels together to reduce any empty space
        pack();
        // Center frame on screen
        setLocationRelativeTo(null);
        // Set visible to be displayed on screen
        setVisible(true);
    }

    /**
     * Purpose: Build menu bar for File menu
     */
    public void buildMenuBar()
    {
        // Creates "About" menu
        aboutMenu = new JMenu(
            "About");             
        // Creates "Developer" menu item              
        aboutMenuItem = 
            new JMenuItem("Developer");        
        // Adds functionality to button (open text box) 
        aboutMenuItem.addActionListener(
            new AboutItemListener());   
        // Adds "About" menu item to about menu        
        aboutMenu.add(aboutMenuItem);           

        // Create menu bar
        menuBar = new JMenuBar();
        // Create file menu
        fileMenu = new JMenu("File");
        // Create menu item to restart program
        restartMenuItem = new JMenuItem("Restart");
        // Add Action Listener to restart program when clicked
        restartMenuItem.addActionListener(new RestartItemListener(this));
        // Create menu item to exit program
        exitMenuItem = new JMenuItem("Exit");
        // Add Action Listener to exit program when clicked
        exitMenuItem.addActionListener(new ExitItemListener());
        // Add menu item to file menu
        fileMenu.add(restartMenuItem);
        // Add menu item to file menu
        fileMenu.add(exitMenuItem);
        // Add about menu to menu bar
        menuBar.add(aboutMenu);
        // Add file menu to menu bar
        menuBar.add(fileMenu);
        // Add menu bar to frame
        setJMenuBar(menuBar);
    }

    /**
     * Purpose: Build panel to organize top components of page (title, menu, search, etc)
     */
    public void buildHeaderPanel()
    {
        // Create a panel for the header of the page
        headerPanel = new JPanel(new BorderLayout());
        // Set background color white
        headerPanel.setBackground(Color.WHITE);
        // Add header panel to main panel
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        // Add title label to header panel
        headerPanel.add(titleLabel, BorderLayout.CENTER);
    }

    /**
     * Purpose: Build panel for displaying welcome message, login, cart, etc
     */
    public void buildDisplayPanel()
    {
        // Create display panel
        displayPanel = new JPanel(new BorderLayout());
        // Set background color white
        displayPanel.setBackground(Color.WHITE);
        // Create welcome label
        welcomeLabel = new JLabel("Welcome to " + shopName + "!");
        // Set font
        welcomeLabel.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 24));
        // Center horizontally
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER); 
        // Center vertically
        welcomeLabel.setVerticalAlignment(JLabel.CENTER); 
        // Add label to welcome panel
        displayPanel.add(welcomeLabel, BorderLayout.NORTH);
        // Set an empty border for spacing
        displayPanel.setBorder(BorderFactory.createEmptyBorder(50, 30, 30, 30));

        // Create welcome message
        welcomeTextArea = new JTextArea("Our ski shop is the " +
                            "one-stop shop for all the gear and equipment " +
                            "necessary for an epic run on the slopes. Whether " +
                            "you're a skier or a snowboarder, a beginner at " +
                            "the bunny slopes or an expert tearing up the park, " +
                            "we have everything you need to tackle the mountains " +
                            "and ride the powder with confidence!");
        // Set font
        welcomeTextArea.setFont(new Font("Serif", Font.PLAIN, 16));
        // Restrict editing
        welcomeTextArea.setEditable(false);
        // Wrap sentences to next line
        welcomeTextArea.setLineWrap(true);
        // Wrap entire words to next line
        welcomeTextArea.setWrapStyleWord(true);
        // Set an empty border for spacing
        welcomeTextArea.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        // Add text area to welcome panel
        displayPanel.add(welcomeTextArea, BorderLayout.CENTER);
        // Add welcome panel to main panel
        mainPanel.add(displayPanel, BorderLayout.CENTER);


        // Create home page label
        homeLabel = new JLabel("To browse our selection of products, " + 
                                      "click on the \"Menu\" button or use the search bar");
        // Create back to home button
        homeButton = new JButton("Back to Home");
        // Add Action Listener to return to home page
        homeButton.addActionListener(new HomeButtonListener(this));
    }

    /**
     * Purpose: Build panel to for search bar and button
     */
    public void buildSearchPanel()
    {
        // Create panel for search bar
        searchPanel = new JPanel();
        // Set an empty border for spacing
        searchPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        // Set background color white
        searchPanel.setBackground(Color.WHITE);
        // Add header panel to header panel
        headerPanel.add(searchPanel, BorderLayout.EAST);

        // Create the Product menu
        menuButton = new JButton("Menu");
        // Create popup menu of different Product types
        productMenu = new JPopupMenu();
        // Create Skis menu item
        skisItem = new JMenuItem("Skis");
        // Add Action Listener to display results for Skis
        skisItem.addActionListener(new SkisItemListener(this));
        // Create Snowboard menu item
        snowboardItem = new JMenuItem("Snowboard");
        // Add Action Listener to display results for Snowboard
        snowboardItem.addActionListener(new SnowboardItemListener(this));
        // Create Boots menu item
        bootsItem = new JMenuItem("Boots");
        // Add Action Listener to display results for Boots
        bootsItem.addActionListener(new BootsItemListener(this));
        // Create Bindings menu item
        bindingsItem = new JMenuItem("Bindings");
        // Add Action Listener to display results for Bindings
        bindingsItem.addActionListener(new BindingsItemListener(this));
        // Create Poles menu item
        polesItem = new JMenuItem("Poles");
        // Add Action Listener to display results for Skis
        polesItem.addActionListener(new PolesItemListener(this));
        // Add Skis menu item to Product popup menu
        productMenu.add(skisItem);
        // Add Snowboard menu item to Product popup menu
        productMenu.add(snowboardItem);
        // Add Boots menu item to Product popup menu
        productMenu.add(bootsItem);
        // Add Bindings menu item to Product popup menu
        productMenu.add(bindingsItem);
        // Add Poles menu item to Product popup menu
        productMenu.add(polesItem);
        // Add Action Listener to display Product types when clicked
        menuButton.addActionListener(new MenuButtonListener(productMenu, menuButton));
        // Add Product menu button to search panel
        searchPanel.add(menuButton);

        // Create filter button
        filterButton = new JButton("Filters");
        // Create popup menu of different Product types
        filterMenu = new JPopupMenu();
        // Add action listener to display filters for an advanced search
        filterButton.addActionListener(new FilterButtonListener(filterButton, filterMenu));
        // Add button to search panel
        searchPanel.add(filterButton);

        // Build filter menu (advanced search)
        buildFilterMenu();

        // Create a text field for search
        searchBar = new JTextField("Enter a product or keyword");
        // Set the number of columns (desired width)
        searchBar.setColumns(20);
        // Set the text color for the placeholder
        searchBar.setForeground(Color.GRAY); 
        // Display message when mouse hovers over text field
        searchBar.setToolTipText("Leave field blank to view all products");
        // Add Mouse Listener to clear placeholder text and set color black when clicked
        searchBar.addMouseListener(new SearchBarMouseListener(searchBar));
        // Add Action Listener to search for Products when entering input into search bar
        searchBar.addActionListener(new SearchBarListener(this, searchBar));
        // Add to search panel
        searchPanel.add(searchBar);

        // Create a button for search
        searchButton = new JButton(new ImageIcon("MagnifyingGlass.jpg"));
        // Display message when mouse hovers over button
        searchButton.setToolTipText("Click to search for product/keyword");
        // Add Action Listener to search for Products when clicking on search button
        searchButton.addActionListener(new SearchButtonListener(this, searchBar));
        // Add to search panel
        searchPanel.add(searchButton);
    }

    /**
     * Purpose: Build filter menu
     */
    public void buildFilterMenu()
    {
        // Create product filters (categories)
        JMenu brandMenu = new JMenu("Brands");
        JMenu modelMenu = new JMenu("Models");
        JMenu priceMenu = new JMenu("Price");
        JMenu genderMenu = new JMenu("Gender");
        JMenu skillMenu = new JMenu("Skill");
        JMenuItem searchItem = new JMenuItem("Search");

        // Add menus to filter menu
        filterMenu.add(brandMenu);
        filterMenu.add(modelMenu);
        filterMenu.add(priceMenu);
        filterMenu.add(genderMenu);
        filterMenu.add(skillMenu);
        filterMenu.add(searchItem);

        // Add action listener for search menu item
        searchItem.addActionListener(new SearchItemListener(this));

        // Create brand checkboxes
        JRadioButton rossignol = new JRadioButton("Rossignol");
        JRadioButton burton = new JRadioButton("Burton");
        JRadioButton k2 = new JRadioButton("K2");
        JRadioButton marker = new JRadioButton("Marker");

        // Create button group so only one button can be selected at a time
        ButtonGroup brandGroup = new ButtonGroup();
        // Add radio buttons to button group
        brandGroup.add(rossignol);
        brandGroup.add(burton);
        brandGroup.add(k2);
        brandGroup.add(marker);

        // Add brands to menu
        brandMenu.add(rossignol);
        brandMenu.add(burton);
        brandMenu.add(k2);
        brandMenu.add(marker);

        // Create model radio buttons
        JRadioButton rallybird = new JRadioButton("Rallybird");
        JRadioButton alltrack = new JRadioButton("Alltrack");
        JRadioButton tactic = new JRadioButton("Tactic");
        JRadioButton poker = new JRadioButton("Poker");
        JRadioButton reckoner = new JRadioButton("Reckoner");
        JRadioButton process = new JRadioButton("Process");
        JRadioButton yeasayer = new JRadioButton("Yeasayer");
        JRadioButton ruler = new JRadioButton("Ruler");
        JRadioButton cartel = new JRadioButton("Cartel");
        JRadioButton griffon = new JRadioButton("Griffon");

        // Create button group so only one button can be selected at a time
        ButtonGroup modelGroup = new ButtonGroup();
        // Add model buttons to button group
        modelGroup.add(rallybird);
        modelGroup.add(alltrack);
        modelGroup.add(tactic);
        modelGroup.add(poker);
        modelGroup.add(reckoner);
        modelGroup.add(process);
        modelGroup.add(yeasayer);
        modelGroup.add(ruler);
        modelGroup.add(cartel);
        modelGroup.add(griffon);

        // Add action listeners to models
        rallybird.addActionListener(new RallybirdListener(this, rallybird));
        alltrack.addActionListener(new AlltrackListener(this, alltrack));
        tactic.addActionListener(new TacticListener(this, tactic));
        poker.addActionListener(new PokerListener(this, poker));
        reckoner.addActionListener(new ReckonerListener(this, reckoner));
        process.addActionListener(new ProcessListener(this, process));
        yeasayer.addActionListener(new YeasayerListener(this, yeasayer));
        ruler.addActionListener(new RulerListener(this, ruler));
        cartel.addActionListener(new CartelListener(this, cartel));
        griffon.addActionListener(new GriffonListener(this, griffon));

        // Hide models until brand is clicked
        rallybird.setVisible(false);
        alltrack.setVisible(false);
        tactic.setVisible(false);
        poker.setVisible(false);
        reckoner.setVisible(false);
        process.setVisible(false);
        yeasayer.setVisible(false);
        ruler.setVisible(false);
        cartel.setVisible(false);
        griffon.setVisible(false);

        // Add radio buttons to model menu
        modelMenu.add(rallybird);
        modelMenu.add(alltrack);
        modelMenu.add(tactic);
        modelMenu.add(poker);
        modelMenu.add(reckoner);
        modelMenu.add(process);
        modelMenu.add(yeasayer);
        modelMenu.add(ruler);
        modelMenu.add(cartel);
        modelMenu.add(griffon);

        // Add action listeners for brand radio buttons
        rossignol.addActionListener(new RossignolListener(this, rossignol, rallybird, alltrack, tactic, poker, reckoner, process, yeasayer, ruler, cartel, griffon));
        burton.addActionListener(new BurtonListener(this, burton, rallybird, alltrack, tactic, poker, reckoner, process, yeasayer, ruler, cartel, griffon));
        k2.addActionListener(new K2Listener(this, k2, rallybird, alltrack, tactic, poker, reckoner, process, yeasayer, ruler, cartel, griffon));
        marker.addActionListener(new MarkerListener(this, marker, rallybird, alltrack, tactic, poker, reckoner, process, yeasayer, ruler, cartel, griffon));

        // Create price radio buttons
        JRadioButton price50 = new JRadioButton("Under $50");
        JRadioButton price100 = new JRadioButton("Under $100");
        JRadioButton price250 = new JRadioButton("Under $250");
        JRadioButton price500 = new JRadioButton("Under 500");
        JRadioButton allPrices = new JRadioButton("All Prices");

        // Add action listeners for price radio buttons
        price50.addActionListener(new Price50Listener(this, price50));
        price100.addActionListener(new Price100Listener(this, price100));
        price250.addActionListener(new Price250Listener(this, price250));
        price500.addActionListener(new Price500Listener(this, price500));
        allPrices.addActionListener(new AllPricesListener(this, allPrices));

        // Create button group so only one button can be selected at a time
        ButtonGroup priceGroup = new ButtonGroup();
        // Add price buttons to button group
        priceGroup.add(price50);
        priceGroup.add(price100);
        priceGroup.add(price250);
        priceGroup.add(price500);
        priceGroup.add(allPrices);

        // Add prices to menu
        priceMenu.add(price50);
        priceMenu.add(price100);
        priceMenu.add(price250);
        priceMenu.add(price500);
        priceMenu.add(allPrices);

        // Create gender radio buttons
        JRadioButton men = new JRadioButton("Men");
        JRadioButton women = new JRadioButton("Women");
        JRadioButton unisex = new JRadioButton("Unisex");

        // Add action listeners for gender radio buttons
        men.addActionListener(new MenListener(this, men));
        women.addActionListener(new WomenListener(this, women));
        unisex.addActionListener(new UnisexListener(this, unisex));

        // Create button group so only one button can be selected at a time
        ButtonGroup genderGroup = new ButtonGroup();
        // Add gender buttons to button group
        genderGroup.add(men);
        genderGroup.add(women);
        genderGroup.add(unisex);

        // Add prices to menu
        genderMenu.add(men);
        genderMenu.add(women);
        genderMenu.add(unisex);

        // Create skill radio buttons
        JRadioButton beginner = new JRadioButton("Beginner");
        JRadioButton intermediate = new JRadioButton("Intermediate");
        JRadioButton advanced = new JRadioButton("Advanced");
        JRadioButton allSkills = new JRadioButton("All Skills");

        // Add action listeners for skill radio buttons
        beginner.addActionListener(new BeginnerListener(this, beginner));
        intermediate.addActionListener(new IntermediateListener(this, intermediate));
        advanced.addActionListener(new AdvancedListener(this, advanced));
        allSkills.addActionListener(new AllSkillsListener(this, allSkills));

        // Create button group so only one button can be selected at a time
        ButtonGroup skillGroup = new ButtonGroup();
        // Add skill buttons to button group
        skillGroup.add(beginner);
        skillGroup.add(intermediate);
        skillGroup.add(advanced);
        skillGroup.add(allSkills);

        // Add prices to menu
        skillMenu.add(beginner);
        skillMenu.add(intermediate);
        skillMenu.add(advanced);
        skillMenu.add(allSkills);
    }

    /**
     * Purpose: Build panel for login and cart functions
     */
    public void buildTopRightPanel()
    {
        // Create panel
        topRightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        // Set an empty border for spacing
        topRightPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        // Set background color white
        topRightPanel.setBackground(Color.WHITE);
        // Add top right panel to header panel
        headerPanel.add(topRightPanel, BorderLayout.NORTH);

        // Create login button
        loginButton = new JButton("Login");
        // Add Action Listener to display login prompts
        loginButton.addActionListener(new LoginButtonListener(this, loginButton));
        // Add login button to top right panel
        topRightPanel.add(loginButton);

        // Create a button for the cart
        cartButton = new JButton("Cart");
        // Add Action Listener to display cart options when clicked
        cartButton.addActionListener(new CartButtonListener(this));
        // Add cart button to top right panel
        topRightPanel.add(cartButton);
    }

    /**
     * Purpose: return to home page
     * @throws Exception
     */
    public void homePage() throws Exception
    {   
        // Hide current panel
        displayPanel.setVisible(false);
        // Create new Panel
        JPanel newPanel = new JPanel();
        // Set background color white
        newPanel.setBackground(Color.WHITE);
        // Set new display panel
        setDisplayPanel(newPanel);

        // Add label to display panel
        displayPanel.add(getHomeLabel());
        // Set an empty border for spacing
        displayPanel.setBorder(BorderFactory.createEmptyBorder(70, 30, 30, 30));
        // Add panel to main panel
        mainPanel.add(displayPanel, BorderLayout.CENTER);
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
        displayResults(searchResults, fields, "broad");
    }

    /**
     * Purpose: perform search of specific Product type
     * @throws Exception
     */
    public void typeSearch(String type) throws Exception
    {
        // Create empty String to get all products
        String allProducts = "";
        // Create a Product array for all search results
        Product[] productArray;
        // Create a String array for keyword
        String[] fields = new String[]{allProducts};
        // Create a cart to add search results to
        Cart searchResults = new Cart();
        // Scan the inventory file and assign the cart's array of products to "productArray"
        productArray = scanInventory(type, allProducts).getProducts();
        if (productArray != null)
        {
            // Search through each product in array
            for (Product product : productArray)
            {
                // Add each product to the seach results cart
                searchResults.addToCart(product);
            }
        }
        // Display results
        displayResults(searchResults, fields, type);
    }

    /**
     * Purpose: Purpose: specific search using filters 
     * @throws Exception
     */
    public void advancedSearch() throws Exception
    {  
        // Store all input into an ArrayList of Strings
        ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(typeFilter, brandFilter, modelFilter, priceFilter, sizeFilter, genderFilter));    
        
        // If type equals "skis" or "snowboard", continue
        if (typeFilter.equals("Skis") || typeFilter.equals("Snowboard"))
        {
            // Add skill filter to ArrayList
            arrayList.add(skillFilter);
        }
        // If type equals "boots" or "bindings", continue
        else if (typeFilter.equals("Boots") || typeFilter.equals("Bindings"))
        {
            // Add sport to ArrayList
            arrayList.add(sportFilter);
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
        Product[] array = scanInventory(typeFilter, "").getProducts();  
        // Iterate through each product in array
        for (Product product : array)
        {
            // If the brand of product equals input, continue
            if (product.getBrand().toLowerCase().equals(brandFilter) || brandFilter.equals("all"))
            {   
                // If the model of product equals input, continue
                if (product.getModel().toLowerCase().equals(modelFilter) || modelFilter.equals("all"))
                { 
                    // If the price of product is less than input or input is 0, continue
                    if (product.getPrice() < Double.valueOf(priceFilter) || Double.valueOf(priceFilter) == 0)
                    {
                        // If the size of product equals input or input is 0, continue
                        if (product.getSize() == Integer.valueOf(sizeFilter) || Integer.valueOf(sizeFilter) == 0)
                        {
                            // If the gender of product equals input or input is "all", continue
                            if (product.getGender().toLowerCase().equals(genderFilter) || product.getGender().equals("Unisex") || genderFilter.equals("all"))
                            {
                                // If type equals "skis" or "snowboard", continue
                                if (typeFilter.equals("skis") || typeFilter.equals("snowboard"))
                                {
                                    // If the skill level of product equals input or input is "all", continue
                                    if (product.getSkillLevel().toLowerCase().equals(skillFilter) || skillFilter.equals("all"))
                                    {
                                        // If all fields are met, add product to cart
                                        cart.addToCart(product);
                                    }
                                }
                                // If type equals "boots" or "bindings", continue
                                else if (typeFilter.equals("boots") || typeFilter.equals("bindings"))
                                {
                                    // If the sport equals input or input is "all", continue
                                    if (product.getSport().toLowerCase().equals(sportFilter) || product.getSport().equals("Unisex") || sportFilter.equals("all"))
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
        displayResults(cart, fields, "advanced");
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
            exception.printStackTrace();
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
    public void displayResults(Cart searchResults, String[] fields, String searchType) throws Exception
    {
        // Call getModels() method to create array for different types of models of Products
        searchResults.getModels();
        // Initialize a count variable with quantity of different models in cart 
        int count = searchResults.getModelCount();

        // Hide current panel
        displayPanel.setVisible(false);
        // Create new Panel
        JPanel newPanel = new JPanel(new BorderLayout());
        // Set background color white
        newPanel.setBackground(Color.WHITE);
        // Set new display panel
        setDisplayPanel(newPanel);
        // Create String for results label text
        String results = "";

        // If broadSearch method used change label text accordingly
        if (searchType.equals("broad"))
        {
            // If keyword is blank, display all products
            if (fields[0].equals(""))
            {
                results = "All Products"; 
            }
            // Otherwise, display keyword entered
            else 
            {
               results = count + " result(s) for \"" + fields[0] + "\""; 
            }
        }
        else if (searchType.equals("advanced"))
        {

        }
        // Otherwise, if typeSearch method used change label text accordingly
        else
        {
            results = searchType + " Inventory";
        }

        // If at least 1 product found, display results
        if (count > 0)
        {
            // Create label to display number of results
            JLabel resultsLabel = new JLabel(results);
            // Center label
            resultsLabel.setVerticalAlignment(JLabel.CENTER);
            resultsLabel.setHorizontalAlignment(JLabel.CENTER);
            // Add label to display panel
            displayPanel.add(resultsLabel, BorderLayout.NORTH);
            // Set an empty border for spacing
            displayPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

            // Create text area to display search results 
            JTextArea resultsTextArea = new JTextArea(searchResults.toString("search"));
            // Restrict editing
            resultsTextArea.setEditable(false);
            // Wrap sentences to next line
            resultsTextArea.setLineWrap(true);
            // Wrap entire words to next line
            resultsTextArea.setWrapStyleWord(true);

            // Create scroll bar for the text area (search results)
            JScrollPane scrollBar = new JScrollPane(resultsTextArea);
            // Set an empty border for spacing
            scrollBar.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
            // Add text area to display panel
            displayPanel.add(scrollBar, BorderLayout.CENTER);

            // Create panel to to prompt if Customer is interested
            JPanel interestedPanel = new JPanel();
            // Set background color white
            interestedPanel.setBackground(Color.WHITE);

            // Create label to display prompt asking if interested in products
            JLabel interestedLabel = new JLabel("Are you interested in any of these products?");
            // Add label to interested panel
            interestedPanel.add(interestedLabel);

            // Create text field for user input
            JTextField interestedField = new JTextField("Enter yes or no");
            // Set the number of columns (desired width)
            interestedField.setColumns(20);
            // Set the text color for the placeholder
            interestedField.setForeground(Color.GRAY); 
            // Add Mouse Listener to clear text when clicked
            interestedField.addMouseListener(new InterestedFieldMouseListener(interestedField));
            // Add Action Listener to search for Products when pressing enter
            interestedField.addActionListener(new InterestedFieldListener(this, interestedField, interestedPanel, searchResults));
            // Add text field to interested panel
            interestedPanel.add(interestedField);

            // Add interested panel to display panel
            displayPanel.add(interestedPanel, BorderLayout.SOUTH);
            // Add display panel to main panel
            mainPanel.add(displayPanel, BorderLayout.CENTER);
        }
        // Otherwise, display no results found
        else 
        {
            // Create panel to display results label and home button
            JPanel resultsPanel = new JPanel(new BorderLayout());
            // Set background color white
            resultsPanel.setBackground(Color.WHITE);
            // Create label to display number of results
            JLabel resultsLabel = new JLabel(results);
            // Center label
            resultsLabel.setVerticalAlignment(JLabel.CENTER);
            resultsLabel.setHorizontalAlignment(JLabel.CENTER);
            // Add results label to panel
            resultsPanel.add(resultsLabel, BorderLayout.NORTH);

            // Create text area to display products in cart
            JTextArea resultsTextArea = new JTextArea("No products available...");
            // Restrict editing
            resultsTextArea.setEditable(false);
            // Wrap sentences to next line
            resultsTextArea.setLineWrap(true);
            // Wrap entire words to next line
            resultsTextArea.setWrapStyleWord(true);
            // Set an empty border for spacing
            resultsTextArea.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
            // Add text area to panel
            resultsPanel.add(resultsTextArea, BorderLayout.CENTER);

            // Add home button to panel
            resultsPanel.add(homeButton, BorderLayout.SOUTH);

            // Add results panel to display panel
            displayPanel.add(resultsPanel, BorderLayout.CENTER);
            // Set an empty border for spacing
            displayPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

            // Add display panel to main panel
            mainPanel.add(displayPanel, BorderLayout.CENTER);
        }
    }

    /**
     * Purpose: determine if customer would like to add any items to cart
     * @throws Exception
     */
    public void interested(Cart searchResults, int itemNumber) throws Exception
    {
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
        // Create text field for user input
        JTextField sizeField = new JTextField();
        // If desired item is within the search results list, continue
        if (itemInSearchResults)
        { 
            // Hide display panel
            displayPanel.setVisible(false);
            // Create new Panel
            JPanel newPanel = new JPanel(new BorderLayout());
            // Set background color white
            newPanel.setBackground(Color.WHITE);
            // Set new display panel
            setDisplayPanel(newPanel);
            // Unhide display panel
            displayPanel.setVisible(true);
            // Add to main panel
            mainPanel.add(displayPanel, BorderLayout.CENTER);

            // Create text area to display search results 
            JTextArea productTextArea = new JTextArea(searchResults.getModelDescription(modelArray));
            // Restrict editing
            productTextArea.setEditable(false);
            // Wrap sentences to next line
            productTextArea.setLineWrap(true);
            // Wrap entire words to next line
            productTextArea.setWrapStyleWord(true);

            // Create scroll bar for the text area (search results)
            JScrollPane scrollBar = new JScrollPane(productTextArea);
            // Set an empty border for spacing
            scrollBar.setBorder(BorderFactory.createEmptyBorder(30, 30, 50, 30));
            // Add text area to display panel
            displayPanel.add(scrollBar, BorderLayout.CENTER);

            // Create lower panel for prompt/user input
            JPanel promptPanel = new JPanel();
            // Set background color white
            promptPanel.setBackground(Color.WHITE);
            // Add panel to display panel
            displayPanel.add(promptPanel, BorderLayout.SOUTH);

            // Create label to prompt Customer for desired size
            JLabel sizeLabel = new JLabel("Which size would you like?");
            // Add label to prompt panel
            promptPanel.add(sizeLabel);

            // Create text field for user input
            sizeField.setText("Enter available size");
            // Set the number of columns (desired width)
            sizeField.setColumns(20);
            // Set the text color for the placeholder
            sizeField.setForeground(Color.GRAY); 
            // Add Mouse Listener to clear text when clicked
            sizeField.addMouseListener(new SizeFieldMouseListener(sizeField));
            // Add Action Listener to select desired size
            sizeField.addActionListener(new SizeFieldListener(this, sizeField, promptPanel, searchResults));
            // Add text field to size panel
            promptPanel.add(sizeField);
        }
        // If the item number entered isn't equal to any of the item numbers in the search results, display prompt
        else 
        {
            // Display "invalid number entered" message
            sizeField.setText("Item not found in search results. Please try again.");
        }
    }

    /**
     * Purpose: determine the amount the customer would like to add to cart
     * @throws Exception
     */
    public void getDesiredQuantity(Cart searchResults, int desiredIndex, JPanel promptPanel) throws Exception
    {
        // Hide prompt panel
        promptPanel.setVisible(false);
        // Create new Panel
        JPanel newPanel = new JPanel();
        // Set background color white
        newPanel.setBackground(Color.WHITE);
        // Add to display panel
        displayPanel.add(newPanel, BorderLayout.SOUTH);

        // Create label to display prompt asking customer for desired quantity
        JLabel quantityLabel = new JLabel("How many do you want?");
        // Add label to panel
        newPanel.add(quantityLabel);

        // Create text field for user input
        JTextField quantityField = new JTextField("Enter desired quantity");
        // Set the number of columns (desired width)
        quantityField.setColumns(20);
        // Set the text color for the placeholder
        quantityField.setForeground(Color.GRAY); 
        // Add Mouse Listener to clear text when clicked
        quantityField.addMouseListener(new QuantityFieldMouseListener(quantityField));
        // Add Action Listener to select desired quantity
        quantityField.addActionListener(new QuantityFieldListener(this, quantityField, newPanel, searchResults, desiredIndex));
        // Add text field to quantity panel
        newPanel.add(quantityField);
    }

    /**
     * Purpose: determine if the customer would like to add product to cart
     * @throws Exception
     */
    public void addToCart(Cart searchResults, Product[][] multiSizes, int quantity, int desiredIndex, JPanel promptPanel) throws Exception
    {
        // Hide prompt panel
        promptPanel.setVisible(false);
        // Create new Panel
        JPanel newPanel = new JPanel();
        // Set background color white
        newPanel.setBackground(Color.WHITE);
        // Add to display panel
        displayPanel.add(newPanel, BorderLayout.SOUTH);
        
        // Create label to display prompt asking customer if they would like to add product to cart
        JLabel cartLabel = new JLabel("Would you like to add to cart?");
        // Add label to panel
        newPanel.add(cartLabel);

        // Create text field for user input
        JTextField cartField = new JTextField("Enter yes or no");
        // Set the number of columns (desired width)
        cartField.setColumns(20);
        // Set the text color for the placeholder
        cartField.setForeground(Color.GRAY); 
        // Add Mouse Listener to clear text when clicked
        cartField.addMouseListener(new CartFieldMouseListener(cartField));
        // Add Action Listener to select desired cart
        cartField.addActionListener(new CartFieldListener(this, searchResults, cartField, quantity, multiSizes, desiredIndex, newPanel));
        // Add text field to cart panel
        newPanel.add(cartField);
    }

    /**
     * Purpose: prompt to ask if customer would like to proceed to checkout or continue shopping
     * @throws Exception
     */
    public void proceed(JPanel promptPanel) throws Exception
    {
        // Hide prompt panel
        promptPanel.setVisible(false);
        // Create new Panel
        JPanel newPanel = new JPanel();
        // Set background color white
        newPanel.setBackground(Color.WHITE);
        // Add to display panel
        displayPanel.add(newPanel, BorderLayout.SOUTH);

        // Create label to display prompt asking if customer would like to checkout or continue shopping
        JLabel cartLabel = new JLabel("Would you like to proceed to checkout or continue shopping?");
        // Add label to panel
        newPanel.add(cartLabel);

        // Create text field for user input
        JTextField proceedField = new JTextField("Enter checkout or home");
        // Set the number of columns (desired width)
        proceedField.setColumns(20);
        // Set the text color for the placeholder
        proceedField.setForeground(Color.GRAY); 
        // Add Mouse Listener to clear text when clicked
        proceedField.addMouseListener(new ProceedFieldMouseListener(proceedField));
        // Add Action Listener to select desired proceed
        proceedField.addActionListener(new ProceedFieldListener(this, proceedField));
        // Add text field to proceed panel
        newPanel.add(proceedField);
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
     * Purpose: checkout function to display products in cart and proceed to purchase if desired
     * @throws Exception
     */
    public void checkout() throws Exception
    {   
        // Click cart button to display products in cart
        cartButton.doClick();
    }

        /**
     * Purpose: retrieve main panel
     */
    public JPanel getMainPanel()
    {
        return mainPanel;
    }

    /**
     * Purpose: retrieve display panel
     */
    public JPanel getDisplayPanel()
    {
        return displayPanel;
    }

    /**
     * Purpose: set new display panel
     */
    public void setDisplayPanel(JPanel newPanel)
    {
        displayPanel = newPanel;
    }

    /**
     * Purpose: get home page label
     */
    public JLabel getHomeLabel()
    {
        return homeLabel;
    }

    /**
     * Purpose: retrieve Customer
     */
    public Customer getCustomer()
    {
        return customer;
    }

    /**
     * Purpose: retrieve cart
     */
    public Cart getCart()
    {
        return cart;
    }

    /**
     * Purpose: get home button
     */
    public JButton getHomeButton()
    {
        return homeButton;
    }

    /**
     * Purpose: set type filter
     */
    public void setTypeFilter(String typeFilter)
    {
        this.typeFilter = typeFilter;
    }

    /**
     * Purpose: get type filter
     */
    public String getTypeFilter()
    {
        return typeFilter;
    }

    /**
     * Purpose: set brand filter
     */
    public void setBrandFilter(String brandFilter)
    {
        this.brandFilter = brandFilter.toLowerCase();
    }

    /**
     * Purpose: get brand filter
     */
    public String getBrandFilter()
    {
        return brandFilter;
    }

    /**
     * Purpose: set model filter
     */
    public void setModelFilter(String modelFilter)
    {
        this.modelFilter = modelFilter.toLowerCase();
    }

    /**
     * Purpose: get model filter
     */
    public String getModelFilter()
    {
        return modelFilter;
    }

    /**
     * Purpose: set price filter
     */
    public void setPriceFilter(String priceFilter)
    {
        this.priceFilter = priceFilter.toLowerCase();
    }

    /**
     * Purpose: get price filter
     */
    public String getPriceFilter()
    {
        return priceFilter;
    }


    /**
     * Purpose: set gender filter
     */
    public void setGenderFilter(String genderFilter)
    {
        this.genderFilter = genderFilter.toLowerCase();
    }

    /**
     * Purpose: get gender filter
     */
    public String getGenderFilter()
    {
        return genderFilter;
    }

    /**
     * Purpose: set skill filter
     */
    public void setSkillFilter(String skillFilter)
    {
        this.skillFilter = skillFilter.toLowerCase();
    }

    /**
     * Purpose: get skill filter
     */
    public String getSkillFilter()
    {
        return skillFilter;
    }

    /**
     * Purpose: set sport filter
     */
    public void setSportFilter(String sportFilter)
    {
        this.sportFilter = sportFilter.toLowerCase();
    }

    /**
     * Purpose: get sport filter
     */
    public String getSportFilter()
    {
        return sportFilter;
    }
}