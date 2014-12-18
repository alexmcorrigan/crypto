package com.alexcorrigan.crypto.monoalphabetic;

import org.junit.Test;

import static com.alexcorrigan.crypto.AssertCipher.assertSubstitutionCipher;
import static com.alexcorrigan.crypto.AssertCipher.assertSubstitutionCipherCasePreserved;
import static com.alexcorrigan.crypto.CipherFactory.rot13Cipher;
import static com.alexcorrigan.crypto.CipherFactory.rot47Cipher;
import static com.alexcorrigan.crypto.CipherFactory.rot5Cipher;
import static com.alexcorrigan.crypto.TestConstants.CLEAR_TEXT_SENTENCE;

public class TestROTCiphers {

    @Test
    public void testROT5() throws Exception {
        assertSubstitutionCipher(rot5Cipher(), "1234567890", "6789012345");
    }

    @Test
    public void testROT13() throws Exception {
        assertSubstitutionCipher(rot13Cipher(), CLEAR_TEXT_SENTENCE, "GUR DHVPX OEBJA SBK WHZCF BIRE GUR YNML QBT.");
    }

    @Test
    public void testROT47() throws Exception {
        assertSubstitutionCipherCasePreserved(rot47Cipher(), CLEAR_TEXT_SENTENCE, "%wt \"&xrz q#~(} u~) y&|!$ ~'t# %wt {p+* s~v]");
    }

}
