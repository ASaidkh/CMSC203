import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlotTestStudent {

    private Plot plot1;
    private Plot plot2;
    private Plot plot3;
    private Plot plot4;

    @BeforeEach
    void setUp() throws Exception {
        plot1 = new Plot(0, 0, 5, 5);
        plot2 = new Plot(5, 5, 5, 5);
        plot3 = new Plot(2, 2, 2, 2);
        plot4 = new Plot(7, 7, 2, 2);
    }

    @Test
    void testEncompasses() {
        assertTrue(plot1.encompasses(plot3));
        assertFalse(plot1.encompasses(plot2));
        assertFalse(plot1.encompasses(plot4));
    }

    @Test
    void testGetWidth() {
        assertEquals(5, plot1.getWidth());
        assertEquals(5, plot2.getWidth());
        assertEquals(2, plot3.getWidth());
        assertEquals(2, plot4.getWidth());
    }

    @Test
    void testGetDepth() {
        assertEquals(5, plot1.getDepth());
        assertEquals(5, plot2.getDepth());
        assertEquals(2, plot3.getDepth());
        assertEquals(2, plot4.getDepth());
    }

    @Test
    void testGetX() {
        assertEquals(0, plot1.getX());
        assertEquals(5, plot2.getX());
        assertEquals(2, plot3.getX());
        assertEquals(7, plot4.getX());
    }

    @Test
    void testGetY() {
        assertEquals(0, plot1.getY());
        assertEquals(5, plot2.getY());
        assertEquals(2, plot3.getY());
        assertEquals(7, plot4.getY());
    }

    @Test
    void testOverlaps() {
        assertTrue(plot1.overlaps(plot3));
        assertFalse(plot2.overlaps(plot3));
        assertFalse(plot1.overlaps(plot2));
        assertFalse(plot1.overlaps(plot4));
    }

    @Test
    void testToString() {
        assertEquals("0,0,5,5", plot1.toString());
        assertEquals("5,5,5,5", plot2.toString());
        assertEquals("2,2,2,2", plot3.toString());
        assertEquals("7,7,2,2", plot4.toString());
    }

}
