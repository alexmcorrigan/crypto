package com.alexcorrigan.crypto.utils;

import com.alexcorrigan.crypto.CipherUtils;
import junit.framework.TestCase;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestCipherUtils {

    @Test
    public void testLetterFromOffsetAlphabet() throws Exception {
        assertNextAlphabetChar('A', 0, 0);
        assertNextAlphabetChar('Z', 0, 25);
        assertNextAlphabetChar('B', 1, 0);
        assertNextAlphabetChar('A', 1, 25);
        assertNextAlphabetChar('Z', 25, 0);
        assertNextAlphabetChar('A', 25, 1);
        assertNextAlphabetChar('Y', 25, 25);
    }

    @Test
    public void testIndexOfLetterInOffsetAlphabet() throws Exception {
        TestCase.assertEquals(0, CipherUtils.indexOfLetterInOffsetAlphabet(0, 'A'));
        assertEquals(25, CipherUtils.indexOfLetterInOffsetAlphabet(1, 'A'));
        assertEquals(1, CipherUtils.indexOfLetterInOffsetAlphabet(25, 'A'));
    }

    @Test
    public void testCharToAlphabeticIndex() throws Exception {
        assertEquals(0, CipherUtils.charToAlphabeticIndex('A'));
        assertEquals(25, CipherUtils.charToAlphabeticIndex('Z'));
    }

    @Test
    public void testAlphabeticIndexToChar() throws Exception {
        assertEquals('A', CipherUtils.alphabeticIndexToChar(0));
        assertEquals('Z', CipherUtils.alphabeticIndexToChar(25));
    }

    private void assertNextAlphabetChar(char expected, int baseReference, int nextIndex) {
        assertEquals(expected, CipherUtils.letterAtIndexInOffsetAlphabet(baseReference, nextIndex));
    }
}
