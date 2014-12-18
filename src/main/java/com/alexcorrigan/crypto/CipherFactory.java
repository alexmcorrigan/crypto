package com.alexcorrigan.crypto;

import com.alexcorrigan.crypto.monoalphabetic.CeaserCipher;
import com.alexcorrigan.crypto.monoalphabetic.KeyedSubstitutionCipher;
import com.alexcorrigan.crypto.polyalphabetic.VigenereCipher;

import static com.alexcorrigan.crypto.CipherConstants.*;

public class CipherFactory {

    public static Cipher rot5Cipher() {
        return new CeaserCipher(ROT5_OFFSET, ROT5_ASCII_START, ROT5_ASCII_END);
    }

    public static Cipher rot13Cipher() {
        return new CeaserCipher(ROT13_OFFSET, ROT13_ASCII_START, ROT13_ASCII_END);
    }

    public static Cipher rot47Cipher() {
        return new CeaserCipher(ROT47_OFFSET, ROT47_ASCII_START, ROT47_ASCII_END);
    }

    public static Cipher ceaserCipher(int offset) {
        return new CeaserCipher(offset, ALPHA_ASCII_START, ALPHA_ASCII_END);
    }

    public static Cipher keyedSubstitutionCipher(String key) {
        return new KeyedSubstitutionCipher(key);
    }

    public static Cipher vigenereCipher(String key) {
        return new VigenereCipher(key);
    }
}
