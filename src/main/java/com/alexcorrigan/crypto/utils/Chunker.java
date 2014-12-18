package com.alexcorrigan.crypto.utils;

import com.sun.javaws.exceptions.InvalidArgumentException;

public class Chunker {

    private static final int DEFAULT_CHUNK_SIZE = 4;

    public String chunk(int chunkSize, String textToChunk) throws Exception {
        if (chunkSize < 1) {
            throw new Exception("Chunk size must be greater than zero");
        }
        StringBuilder resultStringBuild = new StringBuilder();
        char[] chars = textToChunk.toCharArray();
        int chunkCount = 0;

        for (int c = 0; c < chars.length; c++) {
            char character = chars[c];
            if (continueWithCurrentChunk(chunkCount, chunkSize, character)) {
                resultStringBuild.append(character);
                chunkCount ++;
            } else if (startNewChunk(chunkCount, chunkSize, character)) {
                resultStringBuild.append(" " + character);
                chunkCount = 1;
            }
        }
        return resultStringBuild.toString();
    }

    public String chunk(String textToChunk) throws Exception {
        return chunk(DEFAULT_CHUNK_SIZE, textToChunk);
    }

    private boolean startNewChunk(int chunkCount, int chunkSize, char character) {
        return character != ' ' && chunkCount == chunkSize;
    }

    private boolean continueWithCurrentChunk(int chunkCount, int chunkSize, char character) {
        return character != ' ' && chunkCount < chunkSize;
    }

}
