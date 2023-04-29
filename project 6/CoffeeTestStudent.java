import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CoffeeTestStudent {

	@Test
	public void testCalcPrice() {
		Coffee coffee = new Coffee("Americano", Size.MEDIUM, false, false);
        assertEquals(3.00, coffee.calcPrice(), 0.01);
        
        Coffee coffee2 = new Coffee("Cappuccino", Size.LARGE, true, false);
        assertEquals(4.50, coffee2.calcPrice(), 0.01);
        
        Coffee coffee3 = new Coffee("Latte", Size.SMALL, false, true);
        assertEquals(2.50, coffee3.calcPrice(), 0.01);
        
        Coffee coffee4 = new Coffee("Mocha", Size.LARGE, true, true);
        assertEquals(5.00, coffee4.calcPrice(), 0.01);
	}

	@Test
	public void testToString() {
		Coffee coffee = new Coffee("Espresso", Size.MEDIUM, false, false);
        assertEquals("Espresso, MEDIUM, Price: $3.00", coffee.toString());
        
        Coffee coffee2 = new Coffee("Cappuccino", Size.LARGE, true, false);
        assertEquals("Cappuccino, LARGE, extra shot, Price: $4.50", coffee2.toString());
        
        Coffee coffee3 = new Coffee("Latte", Size.SMALL, false, true);
        assertEquals("Latte, SMALL, extra syrup, Price: $2.50", coffee3.toString());
        
        Coffee coffee4 = new Coffee("Mocha", Size.LARGE, true, true);
        assertEquals("Mocha, LARGE, extra shot, extra syrup, Price: $5.00", coffee4.toString());
    }
	

	@Test
	public void testEqualsObject() {
		Coffee coffee1 = new Coffee("Americano", Size.MEDIUM, false, false);
        Coffee coffee2 = new Coffee("Americano", Size.MEDIUM, false, false);
        Coffee coffee3 = new Coffee("Latte", Size.SMALL, true, false);
        
        assertTrue(coffee1.equals(coffee2));
        assertFalse(coffee1.equals(coffee3));
	}


}
