// Needed for Scanner and ArrayLists objects           
import java.util.ArrayList;
import java.util.Arrays;

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
 * A cart for products to be added and saved for later checkout
 */

public class Cart
{
    // A cart HAS-MANY types of products
    private String[] productTypes = new String[]{"Skis", "Snowboard","Boots", "Bindings", "Poles"};  
    private Product[] products;             // A cart HAS-MANY Products 
    private Product[][] multiProducts;      // A cart HAS-MANY Products of different types
    private Product[][] multiModels;        // A cart HAS-MANY different models of Product
    private Product[][] multiSizes;         // A cart HAS-MANY different sizes of Products
    private int[] productSizes;             // A cart HAS-MANY sizes of products
    private String firstType;               // A cart HAS-A first type of product added
    private int typeCount;                  // A cart HAS-A count for product types added
    private int quantity;                   // A cart HAS-A quantity for each product
    private int modelCount;                 // A cart HAS-A quantity for different types of models of Products
    private double total;                   // A cart HAS-A total amount for all products

    /**
     * Purpose: empty constructor
     */
    public Cart()
    {
    }

    /**
     * Purpose: copy constructor
     */
    public Cart(Cart cartToAdd)
    {   

    }

    /**
     * Purpose: assignment constructor
     * @param productToAdd to add and initialize Product array with
     */
    public Cart(Product productToAdd)
    {
        // Initialize current Product array with product to add
        products = new Product[]{productToAdd};
        // Assign type to firstType field
        firstType = productToAdd.getType();
        // Increment typeCount
        typeCount++;
    }

    /**
     * Purpose: assignment constructor
     * @param productArray array of products to initialize and add to cart
     */
    public Cart(Product[] productArray)
    {
        // Initialize current array with the length of new array
        products = new Product[productArray.length];
        // Iterate through each product in the array
        for (int i = 0; i < productArray.length; i++)
        {
            // Assign each product from new array to current array
            products[i] = productArray[i];
        }
        // Assign type to firstType field
        firstType = products[0].getType();
        // Increment typeCount
        typeCount++;
    }

    /**
     * Purpose: assignment constructor
     * @param array 2D Product array to assign to cart
     */
    public Cart(Product[][] array)
    {
        // Initialize current array with array length passed through as the argument
        multiProducts = new Product[array.length][];
        // Iterate through each row of array
        for (int row = 0; row < array.length; row++)
        {
            // If row is null, skip
            if (array[row] != null)
            {
                // Iterate through each column of array
                for (int column = 0; column < array[row].length; column++)
                {
                    // If first type hasn't been initialized, assign type
                    if (firstType == null)
                    {
                        // Assign first product type
                        firstType = array[row][column].getType();
                    }
                    // Assign each product of argument array to current array
                    multiProducts[row][column] = array[row][column];
                }
            }
        }
        // Update type count
        updateTypeCount();
    }

    /**
     * Purpose: add product to cart
     * @param product to add
     */
    public void addToCart(Product productToAdd)
    {
        // If count of product types added is less than 1, continue
        if (typeCount < 1)
        {
            // Assign the type of product added to first type
            firstType = productToAdd.getType();
            // Increment type count
            typeCount++;
            // If current Product array is not null, continue
            if (products != null)
            {
                // Add product to array (via created method)
                products = addProductToArray(productToAdd, products);
            }
            // Otherwise, initialize current Product array with new product
            else 
            {
                // Initialize new product to current Product array
                products = new Product[]{productToAdd};
            }
        }
        // If type count is 1, continue
        else if (typeCount == 1)
        {
            // If the type of the product being added is not equal to the first type of product, add to 2D array
            if (!firstType.equals(productToAdd.getType()))
            {
                // Increment type count
                typeCount++;
                // Iterate through each product in current Product array and add to 2D array
                for (Product product : products)
                {
                    // Add each product
                    addToMultiCart(product);
                }
                // Add new product
                addToMultiCart(productToAdd);
                // Assign null to original Product array for toString method
                products = null;
            }
            // Otherwise, if the product type is the same as first type, add to original Product array
            else 
            {
                // Add product to array (via created method)
                products = addProductToArray(productToAdd, products);
            }
        }
        // Otherwise, if type count is greater than 1, add to 2D array
        else 
        {
            // Add new product to 2D array
            addToMultiCart(productToAdd);
        }
    }

