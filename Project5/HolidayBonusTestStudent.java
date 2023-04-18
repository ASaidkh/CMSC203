import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class HolidayBonusTestStudent {
	  
	double [][] testData = new double[][]{
	        {1253.65, 4.50, 2154.36, 7532.45, 3388.44},
	        {2876.22, -3.24, 1954.66},
	        {4896.23, 2.29, 5499.29},
	        {2256.76, 3.76, 4286.29, 5438.48, 3794.43},
	        {3184.38, 3654.65, 3455.76, 6387.23, 4265.77, 4592.45},
	        {2657.46, 3265.34, 2256.38, 8935.26, 5287.34, 6598.23}};
		
	  
	  @Test
	  public void testCalculateHolidayBonus() {
	   
	    double[] expected = {8000, 3000, 12000, 9000, 14000, 21000};
	    assertArrayEquals(expected, HolidayBonus.calculateHolidayBonus(testData), 0.001);
	  }
	  
	 
	  @Test
	  public void testCalculateTotalHolidayBonus() {
	    double expected = 67000;
	    assertEquals(expected, HolidayBonus.calculateTotalHolidayBonus(testData), 0.001);
	  }
	  
	 
	}
