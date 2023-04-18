import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class TwoDimRaggedArrayUtilityTestStudent {
	
	double [][] testData = new double[][]{
        {1253.65, 4.50, 2154.36, 7532.45, 3388.44},
        {2876.22, -3.24, 1954.66},
        {4896.23, 2.29, 5499.29},
        {2256.76, 3.76, 4286.29, 5438.48, 3794.43},
        {3184.38, 3654.65, 3455.76, 6387.23, 4265.77, 4592.45},
        {2657.46, 3265.34, 2256.38, 8935.26, 5287.34, 6598.23}};
		

	@Test
	void testReadFile() throws FileNotFoundException {
		File file = new File("district4.txt");
		double[][] result = TwoDimRaggedArrayUtility.readFile(file);
		for (int i = 0; i < testData.length; i ++) {
			for (int j = 0; j < testData[i].length; j++) {
				assertEquals(testData[i][j], result[i][j]);
			}
		}
	}

	@Test
	void testWriteToFile() throws IOException {
		  
        // Create a temporary file for testing
        File tempFile = File.createTempFile("test", ".txt");

        // Write the test data to the file
        TwoDimRaggedArrayUtility.writeToFile(testData, tempFile);

        // Read the data from the file and compare it to the test data
        Scanner scanner = new Scanner(tempFile);
        double[][] resultData = new double[testData.length][];
        int i = 0;
        while (scanner.hasNextLine()) {
            String[] lineData = scanner.nextLine().split(" ");
            resultData[i] = new double[lineData.length];
            for (int j = 0; j < lineData.length; j++) {
                resultData[i][j] = Double.parseDouble(lineData[j]);
            }
            i++;
        }
        scanner.close();

        assertEquals(testData.length, resultData.length);
        for (i = 0; i < testData.length; i++) {
            assertEquals(testData[i].length, resultData[i].length);
            for (int j = 0; j < testData[i].length; j++) {
                assertEquals(testData[i][j], resultData[i][j], 0.0001);
            }
        }

        // Delete the temporary file
        tempFile.delete();
    }
	

	@Test
	void testGetTotal() {
		double expectedTotal = 99878.82;
		assertEquals(expectedTotal, TwoDimRaggedArrayUtility.getTotal(testData), 0.01);
	}

	@Test
	void testGetAverage() {
		double expectedAverage = 3567.10;
		assertEquals(expectedAverage, TwoDimRaggedArrayUtility.getAverage(testData), 0.01);
	}

	@Test
	void testGetRowTotal() {
		double[] expected = {14333.4, 4827.64, 10397.81, 15779.72, 25540.24, 29000.01};

	    for (int i = 0; i < testData.length; i++) {
	        double result = TwoDimRaggedArrayUtility.getRowTotal(testData, i);
	        assertEquals(expected[i], result, 0.001);
	    }
	}

	@Test
	void testGetColumnTotal() {
		double[] expected = {17124.7, 6927.3, 19606.74, 28293.42, 16735.98, 11190.68};
	    for (int j = 0; j < expected.length; j++) {
	        assertEquals(expected[j], TwoDimRaggedArrayUtility.getColumnTotal(testData, j), 0.001);
	    }
	}

	@Test
	void testGetHighestInRow() {
		double[] expected = {7532.45, 2876.22, 5499.29, 5438.48, 6387.23, 8935.26};
	    
	    for (int i = 0; i < testData.length; i++) {
	        double result = TwoDimRaggedArrayUtility.getHighestInRow(testData, i);
	        assertEquals(expected[i], result, 0.01);
	    }
	}

	@Test
	void testGetHighestInRowIndex() {
		int[] expected = {3, 0, 2, 3, 3, 3};
	    
	    for (int i = 0; i < testData.length; i++) {
	        int result = TwoDimRaggedArrayUtility.getHighestInRowIndex(testData, i);
	        assertEquals(expected[i], result);
	    }
	}

	@Test
	void testGetLowestInRow() {
		double[] expected = {4.50, -3.24, 2.29, 3.76, 3184.38, 2256.38};
	    
	    for (int i = 0; i < testData.length; i++) {
	        double result = TwoDimRaggedArrayUtility.getLowestInRow(testData, i);
	        assertEquals(expected[i], result, 0.01);
	    }
	}

	@Test
	void testGetLowestInRowIndex() {
		int[] expected = {1, 1, 1, 1, 0, 2};
	    
	    for (int i = 0; i < testData.length; i++) {
	        int result = TwoDimRaggedArrayUtility.getLowestInRowIndex(testData, i);
	        assertEquals(expected[i], result);
	    }
	}

	@Test
	void testGetHighestInColumn() {
		double[] expected = {4896.23, 3654.65, 5499.29, 8935.26, 5287.34, 6598.23};
		
		for (int i = 0; i < 6; i ++) {
			double result = TwoDimRaggedArrayUtility.getHighestInColumn(testData, i);
			assertEquals(expected[i], result);
		}
	}

	@Test
	void testGetHighestInColumnIndex() {
		int[] expected = {2, 4, 2, 5, 5, 5};
	    
	    for (int i = 0; i < 6; i++) {
	        int result = TwoDimRaggedArrayUtility.getHighestInColumnIndex(testData, i);
	        assertEquals(expected[i], result);
	    }
	}

	@Test
	void testGetLowestInColumn() {
		double[] expected = {1253.65, -3.24, 1954.66, 5438.48, 3388.44, 4592.45};
		
		for (int i = 0; i < 6; i ++) {
			double result = TwoDimRaggedArrayUtility.getLowestInColumn(testData, i);
			assertEquals(expected[i], result);
		}
	}

	@Test
	void testGetLowestInColumnIndex() {
		int[] expected = {0, 1, 1, 3, 0, 4};
	    
	    for (int i = 0; i < 6; i++) {
	        int result = TwoDimRaggedArrayUtility.getLowestInColumnIndex(testData, i);
	        assertEquals(expected[i], result);
	    }
	}

	@Test
	void testGetHighestInArray() {
		assertEquals(8935.26, TwoDimRaggedArrayUtility.getHighestInArray(testData), 0.01);
	}

	@Test
	void testGetLowestInArray() {
		assertEquals(-3.24, TwoDimRaggedArrayUtility.getLowestInArray(testData), 0.01);
	}

}
