import org.junit.Test;
import static org.junit.Assert.*;

public class AlcoholTestStudent {
    
    @Test
    public void testCalcPrice() {
        // Test for alcohol beverage offered during the weekend
        Alcohol alcohol1 = new Alcohol("Beer", Size.MEDIUM, true);
        double expectedPrice1 = 3.60; // base price of $3.00 + weekend cost of $0.60
        double actualPrice1 = alcohol1.calcPrice();
        assertEquals(expectedPrice1, actualPrice1, 0.001);
        
        // Test for alcohol beverage not offered during the weekend
        Alcohol alcohol2 = new Alcohol("Wine", Size.LARGE, false);
        double expectedPrice2 = 4.00; // base price of $5.50 + no additional cost
        double actualPrice2 = alcohol2.calcPrice();
        assertEquals(expectedPrice2, actualPrice2, 0.001);
    }
    
    @Test
    public void testToString() {
        Alcohol alcohol = new Alcohol("Rum", Size.SMALL, true);
        String expectedString = "Rum, SMALL, Weekend: true, Price: $2.60";
        String actualString = alcohol.toString();
        assertEquals(expectedString, actualString);
    }
    
    @Test
    public void testEquals() {
        // Test for equality between two Alcohol objects with same name, size, and weekend status
        Alcohol alcohol1 = new Alcohol("Whiskey", Size.LARGE, true);
        Alcohol alcohol2 = new Alcohol("Whiskey", Size.LARGE, true);
        assertTrue(alcohol1.equals(alcohol2));
        
        // Test for inequality between two Alcohol objects with different weekend status
        Alcohol alcohol3 = new Alcohol("Vodka", Size.MEDIUM, true);
        Alcohol alcohol4 = new Alcohol("Vodka", Size.MEDIUM, false);
        assertFalse(alcohol3.equals(alcohol4));
        
    }
    
}
