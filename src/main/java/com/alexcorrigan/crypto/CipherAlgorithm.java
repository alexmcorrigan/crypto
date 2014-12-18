package com.alexcorrigan.crypto;

public interface CipherAlgorithm {

    public String encipher(String clearText);
    public String decipher(String cipherText);

}
