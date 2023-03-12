import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CryptoManagerTestStudent {
	CryptoManager cryptoManager;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
    public void testStringInBounds() {
        assertEquals(true, CryptoManager.isStringInBounds("HELLO_WORLD"));
        assertEquals(false, CryptoManager.isStringInBounds("Hello, world!"));
    }

    @Test
    public void testEncryptCaesar() {
        assertEquals("KHOOR#ZRUOG", CryptoManager.caesarEncryption("HELLO WORLD", 3));
        assertEquals("MJQQT%\\TWQI", CryptoManager.caesarEncryption("HELLO WORLD", 5));
        assertEquals("HELLO WORLD", CryptoManager.caesarEncryption("HELLO WORLD", 0));
    }

    @Test
    public void testDecryptCaesar() {
        assertEquals("HELLO WORLD", CryptoManager.caesarDecryption("KHOOR#ZRUOG", 3));
        assertEquals("HELLO WORLD", CryptoManager.caesarDecryption("MJQQT%\\TWQI", 5));
        assertEquals("HELLO WORLD", CryptoManager.caesarDecryption("HELLO WORLD", 0));
    }

    @Test
    public void testEncryptBellaso() {
        assertEquals("PJXX^(\\[^[L", CryptoManager.bellasoEncryption("HELLO WORLD", "HELLO"));
        assertEquals("IGOPP\"ZSSNG", CryptoManager.bellasoEncryption("HELLO WORLD", "ABCD"));
        assertEquals("KR_OR-*RUYW", CryptoManager.bellasoEncryption("HELLO WORLD", "CMSC"));
    }

    @Test
    public void testDecryptBellaso() {
        assertEquals("HELLO WORLD", CryptoManager.bellasoDecryption("PJXX^(\\[^[L", "HELLO"));
        assertEquals("HELLO WORLD", CryptoManager.bellasoDecryption("IGOPP\"ZSSNG", "ABCD"));
        assertEquals("HELLO WORLD", CryptoManager.bellasoDecryption("KR_OR-*RUYW", "CMSC"));
    }


}
