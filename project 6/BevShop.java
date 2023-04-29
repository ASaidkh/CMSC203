import java.util.ArrayList;
import java.util.Collections;

/*
 * Class: CMSC203
 * Instructor: Gary Thai
 * Description: Represents a beverage shop, includes list of orders, implements BevShopInterface
 * Due: 05/05/2023
 * Platform/Compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Alim Saidkhodjaev M21111105
 */
public class BevShop implements BevShopInterface {

    // ArrayList to store all orders made by customers
    private ArrayList<Order> orders;

    /**
     * Constructs a new BevShop object.
     * Initializes the orders ArrayList.
     */
    public BevShop() {
        this.orders = new ArrayList<Order>();
    }

    /**
     * Checks if the time is valid (between 8 and 23 ).
     *
     * @param time time represents the time.
     * @return true if times is within the range of 8 to 23, false otherwise.
     */
    @Override
    public boolean isValidTime(int time) {
        return time >= MIN_TIME && time <= MAX_TIME;
    }

    /**
     * Returns the constant value for the maximum number of fruits allowed in a smoothie.
     *
     * @return the value for the maximum number of fruits allowed in a smoothie.
     */
    @Override
    public int getMaxNumOfFruits() {
        return MAX_FRUIT;
    }

    /**
     * Returns the constant value for the minimum age for offering alcohol drink.
     *
     * @return the value for the minimum age for offering alcohol drink.
     */
    @Override
    public int getMinAgeForAlcohol() {
        return MIN_AGE_FOR_ALCOHOL;
    }

    /**
     * Checks if the passed parameter exceeds the maximum number of fruits allowed for the smoothie drink.
     *
     * @param numOfFruits number of fruits
     * @return true if the passed parameter exceeds the maximum number of fruits allowed for the smoothie drink, false otherwise.
     */
    public boolean isMaxFruit(int numOfFruits) {
        return numOfFruits > MAX_FRUIT;
    }

    /**
     * Returns the constant maximum number of alcohol beverages per order offered by the beverage shop.
     *
     * @return constant maximum number of alcohol beverages per order offered by the beverage shop.
     */
    public int getMaxOrderForAlcohol() {
        return MAX_ORDER_FOR_ALCOHOL;
    }

    /**
     * Checks if the number of alcohol beverages for the current order has reached the maximum
     * @return true if number of alcohol drinks for the current order has reached the maximum, false otherwise
     */
    public boolean isEligibleForMore() {
        return getNumOfAlcoholDrink() < MAX_ORDER_FOR_ALCOHOL;
    }




    /**
     * Returns the total number of alcohol drinks in the current order.
     *
     * @return total number of alcohol drinks in the current order
     */
	public int getNumOfAlcoholDrink() {
		return getCurrentOrder().findNumOfBeveType(Type.ALCOHOL);
	}

	/**
	 * Checks if the given age is greater than or equal to the minimum age required for alcohol drinks.
	 *
	 * @param age the age to be checked
	 * @return true if age is greater than or equal to the minimum age, false otherwise
	 */
	public boolean isValidAge(int age) {
	    return age >= MIN_AGE_FOR_ALCOHOL;
	}

	/**
	 * Creates a new order with the given details and adds it to the orders list. No beverage is added to the order yet.
	 *
	 * @param time          time of the order
	 * @param day           day of the order of type DAY
	 * @param customerName  customer name
	 * @param customerAge   customer age
	 */
	public void startNewOrder(int time, Day day, String customerName, int customerAge) {
	    Order currentOrder = new Order(time, day, new Customer(customerName,customerAge));
	    orders.add(currentOrder);
	}

	
	/**
	 * process the Coffee order for the current order by adding it to the
	 * current order
	 *
	 * @param bevName
	 *            beverage name
	 * @param size
	 *            beverage size
	 * @param extraShot
	 *            true if the coffee beverage has extra shot , false otherwise
	 * @param extraSyrup
	 *            true if the coffee beverage has extra syrup , false otherwise
	 */
	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		getCurrentOrder().addNewBeverage(bevName, size, extraShot, extraSyrup);
	}

	/**
	 * process the Alcohol order for the current order by adding it to the
	 * current order
	 *
	 * @param bevName
	 *            beverage name
	 * @param size
	 *            beverage size
	 */
	public void processAlcoholOrder(String bevName, Size size) {
		getCurrentOrder().addNewBeverage(bevName, size);
	}

	/**
	 * process the Smoothie order for the current order by adding it to the
	 * current order
	 *
	 * @param bevName
	 *            beverage name
	 * @param size
	 *            beverage size
	 * @param numOfFruits
	 *            number of fruits to be added
	 * @param addProtein
	 *            true if protein is added , false otherwise
	 */
	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
		getCurrentOrder().addNewBeverage(bevName, size, numOfFruits, addProtein);  
	}

	/**
	 * locate an order based on the order number
	 *
	 * @param orderNo
	 *            the order number
	 * @return the index of the order in the list of Orders if found or -1 if
	 *         not found
	 */
	public int findOrder(int orderNo) {
	    for (int i = 0; i < orders.size(); i++) {
	        if (orders.get(i).getOrderNo() == orderNo) {
	            return i;
	        }
	    }
	    return -1;
	}

	/**
	 * locates an order in the list of orders and returns the total value on the
	 * order.
	 *
	 * @param orderNo
	 *            the order number
	 * @returns the calculated price on this order.
	 */
	public double totalOrderPrice(int orderNo) {
	    int index = findOrder(orderNo);
	    if (index != -1) {
	        return orders.get(index).calcOrderTotal();
	    }
	    return -1.0; // return -1 if order not found
	}

	/**
	 * Calculates the total sale of all the orders for this beverage shop
	 *
	 * @return the total sale of all the orders
	 */
	public double totalMonthlySale() {
	    double totalSale = 0;
	    for (Order order : orders) {
	            totalSale += order.calcOrderTotal();
	        }
	    return totalSale;
	}

	/**
	 * returns total numbers of orders within the month
	 *
	 * @returns total numbers of orders within the month
	 */
	public int totalNumOfMonthlyOrders() {
	    return orders.size();
	}

	/**
	 * returns the current Order located in the index in the list of orders.
	 * Notes: this method returns the shallow copy of the order
	 *
	 * @return the current order
	 */
	public Order getCurrentOrder() {
	    return orders.get(orders.size() - 1);
	}


	/**
	 * returns Order in the list of orders at the index Notes: this method
	 * returns the shallow copy of the order
	 *
	 * @return Order in the list of orders at the index
	 */
	public Order getOrderAtIndex(int index) {
		return orders.get(index);
	}

	/**
	 * sorts the orders within this bevShop using the Selection sort algorithm
	 */
	public void sortOrders() {
		 for (int i = 0; i < orders.size() - 1; i++) {
		        int minIdx = i;
		        for (int j = i + 1; j < orders.size(); j++) {
		            if (orders.get(j).getOrderNo() < orders.get(minIdx).getOrderNo()) {
		                minIdx = j;
		            }
		        }
		        if (minIdx != i) {
		            Collections.swap(orders, i, minIdx);
		        }
		    }
		
	}

    
    

}