    /**
     * Purpose: remove product from cart
     * @param product to remove
     */
    public void removeFromCart(Product productToRemove)
    {
        // If type count is 1, continue
        if (typeCount == 1)
        {
            // Remove product from array (via created method)
            products = removeProductFromArray(productToRemove, products);
        }
        // Otherwise, if type count is greater than 1
        else if (typeCount > 1)
        {   
            // Remove product from 2D array
            removeFromMultiCart(productToRemove);
            // Update type count from 2D array
            updateTypeCount();
        }
    }


    /**
     * Purpose: add product to 2D cart
     * @param product to add
     */
    public void addToMultiCart(Product productToAdd)
    {
        // If current Product array is not null, continue
        if (multiProducts != null)
        {
            // Check against each product row to see which array to add product to
            for (int row = 0; row < productTypes.length; row++)
            {
                // Check for same product type, to add product to
                if (productToAdd.getType().equals(productTypes[row]))
                {
                    // If row is not null, continue
                    if (multiProducts[row] != null)
                    {
                        // Add product to array (via created method)
                        multiProducts[row] = addProductToArray(productToAdd, multiProducts[row]);
                    }
                    // Otherwise, initialize row with the new product
                    else 
                    {
                        // Initialize row associated to product type with new product
                        multiProducts[row] = new Product[]{productToAdd};
                    }
                }
            }
        }
        // Otherwise, if current Product array is null, initialize new array with product
        else
        {
            // Initialize Product array with number of product types as the rows length
            multiProducts = new Product[productTypes.length][];
            // Check against each product type to see which row to add product to
            for (int row = 0; row < productTypes.length; row++)
            {
                // Check for same product type, to add product to
                if (productToAdd.getType().equals(productTypes[row]))
                {
                    // Initialize the row associated to product type with new product
                    multiProducts[row] = new Product[]{productToAdd};
                }
            }
        }
    }

    /**
     * Purpose: remove product from 2D Product cart
     * @param product to remove
     */
    public void removeFromMultiCart(Product productToRemove)
    {
        // If current Product array is not null, continue
        if (multiProducts != null)
        {
            // Check against each product type to see which array to remove product from
            for (int row = 0; row < productTypes.length; row++)
            {
                // Check for same product type, remove product from
                if (productToRemove.getType().equals(productTypes[row]))
                {
                    // If the row is not null, continue
                    if (multiProducts[row] != null)
                    {
                        // Remove product from array (via created method)
                        multiProducts[row] = removeProductFromArray(productToRemove, multiProducts[row]);
                    }
                }
            }
        }
    }

    /**
     * Purpose: add Product to Product array
     * @param productArray
     */
    public Product[] addProductToArray(Product product, Product[] productArray)
    { 
        // Convert array to an ArrayList
        ArrayList<Product> arrayList = new ArrayList<Product>(Arrays.asList(productArray));
        // Add Product to Array
        arrayList.add(product);
        // Initialize original Product array with new length with added product
        productArray = new Product[arrayList.size()];
        // Iterate through ArrayList and copy each Product back into original array
        for (int i = 0; i < arrayList.size(); i++)
        {
            // Assign products to Product array
            productArray[i] = arrayList.get(i);
        }
        // Return new Product array (with added Product)
        return productArray;
    }

