package com.alexcorrigan.crypto.monoalphabetic;

import com.alexcorrigan.crypto.Cipher;
import com.alexcorrigan.crypto.CipherAlgorithm;

public class KeyedSubstitutionCipher implements Cipher {

    private final CipherAlgorithm algorithm;

    public KeyedSubstitutionCipher(String key) {
        algorithm = new KeyedSubstitutionCipherAlgorithm(key);
    }

    @Override
    public String encipher(String clearText) {
        return algorithm.encipher(clearText);
    }

    @Override
    public String decipher(String cipherText) {
        return algorithm.decipher(cipherText);
    }
}
