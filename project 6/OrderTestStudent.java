import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;


public class OrderTestStudent {
    
    private Order order;
    
    @Before
    public void setUp() {
        order = new Order(12, Day.MONDAY, new Customer("John", 30));
    }
    
    @Test
    public void testGenerateOrder() {
        int orderNumber = order.generateOrder();
        assertTrue(orderNumber >= 10000 && orderNumber <= 90000);
    }
    
    @Test
    public void testGetOrderNo() {
        int orderNumber = order.getOrderNo();
        assertTrue(orderNumber >= 10000 && orderNumber <= 90000);
    }
    
    @Test
    public void testGetOrderTime() {
        int orderTime = order.getOrderTime();
        assertEquals(12, orderTime);
    }
    
    @Test
    public void testGetOrderDay() {
        Day orderDay = order.getOrderDay();
        assertEquals(Day.MONDAY, orderDay);
    }
    
    @Test
    public void testGetCustomer() {
        Customer customer = order.getCustomer();
        assertNotNull(customer);
        assertEquals("John", customer.getName());
        assertEquals(30, customer.getAge());
    }
    
    @Test
    public void testGetDay() {
        Day orderDay = order.getDay();
        assertEquals(Day.MONDAY, orderDay);
    }
    
    @Test
    public void testIsWeekend() {
        assertFalse(order.isWeekend());
        Order weekendOrder = new Order(10, Day.SATURDAY, new Customer("Jane Smith", 25));
        assertTrue(weekendOrder.isWeekend());
    }
    
    @Test
    public void testAddNewBeverage() {
        int totalItems = order.getTotalItems();
        assertEquals(0, totalItems);
        order.addNewBeverage("Latte", Size.MEDIUM, true, false);
        assertTrue(order.getBeverage(0).equals(new Coffee("Latte", Size.MEDIUM, true, false)));
        totalItems = order.getTotalItems();
        assertEquals(1, totalItems);
        order.addNewBeverage("Margarita", Size.LARGE);
        assertTrue(order.getBeverage(1).equals(new Alcohol("Margarita", Size.LARGE, false)));
        totalItems = order.getTotalItems();
        assertEquals(2, totalItems);
        
        assertEquals(order.findNumOfBeveType(Type.ALCOHOL), 1);
        assertEquals(order.findNumOfBeveType(Type.COFFEE), 1);
        assertEquals(order.findNumOfBeveType(Type.SMOOTHIE), 0);
        
    }
    
    @Test
    public void testCalcOrderTotal() {
    	order.addNewBeverage("Latte", Size.MEDIUM, true, false);
        order.addNewBeverage("Margarita", Size.LARGE);
        assertEquals(order.calcOrderTotal(), 7.5, 0.01);
    }
    
    @Test
    public void testToString() {
    	order.addNewBeverage("Latte", Size.MEDIUM, true, false);
        order.addNewBeverage("Margarita", Size.LARGE);
     
        String expectedOutput = "Order No.: " + order.getOrderNo() + "\n" +
                "Time: 12:00\n" +
                "Day: MONDAY\n" +
                "Customer: John, Age: 30\n" +
                "Beverages: \n" +
                "Latte, MEDIUM, extra shot, Price: $3.50\n" +
                "Margarita, LARGE, Weekend: false, Price: $4.00\n";
        assertEquals(expectedOutput, order.toString());
    }
   
}
