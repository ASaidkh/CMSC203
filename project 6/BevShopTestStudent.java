import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BevShopTestStudent {
	BevShop bevShop;
	
	@Before
    public void setUp() {
		 bevShop = new BevShop();
    }

    @Test
    public void testIsValidTime() {
        assertTrue(bevShop.isValidTime(8));
        assertTrue(bevShop.isValidTime(12));
        assertTrue(bevShop.isValidTime(23));
        assertFalse(bevShop.isValidTime(0));
        assertFalse(bevShop.isValidTime(7));
        assertFalse(bevShop.isValidTime(24));
    }

    @Test
    public void testGetMaxNumOfFruits() {
        BevShop bevShop = new BevShop();
        assertEquals(5, bevShop.getMaxNumOfFruits());
    }

    @Test
    public void testGetMinAgeForAlcohol() {
        BevShop bevShop = new BevShop();
        assertEquals(21, bevShop.getMinAgeForAlcohol());
    }

    @Test
    public void testIsMaxFruit() {
        BevShop bevShop = new BevShop();
        assertFalse(bevShop.isMaxFruit(2));
        assertTrue(bevShop.isMaxFruit(6));
        assertFalse(bevShop.isMaxFruit(5));
    }

    @Test
    public void testGetMaxOrderForAlcohol() {
        BevShop bevShop = new BevShop();
        assertEquals(3, bevShop.getMaxOrderForAlcohol());
    }

    @Test
    public void testIsEligibleForMore() {
        BevShop bevShop = new BevShop();
        bevShop.startNewOrder(10, Day.MONDAY, "John", 25);
        bevShop.processAlcoholOrder("Vodka", Size.MEDIUM);
        bevShop.processAlcoholOrder("Whiskey", Size.LARGE);
        assertTrue(bevShop.isEligibleForMore());
        bevShop.processAlcoholOrder("Beer", Size.SMALL);
        assertFalse(bevShop.isEligibleForMore());
    }

    @Test
    public void testStartNewOrder() {

        bevShop.startNewOrder(12, Day.MONDAY, "John", 30);
        Order order = bevShop.getCurrentOrder();
        assertEquals(Day.MONDAY, order.getDay());
        assertEquals("John", order.getCustomer().getName());
        assertEquals(30, order.getCustomer().getAge());
        
        bevShop.startNewOrder(12, Day.TUESDAY, "Bob", 25);
        Order order2 = bevShop.getCurrentOrder();
        assertEquals(Day.TUESDAY, order2.getDay());
        assertEquals("Bob", order2.getCustomer().getName());
        assertEquals(25, order2.getCustomer().getAge());
    }
    
    @Test
    public void testSortOrder() {
    	bevShop.startNewOrder(12, Day.MONDAY, "John", 30);
    	bevShop.startNewOrder(13, Day.MONDAY, "Johnny", 27);
    	bevShop.startNewOrder(14, Day.MONDAY, "Bob", 29);
    	bevShop.startNewOrder(15, Day.MONDAY, "Dave", 29);
    	
    	bevShop.sortOrders();
    	
    	assertTrue(bevShop.getOrderAtIndex(0).getOrderNo() < bevShop.getOrderAtIndex(1).getOrderNo() && 
    			bevShop.getOrderAtIndex(1).getOrderNo() < bevShop.getOrderAtIndex(2).getOrderNo() &&
    			bevShop.getOrderAtIndex(2).getOrderNo() < bevShop.getOrderAtIndex(3).getOrderNo());
    }


}

