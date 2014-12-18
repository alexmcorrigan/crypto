package com.alexcorrigan.crypto.polyalphabetic;

import com.alexcorrigan.crypto.CipherAlgorithm;

import static com.alexcorrigan.crypto.CipherUtils.*;

public class VigenereCipherAlgorithm implements CipherAlgorithm{

    private final char[] keyChars;

    public VigenereCipherAlgorithm(String key) {
        keyChars = key.toCharArray();
    }

    @Override
    public String encipher(String clearText) {
        char[] clearTextChars = clearText.toCharArray();
        char[] cipherText = new char[clearTextChars.length];
        int keyCharCounter = 0;
        for (int clearTextCharIndex = 0; clearTextCharIndex < clearTextChars.length; clearTextCharIndex++) {
            char clearTextChar = clearTextChars[clearTextCharIndex];
            if (isAlphabetCharacter(clearTextChar)) {
                int clearTextCharAlphaIndex = charToAlphabeticIndex(clearTextChar);
                int keyCharAlphaIndex = charToAlphabeticIndex(keyChars[keyCharCounter % keyChars.length]);
                cipherText[clearTextCharIndex] = letterAtIndexInOffsetAlphabet(keyCharAlphaIndex, clearTextCharAlphaIndex);
                keyCharCounter++;
            } else {
                cipherText[clearTextCharIndex] = clearTextChar;
            }
        }
        return new String(cipherText);
    }

    @Override
    public String decipher(String cipherText) {
        char[] cipherTextChars = cipherText.toCharArray();
        char[] clearTextChars = new char[cipherTextChars.length];
        int keyCharIndex = 0;
        for (int cipherTextCharIndex = 0; cipherTextCharIndex < cipherTextChars.length; cipherTextCharIndex++) {
            char cipherTextChar = cipherTextChars[cipherTextCharIndex];
            if (isAlphabetCharacter(cipherTextChar)) {
                int keyCharAlphaIndex = charToAlphabeticIndex(keyChars[keyCharIndex % keyChars.length]);
                int alphaIndexOfClearTextChar = indexOfLetterInOffsetAlphabet(keyCharAlphaIndex, cipherTextChar);
                clearTextChars[cipherTextCharIndex] = alphabeticIndexToChar(alphaIndexOfClearTextChar);
                keyCharIndex++;
            } else {
                clearTextChars[cipherTextCharIndex] = cipherTextChar;
            }
        }
        return new String(clearTextChars);
    }

}
