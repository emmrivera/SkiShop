import java.util.*;                     // Needed for Scanner and ArrayLists objects
import java.io.*;                       // Needed for reading and writing to files

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
 * A snowboard which has the attributes of a product as well as
 * a size, gender-specificity, skill level, and an option to wax the board
 */

// A Snowboard IS-A Product and IS Waxable
public class Snowboard extends Product implements Waxable
{
    private int itemNumber;             // A Snowboard HAS-AN item number (serial number clone for reading from inventory)
    private int size;                   // A Snowboard HAS-A size 
    private String gender;              // A Snowboard HAS-A gender-specific type
    private String skillLevel;          // A Snowboard HAS-A skill level its geared for
    private String type = "Snowboard";  // A Snowboard HAS-A type of gear
    private String sport = "Snowboard"; // A Snowboard HAS-A sport-specific type
    private String description;         // A Snowboard HAS-A description
    private boolean isWaxed = false;    // A Snowboard HAS-A field to determine if it was waxed

    /**
     * Purpose: constructor that fully initializes the fields of a snowboard
     * including the fields of a product
     * @param brand or make of snowboard
     * @param model of snowboard
     * @param price of snowboard
     * @param size or length of snowboard
     * @param gender specific snowboards (Men's or Women's)
     * @param skillLevel or riding ability
     */
    public Snowboard(String brand, String model, double price,
                    int size, String gender, String skillLevel)
    {
        // Calls super constructor to assign brand, model, and price
        super(brand, model, price);
        // Assign size of board
        this.size = size;
        // Assign gender-specificity
        this.gender = gender;
        // Assign skill level of board
        this.skillLevel = skillLevel;
    }

    /**
     * Purpose: get the size of the product
     * @return size of snowboard
     */
    @Override
    public int getSize()
    {
        return size;
    }

    /**
     * Purpose: set the size of the product
     * @param size of snowboard
     */
    @Override
    public void setSize(int size)
    {
        this.size = size;
    }

    /**
     * Purpose: get the gender-specificity of the product
     * @return gender (Men's or Women's)
     */
    @Override
    public String getGender()
    {
        if (gender == null)
        {
            return "Unisex";
        }
        else 
        {
            return gender;
        }
    }

    /**
     * Purpose: set the gender-specificity for the product
     * @param gender (Men's or Women's)
     */
    @Override
    public void setGender(String gender)
    {
        this.gender = gender;
    }

    /**
     * Purpose: get the skill level of the product
     * @return skillLevel or riding ability
     */
    @Override
    public String getSkillLevel()
    {
        return skillLevel;
    }

    /**
     * Purpose: set the skill level of the product
     * @param skillLevel or riding ability
     */
    @Override
    public void setSkillLevel(String skillLevel)
    {
        this.skillLevel = skillLevel;
    }

    /**
     * Purpose: get the type of the product (Skis/Snowboard/Boots/etc)
     * @return type of product
     * Implemented from abstract parent class (Product)
     */
    @Override
    public String getType()
    {
        return type;
    }

    /**
     * Purpose: get the sport of the product (Ski or Snowboard)
     * @return sport of product
     * Implemented from abstract parent class (Product)
     */
    @Override
    public String getSport()
    {
        return sport;
    }

    /**
     * Purpose: get item number of the product
     * @return item number
     * Implemented from abstract parent class (Product)
     */
    @Override
    public int getItemNumber()
    {
        return itemNumber;
    }

    /**
     * Purpose: set item number of the product
     * @param itemNumber
     * Implemented from abstract parent class (Product)
     */
    @Override
    public void setItemNumber(int itemNumber)
    {
        this.itemNumber = itemNumber;
    }

