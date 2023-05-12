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
 * A product which has the attributes such as brand, model, and price
 * as well as functions to retrieve the product info
 */

public abstract class Product
{
    private String brand;                   // A product HAS-A brand
    private String model;                   // A product HAS-A model
    private double price;                   // A product HAS-A price
    private final int serialNumber;         // A product HAS-A unique serial number
    private static int newSerialNumber = 1; // The Product class HAS-A new serial number for each product added

    /**
     * Purpose: constructor to initialize the brand and model of a product
     * @param brand or make of product
     * @param model of product
     * @param price of product
     */
    public Product(String brand, String model, double price)
    {
        // Assign brand
        this.brand = brand;
        // Assign model
        this.model = model;
        // Assign price
        this.price = price;
        // Assign a unique serial number and increment "newSerialNumber" for next product
        serialNumber = newSerialNumber++;
    }

    /**
     * Purpose: get the brand of the product
     * @return brand
     */
    final String getBrand()
    {
        return brand;
    }

    /**
     * Purpose: get the model of the product
     * @return model
     */
    final String getModel()
    {
        return model;
    }

    /**
     * Purpose: get serial number of the product
     * @return serial number
     */
    final int getSerialNumber()
    {
        return serialNumber;
    }

    /**
     * Purpose: get the price of the product
     * @return price
     */
    public double getPrice()
    {
        return price;
    }

    /**
     * Purpose: set the price of the product
     * @param price
     */
    public void setPrice(double price)
    {
        this.price = price;
    }

    /**
     * Purpose: get item number of the product
     * @return item number
     */
    abstract int getItemNumber();

    /**
     * Purpose: set item number of the product
     * @param itemNumber
     */
    abstract void setItemNumber(int itemNumber);

    /**
     * Purpose: get size of the product
     */
    abstract int getSize();

    /**
     * Purpose: set the size of the product
     * @param size
     */
    abstract void setSize(int size);

    /**
     * Purpose: get gender of the product
     */
    abstract String getGender();

    /**
     * Purpose: set the gender of the product
     * @param gender
     */
    abstract void setGender(String gender);

    /**
     * Purpose: get skill level of the product
     */
    abstract String getSkillLevel();

    /**
     * Purpose: set the skill level of the product
     * @param skillLevel
     */
    abstract void setSkillLevel(String skillLevel);

    /**
     * Purpose: get type of the product
     */
    abstract String getType();

    /**
     * Purpose: get type of sport of the product
     */
    abstract String getSport();

    /**
     * Purpose: add description of the product
     * @param description
     * @throws Exception
     */
    abstract void addDescription(String description) throws Exception;

    /**
     * Purpose: set description of the product
     * @param brand
     * @param model
     * @throws Exception
     */
    abstract void setDescription(String brand, String model) throws Exception;

    /**
     * Purpose: get description of the product
     */
    abstract String getDescription();

    /**
     * Purpose: add product to inventory
     * @param product
     * @throws Exception
     */
    abstract void addToInventory(Product product) throws Exception;

    /**
     * Purpose: remove product to inventory
     * @param product
     * @throws Exception
     */
    abstract void removeFromInventory(Product product) throws Exception;

    /**
     * Purpose: display product info
     * @return info 
     */
    @Override
    public String toString()
    {
        // Assigns product fields to a String to display
        String info = "Product: ";
        // Display brand
        info += brand + " ";
        // Display model
        info += model + " ";
        // Display price
        info += price;
        // Return product info
        return info;
    }
}