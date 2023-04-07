/*
 * Class: CMSC203
 * Instructor: Gary Thai
 * Description: Class to manage properties
 * Due: 04/07/2023
 * Platform/Compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Alim Saidkhodjaev M21111105
 */

public class ManagementCompany {
    
    public static final int MAX_PROPERTY = 5;
    public static final int MGMT_WIDTH = 10;
    public static final int MGMT_DEPTH = 10;
    
    private String name;
    private String taxID;
    private double mgmFeePer;
    private Plot plot;
    private Property[] properties;
    private int propIndex;
    
    // Constructors
    
    /**
     * Creates a ManagementCompany object using empty strings, creates a default Plot with maximum width and depth and it initializes the properties array.
     */
    public ManagementCompany() {
        this("", "", 0.0);
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.properties = new Property[MAX_PROPERTY];
        this.propIndex = 0;
    }
    
    /**
     * Creates a ManagementCompany object using the given values, creates a default Plot with maximum width and depth and it initializes the properties array.
     * @param name - management Company name
     * @param taxID - tax Id
     * @param mgmFee - management Fee
     */
    public ManagementCompany(String name, String taxID, double mgmFee) {
        this(name, taxID, mgmFee, 0, 0, MGMT_WIDTH, MGMT_DEPTH);
    }
    
    /**
     * Creates a ManagementCompany object using the given values creates a Plot using the given values and it initializes the properties array. This constructor should call an appropriate existing constructor.
     * @param name - management Company name
     * @param taxID - tax Id
     * @param mgmFee - management Fee
     * @param x - x coordinate for plot
     * @param y - y coordinate for plot
     * @param width - width for plot
     * @param depth - depth for plot
     */
    public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFeePer = mgmFee;
        this.plot = new Plot(x, y, width, depth);
        this.properties = new Property[MAX_PROPERTY];
        this.propIndex = 0;
    }
    
    /**
     * Creates a new ManagementCompany copy of the given ManagementCompany. This constructor should call an appropriate existing constructor.
     * @param otherCompany - company to be copied
     */
    public ManagementCompany(ManagementCompany otherCompany) {
        this.name = otherCompany.getName();
        this.taxID = otherCompany.getTaxID();
        this.mgmFeePer = otherCompany.getMgmFeePer();
        this.plot = new Plot(otherCompany.getPlot());
        this.properties = new Property[MAX_PROPERTY];
        this.propIndex = 0;
        
        for (Property property : otherCompany.getProperties()) {
            if (property != null) {
                this.addProperty(property);
            }
        }
    }
    
    // Public methods
    
    /**
     * Adds a new property to the properties array, this method should call an appropriate existing overloaded method.
     * @param name - property name
     * @param city - city where the property is located
     * @param rent - rent amount
     * @param owner - the owner's name
     * @return -1 if the array is full, -2 if the Property object is null, -3 if management company does not encompass the property plot, -4 if property plot overlaps ANY of properties in array, otherwise return the index of the array where the property was added.
     */
    public int addProperty(String name, String city, double rent, String owner) {
        return addProperty(new Property(name, city, rent, owner));
    }
    
    /**
     * Adds a new property to the properties array, this method should call an appropriate existing overloaded method.
     * @param name - property name
     * @param city - city where the property is located
     * @param rent - rent amount
     * @param owner - the owner's name
     * @param x - The x coordinate of the plot
     * @param y - The y coordinate of the plot
     * @param width - The width coordinate of the plot
     * @param depth - The depth coordinate of the plot
     * @return
     */
    public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
        return addProperty(new Property(name, city, rent, owner, x, y, width, depth));
    }
    
    /**
     * Creates a property object by copying from another property and adds it to the properties array.
     * @param property - property object to being copied
     * @return-1 if the array is full, -2 if the Property object is null, -3 if management company does not encompass the property plot, -4 if property plot overlaps ANY of properties in array, otherwise return the index of the array where the property was added.
     */
    public int addProperty(Property property) {
        if (propIndex >= MAX_PROPERTY) {
            return -1; // properties array is full
        }
        if (property == null) {
            return -2; // property object is null
        }
        if (!plot.encompasses(property.getPlot())) {
            return -3; // management company does not encompass the property plot
        }
        for (int i = 0; i < propIndex; i++) {
            if (property.getPlot().overlaps(properties[i].getPlot())) {
                return -4; // property plot overlaps ANY of properties in array
            }
        }
        
        properties[propIndex] = property;
        propIndex++;
        
        return propIndex - 1; // return the index of the array where the property was added
    }
    
    /**
     * Removes(nullifies) the LAST property in the properties array
     */
    public void removeLastProperty() {
        if (propIndex > 0) {
            properties[propIndex - 1] = null;
            propIndex--;
        }
    }
    
    /**
     * Checks if the properties array has reached the maximum capacity
     * @return true if properties array is full, false otherwise
     */
    public boolean isPropertiesFull() {
        return propIndex == MAX_PROPERTY;
    }
    
    /**
     * Gets the number of existing properties in the array
     * @return the number of existing properties in the array
     */
    public int getPropertiesCount() {
        return propIndex + 1;
    }
    
    /**
     * Returns the total rent of the properties in the properties array 
     * @return total rent
     */
    public double getTotalRent() {
        double totalRent = 0;
        for (int i = 0; i < propIndex; i++) {
            if (properties[i] != null) {
                totalRent += properties[i].getRentAmount();
            }
        }
        return totalRent;
    }

    /**
     * Gets the property in the array with the maximum amount of rent
     * @return the property in the array which has the highest amount of rent
     */
    public Property getHighestRentPropperty() {
        Property maxRentProp = properties[0];
        for (int i = 1; i < properties.length; i++) {
            if ( properties[i] != null && properties[i].getRentAmount() > maxRentProp.getRentAmount()) {
                maxRentProp = properties[i];
            }
        }
        return maxRentProp;
    }

    /**
     * Checks if the management company has a valid (between 0-100) fee
     * @return true of the management fee is valid (between 0-100), false otherwise
     */
    public boolean isMangementFeeValid() {
        return (mgmFeePer >= 0 && mgmFeePer <= 100);
    }

    /**
     * Gets the name.
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the tax ID.
     * @return the tax ID
     */
    public String getTaxID() {
        return taxID;
    }

    /**
     * Gets the properties.
     * @return the properties
     */
    public Property[] getProperties() {
        return properties;
    }

    /**
     * Gets the management fee per.
     * @return the mgmFeePer
     */
    public double getMgmFeePer() {
        return mgmFeePer;
    }

    /** 
     * Gets the plot.
     * @return the plot
     */
    public Plot getPlot() {
        return plot;
    }

    /**
     * Represents the information of all the properties in the properties array.
     * @return information of ALL the properties within this management company by accessing the properties array. This value should include each management company's name, taxID as well each property's name,city,owner,rent Amount
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Management Company: " + getName() + "\n");
        sb.append("Tax ID: " + getTaxID() + "\n");
        for (int i = 0; i < properties.length; i++) {
        	if (properties[i] != null)
        		sb.append(properties[i].toString() + "\n"); // include the dimensions in the string
        }
        sb.append("Total Fee:" + getTotalRent()*(mgmFeePer/100));
        return sb.toString();
    }



}

