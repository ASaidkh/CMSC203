import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyTestStudent {

	  Property property;
	
	@BeforeEach
    void setUp() throws Exception {
        // Create a new Property object before each test
        property = new Property("PropName", "SomeCity", 1000.0, "Bob", 0, 0, 50, 50);
    }

    @AfterEach
    void tearDown() throws Exception {
        // Set the Property object to null after each test
        property = null;
    }

	@Test
    void testGetPlot() {
        Plot plot = property.getPlot();
        assertNotNull(plot);
        assertEquals(0, plot.getX());
        assertEquals(0, plot.getY());
        assertEquals(50, plot.getWidth());
        assertEquals(50, plot.getDepth());
    }

	 @Test
	    void testGetPropertyName() {
	        assertEquals("PropName", property.getPropertyName());
	    }

	    @Test
	    void testGetCity() {
	        assertEquals("SomeCity", property.getCity());
	    }

	    @Test
	    void testGetRentAmount() {
	        assertEquals(1000.0, property.getRentAmount(), 0.001);
	    }

	    @Test
	    void testGetOwner() {
	        assertEquals("Bob", property.getOwner());
	    }

	    @Test
	    void testToString() {
	        assertEquals("PropName,SomeCity,Bob,1000.0", property.toString());
	    }

}
