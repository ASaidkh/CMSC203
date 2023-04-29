/*
 * Class: CMSC203
 * Instructor: Gary Thai
 * Description: Represents a Beverage Object
 * Due: 05/05/2023
 * Platform/Compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Alim Saidkhodjaev M21111105
 */

public abstract class Beverage {
    
    // instance variables
    private String bevName;
    private Type bevType;
    private Size size;
    private static final double BASE_PRICE = 2.0;
    private static final double SIZE_PRICE = 1.0;
    
    /**
     * Constructs a Beverage object with the given name, type, and size.
     * @param name the name of the beverage
     * @param type the type of the beverage
     * @param size the size of the beverage
     */
    public Beverage(String name, Type type, Size size) {
        this.bevName = name;
        this.bevType = type;
        this.size = size;
    }
    
    /**
     * Gets the base price of the beverage.
     * @return the base price
     */
    public double getBasePrice() {
        return BASE_PRICE;
    }
    
    /**
     * Gets the type of the beverage.
     * @return the type of the beverage
     */
    public Type getType() {
        return bevType;
    }
    
    /**
     * Gets the name of the beverage.
     * @return the name of the beverage
     */
    public String getBevName() {
        return bevName;
    }
    
    /**
     * Gets the size of the beverage.
     * @return the size of the beverage
     */
    public Size getSize() {
        return size;
    }
    
    /**
     * Calculates the price of the beverage, including the size price if applicable.
     * @return the price of the beverage
     */
    public double calcPrice() {
        if (size == Size.SMALL) {
            return BASE_PRICE;
        } else if (size == Size.MEDIUM) {
            return BASE_PRICE + SIZE_PRICE;
        } else { // size == Size.LARGE
            return BASE_PRICE + 2 * SIZE_PRICE;
        }
    }
    
    /**
     * Adds the size price to the base price and returns the new price.
     * @return the new price of the beverage with the size price added
     */
    public double addSizePrice() {
        if (size == Size.SMALL) {
            return BASE_PRICE;
        } else if (size == Size.MEDIUM) {
            return BASE_PRICE + SIZE_PRICE;
        } else { // size == Size.LARGE
            return BASE_PRICE + 2 * SIZE_PRICE;
        }
    }
    
    /**
     * Returns a string representation of the beverage in the format "bevName, size".
     * @return a string representation of the beverage
     */
    @Override
    public String toString() {
        return bevName + ", " + size;
    }
    
    /**
     * Compares this Beverage to another object for equality based on name, type, and size.
     * @param anotherBev the object to compare to
     * @return true if the name, type, and size match, false otherwise
     */
    @Override
    public boolean equals(Object anotherBev) {
        if (anotherBev instanceof Beverage) {
            Beverage other = (Beverage) anotherBev;
            return this.bevName.equals(other.bevName) &&
                   this.bevType == other.bevType &&
                   this.size == other.size;
        }
        return false;
    }
}
