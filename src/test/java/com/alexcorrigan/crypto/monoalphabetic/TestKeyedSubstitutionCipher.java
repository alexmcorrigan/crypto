package com.alexcorrigan.crypto.monoalphabetic;

import org.junit.Test;

import static com.alexcorrigan.crypto.AssertCipher.assertSubstitutionCipher;
import static com.alexcorrigan.crypto.CipherFactory.keyedSubstitutionCipher;
import static com.alexcorrigan.crypto.TestConstants.CLEAR_TEXT_SENTENCE;

public class TestKeyedSubstitutionCipher {

    private static final String KEY = "mockingbird";

    @Test
    public void testName() throws Exception {
        assertSubstitutionCipher(keyedSubstitutionCipher(KEY), CLEAR_TEXT_SENTENCE, "TBI PURCA OQJWH NJX DUFLS JVIQ TBI EMZY KJG.");
    }
}
