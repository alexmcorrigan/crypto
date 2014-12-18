package com.alexcorrigan.crypto;

import static junit.framework.TestCase.assertEquals;

public class AssertCipher {

    public static void assertSubstitutionCipher(Cipher cipher, String clearText, String cipherText) {
        assertEquals(cipherText, cipher.encipher(clearText));
        assertEquals(clearText.toUpperCase(), cipher.decipher(cipherText));
    }

    public static void assertSubstitutionCipherCasePreserved(Cipher cipher, String clearText, String cipherText) {
        assertEquals(cipherText, cipher.encipher(clearText));
        assertEquals(clearText, cipher.decipher(cipherText));
    }

}
