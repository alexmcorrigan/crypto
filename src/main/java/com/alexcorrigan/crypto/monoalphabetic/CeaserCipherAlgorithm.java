package com.alexcorrigan.crypto.monoalphabetic;

import com.alexcorrigan.crypto.CipherAlgorithm;

public class CeaserCipherAlgorithm implements CipherAlgorithm {

    private final int asciiSetStart;
    private final int asciiSetEnd;
    private final int offset;

    public CeaserCipherAlgorithm(int asciiSetStart, int asciiSetEnd, int offset) {
        this.asciiSetStart = asciiSetStart;
        this.asciiSetEnd = asciiSetEnd;
        this.offset = offset;
    }

    @Override
    public String encipher(String clearText) {
        return process(clearText, false);
    }

    @Override
    public String decipher(String cipherText) {
        return process(cipherText, true);
    }

    private String process(String textIn, boolean reverseOffset) {
        int effectiveOffset = offset % (asciiSetEnd - asciiSetStart + 1);
        if (reverseOffset) effectiveOffset = -effectiveOffset;
        char[] textInChars = textIn.toCharArray();
        char[] textOutChars = new char[textInChars.length];
        for (int textInChar = 0; textInChar < textInChars.length; textInChar++) {
            char character = textInChars[textInChar];
            if (character >= asciiSetStart && character <= asciiSetEnd) {
                int newChar = character + effectiveOffset;

                if (offsetIsNegativeAndAsciiSetBreached(asciiSetStart, effectiveOffset, newChar)) {
                    textOutChars[textInChar] = (char) (asciiSetEnd - (asciiSetStart - newChar) + 1);

                } else if (offsetIsPositiveAndAsciiSetBreached(asciiSetEnd, effectiveOffset, newChar)) {
                    textOutChars[textInChar] = (char) (asciiSetStart + (newChar - asciiSetEnd) - 1);

                } else {
                    textOutChars[textInChar] = (char) newChar;
                }
            } else {
                textOutChars[textInChar] = character;
            }
        }
        return new String(textOutChars);
    }

    private static boolean offsetIsPositiveAndAsciiSetBreached(int asciiSetEnd, int offset, int newChar) {
        return offset >= 0 && newChar > asciiSetEnd;
    }

    private static boolean offsetIsNegativeAndAsciiSetBreached(int asciiSetStart, int offset, int newChar) {
        return offset < 0 && newChar < asciiSetStart;
    }

}