    /**
     * Purpose: add description of the product
     * @param description
     * @throws IOException
     * Implemented from abstract parent class (Product)
     */
    @Override
    public void addDescription(String description) throws IOException
    {
        // Create FileWriter object for writing into a file
        FileWriter openFile = null;
        // Create PrintWriter object for "printing" into file
        PrintWriter outputFile = null;
        // Try block to perform I/O operations
        try 
        {
            // Initialize FileWriter object for writing into a file
            openFile = new FileWriter("ProductDescriptions.txt", true);
            // Initialize PrintWriter object for "printing" into file
            outputFile = new PrintWriter(openFile);
            // "Write" description to file
            outputFile.println(description);
            // Close file
            outputFile.close();
        }
        // Catch block if an exception was thrown during I/O operations
        catch (IOException exception) 
        {
            // Display the exception that was thrown
            System.out.println("Sorry, file not found. Unable to add product description.");
        }
        // Finally block to always close access to file
        finally 
        {
            // If PrintWriter was successfully initialized (not null), close object
            if (outputFile != null)
            {
                // Close writer
                outputFile.close(); 
            }
        }
    }

    /**
     * Purpose: set description of the product
     * @param brand
     * @param model
     * @throws IOException
     * Implemented from abstract parent class (Product)
     */
    @Override
    public void setDescription(String brand, String model) throws IOException
    {
        // Create File object for access
        File file = null;
        // Create Scanner object to read file
        Scanner inputFile = null;
        // Try block to perform I/O operations
        try 
        {
            // Initialize File object to access desired file
            file = new File("ProductDescriptions.txt");
            // Initialize Scanner object to read desired inventory file
            inputFile = new Scanner(file);
            // While loop to search through each line of file
            while (inputFile.hasNextLine())
            {
                // Assign the line from the file to a String
                String description = inputFile.nextLine();
                // If line contains both brand and model, assign to product description
                if (description.contains(brand) && description.contains(model))
                {
                    // Set product description
                    this.description = description;
                }
            }
        }
        // Catch block if an exception was thrown during I/O operations
        catch (IOException exception) 
        {
            // Display the exception that was thrown
            System.out.println("Sorry, file not found. Unable to set product description.");
        }
        // Finally block to always close access to file
        finally 
        {
            // If Scanner was successfully initialized (not null), close object
            if (inputFile != null)
            {
                // Close scanner
                inputFile.close(); 
            }
        }
    }

    /**
     * Purpose: get description of the product
     * @return description
     * Implemented from abstract parent class (Product)
     */
    @Override
    public String getDescription()
    {   
        // Return product description
        return description;
    }

    /**
     * Purpose: wax the product
     * Implemented from interface (Waxable)
     */
    @Override
    public void wax()
    {
        isWaxed = true;
    }

    /**
     * Purpose: display if board is waxed
     * @return Yes (if waxed) or No (if not waxed)
     */
    public String isWaxed()
    {
        // If the board is waxed, return "Yes"
        if (isWaxed)
        {
            return "Yes";
        }
        // Otherwise, return "No"
        else
        {
            return "No";
        }
    }

    /**
     * Purpose: add product to inventory (.txt file)
     * @param product to add
     * @throws IOException
     * Implemented from abstract parent class (Product)
     */
    @Override
    public void addToInventory(Product product) throws IOException
    {
        // Create FileWriter object for writing into a file
        FileWriter openFile = null;
        // Create PrintWriter object for "printing" into file
        PrintWriter outputFile = null;
        // Try block to perform I/O operations
        try 
        {
            // Initialize FileWriter object for writing into a file
            openFile = new FileWriter("SnowboardInventory.txt", true);
            // Initialize PrintWriter object
            outputFile = new PrintWriter(openFile);
            // Create a string to "write" to file starting with the product's serial number
            String fields = getSerialNumber() + " ";
            // Increment product's brand
            fields += getBrand() + " ";
            // Increment product's model
            fields += getModel() + " ";
            // Increment product's type
            fields += getType() + " ";
            // Increment product's price
            fields += getPrice() + " ";
            // Increment product's size
            fields += getSize() + " ";
            // Increment product's gender specificity
            fields += getGender() + " ";
            // Increment product's skill level
            fields += getSkillLevel() + " ";
            // "Write" string to file
            outputFile.println(fields);
        }
        // Catch block if an exception was thrown during I/O operations
        catch (IOException exception) 
        {
            // Display the exception that was thrown
            System.out.println("Sorry, file not found. Unable to add product description.");
        }
        // Finally block to always close access to file
        finally 
        {
            // If PrintWriter object was successfully initialized (not null), then close object
            if (outputFile != null)
            {
                // Close writer
                outputFile.close(); 
            }
        }
    }