    /**
     * Purpose: remove Product from Product array
     * @param productArray
     */
    public Product[] removeProductFromArray(Product product, Product[] productArray)
    { 
        // Convert array to an ArrayList
        ArrayList<Product> arrayList = new ArrayList<Product>(Arrays.asList(productArray));
        // Remove Product from Array
        arrayList.remove(product);
        // If array list is not empty, copy array list products to original array
        if (!arrayList.isEmpty())
        {
            // Initialize original Product array with new length with removed product
            productArray = new Product[arrayList.size()];
            // Iterate through ArrayList and copy each Product back into original array
            for (int i = 0; i < arrayList.size(); i++)
            {
                // Assign products to Product array
                productArray[i] = arrayList.get(i);
            }
            // Return new Product array (with added Product)
            return productArray;
        }
        // Otherwise, return null if array list is now empty
        return null;
    }

    /**
     * Purpose: determine if product is already in cart
     * @param productToCheck to check if in cart
     * @return true if product in cart or false if not in cart
     */
    public boolean contains(Product productToCheck)
    {   
        // If there is more than 1 type of product, search 2D array
        if (typeCount > 1)
        {
            // Iterate through each product type in array
            for (Product[] type : multiProducts)
            {
                // If type is not null, continue
                if (type != null)
                {
                    // Iterate through each product of indexed type in array
                    for (Product product : type)
                    {
                        // If product is not null, continue
                        if (product != null)
                        {
                            // If product's item number is equal to desired item number, return true
                            if (product.getItemNumber() == productToCheck.getItemNumber())
                            {
                                // If the item number of desired item is equal to the item number of any of the products in the cart, return true
                                return true;
                            }
                        }
                    }
                }
            }
        }
        // Otherwise, search "products" array
        else 
        {
            // If the product is not null, continue
            if (products != null)
            {
                // Iterate through each product of Product array
                for (Product product : products)
                {
                    // If product's model name is equal to desired model name, return true
                            if (product.getItemNumber() == productToCheck.getItemNumber())
                    {
                        // If the model namesof desired item is equal to the model names of any of the products in the cart, return true
                        return true;
                    }
                }
            }
        }
        // Otherwise, return false
        return false;
    }

    /**
     * Purpose: get specific model from cart
     * @param specificModel
     * @return product
     */
    public Product[] getSpecificModel(int specificModel)
    {
        // Initialize model array
        Product[] modelArray = null;
        // Iterate through each model in cart 
        for (int model = 0; model < modelCount; model++)
        {
            // If the model index is equal to the customer's selection passed through argument
            if ((model + 1) == specificModel)
            {   
                // Assign the array for that specific model to a Product array
                modelArray = multiModels[model];
                // Assign model count to exit loop
                model = modelCount;
            }
        }
        // Return product array
        return modelArray;
    }

    /**
     * Purpose: get products from cart
     * @return products
     */
    public Product[] getProducts()
    {
        // If there is more than 1 type of product, copy 2D array of products into a single Product array
        if (typeCount > 1)
        {
            // Initialize a new product array to store products
            Product[] productArray = new Product[getQuantity()];

            // Create a copy of the Product array with an Array List
             ArrayList<Product> arrayList = new ArrayList<Product>(Arrays.asList(productArray));

            // Iterate through each row of array
            for (int row = 0; row < multiProducts.length; row++)
            {
                // If row is not null, continue
                if (multiProducts[row] != null)
                {
                    // Iterate through each column of array
                    for (int column = 0; column < multiProducts[row].length; column++)
                    {
                        // Add the product to Array List
                        arrayList.add(multiProducts[row][column]);
                    }
                }
            }
            // Use a for loop to copy the Array List products to the new Product array
            for (int i = 0; i < arrayList.size(); i++)
            {
                // Assign products to array by index
                productArray[i] = arrayList.get(i); 
            }
            // Return product array
            return productArray;
        }
        // Otherwise, return Product array
        else 
        {
            return products;
        }
    }

