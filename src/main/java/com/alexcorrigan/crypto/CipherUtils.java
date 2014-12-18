package com.alexcorrigan.crypto;

import static com.alexcorrigan.crypto.CipherConstants.ALPHABET_UPPERCASE;
import static com.alexcorrigan.crypto.CipherConstants.ALPHA_ASCII_START;

public class CipherUtils {

    public static boolean isAlphabetCharacter(char character) {
        return character >= 'A' && character <= 'Z';
    }

    public static char letterAtIndexInOffsetAlphabet(int offset, int index) {
        int effectiveIndex;
        if (index + offset > 25) {
            effectiveIndex = index + offset - 26;
        } else {
            effectiveIndex = index + offset;
        }
        return ALPHABET_UPPERCASE.toCharArray()[effectiveIndex];
    }

    public static int indexOfLetterInOffsetAlphabet(int offset, char letter) {
        for (int index = 0; index < 26; index++) {
            if (letterAtIndexInOffsetAlphabet(offset, index) == letter) {
                return index;
            }
        }
        return -1;
    }

    public static int charToAlphabeticIndex(char character) {
        int i = character - ALPHA_ASCII_START;
        return i;
    }

    public static char alphabeticIndexToChar(int alphabeticIndex) {
        return (char)(alphabeticIndex + ALPHA_ASCII_START);
    }

}
