package com.alexcorrigan.crypto;

public interface Cipher {

    public String encipher(String clearText);
    public String decipher(String cipherText);

}