    /**
     * Purpose: get 2D array of models
     */
    public void getModels()
    {   
        // Initialize an integer variable to count how many models are in cart
        int count = 0;

        // Initialize an Array List for unique model names
        ArrayList<String> uniqueModels = new ArrayList<String>();

        // Declare 2D array based on model name
        Product[][] productArray = null;
        // If there is more than 1 type of product, search through 2D array
        if (typeCount > 1)
        {
            // Iterate through each type of product
            for (Product[] type : multiProducts)
            {
                // If type is not null, iterate through each product
                if (type != null)
                {
                    // Iterate through each product of array
                    for (Product product : type)
                    {
                        // If the product is not null, check if its model name is unique to the ArrayList
                        if (product != null)
                        {
                            // If the ArrayList does not already contain model name, then add model to ArrayList
                            if (!uniqueModels.contains(product.getModel()))
                            {
                                // Add model name to ArrayList
                                uniqueModels.add(product.getModel());
                                // Increment model count
                                count++;
                            }
                        }
                    }
                }
            }
            // Initialize 2D array based on model name
            productArray = new Product[count][];  
            // Iterate through each type of product
            for (Product[] type : multiProducts)
            {
                // If type is not null, iterate through each product
                if (type != null)
                {
                    // Iterate through each product of array
                    for (Product product : type)
                    {
                        // If the product is not null, check product's model name against each unique model name
                        if (product != null)
                        {
                            // Check product model name against the unique model names
                            for (int i = 0; i < count; i++)
                            {
                                // If model name is equal to unique model name, create or add to an array
                                if (product.getModel().equals(uniqueModels.get(i)))
                                {
                                    // If the Product array associated to the unique model name is null, initialize the array with the Product
                                    if (productArray[i] == null)
                                    {
                                        // Initialize array with Product
                                        productArray[i] = new Product[]{product};
                                        // Assign model count to exit loop
                                        i = count;
                                    }
                                    // Otherwise, add product to array
                                    else
                                    {
                                        // Add product to array (via created method)
                                        productArray[i] = addProductToArray(product, productArray[i]);
                                        // Assign model count to exit loop
                                        i = count;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        // Otherwise, search through "products" array
        else 
        {
            // If the product array is not null, continue
            if (products != null)
            {
                // Iterate through each product of array
                for (Product product : products)
                {
                    // If the product is not null, 
                    if (product != null)
                    {
                        // If the ArrayList does not already contain model name, then add model to ArrayList
                        if (!uniqueModels.contains(product.getModel()))
                        {
                            // Add model name to ArrayList
                            uniqueModels.add(product.getModel());
                            // Increment model count
                            count++;
                        }
                    }
                }
            }
            // Initialize 2D array based on model name
            productArray = new Product[uniqueModels.size()][];
            // If products array is not null, continue
            if (products != null)
            {
                // Iterate through each product of array
                for (Product product : products)
                {
                    // If the product is not null, check product's model name against each unique model name
                    if (product != null)
                    {
                        // Check product model name against the unique model names
                        for (int i = 0; i < uniqueModels.size(); i++)
                        {
                            // If model name is equal to unique model name, create or add to an array
                            if (product.getModel().equals(uniqueModels.get(i)))
                            {
                                // If the Product array associated to the unique model name is null, initialize the array with the Product
                                if (productArray[i] == null)
                                {
                                    // Initialize array with Product
                                    productArray[i] = new Product[]{product};
                                    // Assign model count to exit loop
                                    i = count;
                                }
                                // Otherwise, convert array to an ArrayList and add Product
                                else
                                {
                                    // Add product to array (via created method)
                                    productArray[i] = addProductToArray(product, productArray[i]);
                                    // Assign model count to exit loop
                                    i = count;
                                }
                            }
                        }
                    }
                }
            }
        }
        // Assign count to modelCount
        modelCount = count;
        // Assign product array to modelArray
        multiModels = productArray;                                                         
    }

    /**
     * Purpose: sort products by size
     * @param modelArray
     */
    public Product[][] sortBySize(Product[] modelArray)
    {
        // Initialize an ArrayList of unique sizes
        ArrayList<Integer> uniqueSizes = new ArrayList<Integer>();
        // Iterate through each product in model array to add unique sizes to Array List
        for (int i = 0; i < modelArray.length; i++)
        {   
            // If the Array List doesn't already contain size, add it
            if (!uniqueSizes.contains(modelArray[i].getSize()))
            {
                // Add size
                uniqueSizes.add(modelArray[i].getSize());
            }
        }

        // Initialize integer array of unique sizes to copy Array List
        productSizes = new int[uniqueSizes.size()];
        // Copy each size to array
        for (int j = 0; j < productSizes.length; j++)
        {
            // Assign size
            productSizes[j] = uniqueSizes.get(j);
        }

        // Create 2D Product array with unique sizes as rows
        Product[][] productArray = new Product[uniqueSizes.size()][];
        // Iterate through each product in model array to add products to their respective row (based on size)
        for (int i = 0; i < modelArray.length; i++)
        {
            // Iterate through each unique size
            for (int j = 0; j < uniqueSizes.size(); j++)
            {
                // If the product size matches unique size, add to row of product array
                if (modelArray[i].getSize() == uniqueSizes.get(j))
                {
                    // If the row of product array has not been initialized yet, do so
                    if (productArray[j] == null)
                    {
                        // Initialize row with product
                        productArray[j] = new Product[]{modelArray[i]};
                        // Assign array list size to exit loop
                        j = uniqueSizes.size();
                    }
                    // Otherwise, if the row of product array already has products, add to row
                    else 
                    {
                        // Add product to array (via created method)
                        productArray[j] = addProductToArray(modelArray[i], productArray[j]);
                        // Assign array list size to exit loop
                        j = uniqueSizes.size();
                    }   
                }
            }
        }
        // Return Product array sorted by size
        return productArray;
    }

    /**
     * Purpose: get model description
     * @param modelArray
     */
    public String getModelDescription(Product[] modelArray)
    {   
        // Create a String for the models description
        String modelDescription = "";
        // Assign a product to access fields
        Product product = modelArray[0];
        // Increment brand
        modelDescription += "\nProduct: " + product.getBrand() + " ";
        // Increment model
        modelDescription += product.getModel() + " ";
        // Increment type
        modelDescription += product.getType() + " - ";
        // Increment gender
        modelDescription += product.getGender() + "\n";
        // Increment price
        modelDescription += "Price: $" + product.getPrice() + "\n";
        // Increment sizes
        modelDescription += "Sizes(availability): ";
        // Sort Product array by size and assign to multiSizes array
        multiSizes = sortBySize(modelArray);

        // Iterate through each size in array
        for (int i = 0; i < productSizes.length; i++)
        {   
            // If it's not the last size in list, increment with ","
            if (i != productSizes.length - 1)
            {
                // Increment each size and availability of each size
                modelDescription += productSizes[i] + "(" + multiSizes[i].length + "), ";
            }
            // Otherwise, if it's the last size list, increment without ","
            else 
            {
                // Increment last size and availability
                modelDescription += productSizes[i] + "(" + multiSizes[i].length + ")\n";
            }
        }

        // Increment product description
        modelDescription += "\nDescription:\n" + product.getDescription() + "\n";

        // Return model description
        return modelDescription;
    }


    /**
     * Purpose: update count of product types in cart
     * @return array
     */
    public void updateTypeCount()
    {
        // If the 2D Product array is not null, continue
        if (multiProducts != null)
        {
            // Initialize a count
            int count = 0;
            // Iterate through each row of 2D array
            for (Product[] row : multiProducts)
            {
                // If the row is not null, increment the count
                if (row != null)
                {
                    // Increment count
                    count++;
                }
            }
            // Assign count to typeCount field
            typeCount = count;
        }
    }

    /**
     * Purpose: get quantity of products in cart
     * @return quantity
     */
    public int getQuantity()
    {   
        // Initialize an integer variable to count how many products are in cart
        int count = 0;
        // If there is more than 1 type of product, search through 2D array
        if (typeCount > 1)
        {
            // Iterate through each type of array
            for (Product[] type : multiProducts)
            {
                // If type is not null, iterate through each product and increment count
                if (type != null)
                {
                    // Iterate through each product of array
                    for (Product product : type)
                    {
                        // If the product is not null, increment count
                        if (product != null)
                        {
                            // Increment quantity by one (representing each element in array)
                            count++;
                        }
                    }
                }
            }
        }
        // Otherwise, search through "products" array
        else 
        {
            // If the product is not null, continue
            if (products != null)
            {
                // Iterate through each product of array
                for (Product product : products)
                {
                    // If the product is not null, increment count
                    if (product != null)
                    {
                        // Increment quantity by one (representing each element in array)
                        count++;
                    }
                }
            }
        }
        // Assign count to quantity field
        quantity = count;
        // Return quantity of products in cart
        return quantity;
    }

    /**
     * Purpose: get count of models in model array
     * @return modelCount
     */
    public int getModelCount()
    {   
        // Return quantity of different models of Products
        return modelCount;
    }

    /**
     * Purpose: get sizes of products in cart
     * @return productSizes
     */
    public int[] getProductSizes()
    {   
        // Return product sizes
        return productSizes;
    }

    /**
     * Purpose: get 2D array of Products in cart based on size
     * @return multiSizes
     */
    public Product[][] getMultiSizes()
    {   
        // Return product sizes
        return multiSizes;
    }

    /**
     * Purpose: display total price of products in cart
     * @return total cost of products in cart
     */
    public double displayTotal()
    {   
        // If there is more than 1 type of product, search through 2D array
        if (typeCount > 1)
        {
            // If Product array is not null, continue
            if (multiProducts != null)
            {
                // Iterate through each type of array
                for (Product[] type : multiProducts)
                {
                    // If type is not null, iterate through each product of array and increment total
                    if (type != null)
                    {
                        // Iterate through each product of array
                        for (Product product : type)
                        {
                            // If the product is not null, increment total
                            if (product != null)
                            {
                                // Increment the price of each product to the total
                                total += product.getPrice();
                            }
                        }
                    }
                }
            }
        }
        // Otherwise, search through "products" array
        else 
        {
            // If the product is not null, continue
            if (products != null)
            {
               // Iterate through each product of array
                for (Product product : products)
                {
                    // If the product is not null, increment total
                    if (product != null)
                    {
                        // Increment the price of each product to the total
                        total += product.getPrice();
                    }
                } 
            }
        }
        // Return the total cost of all products in the cart
        return total;
    }

    /**
     * Purpose: display 2D cart products
     * @return cart (String of products)
     */
     @Override
    public String toString()
    {
        // Create int for count of products in cart
        int count = 1;
        // Create string to add products to
        String cart = "";
        // If there is more than 1 type of product, search through 2D array
        if (typeCount > 1)
        {
            // Iterate through each row/type of array
            for (Product[] type : multiProducts)
            {
                // If type/row is not null, continue
                if (type != null)
                {
                    // Iterate through each column of array
                    for (Product product : type)
                    {
                        // If product is not null, continue
                        if (product != null)
                        {
                            // If cart String does not already contain model name, add product to String
                            if (!cart.contains(product.getModel()))
                            {
                                // Increment product brand and model to string
                                cart += "(" + (count++) + ") " + product.getBrand() + " " 
                                + product.getModel() + " " + product.getType() + "\n";
                            }
                        }
                    }
                }
            }
        }
        // Otherwise, search through "products" array
        else 
        {
            // If Product array is not null, add each product to String
            if (products != null)
            {
                // Iterate through each product of array
                for (Product product : products)
                {
                    // If product is not null, continue
                    if (product != null)
                    {
                        // If cart String does not already contain model name, add product to String
                        if (!cart.contains(product.getModel()))
                        {
                            // Increment product brand and model to string
                            cart += "(" + (count++) + ") " + product.getBrand() + " " 
                            + product.getModel() + " " + product.getType() + "\n";
                        }
                    }
                }
            }
        }
        // Return the string displaying the products in the cart
        return cart;
    }
}