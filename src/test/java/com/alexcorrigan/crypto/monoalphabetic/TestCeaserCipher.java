package com.alexcorrigan.crypto.monoalphabetic;

import org.junit.Test;

import static com.alexcorrigan.crypto.AssertCipher.assertSubstitutionCipher;
import static com.alexcorrigan.crypto.CipherFactory.ceaserCipher;
import static com.alexcorrigan.crypto.TestConstants.CLEAR_TEXT_SENTENCE;

public class TestCeaserCipher {

    @Test
    public void substitutionCipherWithOffset() throws Exception {
        assertCeaserCipherWithOffset(0, CLEAR_TEXT_SENTENCE, CLEAR_TEXT_SENTENCE);
        assertCeaserCipherWithOffset(1, CLEAR_TEXT_SENTENCE, "UIF RVJDL CSPXO GPY KVNQT PWFS UIF MBAZ EPH.");
        assertCeaserCipherWithOffset(2, CLEAR_TEXT_SENTENCE, "VJG SWKEM DTQYP HQZ LWORU QXGT VJG NCBA FQI.");
        assertCeaserCipherWithOffset(3, CLEAR_TEXT_SENTENCE, "WKH TXLFN EURZQ IRA MXPSV RYHU WKH ODCB GRJ.");
        assertCeaserCipherWithOffset(26, CLEAR_TEXT_SENTENCE, CLEAR_TEXT_SENTENCE);
        assertCeaserCipherWithOffset(27, CLEAR_TEXT_SENTENCE, "UIF RVJDL CSPXO GPY KVNQT PWFS UIF MBAZ EPH.");
    }
    
    private void assertCeaserCipherWithOffset(int offset, String clearText, String cipherText) {
        assertSubstitutionCipher(ceaserCipher(offset), clearText, cipherText);
    }

}
