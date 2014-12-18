package com.alexcorrigan.crypto.monoalphabetic;

import com.alexcorrigan.crypto.Cipher;
import com.alexcorrigan.crypto.CipherAlgorithm;

public class CeaserCipher implements Cipher {

    private final CipherAlgorithm algorithm;

    public CeaserCipher(int offset, int asciiSetStart, int asciiSetEnd) {
        algorithm = new CeaserCipherAlgorithm(asciiSetStart, asciiSetEnd, offset);
    }

    @Override
    public String encipher(String clearText) {
        String cipherText = algorithm.encipher(clearText);
        return cipherText;
    }

    @Override
    public String decipher(String cipherText) {
        String clearText = algorithm.decipher(cipherText);
        return clearText;
    }

}