    /**
     * Purpose: remove product from inventory (.txt file)
     * @param product to remove
     * @throws IOException
     * Implemented from abstract parent class (Product)
     */
    @Override
    public void removeFromInventory(Product product) throws IOException
    {
        // Create a string to "write" to file starting with the product's serial number
        String fields = getItemNumber() + " ";
        // Increment product's brand
        fields += getBrand() + " ";
        // Increment product's model
        fields += getModel() + " ";
        // Increment product's type
        fields += getType() + " ";
        // Increment product's price
        fields += getPrice() + " ";
        // Increment product's size
        fields += getSize() + " ";
        // Increment product's gender specificity
        fields += getGender() + " ";
        // Increment product's skill level
        fields += getSkillLevel() + " ";

        // Create File object for revised inventory
        File newFile = null;
        // Create FileWriter object for writing into a new file
        FileWriter openFile = null;
        // Create PrintWriter object for "printing" into file
        PrintWriter outputFile = null;
        // Create File object to access original inventory file
        File originalFile = null;
        // Create Scanner object to read file
        Scanner inputFile = null;

        // Try block to perform I/O operations
        try 
        {
            // Initialize File object for revised inventory
            newFile = new File("newSnowboardInventory.txt");
            // Initialize FileWriter object for writing into a new file
            openFile = new FileWriter("newSnowboardInventory.txt", true);
            // Initialize PrintWriter object for "printing" into file
            outputFile = new PrintWriter(openFile);
            // Initialize File object to access original inventory file
            originalFile = new File("SnowboardInventory.txt");
            // Initialize Scanner object to read file
            inputFile = new Scanner(originalFile);
            // While loop to search through each line of file
            while (inputFile.hasNextLine())
            {
                // Assign the current line from the file to a String
                String line = inputFile.nextLine();
                // If line does not equal the desired product's fields, continue writing to new file
                if (!line.equals(fields))
                {
                    // Copy product fields into new inventory file
                    outputFile.println(line);
                }
            }
        }
        // Catch block if an exception was thrown during I/O operations
        catch (IOException exception) 
        {
            // Display the exception that was thrown
            System.out.println("Sorry, file not found. Unable to remove product from inventory.");
        }
        // Finally block to always close access to file
        finally 
        {
            // If PrintWriter object was successfully initialized (not null), then close object
            if (outputFile != null)
            {
                // Close writer for new inventory file
                outputFile.close(); 
            }
            // If Scanner object was successfully initialized (not null), then close object
            if (inputFile != null)
            {
                // Close scanner for original inventory file
                inputFile.close(); 
            }
            // If File object was successfully initialized (not null), then delete file
            if (originalFile != null)
            {
                // Delete original inventory file
                originalFile.delete(); 
            }
            // If File object was successfully initialized (not null), then rename file
            if (newFile != null)
            {
                // Rename new inventory file
                newFile.renameTo(originalFile);
            }
        }
    }

    /**
     * Purpose: display snowboard product info
     * @return info of product
     */
    @Override
    public String toString()
    {
        // Create a string to display product info
        // Add the product info already created from 
        // the superclass' toString method
        String info = super.toString() + " ";
        // Increment product type
        info += type + " - ";
        // Increment gender
        info += gender + " ";
        // Increment size to product info
        info += "[Size: " + size + "] ";
        // Return product info
        return info;
    }
}