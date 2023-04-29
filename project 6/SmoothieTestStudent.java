import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SmoothieTestStudent {

	@Test
    public void testCalcPrice() {
        Smoothie smallSmoothie = new Smoothie("Strawberry Banana Smoothie", Size.SMALL, 2, true);
        assertEquals(4.5, smallSmoothie.calcPrice(), 0.001);
        
        Smoothie mediumSmoothie = new Smoothie("Mango Smoothie", Size.MEDIUM, 3, false);
        assertEquals(4.5, mediumSmoothie.calcPrice(), 0.001);
        
        Smoothie largeSmoothie = new Smoothie("Blueberry Smoothie", Size.LARGE, 4, true);
        assertEquals(7.5, largeSmoothie.calcPrice(), 0.001);
    }

    @Test
    public void testToString() {
        Smoothie smoothie = new Smoothie("Pineapple Smoothie", Size.MEDIUM, 2, true);
        System.out.print(smoothie.toString());
        assertEquals("Pineapple Smoothie, MEDIUM, Protein Added: true, Fruits: 2, Price: $5.5", smoothie.toString());
    }

    @Test
    public void testEquals() {
        Smoothie smoothie1 = new Smoothie("Strawberry Banana Smoothie", Size.SMALL, 2, true);
        Smoothie smoothie2 = new Smoothie("Strawberry Banana Smoothie", Size.SMALL, 2, true);
        Smoothie smoothie3 = new Smoothie("Mango Smoothie", Size.MEDIUM, 3, false);

    
        assertTrue(smoothie1.equals(smoothie2));
        assertFalse(smoothie1.equals(smoothie3));
        assertTrue(smoothie1.equals(smoothie1));
    }
}
