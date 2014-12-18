package com.alexcorrigan.crypto.polyalphabetic;

import com.alexcorrigan.crypto.CipherFactory;
import org.junit.Test;

import static com.alexcorrigan.crypto.AssertCipher.assertSubstitutionCipher;
import static com.alexcorrigan.crypto.TestConstants.CLEAR_TEXT_SENTENCE;

public class TestVigenereCipher {

    private static final String KEY = "LEMON";

    @Test
    public void testVigenereCipher() throws Exception {
        assertSubstitutionCipher(CipherFactory.vigenereCipher(KEY), "ATTACKATDAWN", "LXFOPVEFRNHR");
        assertSubstitutionCipher(CipherFactory.vigenereCipher(KEY), CLEAR_TEXT_SENTENCE, "ELQ EHTGW PEZAZ TBI NGACD SHSE ELQ ZNKC PCT.");
    }
}
