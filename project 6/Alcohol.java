/*
 * Class: CMSC203
 * Instructor: Gary Thai
 * Description: Represents an Alcohol Beverage
 * Due: 05/05/2023
 * Platform/Compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Alim Saidkhodjaev M21111105
 */
public class Alcohol extends Beverage {
    
    // Constants
    private static final double WEEKEND_COST = 0.60;
    
    // Instance variables
    private boolean isWeekend;

    /**
     * Constructs an Alcohol object with the given name, size, and weekend status.
     * @param bevName the name of the alcohol beverage
     * @param size the size of the alcohol beverage
     * @param isWeekend whether or not the alcohol beverage is offered during the weekend
     */
    public Alcohol(String bevName, Size size, boolean isWeekend) {
        super(bevName, Type.ALCOHOL, size);
        this.isWeekend = isWeekend;
    }

    /**
     * Calculates the price of the alcohol beverage, including any additional cost for
     * being offered during the weekend.
     * @return the price of the alcohol beverage
     */
    @Override
    public double calcPrice() {
        double price = super.calcPrice();
        if (isWeekend) {
            price += WEEKEND_COST;
        }
        return price;
    }

    /**
     * Returns a string representation of the Alcohol object, including its name, size,
     * whether or not it is offered during the weekend, and its price.
     * @return a string representation of the Alcohol object
     */
    @Override
    public String toString() {
        return super.toString() + ", Weekend: " + isWeekend + ", Price: $" + String.format("%.2f", calcPrice());
    }

    /**
     * Checks whether this Alcohol object is equal to another object based on the Beverage
     * class equals method and its additional instance variable for weekend status.
     * @param anotherBev the other object to compare to
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object anotherBev) {
        if (anotherBev instanceof Alcohol) {
            Alcohol other = (Alcohol) anotherBev;
            return super.equals(other) && this.isWeekend == other.isWeekend;
        }
        return false;
    }

    /**
     * Returns whether or not the alcohol beverage is offered during the weekend.
     * @return true if the alcohol beverage is offered during the weekend, false otherwise
     */
    public boolean isWeekend() {
        return isWeekend;
    }
}
