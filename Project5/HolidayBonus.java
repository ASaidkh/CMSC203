/*
 * Class: CMSC203
 * Instructor: Gary Thai
 * Description: Class to calculate stores bonuses
 * Due: 04/23/2023
 * Platform/Compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Alim Saidkhodjaev M21111105
 */
public class HolidayBonus {
	private static final double HIGH_BONUS = 5000;
	private static final double LOW_BONUS = 1000;
	private static final double OTHER_BONUS = 2000;
	
	/**
	 * Calculates the holiday bonus for each store.
	 *
	 * @param data the two-dimensional array of store sales
	 * @return an array of the bonus for each store
	 */
	public static double[] calculateHolidayBonus(double[][] data) {
	    double[] bonus = new double[data.length];
	    
	    for (int row = 0; row < data.length; row++) {
	        
	        for (int col = 0; col < data[row].length; col++) {
	            double sales = data[row][col];
	            
	            if (sales <= 0) {
	                continue; // skip stores with negative sales or no sales in this category
	            }
	            
	            if (sales == TwoDimRaggedArrayUtility.getHighestInColumn(data, col)) {
	                bonus[row] += HIGH_BONUS;
	            } else if (sales == TwoDimRaggedArrayUtility.getLowestInColumn(data, col)) {
	                bonus[row] += LOW_BONUS;
	            } else {
	                bonus[row] += OTHER_BONUS;
	            }
	        }
	    }
	    
	    return bonus;
	}
	
	/**
	 * Calculates the total holiday bonuses
	 * @param data the two dimensional array of store sales
	 * @return the total of all holiday bonuses 
	 */
	public static double calculateTotalHolidayBonus(double[][] data) {
		
		double[] bonus = calculateHolidayBonus(data);
		double total = 0;
		
		for (int i = 0; i < bonus.length; i++) {
			total += bonus[i];
		}
		
		return total;
	}



}
