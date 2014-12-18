package com.alexcorrigan.crypto.polyalphabetic;

import com.alexcorrigan.crypto.Cipher;
import com.alexcorrigan.crypto.CipherAlgorithm;

public class VigenereCipher implements Cipher {

    private CipherAlgorithm algorithm;

    public VigenereCipher(String key) {
        algorithm = new VigenereCipherAlgorithm(key);
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
