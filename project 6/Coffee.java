/*
 * Class: CMSC203
 * Instructor: Gary Thai
 * Description: Represents a Coffee Beverage
 * Due: 05/05/2023
 * Platform/Compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Alim Saidkhodjaev M21111105
 */
public class Coffee extends Beverage {

    private boolean extraShot;
    private boolean extraSyrup;

    /**
     * Creates a Coffee object with given name, size, and optional extra shot and syrup.
     * @param name the name of the coffee drink
     * @param size the size of the coffee drink
     * @param extraShot true if an extra shot is added, false otherwise
     * @param extraSyrup true if extra syrup is added, false otherwise
     */
    public Coffee(String name, Size size, boolean extraShot, boolean extraSyrup) {
        super(name, Type.COFFEE, size);
        this.extraShot = extraShot;
        this.extraSyrup = extraSyrup;
    }

    /**
     * Returns whether an extra shot is added to the drink.
     * @return true if extra shot is added, false otherwise
     */
    public boolean getExtraShot() {
        return extraShot;
    }

    /**
     * Returns whether extra syrup is added to the drink.
     * @return true if extra syrup is added, false otherwise
     */
    public boolean getExtraSyrup() {
        return extraSyrup;
    }

    /**
     * Calculates the price of the coffee drink based on its size, extra shot, and extra syrup.
     * @return the price of the coffee drink
     */
    @Override
    public double calcPrice() {
        double price = super.calcPrice();
        if (extraShot) {
            price += 0.50;
        }
        if (extraSyrup) {
            price += 0.50;
        }
        return price;
    }

    /**
     * Returns a string representation of the coffee drink, including its name, size, extra shot, extra syrup, and price.
     * @return a string representation of the coffee drink
     */
    @Override
    public String toString() {
        String result = super.toString();
        if (extraShot) {
            result += ", extra shot";
        }
        if (extraSyrup) {
            result += ", extra syrup";
        }
        result += ", Price: $" + String.format("%.2f", calcPrice());
        return result;
    }

    /**
     * Checks if another beverage is equal to this coffee drink.
     * @param anotherBev the other beverage to compare to
     * @return true if the two beverages have the same name, size, extra shot, and extra syrup, false otherwise
     */
    @Override
    public boolean equals(Object anotherBev) {
        if (!super.equals(anotherBev)) {
            return false;
        }
        if (!(anotherBev instanceof Coffee)) {
            return false;
        }
        Coffee otherCoffee = (Coffee) anotherBev;
        return this.extraShot == otherCoffee.extraShot && this.extraSyrup == otherCoffee.extraSyrup;
    }
}
