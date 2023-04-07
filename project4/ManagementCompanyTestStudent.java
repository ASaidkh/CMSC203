import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class ManagementCompanyTestStudent {
	
	private ManagementCompany managementCompany;
    private Property prop1;
    private Property prop2;
    private Property prop3;
	
	@BeforeEach
	void setUp() throws Exception {
		 // Initialize the managementCompany object and three properties
        managementCompany = new ManagementCompany("SomeCompany", "12345", 5);
        prop1 = new Property("House1", "SomeCity", 1000, "Bob");
        prop2 = new Property("House2", "SomeCity", 2000, "Dave");
        prop3 = new Property("House3", "SomeCity", 3000, "Frank");
        
        // Add the three properties to the managementCompany object
        managementCompany.addProperty(prop1);
        managementCompany.addProperty(prop2);
        managementCompany.addProperty(prop3);
	}

	@AfterEach
	void tearDown() throws Exception {
		// Set all objects to null to free memory
        managementCompany = null;
        prop1 = null;
        prop2 = null;
        prop3 = null;
	}

	@Test
	void testIsPropertiesFull() {
		assertFalse(managementCompany.isPropertiesFull());
	}

	@Test
	void testGetPropertiesCount() {
		assertEquals(managementCompany.getPropertiesCount(), 3);
	}

	@Test
	void testGetTotalRent() {
		 double expectedTotalRent = prop1.getRentAmount() + prop2.getRentAmount() + prop3.getRentAmount();
		 assertEquals(expectedTotalRent, managementCompany.getTotalRent(), 0.001);
	}

	@Test
	void testGetHighestRentPropperty() {
		assertEquals("House3", managementCompany.getHighestRentPropperty().getPropertyName());
	}

	@Test
	void testIsMangementFeeValid() {
		assertTrue(managementCompany.isMangementFeeValid());
	}

	@Test
	void testGetName() {
		assertEquals("SomeCompany", managementCompany.getName());
	}

	@Test
	void testGetTaxID() {
		assertEquals("12345", managementCompany.getTaxID());
	}

	
	@Test
	void testGetMgmFeePer() {
		assertEquals(managementCompany.getMgmFeePer(), 5, 0.0001);
	}

	

	@Test
	void testToString() {
		String expectedOutput = "ManagementCompany: SomeCompany\n" + "Tax ID: 12345\n" + "House1,SomeCity,Bob,1000\n" + "House2,SomeCity,Dave,2000\n" + "House3,SomeCity,Frank,3000\n" + "Total Fee:300";
		assertEquals(expectedOutput, managementCompany.toString());
	}

}
