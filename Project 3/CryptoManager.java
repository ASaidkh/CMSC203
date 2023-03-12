/*
 * Class: CMSC203
 * Instructor: Gary Thai
 * Description: Encrypts or decrypts text using either a Caesar Cipher or Giovan Battista Bellaso. 
 * Due: 03/24/2023
 * Platform/Compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Alim Saidkhodjaev M21111105
 */

public class CryptoManager {
    
    private static final char LOWER_RANGE = ' ';
    private static final char UPPER_RANGE = '_';
    private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

    /**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
    public static boolean isStringInBounds(String plainText) {
        for (int i = 0; i < plainText.length(); i++ ) {
        	if (plainText.charAt(i) < LOWER_RANGE || plainText.charAt(i) > UPPER_RANGE) 
        		return false;
        }
        return true;
    }

    /**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
    public static String caesarEncryption(String plainText, int key) {
        if (!isStringInBounds(plainText)) {
            return "The selected string is not in bounds, Try again.";
        }
        
        String encryptedText = "";
        for (int i = 0; i < plainText.length(); i++ ) {
            int encryptedChar = (plainText.charAt(i) - LOWER_RANGE + key) % RANGE + LOWER_RANGE;
            encryptedText += (char) encryptedChar;
        }
        return encryptedText;
    }

    /**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
    public static String caesarDecryption(String encryptedText, int key) {
        String decryptedText = "";
        for (int i = 0; i < encryptedText.length(); i++ ) {
            int decryptedChar = ((encryptedText.charAt(i) - LOWER_RANGE - key) % RANGE + RANGE) % RANGE + LOWER_RANGE;
            decryptedText += (char) decryptedChar;
        }
        return decryptedText;
    }


    /**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
    public static String bellasoEncryption(String plainText, String bellasoStr) {
        String encryptedText = "";

        // Extend key to length of plaintext
        String extendedKey = "";
        int keyLength = bellasoStr.length();
        for (int i = 0; i < plainText.length(); i++) {
            extendedKey += bellasoStr.charAt(i % keyLength);
        }

        // Encrypt each character in the plaintext
        for (int i = 0; i < plainText.length(); i++) {
            char plainChar = plainText.charAt(i);
            char keyChar = extendedKey.charAt(i);
            int offset = ((int) keyChar) % RANGE; // calculate offset
            int encryptedChar = ((int) plainChar + offset) % RANGE + RANGE; // apply offset
            if ((int) encryptedChar > UPPER_RANGE) {
            	encryptedChar = (char)((int) encryptedChar - RANGE);
            }
            encryptedText += (char) encryptedChar; // append encrypted char to result
        }

        return encryptedText;
    }

    /**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
    public static String bellasoDecryption(String encryptedText, String bellasoStr) {
        String extendedKey = "";
        int keyLength = bellasoStr.length();
        for (int i = 0; i < encryptedText.length(); i++) {
            extendedKey += bellasoStr.charAt(i % keyLength);
        }
        
        String decryptedText = "";
        for (int i = 0; i < encryptedText.length(); i++) {
            char encryptedChar = encryptedText.charAt(i);
            char keyChar = extendedKey.charAt(i);
            int offset = ((int) keyChar) % RANGE; // calculate offset
            int decryptedChar = ((int) encryptedChar - offset) % RANGE; // apply offset
            if (decryptedChar < LOWER_RANGE) {
                decryptedChar += RANGE;
            }
            decryptedText += (char) decryptedChar; // append decrypted char to result
        }
        return decryptedText;
    }

}

    





