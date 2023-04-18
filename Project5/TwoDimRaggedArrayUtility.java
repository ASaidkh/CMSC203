/*
 * Class: CMSC203
 * Instructor: Gary Thai
 * Description: Utility class that handles calculation for a two dimensional ragged array
 * Due: 04/23/2023
 * Platform/Compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Alim Saidkhodjaev M21111105
 */

import java.io.*;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {

	/**
	 * Reads from a file and returns a ragged array of doubles.
	 * The maximum rows is 10 and the maximum columns for each row is 10.
	 * Each row in the file is separated by a new line, and each element in the row is separated by a space.
	 * 
	 * @param file the file to read from
	 * @return a two-dimensional ragged (depending on data) array of doubles if the file is not empty, returns a null if file is empty
	 * @throws FileNotFoundException if the file is not found
	 */
	public static double[][] readFile(File file) throws FileNotFoundException {
	    // Create a Scanner to read from the file
	    Scanner scanner = new Scanner(file);

	    // Create a temporary array of Strings to hold the data
	    String[][] temp = new String[10][10];

	    // Read the data from the file into the temporary array
	    int numRows = 0;
	    while (scanner.hasNextLine() && numRows < 10) {
	        String line = scanner.nextLine();
	        String[] tokens = line.split(" ");
	        int numCols = 0;
	        for (String token : tokens) {
	            if (numCols < 10) {
	                temp[numRows][numCols] = token;
	                numCols++;
	            }
	        }
	        numRows++;
	    }

	    // Create the ragged array based on the number of rows
	    double[][] array = new double[numRows][];
	    for (int i = 0; i < numRows; i++) {
	        // Determine the number of columns for the current row
	        int numCols = 0;
	        while (numCols < 10 && temp[i][numCols] != null) {
	            numCols++;
	        }
	        // Create the row and put the values from the temporary array into it
	        array[i] = new double[numCols];
	        for (int j = 0; j < numCols; j++) {
	            array[i][j] = Double.parseDouble(temp[i][j]);
	        }
	    }

	    // Close the Scanner and return the ragged array
	    scanner.close();
	    return array;
	    
	    
	}
	
	/**
	 * Writes the ragged array of doubles into the file. Each row is on a separate line within the file and each double is separated by a space.
	 * 
	 * @param data the two-dimensional ragged array of doubles to write to the file
	 * @param outputFile the file to write to
	 * @throws FileNotFoundException if the outputFile is not valid
	 */
	public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
	    // Create a PrintWriter to write to the file
	    PrintWriter writer = new PrintWriter(outputFile);

	    // Write each row of the data to the file
	    for (int i = 0; i < data.length; i++) {
	        for (int j = 0; j < data[i].length; j++) {
	            writer.print(data[i][j]);
	            if (j < data[i].length - 1) {
	                writer.print(" ");
	            }
	        }
	        writer.println();
	    }

	    // Close the PrintWriter
	    writer.close();
	}
	
	/**
	 * Returns the total of all the elements of the two-dimensional array.
	 * 
	 * @param data the two-dimensional array to get the total of
	 * @return the sum of all the elements in the two-dimensional array
	 */
	public static double getTotal(double[][] data) {
	    double total = 0;

	    // Sum all elements in the array
	    for (int i = 0; i < data.length; i++) {
	        for (int j = 0; j < data[i].length; j++) {
	            total += data[i][j];
	        }
	    }

	    return total;
	}
	
	/**
	 * Returns the average of the elements in the two-dimensional array.
	 * 
	 * @param data the two-dimensional array to get the average of
	 * @return the average of the elements in the two-dimensional array (total of elements/number of elements)
	 */
	public static double getAverage(double[][] data) {
	    double sum = 0;
	    int count = 0;
	    
	    for (int i = 0; i < data.length; i++) {
	        for (int j = 0; j < data[i].length; j++) {
	            sum += data[i][j];
	            count++;
	        }
	    }
	    
	    return sum / count;
	}


	/**
	 * Returns the total of the selected row in the two-dimensional array.
	 * 
	 * @param data the two-dimensional array
	 * @param row the row index to take the total of (0 refers to the first row)
	 * @return the total of the row
	 */
	public static double getRowTotal(double[][] data, int row) {
	    double sum = 0;
	    
	    for (int i = 0; i < data[row].length; i++) {
	        sum += data[row][i];
	    }
	    
	    return sum;
	}

	/**
	 * Returns the total of the selected column in the two-dimensional array.
	 * If a row in the two-dimensional array doesn't have this column index, it is not an error, 
	 * it doesn't participate in this method.
	 * 
	 * @param data the two-dimensional array
	 * @param col the column index to take the total of (0 refers to the first column)
	 * @return the total of the column
	 */
	public static double getColumnTotal(double[][] data, int col) {
	    double sum = 0;
	    
	    for (int i = 0; i < data.length; i++) {
	        if (col < data[i].length) {
	            sum += data[i][col];
	        }
	    }
	    
	    return sum;
	}

	/**
	 * Returns the largest element of the selected row in the two dimensional array. Index 0 refers to the first row.
	 *
	 * @param data the two dimensional array
	 * @param row the row index to find the largest element of (0 refers to the first row)
	 * @return the largest element of the row
	 */
	public static double getHighestInRow(double[][] data, int row) {
	    double highest = Double.NEGATIVE_INFINITY;
	    for (int i = 0; i < data[row].length; i++) {
	        if (data[row][i] > highest) {
	            highest = data[row][i];
	        }
	    }
	    return highest;
	}

	/**
	 * Returns the index of the largest element in the selected row of the two dimensional array.
	 * Index 0 refers to the first row.
	 * If there are multiple occurrences of the largest element, the index of the first occurrence is returned.
	 *
	 * @param data the two dimensional array
	 * @param row  the row index to find the largest element of (0 refers to the first row)
	 * @return the index of the largest element of the row
	 */
	public static int getHighestInRowIndex(double[][] data, int row) {
	    int highestIndex = 0;
	    double highestValue = data[row][0];
	    
	    for (int i = 1; i < data[row].length; i++) {
	        if (data[row][i] > highestValue) {
	            highestValue = data[row][i];
	            highestIndex = i;
	        }
	    }
	    
	    return highestIndex;
	}


	/**
	 * Returns the smallest element of the selected row in the two dimensional array, where index 0 refers to the first row.
	 * If the row index is invalid, returns Double.MAX_VALUE.
	 *
	 * @param data the two dimensional array
	 * @param row the row index to find the smallest element of (0 refers to the first row)
	 * @return the smallest element of the row or Double.MAX_VALUE if the row index is invalid.
	 */
	public static double getLowestInRow(double[][] data, int row) {
	    
	    double min = data[row][0];
	    for (int col = 1; col < data[row].length; col++) {
	        if (data[row][col] < min) {
	            min = data[row][col];
	        }
	    }
	    return min;
	}
	
	/**
	 * Returns the index of the smallest element of the selected row in the two dimensional array
	 * where index 0 refers to the first row.
	 *
	 * @param data the two dimensional array
	 * @param row the row index to find the smallest element of (0 refers to the first row)
	 * @return the index of the smallest element of the row
	 */
	public static int getLowestInRowIndex(double[][] data, int row) {
	    int minIndex = 0;
	    for (int i = 1; i < data[row].length; i++) {
	        if (data[row][i] < data[row][minIndex]) {
	            minIndex = i;
	        }
	    }
	    return minIndex;
	}


	/**
	 * Returns the largest element of the selected column in the two dimensional array index 0 refers to the first column.
	 * If a row in the two dimensional array doesn't have this column index, it is not an error, it doesn't participate in this method.
	 *
	 * @param data the two dimensional array
	 * @param col  the column index to find the largest element of (0 refers to the first column)
	 * @return the largest element of the column
	 */
	public static double getHighestInColumn(double[][] data, int col) {
	   
	    double max = Double.NEGATIVE_INFINITY;
	    
	    for (int row = 0; row < data.length; row++) {
	        // Check if the column index exists in this row
	        if (col < data[row].length) {
	            // Update max if this element is larger than the current max
	            if (data[row][col] > max) {
	                max = data[row][col];
	            }
	        }
	    }
	    return max;
	}

	/**
	 * Returns the index of the largest element of the selected column in the two dimensional array. Index 0 refers to the first column.
	 * If a row in the two dimensional array doesn't have this column index, it is not an error, it doesn't participate in this method.
	 *
	 * @param data the two dimensional array
	 * @param col  the column index to find the largest element of (0 refers to the first column)
	 * @return the index of the largest element of the column
	 */
	public static int getHighestInColumnIndex(double[][] data, int col) {
		
	    int maxIndex = 0;
	    
	    for (int i = 0; i < data.length; i++) {
	        if (data[i].length > col && data[i][col] == getHighestInColumn(data, col)) {
	            maxIndex = i;
	        }
	    }
	    return maxIndex;
	}
	
	/**
	 * Returns the smallest element of the selected column in the two dimensional array
	 * index 0 refers to the first column. If a row in the two dimensional array doesn't
	 * have this column index, it is not an error, it doesn't participate in this method.
	 *
	 * @param data the two dimensional array
	 * @param col  the column index to find the smallest element of (0 refers to the first column)
	 * @return the smallest element of the column
	 */
	public static double getLowestInColumn(double[][] data, int col) {
	    double lowest = Double.POSITIVE_INFINITY;
	    for (double[] row : data) {
	        if (col < row.length && row[col] < lowest) {
	            lowest = row[col];
	        }
	    }
	    return lowest;
	}

	/**
	 * Returns the index of the smallest element of the selected column in the two dimensional array.
	 * Index 0 refers to the first column. If a row in the two dimensional array doesn't have this column index,
	 * it is not an error, it doesn't participate in this method.
	 *
	 * @param data the two dimensional array
	 * @param col  the column index to find the smallest element of (0 refers to the first column)
	 * @return the index of the smallest element of the column
	 */
	public static int getLowestInColumnIndex(double[][] data, int col) {
		int minIndex = 0;
	    for (int i = 0; i < data.length; i++) {
	        if (data[i].length > col && data[i][col] == getLowestInColumn(data, col)) {
	            minIndex = i;
	        }
	    }
	    return minIndex;
	}

	/**
	 * Returns the largest element in the two-dimensional array.
	 *
	 * @param data the two-dimensional array.
	 * @return the largest element in the array.
	 */
	public static double getHighestInArray(double[][] data) {
	    double highest = data[0][0];
	    for (int row = 0; row < data.length; row++) {
	        for (int col = 0; col < data[row].length; col++) {
	            if (data[row][col] > highest) {
	                highest = data[row][col];
	            }
	        }
	    }
	    return highest;
	}

	/**
	 * Returns the smallest element in the two dimensional array.
	 *
	 * @param data the two dimensional array
	 * @return the smallest element in the array
	 */
	public static double getLowestInArray(double[][] data) {
	    double lowest = Double.POSITIVE_INFINITY;
	    for (double[] row : data) {
	        for (double element : row) {
	            if (element < lowest) {
	                lowest = element;
	            }
	        }
	    }
	    return lowest;
	}


}
