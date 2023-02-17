import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradeBookTest {

	GradeBook book1;
	GradeBook book2;
	
	@Before
	public void setUp() throws Exception {
		book1 = new GradeBook(5);
		book1.addScore(50);
		book1.addScore(75);
		
		book2 = new GradeBook(5);
		book2.addScore(90);
		book2.addScore(10.5);
		book2.addScore(17.4);
	}

	@After
	public void tearDown() throws Exception {
		book1 = null;
		book2 = null;
	}

	@Test
	public void testAddScore() {
		assertTrue(book1.toString().equals("50.0 75.0 "));
		assertTrue(book2.toString().equals("90.0 10.5 17.4 "));
	}

	@Test
	public void testSum() {
		assertEquals(125, book1.sum(), .0001);
		assertEquals(117.9, book2.sum(), .0001);
	}

	@Test
	public void testMinimum() {
		assertEquals(50, book1.minimum(), .001);
		assertEquals(10.5, book2.minimum(), .001);
	}

	@Test
	public void testFinalScore() {
		assertEquals(75, book1.finalScore(), 0.001);
		assertEquals(107.4, book2.finalScore(), 0.001);
	}

	@Test
	public void testGetScoreSize() {
		assertEquals(2, book1.getScoreSize(), 0.001);
		assertEquals(3, book2.getScoreSize(), 0.001);
	}

	@Test
	public void testToString() {
	
	}

}
