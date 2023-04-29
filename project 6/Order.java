/*
 * Class: CMSC203
 * Instructor: Gary Thai
 * Description: Represents beverage orders
 * Due: 05/05/2023
 * Platform/Compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Alim Saidkhodjaev M21111105
 */
import java.util.ArrayList;

public class Order implements OrderInterface, Comparable<Order> {
    
    private int orderNumber;
    private int orderTime;
    private Day orderDay;
    private Customer customer;
    private ArrayList<Beverage> beverages;
    
    /**
     * Creates a new order with the given order time, order day, and customer.
     * @param orderTime The time of the order (between 8 and 23).
     * @param orderDay The day of the order.
     * @param cust The customer object.
     */
    public Order(int orderTime, Day orderDay, Customer cust) {
        this.orderNumber = generateOrder();
        this.orderTime = orderTime;
        this.orderDay = orderDay;
        this.customer = new Customer(cust.getName(), cust.getAge());
        this.beverages = new ArrayList<Beverage>();
    }
    
    /**
     * Generates a random order number within the range of 10000 and 90000.
     * @return A random order number within the range of 10000 and 90000.
     */
    public int generateOrder() {
        return (int) (Math.random() * 80000) + 10000;
    }
    
    /**
     * Returns the order number of this order.
     * @return The order number of this order.
     */
    public int getOrderNo() {
        return this.orderNumber;
    }
    
    /**
     * Returns the order time of this order.
     * @return The order time of this order.
     */
    public int getOrderTime() {
        return this.orderTime;
    }
    
    /**
     * Returns the order day of this order.
     * @return The order day of this order.
     */
    public Day getOrderDay() {
        return this.orderDay;
    }
    
    /**
     * Returns the customer object associated with this order.
     * @return The customer object associated with this order.
     */
    public Customer getCustomer() {
        return new Customer(this.customer.getName(), this.customer.getAge());
    }
    
    /**
     * Returns a deep copy of the order day of this order.
     * @return A deep copy of the order day of this order.
     */
    public Day getDay() {
        return this.orderDay;
    }
    
    /**
     * Returns true if the given day is a weekend day (Saturday or Sunday).
     * @return True if the given day is a weekend day (Saturday or Sunday), false otherwise.
     */
    public boolean isWeekend() {
        return this.orderDay == Day.SATURDAY || this.orderDay == Day.SUNDAY;
    }
    
    /**
     * Returns the beverage listed in the given item number of this order.
     * @param itemNo The item number of the beverage.
     * @return The beverage listed in the given item number of this order, or null if there is no item in the order.
     */
    public Beverage getBeverage(int itemNo) {
        if (itemNo >= 0 && itemNo < this.beverages.size()) {
            return this.beverages.get(itemNo);
        } else {
            return null;
        }
    }
    
    /**
     * Returns the total number of beverages ordered within this order.
     * @return The total number of beverages ordered within this order.
     */
    public int getTotalItems() {
        return this.beverages.size();
    }
    
    /**
     * Adds a coffee beverage to this order with the specified name, size, and extras.
     * 
     * @param bevName   the name of the coffee beverage to add
     * @param size      the size of the coffee beverage to add
     * @param extraShot true if an extra shot should be added, false otherwise
     * @param extraSyrup true if extra syrup should be added, false otherwise
     */
    public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        Coffee coffee = new Coffee(bevName, size, extraShot, extraSyrup);
        this.beverages.add(coffee);
    }
    
    /**
     * Adds an alcohol beverage to this order with the specified name and size.
     * 
     * @param bevName the name of the alcohol beverage to add
     * @param size    the size of the alcohol beverage to add
     */
    public void addNewBeverage(String bevName, Size size) {
        Alcohol alcohol = new Alcohol(bevName, size, isWeekend());
        this.beverages.add(alcohol);
    }
    
    /**
     * Adds a smoothie beverage to this order with the specified name, size, number of fruits, and protein.
     * 
     * @param bevName     the name of the smoothie beverage to add
     * @param size        the size of the smoothie beverage to add
     * @param numOfFruits the number of fruits to add to the smoothie
     * @param addProtein  true if protein should be added to the smoothie, false otherwise
     */
    public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
        Smoothie smoothie = new Smoothie(bevName, size, numOfFruits, addProtein);
        this.beverages.add(smoothie);
    }
    
    /**
     * Calculates and returns the total cost of all the beverages in this order.
     * 
     * @return the total cost of all the beverages in this order
     */
    public double calcOrderTotal() {
        double total = 0.0;
        for (Beverage beverage : this.beverages) {
            total += beverage.calcPrice();
        }
        return total;
    }
    
    /**
     * Returns the number of beverages in this order that have the specified type.
     * 
     * @param type the type of beverage to search for
     * @return the number of beverages in this order that have the specified type
     */
    public int findNumOfBeveType(Type type) {
        int count = 0;
        for (Beverage beverage : this.beverages) {
            if (beverage.getType() == type) {
                count++;
            }
        }
        return count;
    }
    
    /**
     * Returns a string representation of this order, including the order number, order time,
     * order day, customer name and age, and the list of beverages with their details.
     * 
     * @return a string representation of this order
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order No.: ").append(getOrderNo()).append("\n");
        sb.append("Time: ").append(orderTime).append(":00").append("\n");
        sb.append("Day: ").append(orderDay).append("\n");
        sb.append("Customer: ").append(customer.getName()).append(", Age: ").append(customer.getAge()).append("\n");
        sb.append("Beverages: \n");
        for (Beverage bev : beverages) {
            sb.append(bev.toString()).append("\n");
        }
        return sb.toString();
    }
    
    /**
     * Compares this order with another order based on the order number. Returns 0 if this
     * order number is same as another order's order number, 1 if it is greater than another
     * order's order number, -1 if it smaller than another order's order number.
     * 
     * @param anotherOrder the order to compare with
     * @return 0 if this order number is same as another order's order number, 1 if it is
     *         greater than another order's order number, -1 if it smaller than another
     *         order's order number.
     */
    public int compareTo(Order anotherOrder) {
        int thisOrderNum = this.getOrderNo();
        int anotherOrderNum = anotherOrder.getOrderNo();
        if (thisOrderNum == anotherOrderNum) {
            return 0;
        } else if (thisOrderNum > anotherOrderNum) {
            return 1;
        } else {
            return -1;
        }
    }

}
