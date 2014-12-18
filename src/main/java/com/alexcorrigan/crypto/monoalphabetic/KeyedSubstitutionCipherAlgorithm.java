package com.alexcorrigan.crypto.monoalphabetic;

import com.alexcorrigan.crypto.CipherAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.alexcorrigan.crypto.CipherUtils.isAlphabetCharacter;
import static com.alexcorrigan.crypto.CipherConstants.ALPHABET_UPPERCASE;

public class KeyedSubstitutionCipherAlgorithm implements CipherAlgorithm {

    private final Map<Character, Character> encipherLookupTable = new HashMap<Character, Character>();
    private final Map<Character, Character> decipherLookupTable = new HashMap<Character, Character>();

    public KeyedSubstitutionCipherAlgorithm(String key) {
        char[] alphabet = ALPHABET_UPPERCASE.toCharArray();
        char[] keyedAlphabet = buildKeyedAlphabet(key).toCharArray();
        for (int alphabetIndex = 0; alphabetIndex < alphabet.length; alphabetIndex++) {
            encipherLookupTable.put(alphabet[alphabetIndex], keyedAlphabet[alphabetIndex]);
            decipherLookupTable.put(keyedAlphabet[alphabetIndex], alphabet[alphabetIndex]);
        }
    }

    @Override
    public String encipher(String clearText) {
        return process(clearText, encipherLookupTable);
    }

    @Override
    public String decipher(String cipherText) {
        return process(cipherText, decipherLookupTable);
    }

    private String process(String textIn, Map<Character, Character> lookupTable) {
        char[] textInChars = textIn.toUpperCase().toCharArray();
        char[] textOutChars = new char[textInChars.length];
        for (int textInIndex = 0; textInIndex < textInChars.length; textInIndex ++) {
            char textInChar = textInChars[textInIndex];
            if (isAlphabetCharacter(textInChar)) {
                textOutChars[textInIndex] = lookupTable.get(textInChar);
            } else {
                textOutChars[textInIndex] = textInChar;
            }
        }
        return new String(textOutChars);
    }

    private String buildKeyedAlphabet(String key) {
        key = key.toUpperCase();
        List<Character> keyedAlphabetChars = new ArrayList<Character>();
        addKeyCharsToKeyedAlphabet(key, keyedAlphabetChars);
        addAlphabetCharsToKeyedAlphabetList(keyedAlphabetChars);
        StringBuilder keyedAlphabetBuilder = new StringBuilder();
        for (Character keyedAlphabetChar : keyedAlphabetChars) {
            keyedAlphabetBuilder.append(keyedAlphabetChar);
        }
        String keyedAlphabet = keyedAlphabetBuilder.toString();
        return keyedAlphabet;
    }

    private void addAlphabetCharsToKeyedAlphabetList(List<Character> keyedAlphabetChars) {
        for (char alphaChar : ALPHABET_UPPERCASE.toCharArray()) {
            if (keyedAlphabetChars.size() == 26) {
                break;
            } else {
                addCharToListIfNotAlreadyPresent(keyedAlphabetChars, alphaChar);
            }
        }
    }

    private void addKeyCharsToKeyedAlphabet(String key, List<Character> keyedAlphabetChars) {
        for (char keyChar : key.toCharArray()) {
            addCharToListIfNotAlreadyPresent(keyedAlphabetChars, keyChar);
        }
    }

    private void addCharToListIfNotAlreadyPresent(List<Character> keyedAlphabetChars, char keyChar) {
        if (!keyedAlphabetChars.contains(keyChar)) {
            keyedAlphabetChars.add(keyChar);
        }
    }

}
