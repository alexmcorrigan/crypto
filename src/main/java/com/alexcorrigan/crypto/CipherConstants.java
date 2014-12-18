package com.alexcorrigan.crypto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CipherConstants {

    public static final int ALPHA_ASCII_START = 'A';
    public static final int ALPHA_ASCII_END = 'Z';

    public static final String ALPHABET_UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static final int ROT5_OFFSET = 5;
    public static final int ROT5_ASCII_START = '0';
    public static final int ROT5_ASCII_END = '9';

    public static final int ROT13_OFFSET = 13;
    public static final int ROT13_ASCII_START = ALPHA_ASCII_START;
    public static final int ROT13_ASCII_END = ALPHA_ASCII_END;

    public static final int ROT47_OFFSET = 47;
    public static final int ROT47_ASCII_START = '!';
    public static final int ROT47_ASCII_END = '~';

    public static final Map<Character, List> VIGENERE_TABLE = buildVigenereTable();

    private static Map<Character, List> buildVigenereTable() {
        Map<Character, List> alphabets = new HashMap<Character, List>();
        return alphabets;
    }



}
