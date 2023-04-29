/*
 * Class: CMSC203
 * Instructor: Gary Thai
 * Description: Represents a Smoothie Beverage
 * Due: 05/05/2023
 * Platform/Compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Alim Saidkhodjaev M21111105
 */
public class Smoothie extends Beverage {
    private static final double FRUIT_COST = 0.5;
    private static final double PROTEIN_COST = 1.5;

    private int numOfFruits;
    private boolean addProtein;

    /**
     * Constructs a Smoothie object using the given values
     * @param bevName the name of the beverage
     * @param size the size of the beverage
     * @param numOfFruits the number of fruits to be added to the smoothie
     * @param addProtein whether to add protein to the smoothie or not
     */
    public Smoothie(String bevName, Size size, int numOfFruits, boolean addProtein) {
        super(bevName, Type.SMOOTHIE, size);
        this.numOfFruits = numOfFruits;
        this.addProtein = addProtein;
    }

    /**
     * Returns the number of fruits added to the smoothie
     * @return the number of fruits
     */
    public int getNumOfFruits() {
        return numOfFruits;
    }

    /**
     * Returns true if protein is added to the smoothie, false otherwise
     * @return whether or not protein is added
     */
    public boolean getAddProtein() {
        return addProtein;
    }

    /**
     * Calculates the price of the smoothie based on the size, number of fruits,
     * and whether or not protein is added
     * @return the price of the smoothie
     */
    @Override
    public double calcPrice() {
        double price = super.calcPrice();
        price += numOfFruits * FRUIT_COST;
        if (addProtein) {
            price += PROTEIN_COST;
        }
        return price;
    }

    /**
     * Returns a String representation of the Smoothie in the format:
     * name, size, whether or not protein is added, number of fruits, and price
     * @return a String representation of the Smoothie
     */
    @Override
    public String toString() {
        return super.toString() + ", Protein Added: " + addProtein + ", Fruits: " + numOfFruits + ", Price: $" + calcPrice();
    }

    /**
     * Checks if this Smoothie is equal to another object
     * @param anotherBev the object to compare to
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object anotherBev) {
        if (anotherBev instanceof Smoothie) {
            Smoothie other = (Smoothie) anotherBev;
            return super.equals(other) && numOfFruits == other.numOfFruits && addProtein == other.addProtein;
        }
        return false;
    }
}
